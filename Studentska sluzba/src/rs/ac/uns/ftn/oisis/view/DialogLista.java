package rs.ac.uns.ftn.oisis.view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import rs.ac.uns.ftn.oisis.controller.PredmetiController;



public class DialogLista extends JDialog {


	private static final long serialVersionUID = -8461691726966921404L;
	private JPanel down;
	protected JButton odustani;
	protected JButton potvrdi;
	private JTable listaIndeksa;
  
	
	public DialogLista(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setLayout(new BorderLayout());
		setSize(300,400);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		down = new JPanel();
		down.setLayout(new GridLayout(1,2,100,50));
		
		odustani = new JButton("Odustani");
		potvrdi = new JButton("Obrisi");
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				PredmetiController.getInstance().IzbrisiStudentaSaPredmeta();
			}
		});
		
		
		down.add(odustani);
		down.add(potvrdi);
		PrikazTabele();
		add(down, BorderLayout.SOUTH);
		setResizable(false);
	}
	
	private void PrikazTabele() {
		listaIndeksa =  TabelaIndeksa.getInstance();
		
		JScrollPane scrol =  new JScrollPane(listaIndeksa);
		add(scrol, BorderLayout.CENTER);
		TabelaIndeksa.getInstance().OsveziTabelu();
	}

	
	
	
	
}
