package rs.ac.uns.ftn.oisis.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisis.view.MainFrame;
import rs.ac.uns.ftn.oisis.view.StudentiTable;

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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("studenti.txt")));

		for (int i = 0; i < spisakStudenata.size(); i++) {
			Student s = spisakStudenata.get(i);
			String line = s.toString();
			bw.write(line);
		}
		bw.close();
	}

	public void otvoriFileStudenta() throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream("studenti.txt")));
		String line;

		while ((line = bfr.readLine()) != null) {
			String p[] = line.split("-");
			String trimP[] = new String[p.length];
			for (int i = 0; i < p.length; i++) {
				trimP[i] = p[i].trim();
			}
			Dodavanje(trimP);
			StudentiTable.getInstance().OsveziTabelu();

		}

		bfr.close();
	}

	public String getValueAt(int row, int column) {
		ArrayList<Student> t;
		if(rezPretrage.size() == 0) {
			t = spisakStudenata;
		}else {
			t=rezPretrage;
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
		if (ProveraIndeksa(index)) {
			brStudenata++;
			Student s = new Student(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[8], prosek, GodinaStudija.valueOf(p[7]),
					Status.valueOf(p[9]));
			spisakStudenata.add(s);
			return true;
		}

		return false;
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
		int pamtiIndeks=-1;
		for (int i = 0; i < spisakStudenata.size(); i++) {
			if(spisakStudenata.get(i).getBrIndeksa().equals(indeks)) {
				pamtiIndeks=i;
			}
		}
		if(pamtiIndeks != -1) {
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

	public void PretragaStud(String ulaz) {
		// proveravam da li je unetio nesto ako nije ne ulazi u fun
		if (ulaz.trim().length() == 0) {
			rezPretrage.clear();
			brStudenataPretga = 0;
			return;
		}

		// resetuje se sve pre pretrage
		rezPretrage.clear();
		brStudenataPretga = 0;

		// sad moram da parsiram, kad podelim po ;
		// sad moze biit jedna od 11 mogucnosti to proveravam na osnovu :
		// prvo proveravamo da li je unet samo 1 od mogucnosti za pretragu
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
				if (s.getBrIndeksa().toLowerCase().equals(drugaPodela[1].trim().toLowerCase()) ) {
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
		}else if(drugaPodela[0].toLowerCase().equals("prosek")) {
			for (Student s : spisakStudenata) {
				if(s.getProsekS().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
					rezPretrage.add(s);
				}
			}
		}else if(drugaPodela[0].toLowerCase().equals("datum rodjenja") || drugaPodela[0].toLowerCase().equals("dat. rodjenja")) {
			for (Student s : spisakStudenata) {
				if(s.getDatumRodjenja().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
					rezPretrage.add(s);
				}
			}
		}else if(drugaPodela[0].toLowerCase().equals("broj telefona") || drugaPodela[0].toLowerCase().equals("br. telefona") || drugaPodela[0].toLowerCase().equals("br")) {
			for (Student s : spisakStudenata) {
				if(s.getKontaktTelefon().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
					rezPretrage.add(s);
				}
			}
		}else if(drugaPodela[0].toLowerCase().equals("email") || drugaPodela[0].toLowerCase().equals("gmail")) {
			for (Student s : spisakStudenata) {
				if(s.getEmail().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
					rezPretrage.add(s);
				}
			}
		}else if(drugaPodela[0].toLowerCase().equals("adresa")) {
			for (Student s : spisakStudenata) {
				if(s.getAdresaStanovanja().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
					rezPretrage.add(s);
				}
			}
		}else if(drugaPodela[0].toLowerCase().equals("dat. upisa") || drugaPodela[0].toLowerCase().equals("datum upisa")) {
			for (Student s : spisakStudenata) {
				if(s.getDatumUpisa().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
					rezPretrage.add(s);
				}
			}
		}else {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Nije napisana dobro pretraga", "EROR",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(prvaPodela.length>1) {
			for (int i = 0; i < prvaPodela.length; i++) {
				prvi = prvaPodela[i];
				drugaPodela = prvi.trim().split(":");
				
				if (drugaPodela.length != 2 || drugaPodela[1].trim().length() == 0) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Nije napisana dobro pretraga", "EROR",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (drugaPodela[0].toLowerCase().equals("broj indeksa") || drugaPodela[0].toLowerCase().equals("br. indeksa")) {
					for (Student s : spisakStudenata) {
						if (!s.getBrIndeksa().toLowerCase().equals(drugaPodela[1].trim().toLowerCase()) ) {
							rezPretrage.remove(s);
						}

					}

				} else if (drugaPodela[0].toLowerCase().equals("ime")) {
					for (Student s : spisakStudenata) {
						if (!s.getIme().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}
					}
				} else if (drugaPodela[0].toLowerCase().equals("prezime") || drugaPodela[0].toLowerCase().equals("prz")) {
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
				}else if(drugaPodela[0].toLowerCase().equals("prosek")) {
					for (Student s : spisakStudenata) {
						if(!s.getProsekS().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}
					}
				}else if(drugaPodela[0].toLowerCase().equals("datum rodjenja") || drugaPodela[0].toLowerCase().equals("dat. rodjenja")) {
					for (Student s : spisakStudenata) {
						if(!s.getDatumRodjenja().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}
					}
				}else if(drugaPodela[0].toLowerCase().equals("broj telefona") || drugaPodela[0].toLowerCase().equals("br. telefona") || drugaPodela[0].toLowerCase().equals("br")) {
					for (Student s : spisakStudenata) {
						if(!s.getKontaktTelefon().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}
					}
				}else if(drugaPodela[0].toLowerCase().equals("email") || drugaPodela[0].toLowerCase().equals("gmail")) {
					for (Student s : spisakStudenata) {
						if(!s.getEmail().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}
					}
				}else if(drugaPodela[0].toLowerCase().equals("adresa")) {
					for (Student s : spisakStudenata) {
						if(!s.getAdresaStanovanja().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}
					}
				}else if(drugaPodela[0].toLowerCase().equals("dat. upisa") || drugaPodela[0].toLowerCase().equals("datum upisa")) {
					for (Student s : spisakStudenata) {
						if(!s.getDatumUpisa().toLowerCase().equals(drugaPodela[1].trim().toLowerCase())) {
							rezPretrage.remove(s);
						}
					}
				}else {
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

	}//kraj metode

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
	
	
	
	
	
	
	
	
	
	

}//kraj klase
