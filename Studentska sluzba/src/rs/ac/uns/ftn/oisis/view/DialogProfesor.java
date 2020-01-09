package rs.ac.uns.ftn.oisis.view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class DialogProfesor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5804437570634152265L;

	protected JTextField txtField1; // ime
	protected JTextField txtField2; // prezime
	protected JTextField txtField3; // datum rodjenja
	protected JTextField txtField4; // adresa stanovanja
	protected JTextField txtField5; // broj telefona
	protected JTextField txtField6; // email
	protected JTextField txtField7; // adresa Kancelarije
	protected JTextField txtField8; // brlicne
	protected JTextField txtField9; // titula
	protected JTextField txtField10; // zvanje
	protected JButton odustani;
	protected JButton potvrdi;

	public DialogProfesor(Frame parent, String title, boolean modal) {
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
				if (Provera()) {
					potvrdi.setEnabled(true);
				}else {
					potvrdi.setEnabled(false);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (Provera()) {

				}

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
				if (Provera()) {
					potvrdi.setEnabled(true);
				}else {
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
				if (Provera()) {
					potvrdi.setEnabled(true);
				}else {
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
				if (Provera()) {
					potvrdi.setEnabled(true);
				}else {
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
				if (Provera()) {
					potvrdi.setEnabled(true);
				}else {
					potvrdi.setEnabled(false);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblTxtField6 = new JLabel("Email");
		txtField6 = new JTextField(20);
		txtField6.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Provera()) {
					potvrdi.setEnabled(true);
				}else {
					potvrdi.setEnabled(false);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblTxtField7 = new JLabel("Adresa Kancelarije");
		txtField7 = new JTextField(20);
		txtField7.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				if (Provera()) {
					potvrdi.setEnabled(true);
				}else {
					potvrdi.setEnabled(false);
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblTxtField8 = new JLabel("Broj licne karte");
		txtField8 = new JTextField(20);
		txtField8.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Provera()) {
					potvrdi.setEnabled(true);
				}else {
					potvrdi.setEnabled(false);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblTxtField9 = new JLabel("Titula");
		txtField9 = new JTextField(20);
		txtField9.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Provera()) {
					potvrdi.setEnabled(true);
				}else {
					potvrdi.setEnabled(false);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel lblTxtField10 = new JLabel("Zvanje");
		txtField10 = new JTextField(20);
		txtField10.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Provera()) {
					potvrdi.setEnabled(true);
				}else {
					potvrdi.setEnabled(false);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		odustani = new JButton("Odustani");
		potvrdi = new JButton("Potvrdi");
		potvrdi.setEnabled(false);

		add(lblTxtField1); // ime
		add(txtField1);

		add(lblTxtField2); // prezime
		add(txtField2);

		add(lblTxtField3); // datum rodjenja
		add(txtField3);

		add(lblTxtField4); // adresa stanovanja
		add(txtField4);

		add(lblTxtField5); // broj telefona
		add(txtField5);

		add(lblTxtField6); // email
		add(txtField6);

		add(lblTxtField7); // adresa kancelarije
		add(txtField7);

		add(lblTxtField8); // br licne karte
		add(txtField8);

		add(lblTxtField9); // titula
		add(txtField9);

		add(lblTxtField10); // Zvanje
		add(txtField10);

		add(odustani);
		add(potvrdi);

		setResizable(false);
	}

	protected String[] podaci() {
		String[] p = new String[10];

		for (int i = 0; i < p.length; i++) {
			p[i] = new String();
		}

		p[0] = txtField1.getText().toString();
		p[1] = txtField2.getText().toString();
		p[2] = txtField3.getText().toString();
		p[3] = txtField4.getText().toString();
		p[4] = txtField5.getText().toString();
		p[5] = txtField6.getText().toString();
		p[6] = txtField7.getText().toString();
		p[7] = txtField8.getText().toString();
		p[8] = txtField9.getText().toString();
		p[9] = txtField10.getText().toString();

		return p;
	}

	private boolean Provera() {
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
				txtField6.setBackground(Color.RED);
				return false;
			}
		}

		if (p[6].length() != 0) { // adresa stanovanja
			if (!Pattern.matches("[A-Za-z0-9,._ ]*", p[6])) {
				txtField7.setBackground(Color.RED);
				return false;
			}
		}

		if (p[7].length() != 0) { // brLinke
			if (!Pattern.matches("[0-9\"]*", p[7])) {
				txtField8.setBackground(Color.RED);
				return false;
			} else if (p[7].length() != 11) {
				txtField8.setBackground(Color.RED);
				return false;
			}
		}

		if (!Pattern.matches("[A-Za-z_ ]*", p[8])) { // Titula
			txtField9.setBackground(Color.RED);
			return false;
		} else {
			txtField9.setBackground(Color.WHITE);
		}
		if (!Pattern.matches("[A-Za-z_ ]*", p[9])) { // Zvanje
			txtField10.setBackground(Color.RED);
			return false;
		} else {
			txtField10.setBackground(Color.WHITE);
		}

		for (String string : p) {
			if ((string = string.trim()).length() == 0) {
				txtField1.setBackground(Color.WHITE);
				txtField2.setBackground(Color.WHITE);
				txtField3.setBackground(Color.WHITE);
				txtField4.setBackground(Color.WHITE);
				txtField5.setBackground(Color.WHITE);
				txtField6.setBackground(Color.WHITE);
				txtField7.setBackground(Color.WHITE);
				txtField8.setBackground(Color.WHITE);
				txtField9.setBackground(Color.WHITE);
				txtField10.setBackground(Color.WHITE);
				return false;
			}
		}

		txtField1.setBackground(Color.WHITE);
		txtField2.setBackground(Color.WHITE);
		txtField3.setBackground(Color.WHITE);
		txtField4.setBackground(Color.WHITE);
		txtField5.setBackground(Color.WHITE);
		txtField6.setBackground(Color.WHITE);
		txtField7.setBackground(Color.WHITE);
		txtField8.setBackground(Color.WHITE);
		txtField9.setBackground(Color.WHITE);
		txtField10.setBackground(Color.WHITE);

		return ret;
	}

}
