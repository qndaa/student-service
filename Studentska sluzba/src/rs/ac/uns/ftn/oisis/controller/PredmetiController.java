package rs.ac.uns.ftn.oisis.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisis.model.BazaPredmeta;
import rs.ac.uns.ftn.oisis.model.BazaProfesora;
import rs.ac.uns.ftn.oisis.model.Predmet;
import rs.ac.uns.ftn.oisis.model.Profesor;
import rs.ac.uns.ftn.oisis.model.Student;
import rs.ac.uns.ftn.oisis.view.DialogStudenaNaPredmet;
import rs.ac.uns.ftn.oisis.view.IzmenaPredmetaDialog;
import rs.ac.uns.ftn.oisis.view.MainFrame;
import rs.ac.uns.ftn.oisis.view.PredmetiTable;
import rs.ac.uns.ftn.oisis.view.PredmetiTablePane;
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
		int selectedRow = PredmetiTablePane.getSelectedRow();
		if (selectedRow >= 0 && selectedRow < BazaPredmeta.getBrojUnetihPredmeta()&& 
				BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) {
			
			int odabir = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
					"Da li ste sigurni da zelite da izbrisete predmet?", "Brsanje predmeta", JOptionPane.YES_NO_OPTION);
			if (odabir == JOptionPane.YES_OPTION) {
				String sifraPredmeta = BazaPredmeta.getInstance().getSviPredmeti().get(selectedRow).getSifra();
				BazaPredmeta.getInstance().obrisiPredmet(selectedRow);
				BazaProfesora.getInstance().obrisiPredmetSaProfesora(sifraPredmeta);
			}
		} else if(selectedRow >= 0 && selectedRow < BazaPredmeta.getBrojPredmetaKojiSuUPretrazi()){
			
			int odabir = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
					"Da li ste sigurni da zelite da izbrisete predmet?", "Brsanje predmeta", JOptionPane.YES_NO_OPTION);
			
			if (odabir == JOptionPane.YES_OPTION) {
				Predmet p = BazaPredmeta.getInstance().getRazultatPretrage().get(selectedRow);
				BazaProfesora.getInstance().obrisiPredmetSaProfesora(p.getSifra());
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
		
		int selectedRow = PredmetiTablePane.getSelectedRow();
		
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
	
	public boolean PostojiStudentSaIndeksom(String index, int row) {
		return BazaPredmeta.getInstance().ProveraStudenta(index, row);
	}
	
	public void DodavanjeStudNaPred() {
		int row = PredmetiTable.getInstance().getSelectedRow();
		
		if(row >= 0 && row < BazaPredmeta.getBrojUnetihPredmeta()) {
			DialogStudenaNaPredmet di = new DialogStudenaNaPredmet(MainFrame.getInstance(),"Dodavanje studenta na predmet", true);
			di.setVisible(true);
			
			
		} else {
			
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Predmet nije selektovan", "EROR",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	public Predmet getPredmetPoIndeksu(int i) {
		if(BazaPredmeta.getBrojUnetihPredmeta() !=0) {
		return BazaPredmeta.getInstance().getSviPredmeti().get(i);
		}
		return null;
	}
	
	
	public void DodavanjeStudentaNaPredmet(Student stud, int i) {
		BazaPredmeta.getInstance().DodajStudentaNaPredmet(stud,i);
	}

	public boolean dodajProfesoraNaPredmet(Profesor profesor) {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstance().dodajProfesoraNaPredmet(profesor);
	}

	public void obrisiProfesoraSaPredmeta() {
		BazaPredmeta.getInstance().obrisiProfesoraSaPredmeta();
		
	}
	
	
	
	
	
	

}
