package rs.ac.uns.ftn.oisis.gui;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar{
	
	
	
	public Toolbar() {
		super(SwingConstants.HORIZONTAL);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JToggleButton addStudentBtn = new JToggleButton();
		addStudentBtn.setToolTipText("Dodaj novog studenta.");
		addStudentBtn.setIcon(new ImageIcon("images/student.png"));
		add(addStudentBtn, FlowLayout.LEFT);
		
		addSeparator();
		
		JToggleButton changeStudentBtn = new JToggleButton();
		changeStudentBtn.setToolTipText("Izmeni studenta");
		changeStudentBtn.setIcon(new ImageIcon("images/change.png"));
		add(changeStudentBtn);
		
		addSeparator();
		
		JToggleButton deleteStudentBtn = new JToggleButton();
		deleteStudentBtn.setToolTipText("Brisanje studenta.");
		deleteStudentBtn.setIcon(new ImageIcon("images/delete.png"));
		add(deleteStudentBtn);
		
		addSeparator();
		
		add(Box.createHorizontalStrut(550));
		JTextField searchField = new JTextField(20);
		Font font1 = new Font("SansSerif", Font.BOLD, 18);
		searchField.setFont(font1);
		add(searchField);
		
		addSeparator();
		
		
		JButton searchBtn = new JButton();
		searchBtn.setToolTipText("Pretrazi studenta.");
		searchBtn.setIcon(new ImageIcon("images/search.png"));
		
		add(searchBtn);
		
		setFloatable(false);
		
	}
	
	
	
	

	
	
	
}
