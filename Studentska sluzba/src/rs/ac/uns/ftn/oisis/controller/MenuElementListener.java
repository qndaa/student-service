package rs.ac.uns.ftn.oisis.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rs.ac.uns.ftn.oisis.view.MainFrame;
import rs.ac.uns.ftn.oisis.view.TabbedPane;
import rs.ac.uns.ftn.oisis.view.DialogStudent;
import rs.ac.uns.ftn.oisis.view.DodavanjeStudentaDijalog;

public class MenuElementListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(TabbedPane.activeTab==0) {
		DodavanjeStudentaDijalog di = new DodavanjeStudentaDijalog(MainFrame.getInstance(),"Dodavanje studenta", true);
		di.setVisible(true);
		}
		
	}

}