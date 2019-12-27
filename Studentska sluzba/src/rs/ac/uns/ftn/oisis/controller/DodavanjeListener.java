package rs.ac.uns.ftn.oisis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rs.ac.uns.ftn.oisis.view.DodavanjePredmetaDialog;
import rs.ac.uns.ftn.oisis.view.MainFrame;
import rs.ac.uns.ftn.oisis.view.TabbedPane;
import rs.ac.uns.ftn.oisis.view.ToolBar;

public class DodavanjeListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		if (TabbedPane.activeTab == 0) {

		} else if (TabbedPane.activeTab == 1) {
			DodavanjePredmetaDialog dialog = new DodavanjePredmetaDialog(MainFrame.getInstance(), "Dodavanje predmeta",
					true);
			dialog.setVisible(true);
			ToolBar.getInstance().setSelectedButton();
		} else if (TabbedPane.activeTab == 2) {

		}

	}

}