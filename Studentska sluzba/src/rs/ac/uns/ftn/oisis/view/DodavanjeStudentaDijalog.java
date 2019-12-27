package rs.ac.uns.ftn.oisis.view;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisis.controller.StudentiController;

public class DodavanjeStudentaDijalog extends DialogStudent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5858072474448933552L;

	public DodavanjeStudentaDijalog(Frame parent,String title, boolean modal) {
		super(parent, title, modal);
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String p[] = podaci(); 
				boolean dodavanje = StudentiController.getInstance().DodajStudenta(p);
				if(dodavanje) {
					dispose();
					StudentiTable.getInstance().OsveziTabelu();
					JOptionPane.showMessageDialog((Component) e.getSource(), "Uspesno ste dodali studenta");
				}else {
					setVisible(false);
					JOptionPane.showMessageDialog((Component) e.getSource(), "Student sa unteim indeksom vec postoji", "Eror", JOptionPane.ERROR_MESSAGE);
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
