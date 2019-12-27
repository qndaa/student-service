package rs.ac.uns.ftn.oisis.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import rs.ac.uns.ftn.oisis.view.ProfesoriTable;

public class BazaProfesora {

	private static BazaProfesora instance;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}

	private static int brojUnetihProfesora = 0;
	private static int brojProfesoraKojiSuUPretrazi = 0;

	private ArrayList<String> naziviKolona;
	private ArrayList<Profesor> sviProfesori;
	private ArrayList<Profesor> rezultatPretrage;

	private File fileProfesori = new File("profesori.txt");

	private BazaProfesora() {
		super();
		naziviKolona = new ArrayList<String>();
		sviProfesori = new ArrayList<Profesor>();
		rezultatPretrage = new ArrayList<Profesor>();
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
	}

	public ArrayList<String> getNaziviKolona() {
		return naziviKolona;
	}

	public void setNaziviKolona(ArrayList<String> naziviKolona) {
		this.naziviKolona = naziviKolona;
	}

	public ArrayList<Profesor> getSviProfesori() {
		return sviProfesori;
	}

	public void setSviProfesori(ArrayList<Profesor> profesori) {
		this.sviProfesori = profesori;
	}

	public String getValueAt(int row, int column) {
		ArrayList<Profesor> temp;
		if(rezultatPretrage.size() == 0) {
			temp = sviProfesori;
		}else {
			temp = rezultatPretrage;
		}
		if (row < temp.size()) {
			
			Profesor profesor = sviProfesori.get(row);
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

	public static int getBrojUnetihProfesora() {
		return brojUnetihProfesora;
	}

	public static void setBrojUnetihProfesora(int brojUnetihProfesora) {
		BazaProfesora.brojUnetihProfesora = brojUnetihProfesora;
	}

	public static int getBrojProfesoraKojiSuUPretrazi() {
		return brojProfesoraKojiSuUPretrazi;
	}

	public static void setBrojProfesoraKojiSuUPretrazi(int brojProfesoraKojiSuUPretrazi) {
		BazaProfesora.brojProfesoraKojiSuUPretrazi = brojProfesoraKojiSuUPretrazi;
	}

	public void obrisiProfesora(int selectedRow) {
		sviProfesori.remove(selectedRow);
		brojUnetihProfesora--;

	}

	public void saveProfesori() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileProfesori)));

		for (int i = 0; i < sviProfesori.size(); i++) {
			Profesor p = sviProfesori.get(i);
			String line = p.toString();
			bw.write(line);
		}
		bw.close();
	}

	public void loadProfesori() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileProfesori)));

		String line = new String();

		while ((line = br.readLine()) != null) {
			String fields[] = line.split("-");
			String trimFields[] = new String[fields.length];
			for (int i = 0; i < fields.length; i++) {
				trimFields[i] = fields[i].trim();
			}

			dodajPredmet(trimFields);
			ProfesoriTable.getInstance().refresTable();
			
			// dodati jos ucitavanje predmeta na kojima predaje profesor 
		}

		br.close();

	}

	private boolean dodajPredmet(String[] kolone) {
		brojUnetihProfesora++;
		String key = kolone[7];
		if (profesorSaKljucemNePostoji(key)) {
			Profesor newProfesor = new Profesor(kolone[0], kolone[1], kolone[2], kolone[3], kolone[4], kolone[5],
					kolone[6], kolone[7], kolone[8], kolone[9]);
			sviProfesori.add(newProfesor);
			return true;

		}
		return false;

	}

	private boolean profesorSaKljucemNePostoji(String key) {
		for (Profesor p : sviProfesori) {
			if (key.equals(p.getBrojLicneKarte())) {
				return false;
			}
		}
		return true;
	}

}
