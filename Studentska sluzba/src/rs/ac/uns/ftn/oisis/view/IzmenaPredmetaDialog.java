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

	public IzmenaPredmetaDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		int selectedRow = PredmetiTable.getInstance().getSelectedRow();
		Predmet p = BazaPredmeta.getInstance().getPredmeti().get(selectedRow);
		txtNazivPredmeta.setText(p.getNaziv());
		txtSifrePredmeta.setText(p.getSifra());
		semestarCB.setSelectedItem(p.getSemestar());
		godinaCB.setSelectedItem(p.getGodIzv());

		potvrdaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String unos[] = prikupiUnos();
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
