package rs.ac.uns.ftn.oisis.controller;

import rs.ac.uns.ftn.oisis.model.BazaPredmeta;
import rs.ac.uns.ftn.oisis.model.BazaStudent;

public class StudentiController {
	private static StudentiController instance = null;
	
	private StudentiController() {} 
	
	
	
	
	
	public boolean DodajStudenta(String []p) {
		return BazaStudent.getInstance().Dodavanje(p);
	}
	
	
	
	
	

	public static StudentiController getInstance() {
		if(instance == null ) {
			instance = new StudentiController();
		}
	
		return instance;
	}
	
	
	
	
	
}
