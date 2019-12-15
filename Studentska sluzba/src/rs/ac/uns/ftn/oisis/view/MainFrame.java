package rs.ac.uns.ftn.oisis.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import rs.ac.uns.ftn.oisis.controller.MainFrameListener;
import rs.ac.uns.ftn.oisis.controller.TabbedPaneListener;


public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = -6400016063430161422L;
	
	private static MainFrame instance = null;
	private MenuBar meni = null;
	private ToolBar toolBar = null;
	private TabbedPane tabbedPane = null;
	private StatusBar bar = null;
	
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
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		System.out.println(screenHeight);
		setSize(screenWidth*3/4, screenHeight*3/4);
		setTitle("Studentska sluzba");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Color bg = new Color(210, 210, 210);
		getContentPane().setBackground(bg);
		
		setResizable(false);
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
		meni = new MenuBar();
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
