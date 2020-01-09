package rs.ac.uns.ftn.oisis.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisis.view.MainFrame;

public class BazaStudent {

	private static BazaStudent instance = null;
	private ArrayList<String> colon;
	private ArrayList<Student> spisakStudenata;
	private ArrayList<Student> rezPretrage;

	private static int brStudenataPretga = 0;
	private static int brStudenata = 0;
	private static int brPredmeta = 0;

	public static BazaStudent getInstance() {
		if (instance == null) {
			instance = new BazaStudent();
		}

		return instance;
	}

	public static int getBrPredmeta() {
		return brPredmeta;
	}

	public static void setBrPredmeta(int brPredmeta) {
		BazaStudent.brPredmeta = brPredmeta;
	}

	private BazaStudent() {
		colon = new ArrayList<String>();
		spisakStudenata = new ArrayList<Student>();
		rezPretrage = new ArrayList<Student>();
		colon.add("Broj indeksa");
		colon.add("Ime");
		colon.add("Prezime");
		colon.add("Godina studija");
		colon.add("Status");
		colon.add("Prosek");
		colon.add("Dat.Rodjenja");
		colon.add("Telefon");
		colon.add("Email");
		colon.add("Adresa");
		colon.add("Dat.Upisa");
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

	public void sacuvajStudente() throws IOException {
		ObjectOutputStream out = null;

		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("studenti.raw")));
			for (Student s : spisakStudenata) {
				out.writeObject(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}

	}

	public void otvoriFileStudenta() throws IOException {
		ObjectInputStream in = null;
		Student s = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("studenti.raw")));
			while (true) {
				s = (Student) in.readObject();
				DodavanjeObjecta(s);
			}

		} catch (Exception e) {
			
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}

	public String getValueAt(int row, int column) {
		ArrayList<Student> t;
		if (rezPretrage.size() == 0) {
			t = spisakStudenata;
		} else {
			t = rezPretrage;
		}
		if (row < t.size()) {

			Student student = t.get(row);
			switch (column) {
			case 0:
				return student.getBrIndeksa();
			case 1:
				return student.getIme();
			case 2:
				return student.getPrezime();
			case 3:
				return student.getGodinaS();
			case 4:
				return student.getStatusS();
			case 5:
				return student.getProsekS();
			case 6:
				return student.getDatumRodjenja();
			case 7:
				return student.getKontaktTelefon();
			case 8:
				return student.getEmail();
			case 9:
				return student.getAdresaStanovanja();
			case 10:
				return student.getDatumUpisa();
			case 11:
				return "Predmeti";

			default:
				return null;
			}
		} else {
			return null;
		}

	}

	public boolean Dodavanje(String[] p) {
		String index = p[6];
		double prosek = Double.parseDouble(p[10]);
		Random rand = new Random();
		prosek = rand.nextInt((10 - 5) + 1) + 5;
		if (ProveraIndeksa(index)) {
			brStudenata++;
			Student s = new Student(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[8], prosek, GodinaStudija.valueOf(p[7]),
					Status.valueOf(p[9]));
			spisakStudenata.add(s);
			return true;
		}

		return false;
	}

	public void DodavanjeObjecta(Student s) {
		brStudenata++;
		spisakStudenata.add(s);
	}

	public boolean ProveraIndeksa(String index) {
		for (Student s : spisakStudenata) {
			if (s.getBrIndeksa().equals(index)) {
				return false;
			}
		}
		return true;
	}

	public void BrisanjeStudenta(int i) {
		spisakStudenata.remove(i);
		brStudenata--;
	}

	public static int getBrStudenata() {
		return brStudenata;
	}

	public Student getStudent(String index) {
		Student student = null;
		for (Student s : spisakStudenata) {
			if (s.getBrIndeksa().equals(index)) {
				student = s;
			}
		}

		return student;
	}

	public void SmanjiBrPretrage() {
		brStudenataPretga--;
	}

	public void BrisanjePoIndeksu(String indeks) {
		int pamtiIndeks = -1;
		for (int i = 0; i < spisakStudenata.size(); i++) {
			if (spisakStudenata.get(i).getBrIndeksa().equals(indeks)) {
				pamtiIndeks = i;
			}
		}
		if (pamtiIndeks != -1) {
			spisakStudenata.remove(pamtiIndeks);
			brStudenata--;
		}
	}

	public void DodajPredmetStudentu(Predmet predmet, String s) {
		for (int i = 0; i < spisakStudenata.size(); i++) {
			if (spisakStudenata.get(i).getBrIndeksa().equals(s)) {
				spisakStudenata.get(i).getSpisakPredmeta().add(predmet);
				brPredmeta++;
			}
		}
	}

	public void IzbrisiPredmetStudentu(String sifraPredmeta, String brIndeksa) {
		for (int i = 0; i < spisakStudenata.size(); i++) {
			if (spisakStudenata.get(i).getBrIndeksa().equals(brIndeksa)) {
				for (int j = 0; j < spisakStudenata.get(i).getSpisakPredmeta().size(); j++) {
					if (spisakStudenata.get(i).getSpisakPredmeta().get(j).getSifra().equals(sifraPredmeta)) {
						spisakStudenata.get(i).getSpisakPredmeta().remove(j);
					}
				}

			}
		}

	}

	public void PretragaStud(String ulaz) {
		
		if (ulaz.trim().length() == 0) {
			rezPretrage.clear();
			brStudenataPretga = 0;
			return;
		}


		rezPretrage.clear();
		brStudenataPretga = 0;
		String prvaPodela[] = ulaz.trim().split(";");
		String prvi = prvaPodela[0];
		String drugaPodela[] = prvi.trim().split(":");

		if (drugaPodela.length != 2 || drugaPodela[1].trim().length() == 0) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Nije napisana dobro pretraga", "EROR",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (drugaPodela[0].toLowerCase().equals("broj indeksa") || drugaPodela[0].toLowerCase().equals("br. indeksa")) {
			for (Student s : spisakStudenata) {
				if (s.getBrIndeksa().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
					rezPretrage.add(s);
				}

			}

		} else if (drugaPodela[0].toLowerCase().equals("ime")) {
			for (Student s : spisakStudenata) {
				if (s.getIme().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
					rezPretrage.add(s);
				}
			}
		} else if (drugaPodela[0].toLowerCase().equals("prezime") || drugaPodela[0].toLowerCase().equals("prz")) {
			for (Student s : spisakStudenata) {
				if (s.getPrezime().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
					rezPretrage.add(s);
				}
			}
		} else if (drugaPodela[0].toLowerCase().equals("god. studija")
				|| drugaPodela[0].toLowerCase().equals("godina studija")) {
			for (Student s : spisakStudenata) {
				if (s.getGodinaS().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
					rezPretrage.add(s);
				}
			}
		} else if (drugaPodela[0].toLowerCase().equals("status")
				|| drugaPodela[0].toLowerCase().equals("status studenta")
				|| drugaPodela[0].toLowerCase().equals("status stud")) {
			for (Student s : spisakStudenata) {
				if (s.getStatusS().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
					rezPretrage.add(s);
				}
			}
		} else if (drugaPodela[0].toLowerCase().equals("prosek")) {
			for (Student s : spisakStudenata) {
				if (s.getProsekS().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
					rezPretrage.add(s);
				}
			}
		} else if (drugaPodela[0].toLowerCase().equals("datum rodjenja")
				|| drugaPodela[0].toLowerCase().equals("dat. rodjenja")) {
			for (Student s : spisakStudenata) {
				if (s.getDatumRodjenja().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
					rezPretrage.add(s);
				}
			}
		} else if (drugaPodela[0].toLowerCase().equals("broj telefona")
				|| drugaPodela[0].toLowerCase().equals("br. telefona") || drugaPodela[0].toLowerCase().equals("br")) {
			for (Student s : spisakStudenata) {
				if (s.getKontaktTelefon().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
					rezPretrage.add(s);
				}
			}
		} else if (drugaPodela[0].toLowerCase().equals("email") || drugaPodela[0].toLowerCase().equals("gmail")) {
			for (Student s : spisakStudenata) {
				if (s.getEmail().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
					rezPretrage.add(s);
				}
			}
		} else if (drugaPodela[0].toLowerCase().equals("adresa")) {
			for (Student s : spisakStudenata) {
				if (s.getAdresaStanovanja().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
					rezPretrage.add(s);
				}
			}
		} else if (drugaPodela[0].toLowerCase().equals("dat. upisa")
				|| drugaPodela[0].toLowerCase().equals("datum upisa")) {
			for (Student s : spisakStudenata) {
				if (s.getDatumUpisa().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
					rezPretrage.add(s);
				}
			}
		} else {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Nije napisana dobro pretraga", "EROR",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (prvaPodela.length > 1) {
			for (int i = 0; i < prvaPodela.length; i++) {
				prvi = prvaPodela[i];
				drugaPodela = prvi.trim().split(":");

				if (drugaPodela.length != 2 || drugaPodela[1].trim().length() == 0) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Nije napisana dobro pretraga", "EROR",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (drugaPodela[0].toLowerCase().equals("broj indeksa")
						|| drugaPodela[0].toLowerCase().equals("br. indeksa")) {
					for (Student s : spisakStudenata) {
						if (!s.getBrIndeksa().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}

					}

				} else if (drugaPodela[0].toLowerCase().equals("ime")) {
					for (Student s : spisakStudenata) {
						if (!s.getIme().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}
					}
				} else if (drugaPodela[0].toLowerCase().equals("prezime")
						|| drugaPodela[0].toLowerCase().equals("prz")) {
					for (Student s : spisakStudenata) {
						if (!s.getPrezime().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}
					}
				} else if (drugaPodela[0].toLowerCase().equals("god. studija")
						|| drugaPodela[0].toLowerCase().equals("godina studija")) {
					for (Student s : spisakStudenata) {
						if (!s.getGodinaS().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}
					}
				} else if (drugaPodela[0].toLowerCase().equals("status")
						|| drugaPodela[0].toLowerCase().equals("status studenta")
						|| drugaPodela[0].toLowerCase().equals("status stud")) {
					for (Student s : spisakStudenata) {
						if (!s.getStatusS().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}
					}
				} else if (drugaPodela[0].toLowerCase().equals("prosek")) {
					for (Student s : spisakStudenata) {
						if (!s.getProsekS().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}
					}
				} else if (drugaPodela[0].toLowerCase().equals("datum rodjenja")
						|| drugaPodela[0].toLowerCase().equals("dat. rodjenja")) {
					for (Student s : spisakStudenata) {
						if (!s.getDatumRodjenja().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}
					}
				} else if (drugaPodela[0].toLowerCase().equals("broj telefona")
						|| drugaPodela[0].toLowerCase().equals("br. telefona")
						|| drugaPodela[0].toLowerCase().equals("br")) {
					for (Student s : spisakStudenata) {
						if (!s.getKontaktTelefon().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}
					}
				} else if (drugaPodela[0].toLowerCase().equals("email")
						|| drugaPodela[0].toLowerCase().equals("gmail")) {
					for (Student s : spisakStudenata) {
						if (!s.getEmail().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}
					}
				} else if (drugaPodela[0].toLowerCase().equals("adresa")) {
					for (Student s : spisakStudenata) {
						if (!s.getAdresaStanovanja().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}
					}
				} else if (drugaPodela[0].toLowerCase().equals("dat. upisa")
						|| drugaPodela[0].toLowerCase().equals("datum upisa")) {
					for (Student s : spisakStudenata) {
						if (!s.getDatumUpisa().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}
					}
				} else {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Nije napisana dobro pretraga", "EROR",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

			}

		}

		brStudenataPretga = rezPretrage.size();
		if (rezPretrage.size() == 0) {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Ne postoji student sa unetim podacima", "EROR",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

	}// kraj metode

	public ArrayList<Student> getRezPretrage() {
		return rezPretrage;
	}

	public void setRezPretrage(ArrayList<Student> rezPretrage) {
		this.rezPretrage = rezPretrage;
	}

	public static int getBrStudenataPretga() {
		return brStudenataPretga;
	}

	public static void setBrStudenataPretga(int brStudenataPretga) {
		BazaStudent.brStudenataPretga = brStudenataPretga;
	}

	public static void setBrStudenata(int brStudenata) {
		BazaStudent.brStudenata = brStudenata;
	}

}// kraj klase
