package rs.ac.uns.ftn.oisis.view;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisis.model.BazaPredmeta;
import rs.ac.uns.ftn.oisis.model.Predmet;

public class IzmenaPredmetaDialog extends PredmetDialog {

	private static final long serialVersionUID = 8523846366419798927L;
	private Predmet p;
	private Predmet predmetIzSviPredmeti = null;

	public IzmenaPredmetaDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		int selectedRow = PredmetiTable.getInstance().getSelectedRow();
		if (BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) {
			 p = BazaPredmeta.getInstance().getSviPredmeti().get(selectedRow);
			
		} else {
			p = BazaPredmeta.getInstance().getRazultatPretrage().get(selectedRow);
			predmetIzSviPredmeti = BazaPredmeta.getInstance().vratiPredmetPoKljucu(p.getSifra());
		}
		
		txtNazivPredmeta.setText(p.getNaziv());
		txtSifrePredmeta.setText(p.getSifra());
		semestarCB.setSelectedItem(p.getSemestar());
		godinaCB.setSelectedItem(p.getGodIzv());
		
		potvrdaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String unos[] = prikupiUnos();
				if (!p.getSifra().equals(unos[0])) {
					if (!BazaPredmeta.getInstance().predmetSaKljucemNePostoji(unos[0])) {
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Predmet sa sifrom vec postoji.",
								"Greska", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				if(predmetIzSviPredmeti != null) {
					predmetIzSviPredmeti.setNaziv(unos[1]); 
					predmetIzSviPredmeti.setSifra(unos[0]);
					predmetIzSviPredmeti.setSemestar(unos[2]);
					predmetIzSviPredmeti.setGodIzv(unos[3]);
				}
				p.setNaziv(unos[1]);
				p.setSifra(unos[0]);
				p.setSemestar(unos[2]);
				p.setGodIzv(unos[3]);

				dispose();
				PredmetiTable.getInstance().refreshTable();
				JOptionPane.showMessageDialog((Component) e.getSource(), "Uspesno ste izmenili predmet.");

			}
		});

		odustaniBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

	}

}
