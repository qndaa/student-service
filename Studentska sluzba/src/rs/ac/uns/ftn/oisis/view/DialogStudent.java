package rs.ac.uns.ftn.oisis.view;

import java.awt.Color;
import java.awt.Frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class DialogStudent extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6847297048903882740L;
	protected JTextField txtField1; // ime
	protected JTextField txtField2; // prezime
	protected JTextField txtField3; // datum rodjenja
	protected JTextField txtField4; // adresa stanovanja
	protected JTextField txtField5; // broj telefona
	protected JTextField txtField6; // borj Indeksa
	protected JTextField txtField9; // email
	protected JTextField txtField8; // datum upisa

	protected JComboBox<String> god;
	protected JRadioButton budz;
	protected JRadioButton samo;
	protected ButtonGroup bg1;
	protected JButton odustani;
	protected JButton potvrdi;

	// email
	// datum upisa

	public DialogStudent(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setLayout(new GridLayout(11, 2, 10, 20));
		setSize(500, 500);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		JLabel lblTxtField1 = new JLabel("Ime");
		txtField1 = new JTextField(20);
		txtField1.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Provera_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblTxtField2 = new JLabel("Prezime");
		txtField2 = new JTextField(20);
		txtField2.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Provera_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblTxtField3 = new JLabel("Datum rodjenja");
		txtField3 = new JTextField(20);
		txtField3.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Provera_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblTxtField4 = new JLabel("Adresa Stanovanja");
		txtField4 = new JTextField(20);
		txtField4.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Provera_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JLabel lblTxtField5 = new JLabel("Broj telefona");
		txtField5 = new JTextField(20);
		txtField5.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Provera_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblTxtField9 = new JLabel("Email");
		txtField9 = new JTextField(20);
		txtField9.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Provera_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblTxtField6 = new JLabel("Broj indeksa");
		txtField6 = new JTextField(20);
		txtField6.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Provera_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblTxtField8 = new JLabel("Datum Upisa");
		txtField8 = new JTextField(20);
		txtField8.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Provera_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		;

		JLabel lblTxtField7 = new JLabel("Trenutna godina Studija*");
		String[] godina = new String[] { "I", "II", "III", "IV" };
		god = new JComboBox<String>(godina);
		god.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Provera_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
			}
		});

		bg1 = new ButtonGroup();
		budz = new JRadioButton("Budzet", true);
		samo = new JRadioButton("Samofinansiranje");
		odustani = new JButton("Odustasni");
		potvrdi = new JButton("Potvird");
		potvrdi.setEnabled(false);
		samo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Provera_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
			}
		});
		budz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Provera_podataka()) {
					potvrdi.setEnabled(true);
				} else {
					potvrdi.setEnabled(false);
				}
			}
		});

		bg1.add(budz);
		bg1.add(samo);
		add(lblTxtField1); // ime
		add(txtField1);

		add(lblTxtField2); // prezime
		add(txtField2);

		add(lblTxtField3); // datum rodjenja
		add(txtField3);

		add(lblTxtField4); // Adresa Stanovanja
		add(txtField4);

		add(lblTxtField5); // Broj telefona
		add(txtField5);

		add(lblTxtField9); // Email
		add(txtField9);

		add(lblTxtField6); // Broj Indeksa
		add(txtField6);

		add(lblTxtField8); // datum upisa
		add(txtField8);

		add(lblTxtField7); // Trenutna godina studija

		add(god);
		add(budz);
		add(samo);
		add(odustani);
		add(potvrdi);

		setResizable(false);

	}

	protected String[] podaci() {
		String[] p = new String[10];

		for (int i = 0; i < p.length; i++) {
			p[i] = new String();
		}

		p[0] = txtField1.getText().toString(); // ime
		p[1] = txtField2.getText().toString(); // prezime
		p[2] = txtField3.getText().toString(); // datum rodejna
		p[3] = txtField4.getText().toString(); // adresa stanovanja
		p[4] = txtField5.getText().toString(); // br telefona
		p[5] = txtField9.getText().toString(); // email
		p[6] = txtField6.getText().toString(); // br indeksa
		p[7] = god.getSelectedItem().toString(); // godina 
		p[8] = txtField8.getText().toString(); //datum upisa
		// Budzet / samofinasiranje
		if (samo.isSelected()) {
			p[9] = "S";
		} else {
			p[9] = "B";
		}

		return p;
	}

	private boolean Provera_podataka() {
		boolean ret = true;
		String[] p = podaci();

		if (!Pattern.matches("[A-Za-z_ ]*", p[0])) { // Ime
			txtField1.setBackground(Color.RED);
			return false;
		} else {
			txtField1.setBackground(Color.WHITE);
		}
		if (!Pattern.matches("[A-Za-z_ ]*", p[1])) { // Prezime
			txtField2.setBackground(Color.RED);
			return false;
		} else {
			txtField2.setBackground(Color.WHITE);
		}
		if (p[2].length() != 0) { // datum rodjenja
			if (!Pattern.matches("^(3[01]|[12][0-9]|0[1-9]).(1[0-2]|0[1-9]).[0-9]{4}$", p[2])) {
				txtField3.setBackground(Color.RED);
				return false;
			}
		}
		if (p[3].length() != 0) { // adresa stanovanja
			if (!Pattern.matches("[A-Za-z0-9,._ ]*", p[3])) {
				txtField4.setBackground(Color.RED);
				return false;
			}
		}
		if (p[4].length() != 0) {// broj telefona
			if (!Pattern.matches("^[0-9]*", p[4])) {
				txtField5.setBackground(Color.RED);
				return false;
			} else if (p[4].length() > 16) {
				txtField5.setBackground(Color.RED);
				return false;
			}
		}
		
		if (p[5].length() != 0) { // email
			if (!Pattern.matches("^(.+)@(.+)$", p[5])) {
				txtField9.setBackground(Color.RED);
				return false;
			}
		}
		if (p[6].length() != 0) { // indeks
			if (!Pattern.matches("[A-Z]{1,3}-[0-9]{2,3}-[0-9]{4}", p[6])) {
				txtField6.setBackground(Color.RED);
				return false;
			}
		}
		
		if (p[8].length() != 0) { // datum upisa
			if (!Pattern.matches("^(3[01]|[12][0-9]|0[1-9]).(1[0-2]|0[1-9]).[0-9]{4}$", p[8])) {
				txtField8.setBackground(Color.RED);
				return false;
			}
		}

		for (String string : p) {
			if ((string = string.trim()).length() == 0) {
				txtField1.setBackground(Color.WHITE);
				txtField2.setBackground(Color.WHITE);
				txtField3.setBackground(Color.WHITE);
				txtField4.setBackground(Color.WHITE);
				txtField5.setBackground(Color.WHITE);
				txtField6.setBackground(Color.WHITE);
				txtField8.setBackground(Color.WHITE);
				txtField9.setBackground(Color.WHITE);
				return false;

			}
		}

		txtField1.setBackground(Color.WHITE);
		txtField2.setBackground(Color.WHITE);
		txtField3.setBackground(Color.WHITE);
		txtField4.setBackground(Color.WHITE);
		txtField5.setBackground(Color.WHITE);
		txtField6.setBackground(Color.WHITE);
		txtField8.setBackground(Color.WHITE);
		txtField9.setBackground(Color.WHITE);

		return ret;
	}

}
