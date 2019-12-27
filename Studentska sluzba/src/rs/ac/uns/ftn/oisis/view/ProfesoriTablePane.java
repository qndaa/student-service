package rs.ac.uns.ftn.oisis.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import rs.ac.uns.ftn.oisis.controller.ProfesoriController;

public class ProfesoriTablePane extends JPanel {

	private static final long serialVersionUID = 3185855001667405798L;
	private JScrollPane scrollPane;
	private ProfesoriTable profesoriTable;

	public ProfesoriTablePane() {
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
		top.setPreferredSize(new Dimension(screenWidth, screenHeight / 10));
		down.setPreferredSize(new Dimension(screenWidth, screenHeight / 10));

		add(top, BorderLayout.NORTH);
		add(down, BorderLayout.SOUTH);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);

		profesoriTable = ProfesoriTable.getInstance();

		try {
			ProfesoriController.getInstance().loadData();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scrollPane = new JScrollPane(profesoriTable);
		add(scrollPane, BorderLayout.CENTER);
	}

}
