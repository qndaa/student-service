package rs.ac.uns.ftn.oisis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rs.ac.uns.ftn.oisis.view.DodavanjeStudentaProfesoraNaPredmetDialog;
import rs.ac.uns.ftn.oisis.view.MainFrame;

public class DodavanjeStudentaProfesoraNaPredmetListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		DodavanjeStudentaProfesoraNaPredmetDialog dialog = new DodavanjeStudentaProfesoraNaPredmetDialog(MainFrame.getInstance(), "Dodajte na predmet?", true);
		dialog.setVisible(true);
		
	}

}
