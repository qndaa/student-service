package rs.ac.uns.ftn.oisis.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisis.model.BazaProfesora;
import rs.ac.uns.ftn.oisis.view.MainFrame;
import rs.ac.uns.ftn.oisis.view.ProfesoriTable;
import rs.ac.uns.ftn.oisis.view.ToolBar;

public class ProfesoriController {

	private static ProfesoriController instance = null;

	public static ProfesoriController getInstance() {
		if (instance == null) {
			instance = new ProfesoriController();
		}

		return instance;
	}

	public boolean DodajProfesora(String[] p) {
		return BazaProfesora.getInstance().DodajProf(p);
	} 
	
	public void brisanjeProfesora() {
		int selectedRow = ProfesoriTable.getInstance().getSelectedRow();
		BazaProfesora.getInstance();
		BazaProfesora.getInstance();
		if (selectedRow >= 0 && selectedRow < BazaProfesora.getBrojUnetihProfesora()
				&& BazaProfesora.getBrojProfesoraKojiSuUPretrazi() == 0) {
			int odabir = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
					"Da li ste sigurni da zelite da izbrisete profesora?", "Brsanje predmeta",
					JOptionPane.YES_NO_OPTION);

			if (odabir == JOptionPane.YES_OPTION) {
				BazaProfesora.getInstance().obrisiProfesora(selectedRow);
			}
		} else if (selectedRow >= 0 && selectedRow < BazaProfesora.getBrojProfesoraKojiSuUPretrazi()) {
			int odabir = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
					"Da li ste sigurni da zelite da izbrisete profesora?", "Brsanje predmeta",
					JOptionPane.YES_NO_OPTION);
			if (odabir == JOptionPane.YES_OPTION) {
				// kada brisemo iz pretrage

			}
		} else {
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Profesor nije selektovan!", "Greska",
					JOptionPane.ERROR_MESSAGE);

		}

	}

	public void saveData() throws IOException {
		BazaProfesora.getInstance().saveProfesori();
	}

	public void loadData() throws IOException {
		BazaProfesora.getInstance().loadProfesori();
	}

	public void dodajPredmet(String[] trimFields) {

	}

	public void pretragaProfesora() {
		String input = ToolBar.getInstance().getSearchField().getText();

		BazaProfesora.getInstance().pretraziProfesore(input);

		ProfesoriTable.getInstance().refresTable();

	}

}
