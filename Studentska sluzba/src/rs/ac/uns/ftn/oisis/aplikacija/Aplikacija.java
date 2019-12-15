package rs.ac.uns.ftn.oisis.aplikacija;

import rs.ac.uns.ftn.oisis.model.BazaPredmeta;
import rs.ac.uns.ftn.oisis.model.BazaProfesora;
import rs.ac.uns.ftn.oisis.model.BazaStudent;
import rs.ac.uns.ftn.oisis.view.MainFrame;


public class Aplikacija {

	public static void main(String[] args) {
		// Start :D 
		MainFrame.getInstance();
		BazaProfesora.getInstance();
		BazaStudent.getInstance();
		BazaPredmeta.getInstance();

	}
	

}
