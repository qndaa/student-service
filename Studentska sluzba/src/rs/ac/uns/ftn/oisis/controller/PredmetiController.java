package rs.ac.uns.ftn.oisis.controller;


import java.io.IOException;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisis.model.BazaPredmeta;
import rs.ac.uns.ftn.oisis.view.MainFrame;
import rs.ac.uns.ftn.oisis.view.PredmetiTable;

public class PredmetiController {

	private static PredmetiController instance = null;

	public static PredmetiController getInstance() {
		if (instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}
	public boolean dodajPredmet(String kolone[]) {
		boolean dodao = BazaPredmeta.getInstance().dodajPredmet(kolone);
		if(dodao == true) {
																//// nije zavrseno
		}
		return dodao;
	}

	
	public void saveData() throws IOException {
		PredmetiTable.getInstance().savePredmete();
	}
	
	public void loadData() throws IOException {
		PredmetiTable.getInstance().loadPredmete();
	}
	
	public void brisanjePredmeta() {
		int selectedRow = PredmetiTable.getInstance().getSelectedRow();
		if(selectedRow >= 0 && selectedRow <= BazaPredmeta.getBrojUnetihPredmeta()) {
			int odabir = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da zelite da izbrisete predmet?",
					"Brsanje predmeta", JOptionPane.YES_NO_OPTION);
			if (odabir == JOptionPane.YES_OPTION) {
				BazaPredmeta.getInstance().obrisiPredmet(selectedRow);
			}
		} else {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Predmet nije selektovan!", "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
}
