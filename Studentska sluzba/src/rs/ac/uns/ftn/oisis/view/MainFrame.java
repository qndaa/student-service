package rs.ac.uns.ftn.oisis.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

import rs.ac.uns.ftn.oisis.controller.MainFrameListener;
import rs.ac.uns.ftn.oisis.controller.TabbedPaneListener;


public class MainFrame extends JFrame {
	/**
	 * Klasa glavnog prozora, koja sadrzi polja za toolbar, meni, tabbedpane i status bar.
	 * Kreirana kao singlton glasa, funkcijom getInstance() prvi put kreiramo objekat 
	 * klase MainFrame i svaki sledeci put vratimo kreiranu instancu.
	 * 
	 */

	private static final long serialVersionUID = -6400016063430161422L;
	
	private static MainFrame instance = null;
	private MenuBar meni = null;
	private ToolBar toolBar = null;
	private TabbedPane tabbedPane = null;
	private StatusBar bar = null;
	public static int screenWidth = 0;
	public static int screenHeight = 0;

	
	
	// Singlton obrazac
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private  MainFrame () {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();

		screenWidth = screenSize.width;
		screenHeight = screenSize.height;

		setSize(screenWidth*3/4, screenHeight*3/4);
		
		setTitle("Studentska sluzba");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Color bg = new Color(210, 210, 210);
		getContentPane().setBackground(bg);
		
		setResizable(true);
		setLayout(new BorderLayout());
		
		// menu_bar
		dodajMeni();
		
		// toolbar
		dodajToolbar();
		
		// tabbedPane
		dodajTabbedPane();
		
		// Status bar
		dodajStatusBar();
		
		// windows listener
		addWindowListener(new MainFrameListener());	
		
		setVisible(true);
	}
	
	private void dodajMeni() {
		meni=MenuBar.getInstance();
		this.setJMenuBar(meni);
	}
	
	private void dodajToolbar() {
		toolBar = ToolBar.getInstance();
		this.add(toolBar, BorderLayout.NORTH);
		toolBar.setVisible(true);
	}
	
	private void dodajTabbedPane() {
		tabbedPane = new TabbedPane();
		this.add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.addChangeListener(new TabbedPaneListener());
	}

	private void dodajStatusBar() {
		bar = new StatusBar();
		this.add(bar, BorderLayout.SOUTH);
	}
	
	

}
