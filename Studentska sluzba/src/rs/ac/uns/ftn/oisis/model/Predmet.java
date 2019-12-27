package rs.ac.uns.ftn.oisis.model;

import java.util.ArrayList;


public class Predmet {
	private String sifra;
	private String naziv;
	private String semestar;
	private String godIzv;
	private ArrayList<Profesor> predmetniProf;
	private ArrayList<Student> studenti;
	
	public Predmet(String sifra, String naziv, String semestar, String godIzv) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godIzv = godIzv;
		this.predmetniProf = new ArrayList<Profesor>();
		this.studenti = new ArrayList<Student>();
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSemestar() {
		return semestar;
	}

	public void setSemestar(String semestar) {
		this.semestar = semestar;
	}

	public String getGodIzv() {
		return godIzv;
	}

	public void setGodIzv(String godIzv) {
		this.godIzv = godIzv;
	}

	public ArrayList<Profesor> getPredmetniProf() {
		return predmetniProf;
	}

	public void setPredmetniProf(ArrayList<Profesor> predmetniProf) {
		this.predmetniProf = predmetniProf;
	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}

	@Override
	public String toString() {
		return sifra + " - " + naziv + " - " + semestar + " - " + godIzv
				+ " - " + predmetniProf + " - " + studenti + "\n";
	}
	
	
	
	
}
