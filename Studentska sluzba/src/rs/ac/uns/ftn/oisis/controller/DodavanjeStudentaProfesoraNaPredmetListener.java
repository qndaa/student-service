package rs.ac.uns.ftn.oisis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisis.view.DodavanjeStudentaProfesoraNaPredmetDialog;
import rs.ac.uns.ftn.oisis.view.MainFrame;
import rs.ac.uns.ftn.oisis.view.PredmetiTablePane;
import rs.ac.uns.ftn.oisis.view.ToolBar;

public class DodavanjeStudentaProfesoraNaPredmetListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (PredmetiTablePane.getSelectedRow() > -1) {
			DodavanjeStudentaProfesoraNaPredmetDialog dialog = new DodavanjeStudentaProfesoraNaPredmetDialog(
					MainFrame.getInstance(), "Dodajte na predmet?", true);
			dialog.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Predmet nije selektovan!", "Greska",
					JOptionPane.ERROR_MESSAGE);
			ToolBar.getInstance().setSelectedButton();
		}

	}

}
