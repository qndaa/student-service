package rs.ac.uns.ftn.oisis.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import rs.ac.uns.ftn.oisis.controller.PredmetiController;
import rs.ac.uns.ftn.oisis.controller.ProfesoriController;
import rs.ac.uns.ftn.oisis.model.Profesor;

public class ProfesoriNaPredmetuDialog extends JDialog {

	private static final long serialVersionUID = 4582576472527889884L;

	private JPanel down = null;
	private JPanel panelCenter = null;
	private JButton close = null;
	private JButton delete = null;

	public ProfesoriNaPredmetuDialog(Frame parent, String title, boolean modal, Profesor profesor) {
		super(parent, title, modal);
		setLayout(new BorderLayout());
		setSize(450, 250);
		setLocationRelativeTo(MainFrame.getInstance());
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setResizable(false);

		down = new JPanel();

		panelCenter = new JPanel();

		panelCenter.setBackground(Color.white);
		panelCenter.setLayout(new GridBagLayout());
		panelCenter.setBackground(new Color(204, 227, 249));
		add(panelCenter, BorderLayout.CENTER);

		JLabel licnaKarta = new JLabel("Licna karta:");
		JLabel ime = new JLabel("Ime:");
		JLabel prezime = new JLabel("Prezime:");

		GridBagConstraints gbcLicnaKarta = new GridBagConstraints();
		gbcLicnaKarta.gridx = 0;
		gbcLicnaKarta.gridy = 0;
		gbcLicnaKarta.insets = new Insets(20, 30, 0, 30);
		panelCenter.add(licnaKarta, gbcLicnaKarta);

		GridBagConstraints gbcIme = new GridBagConstraints();
		gbcIme.gridx = 1;
		gbcIme.gridy = 0;
		gbcIme.insets = new Insets(20, 30, 0, 30);
		panelCenter.add(ime, gbcIme);

		GridBagConstraints gbcPrezime = new GridBagConstraints();
		gbcPrezime.gridx = 2;
		gbcPrezime.gridy = 0;
		gbcPrezime.insets = new Insets(20, 30, 0, 30);
		panelCenter.add(prezime, gbcPrezime);

		JLabel licnaKartaProfesor = new JLabel(profesor.getBrojLicneKarte());
		JLabel imeProfesor = new JLabel(profesor.getIme());
		JLabel prezimeProfesor = new JLabel(profesor.getPrezime());

		licnaKartaProfesor.setBackground(Color.LIGHT_GRAY);
		licnaKartaProfesor.setOpaque(true);
		imeProfesor.setBackground(Color.LIGHT_GRAY);
		imeProfesor.setOpaque(true);
		prezimeProfesor.setBackground(Color.LIGHT_GRAY);
		prezimeProfesor.setOpaque(true);

		GridBagConstraints gbcLicnaKartaProfesor = new GridBagConstraints();
		gbcLicnaKartaProfesor.gridx = 0;
		gbcLicnaKartaProfesor.gridy = 1;
		gbcLicnaKartaProfesor.insets = new Insets(20, 30, 0, 30);
		panelCenter.add(licnaKartaProfesor, gbcLicnaKartaProfesor);

		GridBagConstraints gbcImeProfesor = new GridBagConstraints();
		gbcImeProfesor.gridx = 1;
		gbcImeProfesor.gridy = 1;
		gbcImeProfesor.insets = new Insets(20, 30, 0, 30);
		panelCenter.add(imeProfesor, gbcImeProfesor);

		GridBagConstraints gbcPrezimeProfesor = new GridBagConstraints();
		gbcPrezimeProfesor.gridx = 2;
		gbcPrezimeProfesor.gridy = 1;
		gbcPrezimeProfesor.insets = new Insets(20, 30, 0, 30);
		panelCenter.add(prezimeProfesor, gbcPrezimeProfesor);

		delete = new JButton("Obrisi predmetnog profesora");

		GridBagConstraints gbcObrisi = new GridBagConstraints();
		gbcObrisi.gridx = 0;
		gbcObrisi.gridy = 2;
		gbcObrisi.gridwidth = 3;
		gbcObrisi.insets = new Insets(50, 50, 0, 50);
		panelCenter.add(delete, gbcObrisi);

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ProfesoriController.getInstance().obrisiPredmetSaProfesora();
				PredmetiController.getInstance().obrisiProfesoraSaPredmeta();
				dispose();
				JOptionPane.showMessageDialog((Component) e.getSource(), "Uspesno ste izbrisali predmetnog profesora!");

			}
		});

		down.setLayout(new BorderLayout());
		close = new JButton("Zatvori");

		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		down.add(close, BorderLayout.CENTER);

		add(down, BorderLayout.SOUTH);

	}

}
