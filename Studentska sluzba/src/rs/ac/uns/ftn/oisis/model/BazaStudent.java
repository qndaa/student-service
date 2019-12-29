package rs.ac.uns.ftn.oisis.model;

import java.util.ArrayList;

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
		addStudenta();
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

	void addStudenta() {
		spisakStudenata.add(new Student("Aca", "Simic", "26.12.1998", "Kneza Caslava br.14", "0692603936",
				"simicaca98@gmail.com", "RA-175-2017", "10.10.2017", 8.0, GodinaStudija.III, Status.B));
		brStudenata++;
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
			default:
				return null;
			}
		} else {
			return null;
		}

	}

	public boolean Dodavanje(String[] p) {
		String index = p[6];
		if (ProveraIndeksa(index)) {
			brStudenata++;
			Student s = new Student(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[8], 0, GodinaStudija.valueOf(p[7]),
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
