package rs.ac.uns.ftn.oisis.controller;

import java.io.IOException;

import rs.ac.uns.ftn.oisis.model.BazaPredmeta;
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
}
