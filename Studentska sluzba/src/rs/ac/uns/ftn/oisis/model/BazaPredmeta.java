package rs.ac.uns.ftn.oisis.model;

import java.util.ArrayList;

public class BazaPredmeta {

	private static BazaPredmeta instance;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	private static int brojUnetihPredmeta = 0;

	private ArrayList<String> nazivKolona;
	private ArrayList<Predmet> predmeti;

	private BazaPredmeta() {
		super();
		nazivKolona = new ArrayList<String>();
		predmeti = new ArrayList<Predmet>();
		nazivKolona.add("Sifra");
		nazivKolona.add("Naziv");
		nazivKolona.add("Semestar");
		nazivKolona.add("Godina izvodjenja");
		nazivKolona.add("Spisak profesora");
		nazivKolona.add("Spisak studenata");

	}

	public static int getBrojUnetihPredmeta() {
		return brojUnetihPredmeta;
	}

	public static void setBrojUnetihPredmeta(int brojUnetihPredmeta) {
		BazaPredmeta.brojUnetihPredmeta = brojUnetihPredmeta;
	}

	public ArrayList<String> getNazivKolona() {
		return nazivKolona;
	}

	public void setNazivKolona(ArrayList<String> nazivKolona) {
		this.nazivKolona = nazivKolona;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public String getValueAt(int row, int column) {
		if (row < brojUnetihPredmeta) {
			Predmet predmet = predmeti.get(row);
			switch (column) {
			case 0:
				return predmet.getSifra();
			case 1:
				return predmet.getNaziv();
			case 2:
				return predmet.getSemestar().toString();
			case 3:
				return predmet.getGodIzv().toString();
			case 4:
				return "Spisak profesora";
			case 5:
				return "Spisak studenata";
			default:
				return null;
			}
		} else {
			return null;
		}
	}

}
