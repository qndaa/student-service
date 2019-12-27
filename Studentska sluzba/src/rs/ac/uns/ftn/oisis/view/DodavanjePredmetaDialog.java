package rs.ac.uns.ftn.oisis.view;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisis.controller.PredmetiController;

public class DodavanjePredmetaDialog extends PredmetDialog{

	
	private static final long serialVersionUID = 8084995316814056271L;

	public DodavanjePredmetaDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		
		
		potvrdaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String unos[] = prikupiUnos();		
				boolean dodao = PredmetiController.getInstance().dodajPredmet(unos);
				if (dodao) {
					dispose();
					PredmetiTable.getInstance().refreshTable();
					JOptionPane.showMessageDialog((Component) e.getSource(), "Uspesno ste dodali predmet.");
				} else {
					setVisible(false);
					JOptionPane.showMessageDialog((Component) e.getSource(), "Predmet sa unetom sifrom vec postoji!", "Greska", JOptionPane.ERROR_MESSAGE);
					setVisible(true);
				}
			}
		});
		
		
		odustaniBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
}
