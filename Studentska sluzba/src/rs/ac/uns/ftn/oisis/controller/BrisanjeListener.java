package rs.ac.uns.ftn.oisis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rs.ac.uns.ftn.oisis.view.PredmetiTable;
import rs.ac.uns.ftn.oisis.view.TabbedPane;
import rs.ac.uns.ftn.oisis.view.ToolBar;

public class BrisanjeListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(TabbedPane.activeTab == 0) {
			// implementirati brisanje studenta
		} else if (TabbedPane.activeTab == 1) {
			// implementirati brisanje predmeta
			PredmetiController.getInstance().brisanjePredmeta();
			PredmetiTable.getInstance().refreshTable();	
			ToolBar.getInstance().setSelectedButton();
		} else if (TabbedPane.activeTab == 2) {
			// implementirati brisanje profesora 	
		}
		
	}

}
