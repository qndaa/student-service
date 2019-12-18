package rs.ac.uns.ftn.oisis.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.WindowConstants;

import rs.ac.uns.ftn.oisis.controller.PredmetiController;

public class DodavanjePredmetaDialog extends JDialog 	{

	private static final long serialVersionUID = 2007277827150240052L;

	private JTextField txtSifrePredmeta;
	private JTextField txtNazivPredmeta;
	private JComboBox<String> semestarCB;
	private JComboBox<String> godinaCB;
	
	private JButton odustaniBtn;
	private JButton potvrdaBtn;

	public DodavanjePredmetaDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		setLayout(new BorderLayout());
		setSize(400, 250);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		JPanel panelCenter = new JPanel();

		panelCenter.setBackground(Color.white);
		panelCenter.setLayout(new GridBagLayout());
		panelCenter.setBackground(new Color(204, 227, 249));
		add(panelCenter, BorderLayout.CENTER);

		JLabel sifraPredmetaLabel = new JLabel("Sifra predmeta:");
		JLabel nazivPredmetaLabel = new JLabel("Naziv predmeta:");
		JLabel semestarLabel = new JLabel("Semestar:");
		JLabel godinaLabel = new JLabel("Godina:");

		String semestar[] = { "             ", "Zimski", "Ljetni" };
		semestarCB = new JComboBox<String>(semestar);
		semestarCB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isValideInput()) {
					potvrdaBtn.setEnabled(true);
				} else {
					potvrdaBtn.setEnabled(false);
				}
				
			}
		});

		String godina[] = { "             ", "I", "II", "III", "IV", "V", "VI" };
		godinaCB = new JComboBox<String>(godina);
		godinaCB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isValideInput()) {
					potvrdaBtn.setEnabled(true);
				} else {
					potvrdaBtn.setEnabled(false);
				}
				
			}
		});
		
		txtSifrePredmeta = new JTextField();
		txtNazivPredmeta = new JTextField();
		
		txtNazivPredmeta.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(isValideInput()) {
					potvrdaBtn.setEnabled(true);
				} else {
					potvrdaBtn.setEnabled(false);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {}
		});
		
		txtSifrePredmeta.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(isValideInput()) {
					potvrdaBtn.setEnabled(true);
				} else {
					potvrdaBtn.setEnabled(false);
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
		
		
		
		
		
		
		GridBagConstraints gbcSifraPredmeta = new GridBagConstraints();
		gbcSifraPredmeta.gridx = 0;
		gbcSifraPredmeta.gridy = 0;
		gbcSifraPredmeta.insets = new Insets(10, 20, 0, 0);
		panelCenter.add(sifraPredmetaLabel, gbcSifraPredmeta);

		GridBagConstraints gbcNazivPredmeta = new GridBagConstraints();
		gbcNazivPredmeta.gridx = 0;
		gbcNazivPredmeta.gridy = 1;
		gbcNazivPredmeta.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(nazivPredmetaLabel, gbcNazivPredmeta);

		GridBagConstraints gbcTxtSifraPredmeta = new GridBagConstraints();
		gbcTxtSifraPredmeta.gridx = 1;
		gbcTxtSifraPredmeta.gridy = 0;
		gbcTxtSifraPredmeta.weightx = 100;
		gbcTxtSifraPredmeta.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtSifraPredmeta.insets = new Insets(10, 20, 0, 20);
		panelCenter.add(txtSifrePredmeta, gbcTxtSifraPredmeta);

		GridBagConstraints gbcTxtNazivPredmeta = new GridBagConstraints();
		gbcTxtNazivPredmeta.gridx = 1;
		gbcTxtNazivPredmeta.gridy = 1;
		gbcTxtNazivPredmeta.weightx = 200;
		gbcTxtNazivPredmeta.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtNazivPredmeta.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtNazivPredmeta, gbcTxtNazivPredmeta);

		GridBagConstraints gbcSemestar = new GridBagConstraints();
		gbcSemestar.gridx = 0;
		gbcSemestar.gridy = 2;
		gbcSemestar.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(semestarLabel, gbcSemestar);

		GridBagConstraints gbcGodina = new GridBagConstraints();
		gbcGodina.gridx = 0;
		gbcGodina.gridy = 3;
		gbcGodina.insets = new Insets(20, 20, 0, 0);
		panelCenter.add(godinaLabel, gbcGodina);

		GridBagConstraints gbcCBSemestar = new GridBagConstraints();
		gbcCBSemestar.gridx = 1;
		gbcCBSemestar.gridy = 2;
		gbcCBSemestar.weightx = 10;
		gbcCBSemestar.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(semestarCB, gbcCBSemestar);

		GridBagConstraints gbcCBGodina = new GridBagConstraints();
		gbcCBGodina.gridx = 1;
		gbcCBGodina.gridy = 3;
		gbcCBGodina.weightx = 10;
		gbcCBGodina.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(godinaCB, gbcCBGodina);

		JPanel panelBottom = new JPanel(new FlowLayout());
		panelBottom.add(Box.createHorizontalStrut(180));
		odustaniBtn = new JButton("Odustani");
		odustaniBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		potvrdaBtn = new JButton("Potvrda");
		potvrdaBtn.setEnabled(false);
		potvrdaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String unos[] = prikupiUnos();		
				boolean dodao = PredmetiController.getInstance().dodajPredmet(unos);
				if (dodao) {
					dispose();
					PredmetiTable.getInstance().refreshTable();
					JOptionPane.showMessageDialog((Component) e.getSource(), "Uspesno ste dodali predmet.");
				} else {
					setVisible(false);
					JOptionPane.showMessageDialog((Component) e.getSource(), "Predmet sa unetom sifrom vec postoji!", "Greska", JOptionPane.ERROR_MESSAGE);
					setVisible(true);
				}
			}
		});

		panelBottom.add(odustaniBtn);
		panelBottom.add(potvrdaBtn);
		panelBottom.setBackground(new Color(210, 210, 210));
		
		
	
		add(panelBottom, BorderLayout.SOUTH);
		setResizable(false);

	}

	public String[] prikupiUnos() {
		String unos[] = new String[4];
		for (int i = 0; i < unos.length; i++) {
			unos[i] = new String();
		}
		unos[0] = txtSifrePredmeta.getText().toString();
		unos[1] = txtNazivPredmeta.getText().toString();
		unos[2] = semestarCB.getSelectedItem().toString();
		unos[3] = godinaCB.getSelectedItem().toString();
		
		return unos;
	}

	private boolean isValideInput() {
		String unos [] = prikupiUnos();
		boolean ret = true;
		
		if (!Pattern.matches("[a-zA-Z0-9]*", unos[0])) {
			txtSifrePredmeta.setBackground(Color.RED);
			return false;
		}
		if (!Pattern.matches("[a-zA-Z0-9_ ]*", unos[1])) {
			txtNazivPredmeta.setBackground(Color.RED);
			return false;
		}
		for(String s: unos) {
			if((s = s.trim()).length() == 0) {
				txtSifrePredmeta.setBackground(Color.WHITE);
				txtNazivPredmeta.setBackground(Color.WHITE);
				ret = false;
			}
		}
		txtSifrePredmeta.setBackground(Color.WHITE);
		txtNazivPredmeta.setBackground(Color.WHITE);
		
		return ret;
	}

}
