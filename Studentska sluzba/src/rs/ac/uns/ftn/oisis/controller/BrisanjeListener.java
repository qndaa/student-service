package rs.ac.uns.ftn.oisis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rs.ac.uns.ftn.oisis.view.PredmetiTable;
import rs.ac.uns.ftn.oisis.view.PredmetiTablePane;
import rs.ac.uns.ftn.oisis.view.ProfesoriTable;
import rs.ac.uns.ftn.oisis.view.ProfesoriTablePane;
import rs.ac.uns.ftn.oisis.view.StudentiTable;
import rs.ac.uns.ftn.oisis.view.StudentiTablePane;
import rs.ac.uns.ftn.oisis.view.TabbedPane;
import rs.ac.uns.ftn.oisis.view.ToolBar;

public class BrisanjeListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(TabbedPane.activeTab == 0) {
			// implementirati brisanje studenta
			StudentiController.getInstance().BrisanjeStudenta();
			StudentiTable.getInstance().OsveziTabelu();
			StudentiTablePane.setSelektovanaVrsta(-1);
			ToolBar.getInstance().setSelectedButton();
		} else if (TabbedPane.activeTab == 1) {
			// implementirati brisanje predmeta
			PredmetiController.getInstance().brisanjePredmeta();
			PredmetiTable.getInstance().refreshTable();	
			PredmetiTablePane.setSelectedRow(-1);
			ToolBar.getInstance().setSelectedButton();
		} else if (TabbedPane.activeTab == 2) {
			ProfesoriController.getInstance().brisanjeProfesora();
			ProfesoriTable.getInstance().refresTable();
			ProfesoriTablePane.setSelektovanaVrsta(-1);
			ToolBar.getInstance().setSelectedButton();
		}
		
	}

}
