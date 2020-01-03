package rs.ac.uns.ftn.oisis.model;

import java.util.ArrayList;

public class Profesor extends Osoba {

	private String adresaKancelarije;
	private String brojLicneKarte;
	private String titula;
	private String zvanje;
	private ArrayList<Predmet> predajeNaPredmetima;
	
	public Profesor(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String adresaKancelarije, String brojLicneKarte, String titula, String zvanje) {
		super(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, email);
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predajeNaPredmetima = new ArrayList<Predmet>();
	}

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public ArrayList<Predmet> getPredajeNaPredmetima() {
		return predajeNaPredmetima;
	}

	public void setPredajeNaPredmetima(ArrayList<Predmet> predajeNaPredmetima) {
		this.predajeNaPredmetima = predajeNaPredmetima;
	}

	@Override
	public String toString() {
		String ispis = super.toString() + adresaKancelarije + " - " + brojLicneKarte + " - "
				+ titula + " - " + zvanje  + "\n";
		return ispis;
	}
		
}
