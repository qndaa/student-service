package rs.ac.uns.ftn.oisis.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisis.model.BazaStudent;
import rs.ac.uns.ftn.oisis.model.Predmet;
import rs.ac.uns.ftn.oisis.model.Student;
import rs.ac.uns.ftn.oisis.view.IzmenaStudentaDialog;
import rs.ac.uns.ftn.oisis.view.MainFrame;
import rs.ac.uns.ftn.oisis.view.StudentiTable;
import rs.ac.uns.ftn.oisis.view.StudentiTablePane;
import rs.ac.uns.ftn.oisis.view.TabelaIndeksa;
import rs.ac.uns.ftn.oisis.view.ToolBar;

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
	
	public void IzbrisiPredmetStudentu(String sifraPredmeta, String brIndeksa) {
		BazaStudent.getInstance().IzbrisiPredmetStudentu(sifraPredmeta, brIndeksa);
	}
	
	
	public void sacuvajStudenta()  throws IOException {
		 BazaStudent.getInstance().sacuvajStudente();
	}
	
	public void otvoriFileStudent() throws IOException {
		BazaStudent.getInstance().otvoriFileStudenta();
		
	}
	
	
	public void BrisanjeStudenta() {
		int row = StudentiTablePane.getSelektovanaVrsta();

		// ako je selektovana kolona veca ili jedanko od 0 i ako u bazi ima sutudenata
		// izbirsi
		if (row >= 0 && row < BazaStudent.getBrStudenata() && BazaStudent.getBrStudenataPretga()== 0) {
			int pritisnuo = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
					"Da li ste sigurni da zelite da obrisete studenta?", "Brisanje Studenta",
					JOptionPane.YES_NO_OPTION);
			if (pritisnuo == JOptionPane.YES_OPTION) {
				BazaStudent.getInstance().BrisanjeStudenta(row);
			}

		} else if (row >= 0 && row < BazaStudent.getBrStudenataPretga()) {
			
		
			int pritisnuo = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
					"Da li ste sigurni da zelite da obrisete studenta?", "Brisanje Studenta",
					JOptionPane.YES_NO_OPTION);
			if (pritisnuo == JOptionPane.YES_OPTION) {
				//izbrisi studenta selektovanog u pretrazis
				Student s = BazaStudent.getInstance().getRezPretrage().get(row);
				BazaStudent.getInstance().getRezPretrage().remove(row);
				BazaStudent.getInstance().SmanjiBrPretrage(); 
				BazaStudent.getInstance().BrisanjePoIndeksu(s.getBrIndeksa());;//izbrisi po indesku iz svih studenata
				
			}	
				
			}else {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Student nije selektovan", "EROR",
					JOptionPane.ERROR_MESSAGE);
			;

		}

	}

	public void IzmenaStudenta() {
		int row = StudentiTablePane.getSelektovanaVrsta();
		System.out.println(row);
	
		if (row >= 0 && row < BazaStudent.getBrStudenata() && BazaStudent.getBrStudenataPretga() == 0) {
			
			IzmenaStudentaDialog d = new IzmenaStudentaDialog(MainFrame.getInstance(),"Izmena studenta", true);
			d.setVisible(true);
		}else if (row >= 0 && row < BazaStudent.getBrStudenataPretga()) {
			
			IzmenaStudentaDialog d = new IzmenaStudentaDialog(MainFrame.getInstance(),"Izmena studenta", true);
			d.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Student nije selektovan", "EROR",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void pretragaStudenta() {
		String ulaz = ToolBar.getInstance().getSearchField().getText();
		BazaStudent.getInstance().PretragaStud(ulaz);
		
		StudentiTable.getInstance().OsveziTabelu();	
	}
	
	
	
	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}

		return instance;
	}

}
