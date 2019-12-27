package rs.ac.uns.ftn.oisis.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


public class MainFrameListener implements WindowListener {
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent e)  {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		JFrame frame = (JFrame) e.getComponent();
		int odabir = JOptionPane.showConfirmDialog(frame, "Da li ste sigurni da zelite da zatvorite aplikaciju?",
				"Zatvaranje aplikacije", JOptionPane.YES_NO_OPTION);
		if (odabir == JOptionPane.YES_OPTION) {
			try {
				PredmetiController.getInstance().saveData();
				// Dok Aca doda dodavanje predmeta
				//ProfesoriController.getInstance().saveData();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		} else {
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}	
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}
	
	
	
	
	
	
	
	
	
	

}
