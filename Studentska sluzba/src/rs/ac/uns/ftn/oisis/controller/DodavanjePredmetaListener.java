package rs.ac.uns.ftn.oisis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rs.ac.uns.ftn.oisis.view.DodavanjePredmetaDialog;
import rs.ac.uns.ftn.oisis.view.MainFrame;
import rs.ac.uns.ftn.oisis.view.ToolBar;

public class DodavanjePredmetaListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		DodavanjePredmetaDialog dialog = new DodavanjePredmetaDialog(MainFrame.getInstance(), "Dodavanje predmeta", true);
		dialog.setVisible(true);
		ToolBar.getInstance().setSelectedButton();
		
	}

}
