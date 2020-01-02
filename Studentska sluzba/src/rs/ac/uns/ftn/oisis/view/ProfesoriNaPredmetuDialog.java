package rs.ac.uns.ftn.oisis.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProfesoriNaPredmetuDialog extends JDialog {

	private static final long serialVersionUID = 4582576472527889884L;

	private static ProfesoriNaPredmetuTable table;
	private static JPanel panel = null;

	public ProfesoriNaPredmetuDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setSize(450, 250);
		setLocationRelativeTo(MainFrame.getInstance());
		setResizable(false);
		panel = new JPanel();
		panel.setBackground(new Color(204, 227, 249));
		panel.setOpaque(true);
		table = ProfesoriNaPredmetuTable.getInstance();
		table.setBackground(new Color(204, 227, 249));
		table.setVisible(true);

		panel.add(new JScrollPane(table));

		add(panel, BorderLayout.CENTER);

	}

}
