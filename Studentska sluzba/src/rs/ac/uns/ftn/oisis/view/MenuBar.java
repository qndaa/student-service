package rs.ac.uns.ftn.oisis.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.KeyStroke;

import rs.ac.uns.ftn.oisis.controller.IzmenaListener;
import rs.ac.uns.ftn.oisis.controller.MenuElementListenerBirsanje;
import rs.ac.uns.ftn.oisis.controller.MenuElementListenerDodavanje;
import rs.ac.uns.ftn.oisis.controller.PredmetiController;
import rs.ac.uns.ftn.oisis.controller.ProfesoriController;

public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3089207134039186028L;

	private static MenuBar instance = null;
	private JMenu file;
	private JMenu edit;
	private JMenuItem cloos;
	private JMenu New;
	// dugmici za doddavanje
	private JMenuItem New_Stud;
	private JMenuItem New_Prof;
	private JMenuItem New_Sub;
	private JMenu New_Stud_Prof; // dugme za dodavanje prof/stud
	private JMenuItem newStud;
	private JMenuItem newProf;

	// dugmici za izmenu
	private JMenu Edit; // edit
	private JMenuItem Edi_Stud;
	private JMenuItem Edit_Prof;
	private JMenuItem Edit_Sub;
	private JMenu Edit_Stud_Prof; // dugme za dodavanje prof/stud
	private JMenuItem editStud;
	private JMenuItem editProf;

	// dugmici za brisanje

	private JMenuItem Delete_Stud;
	private JMenuItem Delete_Prof;
	private JMenuItem Delete_Sub;
	private JMenu Delete_Stud_Prof; // dugme za dodavanje prof/stud
	private JMenuItem deleteStud;
	private JMenuItem deleteProf;
	
	private JMenu delete;
	private JMenu help;
	private JMenu about;

	public static MenuBar getInstance() {
		if (instance == null) {
			instance = new MenuBar();
		}

		return instance;
	}

	private MenuBar() {

		file = new JMenu("File");
		cloos = new JMenuItem("Close");
		New = new JMenu("New");

		New_Stud_Prof = new JMenu("New Stud/Prof");

		New.setMnemonic(KeyEvent.VK_N);

		New.setIcon(new ImageIcon("images/new.png"));

		file.add(New);

		// dugme za dodavanje Studenta
		New_Stud = new JMenuItem("New Stud");
		New_Stud.setMnemonic(KeyEvent.VK_S);
		New_Stud.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		New_Stud.setIcon(new ImageIcon("images/new.png"));
		New_Stud.addActionListener(new MenuElementListenerDodavanje());
		New.add(New_Stud);

		New.addSeparator();

		// dugme za dodavanje Profesora
		New_Prof = new JMenuItem("New Prof");
		New_Prof.setMnemonic(KeyEvent.VK_P);
		New_Prof.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		New_Prof.setIcon(new ImageIcon("images/new.png"));
		 New_Prof.addActionListener(new MenuElementListenerDodavanje());
		New.add(New_Prof);

		New.addSeparator();

		New_Sub = new JMenuItem("New Sub");
		New_Sub.setMnemonic(KeyEvent.VK_U);
		New_Sub.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		New_Sub.setIcon(new ImageIcon("images/new.png"));
		New_Sub.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DodavanjePredmetaDialog dialog = new DodavanjePredmetaDialog(MainFrame.getInstance(), "Dodavanje predmeta",
						true);
				dialog.setVisible(true);
				
			}
		});

		New.add(New_Sub);

		// Dugme za dodavanje profesora ili studenta na predmet
		New_Stud_Prof.setMnemonic(KeyEvent.VK_T);
		New_Stud_Prof.setIcon(new ImageIcon("images/new.png"));
		New_Stud_Prof.setEnabled(false);
		New.add(New_Stud_Prof);

		newStud = new JMenuItem("New Stud");
		newStud.setMnemonic(KeyEvent.VK_K);
		newStud.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		newStud.setIcon(new ImageIcon("images/new.png"));
		newStud.addActionListener(new MenuElementListenerDodavanje());
		
		New_Stud_Prof.add(newStud);
		New_Stud_Prof.addSeparator();

		newProf = new JMenuItem("New Prof");
		newProf.setMnemonic(KeyEvent.VK_L);
		newProf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		newProf.setIcon(new ImageIcon("images/new.png"));
		newProf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodavanjeProfesoraNaPredmetDialog dialog = new DodavanjeProfesoraNaPredmetDialog(
						MainFrame.getInstance(), "Dodavanje profesora na predmet", true);
				dialog.setVisible(true);

			}
		});
		New_Stud_Prof.add(newProf);

		// da bi na pocetku sva polja ne bi bila aktivna
		New_Stud_Prof.setEnabled(false);
		New_Prof.setEnabled(false);
		New_Sub.setEnabled(false);

		file.addSeparator();

		cloos.setMnemonic(KeyEvent.VK_C);
		cloos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		cloos.setIcon(new ImageIcon("images/cancel.png"));

		file.add(cloos);

		edit = new JMenu("Edit");

		Edit = new JMenu("Edit");
		
		//Dugmici izmena
		Edit.setMnemonic(KeyEvent.VK_E);
		Edit.setIcon(new ImageIcon("images/edit.png"));

		Edi_Stud = new JMenuItem("Edit Stud");
		Edi_Stud.setMnemonic(KeyEvent.VK_Q);
		Edi_Stud.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		Edi_Stud.setIcon(new ImageIcon("images/edit.png"));
		Edi_Stud.addActionListener(new IzmenaListener());
		Edit.add(Edi_Stud);
			
		Edit.addSeparator();

		Edit_Prof = new JMenuItem("Edit Prof");
		Edit_Prof.setMnemonic(KeyEvent.VK_A);
		Edit_Prof.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		Edit_Prof.setIcon(new ImageIcon("images/edit.png"));
		Edit_Prof.addActionListener(new IzmenaListener());
		Edit.add(Edit_Prof);

		Edit.addSeparator();

		Edit_Sub = new JMenuItem("Edit Sub");
		Edit_Sub.setMnemonic(KeyEvent.VK_Z);
		Edit_Sub.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		Edit_Sub.setIcon(new ImageIcon("images/edit.png"));
		Edit_Sub.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PredmetiController.getInstance().izmenaPredmeta();
				PredmetiTable.getInstance().refreshTable();
				
			}
		});
		Edit.add(Edit_Sub);

		Edit_Stud_Prof = new JMenu("Edit  Stud/Prof");
		Edit_Stud_Prof.setMnemonic(KeyEvent.VK_W);
		Edit_Stud_Prof.setIcon(new ImageIcon("images/edit.png"));
		Edit.add(Edit_Stud_Prof);
		
		
		editStud = new JMenuItem("Edit Stud");
		editStud.setMnemonic(KeyEvent.VK_I);
		editStud.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
		editStud.setIcon(new ImageIcon("images/edit.png"));
		Edit_Stud_Prof.add(editStud);

		editProf = new JMenuItem("Edit Prof");
		editProf.setMnemonic(KeyEvent.VK_J);
		editProf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,ActionEvent.CTRL_MASK));
		editProf.setIcon(new ImageIcon("images/edit.png"));
		Edit_Stud_Prof.add(editProf);

		//da bi na pocetku bila zamrznuta sva sem studetnta
		Edit_Stud_Prof.setEnabled(false);
		Edit_Prof.setEnabled(false);
		Edit_Sub.setEnabled(false);
		
		
		edit.add(Edit);

		edit.addSeparator();

		//Dugmici brisanje
			
		delete = new JMenu("Delete");
		delete.setMnemonic(KeyEvent.VK_D);
		delete.setIcon(new ImageIcon("images/deleteM.png"));

		Delete_Stud = new JMenuItem("Delete Stud");
		Delete_Stud.setMnemonic(KeyEvent.VK_G);
		Delete_Stud.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
		Delete_Stud.setIcon(new ImageIcon("images/deleteM.png"));
		Delete_Stud.addActionListener(new MenuElementListenerBirsanje());
		delete.add(Delete_Stud);
		
		delete.addSeparator();
		
		Delete_Prof = new JMenuItem("Delete Prof");
		Delete_Prof.setMnemonic(KeyEvent.VK_M);
		Delete_Prof.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
		Delete_Prof.setIcon(new ImageIcon("images/deleteM.png"));
		
		
		delete.add(Delete_Prof);
		
		delete.addSeparator();
		
		Delete_Sub = new JMenuItem("Delete Sub");
		Delete_Sub.setMnemonic(KeyEvent.VK_B);
		Delete_Sub.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
		Delete_Sub.setIcon(new ImageIcon("images/deleteM.png"));
		Delete_Sub.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PredmetiController.getInstance().brisanjePredmeta();
				PredmetiTable.getInstance().refreshTable();	
				
			}
		});
		delete.add(Delete_Sub);
		
		Delete_Stud_Prof = new JMenu("Delete Stud/Prof");
		Delete_Stud_Prof.setMnemonic(KeyEvent.VK_Y);
		Delete_Stud_Prof.setIcon(new ImageIcon("images/deleteM.png"));
		
		delete.add(Delete_Stud_Prof);
		
		
		deleteStud = new JMenuItem("Delete Stud");
		deleteStud.setMnemonic(KeyEvent.VK_R);
		deleteStud.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
		deleteStud.setIcon(new ImageIcon("images/deleteM.png"));
		
		Delete_Stud_Prof.add(deleteStud);
		
		deleteProf = new JMenuItem("Delete Prof");
		deleteProf.setMnemonic(KeyEvent.VK_F);
		deleteProf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
		deleteProf.setIcon(new ImageIcon("images/deleteM.png"));
		
		
		Delete_Stud_Prof.addSeparator();
		
		Delete_Stud_Prof.add(deleteProf);
		
		//da bi na pocetku bilo zamrznuto sve sem studenta
		Delete_Stud_Prof.setEnabled(false);
		Delete_Prof.setEnabled(false);
		Delete_Prof.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProfesoriController.getInstance().brisanjeProfesora();
				
				ProfesoriTable.getInstance().refresTable();
				
			}
		});
		Delete_Sub.setEnabled(false);
		
		
		edit.add(delete);

		help = new JMenu("Help");
		about = new JMenu("About");

		file.setMnemonic(KeyEvent.VK_1);
		edit.setMnemonic(KeyEvent.VK_2);
		help.setMnemonic(KeyEvent.VK_3);
		about.setMnemonic(KeyEvent.VK_4);

		add(file);
		add(edit);
		add(help);
		add(about);

	}

	public void PromenaDugmica(int a) {

		if (a == 0) {
			New_Stud.setEnabled(true);
			New_Stud_Prof.setEnabled(false);
			New_Prof.setEnabled(false);
			New_Sub.setEnabled(false);
			
			Edi_Stud.setEnabled(true);
			Edit_Stud_Prof.setEnabled(false);
			Edit_Prof.setEnabled(false);
			Edit_Sub.setEnabled(false);
			
			Delete_Stud.setEnabled(true);
			Delete_Stud_Prof.setEnabled(false);
			Delete_Prof.setEnabled(false);
			Delete_Sub.setEnabled(false);
			

		}
		if (a == 1) {
			New_Stud.setEnabled(false);
			New_Stud_Prof.setEnabled(true);
			New_Sub.setEnabled(true);
			New_Prof.setEnabled(false);
			
			Edi_Stud.setEnabled(false);
			Edit_Stud_Prof.setEnabled(true);
			Edit_Prof.setEnabled(false);
			Edit_Sub.setEnabled(true);
			
			Delete_Stud.setEnabled(false);
			Delete_Stud_Prof.setEnabled(true);
			Delete_Prof.setEnabled(false);
			Delete_Sub.setEnabled(true);
			

		}
		if (a == 2) {
			New_Stud.setEnabled(false);
			New_Stud_Prof.setEnabled(false);
			New_Prof.setEnabled(true);
			New_Sub.setEnabled(false);
			
			Edi_Stud.setEnabled(false);
			Edit_Stud_Prof.setEnabled(false);
			Edit_Prof.setEnabled(true);
			Edit_Sub.setEnabled(false);
			
			Delete_Stud.setEnabled(false);
			Delete_Stud_Prof.setEnabled(false);
			Delete_Prof.setEnabled(true);
			Delete_Sub.setEnabled(false);
			

		}
	}

}
