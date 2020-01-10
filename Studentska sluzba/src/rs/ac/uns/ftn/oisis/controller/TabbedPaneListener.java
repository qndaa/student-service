package rs.ac.uns.ftn.oisis.controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import rs.ac.uns.ftn.oisis.view.MenuBar;
import rs.ac.uns.ftn.oisis.view.PredmetiTablePane;
import rs.ac.uns.ftn.oisis.view.ProfesoriTablePane;
import rs.ac.uns.ftn.oisis.view.StudentiTablePane;
import rs.ac.uns.ftn.oisis.view.TabbedPane;
import rs.ac.uns.ftn.oisis.view.ToolBar;

public class TabbedPaneListener implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent e) {
		TabbedPane tabbedPane = (TabbedPane) e.getSource();
		ToolBar toolBar = ToolBar.getInstance();
		toolBar.paintComponents(toolBar.getTip(TabbedPane.activeTab = tabbedPane.getSelectedIndex()));
		ToolBar.getInstance().getSearchField().setText("");

		PredmetiController.getInstance().pretragaPredmeta();
		ProfesoriController.getInstance().pretragaProfesora();
		StudentiController.getInstance().pretragaStudenta();
		
		PredmetiTablePane.setSelectedRow(-1);
		ProfesoriTablePane.setSelektovanaVrsta(-1);
		StudentiTablePane.setSelektovanaVrsta(-1);
		
		MenuBar.getInstance().PromenaDugmica(TabbedPane.activeTab);
	}

}
