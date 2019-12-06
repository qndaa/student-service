package rs.ac.uns.ftn.oisis.entiteti;

import java.util.ArrayList;

enum Semestar{I, II, III, IV, V, VI, VII, VIII};
enum GodinaIzvodjenja {I, II, III, IV, V, VI};

public class Predmet {
	private String sifra;
	private String naziv;
	private Semestar semestar;
	private GodinaIzvodjenja godIzv;
	private ArrayList<Profesor> predmetniProf;
	private ArrayList<Student> studenti;
	
	public Predmet(String sifra, String naziv, Semestar semestar, GodinaIzvodjenja godIzv,
			ArrayList<Profesor> predmetniProf, ArrayList<Student> studenti) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godIzv = godIzv;
		this.predmetniProf = predmetniProf;
		this.studenti = studenti;
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

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public GodinaIzvodjenja getGodIzv() {
		return godIzv;
	}

	public void setGodIzv(GodinaIzvodjenja godIzv) {
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
	
	
	
	
}
