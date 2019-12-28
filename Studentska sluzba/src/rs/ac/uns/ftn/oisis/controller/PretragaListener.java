package rs.ac.uns.ftn.oisis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rs.ac.uns.ftn.oisis.view.TabbedPane;

public class PretragaListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (TabbedPane.activeTab == 0) {

		} else if (TabbedPane.activeTab == 1) {
			PredmetiController.getInstance().pretragaPredmeta();

		} else if (TabbedPane.activeTab == 2) {
			ProfesoriController.getInstance().pretragaProfesora();
		}

	}

}
