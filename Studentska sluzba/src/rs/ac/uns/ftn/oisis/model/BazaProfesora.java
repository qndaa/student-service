package rs.ac.uns.ftn.oisis.model;

import java.util.ArrayList;

public class BazaProfesora {

	private static BazaProfesora instance;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}

	static int brojUnetihProfesora = 0;

	private ArrayList<String> naziviKolona;
	private ArrayList<Profesor> profesori;

	private BazaProfesora() {
		super();
		naziviKolona = new ArrayList<String>();
		profesori = new ArrayList<Profesor>();
		naziviKolona.add("Broj l.karte");
		naziviKolona.add("Ime");
		naziviKolona.add("Prezime");
		naziviKolona.add("Dat. rodjenja");
		naziviKolona.add("Adr. stanovanja");
		naziviKolona.add("Telefon");
		naziviKolona.add("Adr. kancelarije");
		naziviKolona.add("Titula");
		naziviKolona.add("Zvanje");
		naziviKolona.add("Spisak predmeta na kojima je profesor");
		addProfesora();

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

	void addProfesora() {
		profesori.add(new Profesor("Marko", "Markovic", "10-10-1989", "Laze Teleckog", "0333", "@gmail.com", "t21",
				"100k", "Profesor", "Pocetnik"));
		brojUnetihProfesora++;

	}

	public String getValueAt(int row, int column) {
		if (row < brojUnetihProfesora) {
			Profesor profesor = profesori.get(row);
			switch (column) {
			case 0:
				return profesor.getBrojLicneKarte();
			case 1:
				return profesor.getIme();
			case 2:
				return profesor.getPrezime();
			case 3:
				return profesor.getDatumRodjenja();
			case 4:
				return profesor.getAdresaStanovanja();
			case 5:
				return profesor.getKontaktTelefon();
			case 6:
				return profesor.getAdresaKancelarije();
			case 7:
				return profesor.getTitula();
			case 8:
				return profesor.getZvanje();
			case 9:
				return "Predmeti";
			default:
				return null;
			}
		} else {
			return null;
		}
	}

}
