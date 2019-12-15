package rs.ac.uns.ftn.oisis.model;

import java.util.ArrayList;

public class BazaStudent {
	
	private static BazaStudent instance= null;
	private ArrayList<String> colon;
	private ArrayList<Student> spisakStudenata;
	private static int brStudenata=0;
	
	public static BazaStudent getInstance() {
			if(instance==null) {
				instance= new BazaStudent();
			}
		
		return instance;
	}
	

	private BazaStudent() {
		colon= new ArrayList<String>();
		spisakStudenata= new ArrayList<Student>();
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
		spisakStudenata.add(new Student("Aca", "Simic", "26.12.1998","Kneza Caslava br.14","0692603936", "simicaca98@gmail.com", "Ra175/2017","nekad",8.0,GodinaStudija.III, Status.B));
		brStudenata++;
	}
	
	
	public String getValueAt(int row,int column) {
			if(row<brStudenata) {
				Student student= spisakStudenata.get(row);
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
			}else {
				return null;	
			}
		
		
	}


}
