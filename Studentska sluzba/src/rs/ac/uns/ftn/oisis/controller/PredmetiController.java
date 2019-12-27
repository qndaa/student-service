package rs.ac.uns.ftn.oisis.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisis.model.BazaPredmeta;
import rs.ac.uns.ftn.oisis.model.Predmet;
import rs.ac.uns.ftn.oisis.view.IzmenaPredmetaDialog;
import rs.ac.uns.ftn.oisis.view.MainFrame;
import rs.ac.uns.ftn.oisis.view.PredmetiTable;
import rs.ac.uns.ftn.oisis.view.ToolBar;

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

		return dodao;
	}

	public void saveData() throws IOException {
		BazaPredmeta.getInstance().savePredmete();
	}

	public void loadData() throws IOException {
		BazaPredmeta.getInstance().loadPredmete();
	}

	public void brisanjePredmeta() {
		int selectedRow = PredmetiTable.getInstance().getSelectedRow();
		if (selectedRow >= 0 && selectedRow < BazaPredmeta.getBrojUnetihPredmeta()&& 
				BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) {
			System.out.println("obicno");
			int odabir = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
					"Da li ste sigurni da zelite da izbrisete predmet?", "Brsanje predmeta", JOptionPane.YES_NO_OPTION);
			if (odabir == JOptionPane.YES_OPTION) {
				BazaPredmeta.getInstance().obrisiPredmet(selectedRow);
			}
		} else if(selectedRow >= 0 && selectedRow < BazaPredmeta.getBrojPredmetaKojiSuUPretrazi()){
			System.out.println("Search");
			int odabir = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
					"Da li ste sigurni da zelite da izbrisete predmet?", "Brsanje predmeta", JOptionPane.YES_NO_OPTION);
			
			if (odabir == JOptionPane.YES_OPTION) {
				Predmet p = BazaPredmeta.getInstance().getRazultatPretrage().get(selectedRow);
				BazaPredmeta.getInstance().getRazultatPretrage().remove(selectedRow);
				BazaPredmeta.getInstance().smanjiBrojPredmetaKojiSuUPretrazi();
				BazaPredmeta.getInstance().brisiPoKljucu(p.getSifra());
			}
		} else {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Predmet nije selektovan!", "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void izmenaPredmeta() {
		
		int selectedRow = PredmetiTable.getInstance().getSelectedRow();
		
		if (selectedRow >= 0 && selectedRow < BazaPredmeta.getBrojUnetihPredmeta() &&  
				BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0 ) {
			
			IzmenaPredmetaDialog dialog = new IzmenaPredmetaDialog(MainFrame.getInstance(), "Izmena predmeta", true);
			
			dialog.setVisible(true);
			
		} else if(selectedRow >= 0 && selectedRow < BazaPredmeta.getBrojPredmetaKojiSuUPretrazi()){
			IzmenaPredmetaDialog dialog = new IzmenaPredmetaDialog(MainFrame.getInstance(), "Izmena predmeta", true);
			
			dialog.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Predmet nije selektovan!", "Greska",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void pretragaPredmeta() {
		String input = ToolBar.getInstance().getSearchField().getText();

		BazaPredmeta.getInstance().pretraziPredmete(input);

		PredmetiTable.getInstance().refreshTable();

	}

}
