package rs.ac.uns.ftn.oisis.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rs.ac.uns.ftn.oisis.view.MainFrame;
import rs.ac.uns.ftn.oisis.view.DialogStudent;

public class MenuElementListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		DialogStudent di= new DialogStudent(MainFrame.getInstance(),"Dodavanje studenta", true);
		di.setVisible(true);
		 
		
	}

}
