package rs.ac.uns.ftn.oisis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rs.ac.uns.ftn.oisis.view.PredmetiTable;
import rs.ac.uns.ftn.oisis.view.TabbedPane;
import rs.ac.uns.ftn.oisis.view.ToolBar;

public class IzmenaListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(TabbedPane.activeTab == 0) {
			// Implementirati izmenu studenta
			
			
			
			
			ToolBar.getInstance().setSelectedButton();
		} else if (TabbedPane.activeTab == 1){
			// Implementirati izmenu predmeta
			PredmetiController.getInstance().izmenaPredmeta();
			PredmetiTable.getInstance().refreshTable();
			ToolBar.getInstance().setSelectedButton();
		} else if (TabbedPane.activeTab == 2) {
			// Implementirati izmenu profesora
			
			
			
			
			
			ToolBar.getInstance().setSelectedButton();
		}
		
	}

}
