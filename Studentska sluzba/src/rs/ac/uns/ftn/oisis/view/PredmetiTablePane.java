package rs.ac.uns.ftn.oisis.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PredmetiTablePane extends JPanel {

	private static final long serialVersionUID = -4954990778466131805L;
	private JScrollPane scrollPane;
	private PredmetiTable predmetiTable;

	
	public PredmetiTablePane() {
		setLayout(new BorderLayout());
		setOpaque(false);
		createProfesoriTable();
	}


	private void createProfesoriTable() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		JPanel top = new JPanel();
		JPanel down = new JPanel();
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		down.setOpaque(false);
		top.setOpaque(false);
		left.setOpaque(false);
		right.setOpaque(false);
		top.setPreferredSize(new Dimension(screenWidth, screenHeight/10));
		down.setPreferredSize(new Dimension(screenWidth, screenHeight/10));
		
		add(top, BorderLayout.NORTH);
		add(down, BorderLayout.SOUTH);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
		
		predmetiTable = new PredmetiTable();
		scrollPane = new JScrollPane(predmetiTable);
		add(scrollPane, BorderLayout.CENTER);
		
	}
}
