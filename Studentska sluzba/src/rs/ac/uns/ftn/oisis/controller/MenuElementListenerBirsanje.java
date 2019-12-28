package rs.ac.uns.ftn.oisis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rs.ac.uns.ftn.oisis.view.StudentiTable;
import rs.ac.uns.ftn.oisis.view.TabbedPane;

public class MenuElementListenerBirsanje implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(TabbedPane.activeTab == 0) {
			
			StudentiController.getInstance().BrisanjeStudenta();
			StudentiTable.getInstance().OsveziTabelu();
			
		}
		
	}

}
