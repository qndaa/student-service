package rs.ac.uns.ftn.oisis.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisis.view.MainFrame;
import rs.ac.uns.ftn.oisis.view.PredmetiTablePane;

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

	private File filePredmeti = new File("predmeti.raw");

	private BazaPredmeta() {
		super();
		nazivKolona = new ArrayList<String>();
		sviPredmeti = new ArrayList<Predmet>();
		razultatPretrage = new ArrayList<Predmet>();
		nazivKolona.add("Sifra");
		nazivKolona.add("Naziv");
		nazivKolona.add("Semestar");
		nazivKolona.add("Godina izvodjenja");
		nazivKolona.add("Predmetni profesor");
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
		if (obeVre.length != 2 || obeVre[1].trim().length() == 0) { // proverimo da li je uneseno sta se trazi
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
				if (obeVre.length != 2 || obeVre[1].trim().length() == 0) { // proverimo da li je uneseno sta se trazi
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

		ObjectOutputStream out = null;

		try {

			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePredmeti)));
			for (Predmet predmet : sviPredmeti) {
				out.writeObject(predmet);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void loadPredmete() throws IOException {
		ObjectInputStream in = null;

		Predmet predmet = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePredmeti)));
			while (true) {

				predmet = (Predmet) in.readObject();
				dodajPredmet(predmet);

			}
		} catch (Exception e) {

		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void dodajPredmet(Predmet predmet) {
		brojUnetihPredmeta++;
		sviPredmeti.add(predmet);
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
		for (Predmet p : sviPredmeti) {
			if (p.getSifra().equals(key)) {
				povratka = p;
			}
		}
		return povratka;

	}

	public void brisiPoKljucu(String key) {
		int i = 0;
		for (; i < sviPredmeti.size(); i++) {
			if (key.equals(sviPredmeti.get(i).getSifra())) {
				break;
			}
		}
		sviPredmeti.remove(i);
		brojUnetihPredmeta--;
	}

	public void smanjiBrojPredmetaKojiSuUPretrazi() {
		brojPredmetaKojiSuUPretrazi--;

	}

	public Boolean ProveraStudenta(String index, int row) {
		if (BrojStudenataNaPredmetu != 0) {
			for (Student s : sviPredmeti.get(row).getStudenti()) {
				System.out.println(sviPredmeti.get(row).getStudenti().size());
				if (s.getBrIndeksa().equals(index)) {
					return false;
				}
			}
		}
		return true;
	}

	public void DodajStudentaNaPredmet(Student stud, int i, Predmet p) {
		if (brojPredmetaKojiSuUPretrazi == 0) {
			sviPredmeti.get(i).getStudenti().add(stud);
			BrojStudenataNaPredmetu++;
		} else {
			for (Predmet pred : sviPredmeti) {
				if (pred.getSifra().equals(p.getSifra())) {
					pred.getStudenti().add(stud);
					// razultatPretrage.get(i).getStudenti().add(stud);
				}

			}

		}
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
		Predmet predmet;
		if (brojPredmetaKojiSuUPretrazi == 0) {
			predmet = sviPredmeti.get(selectedRow);
		} else {
			predmet = razultatPretrage.get(selectedRow);
		}
		return predmet.dodajProfesoraNaPredmet(profesor);

	}

	public void obrisiProfesoraSaPredmeta() {
		int selectedPredmet = PredmetiTablePane.getSelectedRow();
		Predmet predmet = sviPredmeti.get(selectedPredmet);
		predmet.setPredmetniProf(null);
	}

	public void obrisiProfesoraSaPredmeta(String licna) {
		for (Predmet predmet : sviPredmeti) {
			if (predmet.getPredmetniProf() != null) {
				if (predmet.getPredmetniProf().getBrojLicneKarte().equals(licna)) {
					predmet.setPredmetniProf(null);
				}
			}
		}
	}

	public String[] IzbrisiStudentaSaPredmeta(int sleketovanPredmet, int selektovanStudent) {
		String sifrIndeks[] = new String[2];

		sifrIndeks[0] = sviPredmeti.get(sleketovanPredmet).getSifra();
		sifrIndeks[1] = sviPredmeti.get(sleketovanPredmet).getStudenti().get(selektovanStudent).getBrIndeksa();
		sviPredmeti.get(sleketovanPredmet).getStudenti().remove(selektovanStudent);
		BrojStudenataNaPredmetu--;
		return sifrIndeks;

	}

}
