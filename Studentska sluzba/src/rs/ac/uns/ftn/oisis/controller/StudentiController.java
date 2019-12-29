package rs.ac.uns.ftn.oisis.controller;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisis.model.BazaStudent;
import rs.ac.uns.ftn.oisis.model.Predmet;
import rs.ac.uns.ftn.oisis.model.Student;
import rs.ac.uns.ftn.oisis.view.IzmenaStudentaDialog;
import rs.ac.uns.ftn.oisis.view.MainFrame;
import rs.ac.uns.ftn.oisis.view.StudentiTable;

public class StudentiController {
	private static StudentiController instance = null;

	private StudentiController() {
	}

	public boolean DodajStudenta(String[] p) {
		return BazaStudent.getInstance().Dodavanje(p);
	}
	
	public boolean IndeksPostoji (String index) {
		
		return BazaStudent.getInstance().ProveraIndeksa(index);
	}

	public Student getStudentPoIndeksu(String indeks) {
		if(BazaStudent.getBrStudenata() !=0) {
		return BazaStudent.getInstance().getStudent(indeks);
		}
		return null;
	}
	
	public void DodavanjePredmetaStudentu(Predmet predmet, String s) {
		BazaStudent.getInstance().DodajPredmetStudentu(predmet, s);
	}
	
	
	public void BrisanjeStudenta() {
		int row = StudentiTable.getInstance().getSelectedRow();

		// ako je selektovana kolona veca ili jedanko od 0 i ako u bazi ima sutudenata
		// izbirsi
		if (row >= 0 && row < BazaStudent.getBrStudenata()) {
			int pritisnuo = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
					"Da li ste sigurni da zelite da obrisete studenta?", "Brisanje Studenta",
					JOptionPane.YES_NO_OPTION);

			if (pritisnuo == JOptionPane.YES_OPTION) {
				BazaStudent.getInstance().BrisanjeStudenta(row);
			}

		} else {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Student nije selektovan", "EROR",
					JOptionPane.ERROR_MESSAGE);
			;

		}

	}

	public void IzmenaStudenta() {
		int row = StudentiTable.getInstance().getSelectedRow();

		// ako je selektovana kolona veca ili jedanko od 0 i ako u bazi ima sutudenata
		// izbirsi
		if (row >= 0 && row < BazaStudent.getBrStudenata()) {
			IzmenaStudentaDialog d = new IzmenaStudentaDialog(MainFrame.getInstance(),"Izmena studenta", true);
			d.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Student nije selektovan", "EROR",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}

		return instance;
	}

}
