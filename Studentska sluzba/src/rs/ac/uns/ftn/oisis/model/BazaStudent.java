package rs.ac.uns.ftn.oisis.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import rs.ac.uns.ftn.oisis.controller.StudentiController;
import rs.ac.uns.ftn.oisis.view.StudentiTable;

public class BazaStudent {

	private static BazaStudent instance = null;
	private ArrayList<String> colon;
	private ArrayList<Student> spisakStudenata;
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
		colon.add("Broj indeksa");
		colon.add("Ime");
		colon.add("Prezime");
		colon.add("Godina studija");
		colon.add("Status");
		colon.add("Prosek");
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


	public void sacuvajStudente()  throws IOException {
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
		
		while((line = bfr.readLine()) != null) {
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
		if (row < brStudenata) {
			Student student = spisakStudenata.get(row);
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
				return "Predmeti";
			case 7:
				return student.getDatumRodjenja();
			case 8:
				return student.getKontaktTelefon();
			case 9:
				return student.getEmail();
			case 10:
					return student.getAdresaStanovanja();
			case 11:
					return student.getDatumUpisa();
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

	public void DodajPredmetStudentu(Predmet predmet, String s) {
		for (int i = 0; i < spisakStudenata.size(); i++) {
			if (spisakStudenata.get(i).getBrIndeksa().equals(s)) {
				spisakStudenata.get(i).getSpisakPredmeta().add(predmet);
				brPredmeta++;
			}

		}

	}

}
