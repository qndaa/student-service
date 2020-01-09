package rs.ac.uns.ftn.oisis.view;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;
import rs.ac.uns.ftn.oisis.model.BazaStudent;
import rs.ac.uns.ftn.oisis.model.Student;

public class IzmenaStudentaDialog extends DialogStudent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1871482353300249173L;
	private Student s;
	private Student sviStud=null;
	public IzmenaStudentaDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		int row = StudentiTablePane.getSelektovanaVrsta();
		
		
		if(BazaStudent.getBrStudenataPretga() == 0) {
			s = BazaStudent.getInstance().getSpisakStudenata().get(row);
		}else {
			s = BazaStudent.getInstance().getRezPretrage().get(row);
			sviStud = BazaStudent.getInstance().getStudent(s.getBrIndeksa());
		}
		

		txtField1.setText(s.getIme()); // ime
		txtField2.setText(s.getPrezime());
		; // prezime
		txtField3.setText(s.getDatumRodjenja());
		; // datum rodjenja
		txtField4.setText(s.getAdresaStanovanja()); // adresa stanovanja
		txtField5.setText(s.getKontaktTelefon());
		; // broj telefona
		txtField6.setText(s.getBrIndeksa());
		; // borj Indeksa
		txtField9.setText(s.getEmail());
		; // email
		txtField8.setText(s.getDatumUpisa());
		; // datum upisa
		god.setSelectedIndex(s.getGodinaI());
		if (s.getStatusS() == "S") {
			samo.setSelected(true);
		} else {
			budz.setSelected(true);

		}

		potvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String pod[] = podaci();

				if (!s.getBrIndeksa().contentEquals(pod[6])) {
					if (!BazaStudent.getInstance().ProveraIndeksa(pod[6])) {
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Stduent sa istim idneskom postoji",
								"EROR", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
					
				if (sviStud !=null) {
					sviStud.setIme(pod[0]);
					sviStud.setPrezime(pod[1]);
					sviStud.setDatumRodjenja(pod[2]);
					sviStud.setAdresaStanovanja(pod[3]);
					sviStud.setKontaktTelefon(pod[4]);
					sviStud.setEmail(pod[5]);
					sviStud.setBrIndeksa(pod[6]);
					sviStud.setGodinaS(pod[7]);
					sviStud.setDatumUpisa(pod[8]);
					sviStud.setStatuS(pod[9]);
				}




				s.setIme(pod[0]);
				s.setPrezime(pod[1]);
				s.setDatumRodjenja(pod[2]);
				s.setAdresaStanovanja(pod[3]);
				s.setKontaktTelefon(pod[4]);
				s.setEmail(pod[5]);
				s.setBrIndeksa(pod[6]);
				s.setGodinaS(pod[7]);
				s.setDatumUpisa(pod[8]);
				s.setStatuS(pod[9]);

				dispose();
				StudentiTable.getInstance().OsveziTabelu();
				JOptionPane.showMessageDialog((Component) e.getSource(), "Uspesno ste izmenili studenta");
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
