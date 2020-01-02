package rs.ac.uns.ftn.oisis.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import rs.ac.uns.ftn.oisis.controller.PredmetiController;
import rs.ac.uns.ftn.oisis.model.BazaProfesora;
import rs.ac.uns.ftn.oisis.model.Profesor;

public class DodavanjeProfesoraNaPredmetDialog extends JDialog {

	private static final long serialVersionUID = 9036797225060112066L;

	private JButton potvrdaBtn;
	private JButton odustaniBtn;
	private JTextField licnaKartaUnos;
	private JLabel tekstLbl;

	public DodavanjeProfesoraNaPredmetDialog(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);

		setLayout(new BorderLayout());

		setSize(400, 150);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		JPanel panelBottom = new JPanel(new FlowLayout());
		panelBottom.add(Box.createHorizontalStrut(180));
		odustaniBtn = new JButton("Odustani");
		odustaniBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ToolBar.getInstance().setSelectedButton();
			}
		});

		potvrdaBtn = new JButton("Potvrda");
		potvrdaBtn.setEnabled(false);
		potvrdaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String input = licnaKartaUnos.getText().trim();
				Profesor profesor = null;
				if ((profesor = BazaProfesora.getInstance().getProfesora(input)) == null) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(),
							"Profesor sa unetom licnom kartom ne postoji u bazi profesora!", "Greska",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				boolean dodat = PredmetiController.getInstance().dodajProfesoraNaPredmet(profesor);

				if (dodat) {
					dispose();
					JOptionPane.showMessageDialog((Component) e.getSource(),
							"Uspesno ste dodali profesora na predmet.");
					ToolBar.getInstance().setSelectedButton();
					return;
				} else {
					JOptionPane.showMessageDialog(MainFrame.getInstance(),
							"Profesor sa unetom licnom kartom vec postoji na predmetu", "Greska",
							JOptionPane.ERROR_MESSAGE);
					ToolBar.getInstance().setSelectedButton();
					return;
				}

			}
		});

		panelBottom.add(odustaniBtn);
		panelBottom.add(potvrdaBtn);

		JPanel panelCenar = new JPanel();
		panelCenar.setLayout(new GridBagLayout());
		tekstLbl = new JLabel("Broj licne karte profesora:");

		licnaKartaUnos = new JTextField();

		licnaKartaUnos.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (isValideInput()) {
					potvrdaBtn.setEnabled(true);
					licnaKartaUnos.setBackground(Color.WHITE);
				} else {
					potvrdaBtn.setEnabled(false);
					licnaKartaUnos.setBackground(Color.RED);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		GridBagConstraints gbcTekstLbl = new GridBagConstraints();
		gbcTekstLbl.gridx = 0;
		gbcTekstLbl.gridy = 0;
		gbcTekstLbl.insets = new Insets(20, 0, 0, 0);
		panelCenar.add(tekstLbl, gbcTekstLbl);

		GridBagConstraints gbcLicnaKartaUnos = new GridBagConstraints();
		gbcLicnaKartaUnos.gridx = 1;
		gbcLicnaKartaUnos.gridy = 0;
		gbcLicnaKartaUnos.weightx = 200;
		gbcLicnaKartaUnos.fill = GridBagConstraints.HORIZONTAL;
		gbcLicnaKartaUnos.insets = new Insets(20, 0, 0, 0);
		panelCenar.add(licnaKartaUnos, gbcLicnaKartaUnos);

		panelCenar.setBackground(new Color(204, 227, 249));
		panelBottom.setBackground(new Color(210, 210, 210));

		add(panelCenar, BorderLayout.CENTER);
		add(panelBottom, BorderLayout.SOUTH);

	}

	private boolean isValideInput() {
		String input = licnaKartaUnos.getText();

		if (Pattern.matches("[0-9]+", input)) {
			return true;
		}
		return false;
	}

}
