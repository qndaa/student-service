package rs.ac.uns.ftn.oisis.view;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisis.controller.ProfesoriController;

public class DodavanjeProfesoraDialog extends DialogProfesor {
	/**
	 * 
	 */
	private static final long serialVersionUID = -248069503105372466L;

	public DodavanjeProfesoraDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		// TODO Auto-generated constructor stub
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String p[] = podaci();
				boolean dodavanje = ProfesoriController.getInstance().DodajProfesora(p);
				if(dodavanje) {
					dispose();
					ProfesoriTable.getInstance().refresTable();
					JOptionPane.showMessageDialog((Component) e.getSource(), "Uspesno ste dodali profesora");
				}else {
					setVisible(false);
					JOptionPane.showMessageDialog((Component) e.getSource(), "Profesor sa untim brojem licne karte postoji", "Eror", JOptionPane.ERROR_MESSAGE);
					setVisible(true);
				}
			}
		});
		
		
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		
	}

	
}
