package rs.ac.uns.ftn.oisis.model;

import java.util.ArrayList;

public class BazaStudent {
	
	private static BazaStudent instance= null;
	private ArrayList<String> colon;
	private ArrayList<Student> spisakStudenata;
	
	public static BazaStudent getInstance() {
			if(instance==null) {
				instance= new BazaStudent();
			}
		
		return instance;
	}
	

	private BazaStudent() {
		colon= new ArrayList<String>();
		spisakStudenata= new ArrayList<Student>();
		colon.add("Broj indeksa");
		colon.add("Ime");
		colon.add("Prezime");
		colon.add("Ime");
		colon.add("Datum rodjenja");
		colon.add("Adresa stanovanja");
		colon.add("Kontakt telefon");
		colon.add("Email");
		colon.add("Datum Upisa");
		colon.add("Godina studija");
		colon.add("Status studenta");
		colon.add("Spisak Predmeta");	
	}

	
	

	public ArrayList<String> getColon() {
		return colon;
	}


	public void setColon(ArrayList<String> colon) {
		this.colon = colon;
	}


	public ArrayList<Student> getSpisakStudenata() {
		return spisakStudenata;
	}


	public void setSpisakStudenata(ArrayList<Student> spisakStudenata) {
		this.spisakStudenata = spisakStudenata;
	}


}
