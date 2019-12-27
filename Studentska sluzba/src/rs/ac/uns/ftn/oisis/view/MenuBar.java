package rs.ac.uns.ftn.oisis.view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.KeyStroke;


import rs.ac.uns.ftn.oisis.controller.MenuElementListener;

public class MenuBar extends JMenuBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3089207134039186028L;

	private static MenuBar instance= null;
	private JMenu file;
	private JMenu edit;
	private JMenuItem cloos;
	private JMenuItem n; // new
	private JMenuItem newS; //dugme za dodavanje prof/stud
	private JMenuItem e; //edit
	private JMenuItem delete;
	private JMenu help;
	private JMenu about;
	
	public static MenuBar getInstance() {
		if(instance==null) {
			instance= new MenuBar();
		}
		
		return instance;
	}
	
	private	MenuBar() {
		
		 file = new JMenu("File");
		 cloos= new JMenuItem("Close");
		 n = new JMenuItem("New");
		 newS= new JMenuItem("New Stud/Prof");
		
		n.setMnemonic(KeyEvent.VK_N);
		n.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		n.setIcon(new ImageIcon("images/new.png"));
		n.addActionListener(new MenuElementListener());
		file.add(n); 
		file.addSeparator();			
		
		file.add(newS);
		newS.setMnemonic(KeyEvent.VK_S);
		newS.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		newS.setIcon(new ImageIcon("images/new.png"));
		newS.setEnabled(false);
		file.addSeparator();
				
		cloos.setMnemonic(KeyEvent.VK_C);
		cloos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		cloos.setIcon(new ImageIcon("images/cancel.png"));
		
		file.add(cloos);
		
		edit= new JMenu("Edit");
		
		e= new JMenuItem("Edit");
		delete= new JMenuItem("Delete");
		
		e.setMnemonic(KeyEvent.VK_E);
		e.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		e.setIcon(new ImageIcon("images/edit.png"));
		
		
		edit.add(e);
		edit.addSeparator();
		
		
		delete.setMnemonic(KeyEvent.VK_D);
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		delete.setIcon(new ImageIcon("images/deleteM.png"));
		
		edit.add(delete);
		
		
		help= new JMenu("Help");
		about= new JMenu("About");
		
		file.setMnemonic(KeyEvent.VK_1);
		edit.setMnemonic(KeyEvent.VK_2);
		help.setMnemonic(KeyEvent.VK_3);
		about.setMnemonic(KeyEvent.VK_4);
		
		add(file);
		add(edit);
		add(help);
		add(about);
			
	}
	
	public void nebitno(int a) {
		if(a==1) {
			newS.setEnabled(true);
		}else {
			newS.setEnabled(false);
		}
	}
	
	

}
