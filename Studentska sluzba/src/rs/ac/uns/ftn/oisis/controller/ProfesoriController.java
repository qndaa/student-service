package rs.ac.uns.ftn.oisis.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisis.model.BazaPredmeta;
import rs.ac.uns.ftn.oisis.model.BazaProfesora;
import rs.ac.uns.ftn.oisis.model.Profesor;
import rs.ac.uns.ftn.oisis.view.IzmenaProfesoraDialog;
import rs.ac.uns.ftn.oisis.view.MainFrame;
import rs.ac.uns.ftn.oisis.view.ProfesoriTable;
import rs.ac.uns.ftn.oisis.view.ProfesoriTablePane;
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
	
	public void IzmenaProfesora() {
		int row = ProfesoriTable.getInstance().getSelectedRow();
		
		if(row >= 0 && row < BazaProfesora.getBrojUnetihProfesora() && BazaProfesora.getBrojProfesoraKojiSuUPretrazi() ==0) {
			IzmenaProfesoraDialog di = new IzmenaProfesoraDialog(MainFrame.getInstance(), "Izmena profesora", true);
			di.setVisible(true);
			
		}if(row >= 0 && row < BazaProfesora.getBrojProfesoraKojiSuUPretrazi() ) {
			IzmenaProfesoraDialog di = new IzmenaProfesoraDialog(MainFrame.getInstance(), "Izmena profesora", true);
			di.setVisible(true);
			
		}
		else {
		JOptionPane.showMessageDialog(MainFrame.getInstance(), "Profesor nije selektovan", "EROR",
					JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	public void brisanjeProfesora() {
		int selectedRow = ProfesoriTablePane.getSelektovanaVrsta();
		if (selectedRow >= 0 && selectedRow < BazaProfesora.getBrojUnetihProfesora()
				&& BazaProfesora.getBrojProfesoraKojiSuUPretrazi() == 0) {
			int odabir = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
					"Da li ste sigurni da zelite da izbrisete profesora?", "Brsanje predmeta",
					JOptionPane.YES_NO_OPTION);

			if (odabir == JOptionPane.YES_OPTION) {
				String licna = BazaProfesora.getInstance().getSviProfesori().get(selectedRow).getBrojLicneKarte();
				BazaProfesora.getInstance().obrisiProfesora(selectedRow);
				BazaPredmeta.getInstance().obrisiProfesoraSaPredmeta(licna);
			}
		} else if (selectedRow >= 0 && selectedRow < BazaProfesora.getBrojProfesoraKojiSuUPretrazi()) {
			int odabir = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
					"Da li ste sigurni da zelite da izbrisete profesora?", "Brsanje predmeta",
					JOptionPane.YES_NO_OPTION);
			if (odabir == JOptionPane.YES_OPTION) {
				Profesor profesor = BazaProfesora.getInstance().getRezultatPretrage().get(selectedRow);
				BazaPredmeta.getInstance().obrisiProfesoraSaPredmeta(profesor.getBrojLicneKarte());
				BazaProfesora.getInstance().getRezultatPretrage().remove(selectedRow);
				BazaProfesora.getInstance().smanjiBrojProfesoraKojiSuUPretrazi();
				BazaProfesora.getInstance().brisiPoLicnoj(profesor.getBrojLicneKarte());
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

	public boolean dodajPredmetNaProfesora(String text) {
		
		return BazaProfesora.getInstance().dodajPredmetNaProfesora(text);
	}

	public void obrisiPredmetSaProfesora() {
		BazaProfesora.getInstance().obrisiPredmetSaProfesora();
		
	}

}
