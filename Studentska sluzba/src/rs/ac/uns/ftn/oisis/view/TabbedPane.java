package rs.ac.uns.ftn.oisis.view;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {
	

	private static final long serialVersionUID = 6085217537142043863L;

	public TabbedPane () {
		addTab("Studenti", new ImageIcon("images/student_tab.png"),null, "");
		addTab("Predmeti", new ImageIcon("images/predmet_tab.png"),null, "");
		addTab("Profesori", new ImageIcon("images/profesor_tab.png"),null, "");
	}

	
	
	
	
	
	
	
	
	
	
	
	
}