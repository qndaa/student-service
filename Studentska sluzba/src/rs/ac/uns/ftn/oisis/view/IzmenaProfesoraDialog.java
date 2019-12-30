package rs.ac.uns.ftn.oisis.view;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisis.model.BazaProfesora;
import rs.ac.uns.ftn.oisis.model.Profesor;

public class IzmenaProfesoraDialog extends DialogProfesor {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6030445823624943923L;
	private Profesor prof;
	
	public IzmenaProfesoraDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		int row = ProfesoriTable.getInstance().getSelectedRow();
		prof = BazaProfesora.getInstance().getSviProfesori().get(row);
		
		 txtField1.setText(prof.getIme());; // ime
		 txtField2.setText(prof.getPrezime());; // prezime
		 txtField3.setText(prof.getDatumRodjenja());; // datum rodjenja
		 txtField4.setText(prof.getAdresaStanovanja());; // adresa stanovanja
		 txtField5.setText(prof.getKontaktTelefon());; // broj telefona
		 txtField6.setText(prof.getEmail());; // email
		 txtField7.setText(prof.getAdresaKancelarije());; // adresa Kancelarije
		 txtField8.setText(prof.getBrojLicneKarte());; // brlicne
		 txtField9.setText(prof.getTitula());; // titula
		 txtField10.setText(prof.getTitula());; // zvanje
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pod[]= podaci();
				
				if(!prof.getBrojLicneKarte().equals(pod[7])) {
					if(!BazaProfesora.getInstance().profesorSaKljucemNePostoji(pod[7])) {
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Profesor sa istim brojem licnke karte postoji",
								"EROR", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}				
				prof.setIme(pod[0]);
				prof.setPrezime(pod[1]);
				prof.setDatumRodjenja(pod[2]);
				prof.setAdresaStanovanja(pod[3]);
				prof.setKontaktTelefon(pod[4]);
				prof.setEmail(pod[5]);
				prof.setAdresaKancelarije(pod[6]);
				prof.setBrojLicneKarte(pod[7]);
				prof.setTitula(pod[8]);
				prof.setZvanje(pod[9]);
				
				dispose();
				ProfesoriTable.getInstance().refresTable();
				JOptionPane.showMessageDialog((Component) e.getSource(), "Uspesno ste izmenili profesor");
				
			}
		});		
		odustani.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();			
			}
		});
		
		
		
		
		
	}

	
}
