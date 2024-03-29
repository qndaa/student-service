package rs.ac.uns.ftn.oisis.view;


import javax.swing.ImageIcon;

import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {

	private static final long serialVersionUID = 6085217537142043863L;
	private	ProfesoriTablePane profesoriTablePane = new ProfesoriTablePane();
	private StudentiTablePane studentiTablePane = new StudentiTablePane();
	private PredmetiTablePane predmetiTablePane = new PredmetiTablePane();
	
	public static int activeTab = 0;
	
	public TabbedPane() {
		
		
		addTab("Studenti", new ImageIcon("images/student_tab.png"),studentiTablePane, "Tabela studenata");

		addTab("Predmeti", new ImageIcon("images/predmet_tab.png"), predmetiTablePane, "Tabela predmeta");

		addTab("Profesori", new ImageIcon("images/profesor_tab.png"), profesoriTablePane, "Tabela profesora");
	}
		
}
