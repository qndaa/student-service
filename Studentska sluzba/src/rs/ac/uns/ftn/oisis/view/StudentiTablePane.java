package rs.ac.uns.ftn.oisis.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import rs.ac.uns.ftn.oisis.controller.StudentiController;

public class StudentiTablePane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7795870561938458998L;
	private StudentiTable studentiTable;
	private JScrollPane scrollPane;
	
	public StudentiTablePane() {
		setLayout(new BorderLayout());
		setOpaque(false);
		createStudentiTable();
	}
	
	
	
	private void createStudentiTable() {
		Toolkit kit= Toolkit.getDefaultToolkit();
		Dimension screenSize= kit.getScreenSize();
		int swidth=screenSize.width;
		int sHeight= screenSize.height;
		
		JPanel top= new JPanel();
		JPanel down= new JPanel();
		JPanel left= new JPanel();
		JPanel right= new JPanel();
		
		
		top.setOpaque(false);
		down.setOpaque(false);
		left.setOpaque(false);
		right.setOpaque(false);

		top.setPreferredSize(new Dimension(swidth,sHeight/10));
		down.setPreferredSize(new Dimension(swidth,sHeight/10));
		
		add(top,BorderLayout.NORTH);
		add(down,BorderLayout.SOUTH);
		add(left,BorderLayout.WEST);
		add(right,BorderLayout.EAST);
		
		
		
		studentiTable = StudentiTable.getInstance();
		
		
		try {
			StudentiController.getInstance().otvoriFileStudent();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		scrollPane = new JScrollPane(studentiTable);
		add(scrollPane,BorderLayout.CENTER);
	}
	
	
	

}
