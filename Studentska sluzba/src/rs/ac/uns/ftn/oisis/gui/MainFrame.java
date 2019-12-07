package rs.ac.uns.ftn.oisis.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;



public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = -6400016063430161422L;

	
	public MainFrame () {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		setSize(screenWidth*3/4, screenHeight*3/4);
		setTitle("Studentska sluzba");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Color bg = new Color(210, 210, 210);
		getContentPane().setBackground(bg);
		
		setResizable(false);
		
		setLayout(new BorderLayout());
			
		//menu_bar
		MenuBar meni = new MenuBar();
		this.setJMenuBar(meni);
		
		//Toolbar
		Toolbar toolbar = new Toolbar();
		add(toolbar, BorderLayout.NORTH);
	
		// TabbedPane
		TabbedPane tabbedPane = new TabbedPane();
		add(tabbedPane, BorderLayout.CENTER);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
