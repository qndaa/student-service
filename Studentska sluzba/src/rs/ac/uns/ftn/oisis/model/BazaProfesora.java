package rs.ac.uns.ftn.oisis.model;

import java.util.ArrayList;

public class BazaProfesora {
	
	private static BazaProfesora instance;
	
	public static BazaProfesora getInstance() {
		if(instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}
	
	private ArrayList<String> naziviKolona;
	private ArrayList<Profesor> profesori;
	
	private BazaProfesora() {
		super();
		naziviKolona.add("Broj l.karte");
		naziviKolona.add("Ime");
		naziviKolona.add("Dat. rodjenja");
		naziviKolona.add("Adr. stanovanja");
		naziviKolona.add("Telefon");
		naziviKolona.add("Adr. kancelarije");
		naziviKolona.add("Titula");
		naziviKolona.add("Zvanje");
		naziviKolona.add("Spisak predmeta na kojima je profesor");
		
	}

	public ArrayList<String> getNaziviKolona() {
		return naziviKolona;
	}

	public void setNaziviKolona(ArrayList<String> naziviKolona) {
		this.naziviKolona = naziviKolona;
	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	
	
	
	
	
	
	
}
