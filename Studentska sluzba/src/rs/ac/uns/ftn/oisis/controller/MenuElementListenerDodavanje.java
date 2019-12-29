package rs.ac.uns.ftn.oisis.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rs.ac.uns.ftn.oisis.view.MainFrame;
import rs.ac.uns.ftn.oisis.view.PredmetiTable;
import rs.ac.uns.ftn.oisis.view.TabbedPane;
import rs.ac.uns.ftn.oisis.view.DialogProfesor;
import rs.ac.uns.ftn.oisis.view.DialogStudenaNaPredmet;
import rs.ac.uns.ftn.oisis.view.DodavanjeProfesoraDialog;
import rs.ac.uns.ftn.oisis.view.DodavanjeStudentaDijalog;

public class MenuElementListenerDodavanje implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(TabbedPane.activeTab==0) {
		DodavanjeStudentaDijalog di = new DodavanjeStudentaDijalog(MainFrame.getInstance(),"Dodavanje studenta", true);
		di.setVisible(true);
		}
		
		if(TabbedPane.activeTab == 1) {
			
			PredmetiController.getInstance().DodavanjeStudNaPred();
			PredmetiTable.getInstance().refreshTable();
			
		}
		
		
		if(TabbedPane.activeTab == 2) {
			DodavanjeProfesoraDialog di = new DodavanjeProfesoraDialog(MainFrame.getInstance(),"Dodavanje profesora", true);
					di.setVisible(true);
		}
		
	}

}
