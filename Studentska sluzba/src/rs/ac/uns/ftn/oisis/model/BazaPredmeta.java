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

import javax.swing.JOptionPane;



import rs.ac.uns.ftn.oisis.view.MainFrame;
import rs.ac.uns.ftn.oisis.view.PredmetiTable;
import rs.ac.uns.ftn.oisis.view.PredmetiTablePane;
import rs.ac.uns.ftn.oisis.view.ProfesoriNaPredmetuTable;

public class BazaPredmeta {

	private static BazaPredmeta instance;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	private static int brojUnetihPredmeta = 0;
	private static int BrojStudenataNaPredmetu = 0;
	private static int brojPredmetaKojiSuUPretrazi = 0;

	private ArrayList<String> nazivKolona;
	private ArrayList<Predmet> sviPredmeti;
	private ArrayList<Predmet> razultatPretrage;

	private File filePredmeti = new File("predmeti.txt");

	private BazaPredmeta() {
		super();
		nazivKolona = new ArrayList<String>();
		sviPredmeti = new ArrayList<Predmet>();
		razultatPretrage = new ArrayList<Predmet>();
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

	public ArrayList<Predmet> getSviPredmeti() {
		return sviPredmeti;
	}

	public void setSviPredmeti(ArrayList<Predmet> predmeti) {
		this.sviPredmeti = predmeti;
	}

	public String getValueAt(int row, int column) {
		ArrayList<Predmet> temp;
		if (razultatPretrage.size() == 0) {
			temp = sviPredmeti;
		} else {
			temp = razultatPretrage;
		}
		if (row < temp.size()) {
			Predmet predmet = temp.get(row);
			switch (column) {
			case 0:
				return predmet.getSifra();
			case 1:
				return predmet.getNaziv();
			case 2:
				return predmet.getSemestar();
			case 3:
				return predmet.getGodIzv();
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

	public boolean dodajPredmet(String kolone[]) {
		brojUnetihPredmeta++;
		String key = kolone[0];
		if (predmetSaKljucemNePostoji(key)) {
			Predmet newPredmet = new Predmet(kolone[0], kolone[1], kolone[2], kolone[3]);
			sviPredmeti.add(newPredmet);
			return true;
		}
		return false;
	}

	public boolean predmetSaKljucemNePostoji(String key) {
		for (Predmet p : sviPredmeti) {
			if (key.equals(p.getSifra())) {
				return false;
			}
		}
		return true;
	}

	public void obrisiPredmet(int index) {
		sviPredmeti.remove(index);
		brojUnetihPredmeta--;
	}

	public void pretraziPredmete(String input) {
		if (input.trim().length() == 0) {
			razultatPretrage.clear();
			brojPredmetaKojiSuUPretrazi = 0;
			return;
		}
		
		razultatPretrage.clear();
		brojPredmetaKojiSuUPretrazi = 0;

		String[] podelaUnosa = input.split(";");
		String s = podelaUnosa[0];
		String[] obeVre = s.trim().split(":");
		if(obeVre.length != 2 || obeVre[1].trim().length() == 0 ) { // proverimo da li je uneseno sta se trazi
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Pretraga nije dobro napisana!", "Greska",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (obeVre[0].toUpperCase().equals("SIFRA")) {
			for (Predmet p : sviPredmeti) {
				if (p.getSifra().toUpperCase().equals(obeVre[1].trim().toUpperCase())) {
					razultatPretrage.add(p);
				}
			}
		} else if (obeVre[0].toUpperCase().equals("NAZIV")) {
			for (Predmet p : sviPredmeti) {
				if (p.getNaziv().toUpperCase().equals(obeVre[1].trim().toUpperCase())) {
					razultatPretrage.add(p);
				}
			}
		} else if (obeVre[0].toUpperCase().equals("SEMESTAR")) {
			for (Predmet p : sviPredmeti) {
				if (p.getSemestar().toUpperCase().equals(obeVre[1].trim().toUpperCase())) {
					razultatPretrage.add(p);
				}
			}
		} else if (obeVre[0].toUpperCase().equals("GODINA IZVODJENJA")) {
			for (Predmet p : sviPredmeti) {
				if (p.getGodIzv().toUpperCase().equals(obeVre[1].trim().toUpperCase())) {
					razultatPretrage.add(p);
				}
			}

		} else {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Pretraga nije dobro napisana!", "Greska",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (podelaUnosa.length > 1) {
			for (int i = 1; i < podelaUnosa.length; i++) {
				s = podelaUnosa[i];
				obeVre = s.trim().split(":");
				if(obeVre.length != 2 || obeVre[1].trim().length() == 0) { // proverimo da li je uneseno sta se trazi
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Pretraga nije dobro napisana!", "Greska",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (obeVre[0].toUpperCase().equals("SIFRA")) {
					for (Predmet p : sviPredmeti) {
						if (!p.getSifra().toUpperCase().equals(obeVre[1].trim().toUpperCase())) {
							razultatPretrage.remove(p);
						}
					}
				} else if (obeVre[0].toUpperCase().equals("NAZIV")) {
					for (Predmet p : sviPredmeti) {
						if (!p.getNaziv().toUpperCase().equals(obeVre[1].trim().toUpperCase())) {
							razultatPretrage.remove(p);
						}
					}
				} else if (obeVre[0].toUpperCase().equals("SEMESTAR")) {
					for (Predmet p : sviPredmeti) {
						if (!p.getSemestar().toUpperCase().equals(obeVre[1].trim().toUpperCase())) {
							razultatPretrage.remove(p);
						}
					}
				} else if (obeVre[0].toUpperCase().equals("GODINA IZVODJENJA")) {
					for (Predmet p : sviPredmeti) {
						if (!p.getGodIzv().toUpperCase().equals(obeVre[1].trim().toUpperCase())) {
							razultatPretrage.remove(p);
						}
					}
				} else {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Pretraga nije dobro napisana!", "Greska",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		}
		brojPredmetaKojiSuUPretrazi = razultatPretrage.size();

		if (razultatPretrage.size() == 0) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Neuspesna pretraga!", "Greska",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void savePredmete() throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePredmeti)));

		for (int i = 0; i < sviPredmeti.size(); i++) {
			Predmet p = sviPredmeti.get(i);
			String line = p.toString();
			bw.write(line);
		}
		bw.close();

	}

	public void loadPredmete() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePredmeti)));

		String line = new String();

		while ((line = br.readLine()) != null) {
			String fields[] = line.split("-");
			String trimFields[] = new String[fields.length];
			for (int i = 0; i < fields.length; i++) {
				trimFields[i] = fields[i].trim();
			}
			dodajPredmet(trimFields);
			PredmetiTable.getInstance().refreshTable();
			// potrebno je jos ubaciti sve studente koji slusaju predmet kao i profesore
			// koji predaju na predmetu
		}
		br.close();

	}

	public ArrayList<Predmet> getRazultatPretrage() {
		return razultatPretrage;
	}

	public void setRazultatPretrage(ArrayList<Predmet> razultatPretrage) {
		this.razultatPretrage = razultatPretrage;
	}

	public static int getBrojPredmetaKojiSuUPretrazi() {
		return brojPredmetaKojiSuUPretrazi;
	}

	public void setBrojPredmetaKojiSuUPretrazi(int brojPredmetaKojiSuUPretrazi) {
		BazaPredmeta.brojPredmetaKojiSuUPretrazi = brojPredmetaKojiSuUPretrazi;
	}
	
	public Predmet vratiPredmetPoKljucu(String key) {
		Predmet povratka = null;
		for(Predmet p : sviPredmeti) {
			if(p.getSifra().equals(key)) {
				povratka = p;
			}
		}
		return povratka;
		
	}
	
	
	
	public void brisiPoKljucu(String key) {
		int i = 0;
		for(; i < sviPredmeti.size(); i++) {
			if(key.equals(sviPredmeti.get(i).getSifra())) {
				break;
			}
		}
		sviPredmeti.remove(i);
	}

	public void smanjiBrojPredmetaKojiSuUPretrazi() {
		brojPredmetaKojiSuUPretrazi--;
		
	}
	
	public Boolean ProveraStudenta(String index, int row) {
		if(BrojStudenataNaPredmetu !=0) {
			for (Student s : sviPredmeti.get(row).getStudenti()) {
				System.out.println(sviPredmeti.get(row).getStudenti().size());
				if(s.getBrIndeksa().equals(index)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void DodajStudentaNaPredmet(Student stud, int i) {
		sviPredmeti.get(i).getStudenti().add(stud);	
		BrojStudenataNaPredmetu++;
	}

	public static int getBrojStudenataNaPredmetu() {
		return BrojStudenataNaPredmetu;
	}

	public static void setBrojStudenataNaPredmetu(int brojStudenataNaPredmetu) {
		BrojStudenataNaPredmetu = brojStudenataNaPredmetu;
	}

	public boolean dodajProfesoraNaPredmet(Profesor profesor) {
		// TODO Auto-generated method stub
		int selectedRow = PredmetiTablePane.getSelectedRow();
		
		Predmet predmet = sviPredmeti.get(selectedRow);
		return predmet.dodajProfesoraNaPredmet(profesor);
		
		
		
		
	}

	public void obrisiProfesoraSaPredmeta() {
		int selectedPredmet = PredmetiTablePane.getSelectedRow();
		int selectedProfesor = ProfesoriNaPredmetuTable.getInstance().getSelectedRow();
		Predmet predmet = sviPredmeti.get(selectedPredmet);
		predmet.getPredmetniProf().remove(selectedProfesor);	
	}
	
	

}
