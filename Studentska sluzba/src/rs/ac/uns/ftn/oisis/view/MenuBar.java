package rs.ac.uns.ftn.oisis.view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 3089207134039186028L;

	MenuBar() {
		
		JMenu file = new JMenu("File");
		JMenuItem cloos= new JMenuItem("Close");
		JMenuItem n = new JMenuItem("New");
		
		
		n.setMnemonic(KeyEvent.VK_N);
		n.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		n.setIcon(new ImageIcon("images/new.png"));
	
		
		file.add(n); 
		file.addSeparator();
		
		
		cloos.setMnemonic(KeyEvent.VK_C);
		cloos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		cloos.setIcon(new ImageIcon("images/cancel.png"));
		
		file.add(cloos);
		
		JMenu edit= new JMenu("Edit");
		
		JMenuItem e= new JMenuItem("Edit");
		JMenuItem delete= new JMenuItem("Delete");
		
		e.setMnemonic(KeyEvent.VK_E);
		e.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		e.setIcon(new ImageIcon("images/edit.png"));
		
		
		edit.add(e);
		edit.addSeparator();
		
		
		delete.setMnemonic(KeyEvent.VK_D);
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		delete.setIcon(new ImageIcon("images/deleteM.png"));
		
		edit.add(delete);
		
		
		JMenu help= new JMenu("Help");
		JMenu about= new JMenu("About");
		
		
		file.setMnemonic(KeyEvent.VK_1);
		edit.setMnemonic(KeyEvent.VK_2);
		help.setMnemonic(KeyEvent.VK_3);
		about.setMnemonic(KeyEvent.VK_4);
		
		
		
		add(file);
		add(edit);
		add(help);
		add(about);
			
	}

}