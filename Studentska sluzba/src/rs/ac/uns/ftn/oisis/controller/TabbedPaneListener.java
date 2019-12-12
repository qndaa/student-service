package rs.ac.uns.ftn.oisis.controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import rs.ac.uns.ftn.oisis.view.TabbedPane;
import rs.ac.uns.ftn.oisis.view.ToolBar;

public class TabbedPaneListener implements ChangeListener{

	@Override
	public void stateChanged(ChangeEvent e) {
		TabbedPane tabbedPane = (TabbedPane) e.getSource();
		ToolBar toolBar = ToolBar.getInstance();
		toolBar.paintComponents(toolBar.getTip(tabbedPane.getSelectedIndex()));
		
	}

}
