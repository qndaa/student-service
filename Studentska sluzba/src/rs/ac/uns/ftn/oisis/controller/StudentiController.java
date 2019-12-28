package rs.ac.uns.ftn.oisis.controller;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisis.model.BazaPredmeta;
import rs.ac.uns.ftn.oisis.model.BazaStudent;
import rs.ac.uns.ftn.oisis.view.MainFrame;
import rs.ac.uns.ftn.oisis.view.StudentiTable;

public class StudentiController {
	private static StudentiController instance = null;
	
	private StudentiController() {} 
	
	
	
	
	
	public boolean DodajStudenta(String []p) {
		return BazaStudent.getInstance().Dodavanje(p);
	}
	
	
	public void BrisanjeStudenta() {
		int row = StudentiTable.getInstance().getSelectedRow();
		
		//ako je selektovana kolona veca ili jedanko od 0 i ako u bazi ima sutudenata izbirsi
		if(row >=0 && row< BazaStudent.getBrStudenata()) { 
			int pritisnuo = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da zelite da obrisete studenta?"
					,"Brisanje Studenta", JOptionPane.YES_NO_OPTION);
			
			if(pritisnuo == JOptionPane.YES_OPTION) {
				BazaStudent.getInstance().BrisanjeStudenta(row);
			}
			
		} else {
			JOptionPane.showMessageDialog(MainFrame.getInstance(),"Student nije selektovan", "EROR", JOptionPane.ERROR_MESSAGE);;

		}
		
	}
	
	
	
	
	
	
	

	public static StudentiController getInstance() {
		if(instance == null ) {
			instance = new StudentiController();
		}
	
		return instance;
	}
	
	
	
	
	
}
