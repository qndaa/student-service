package rs.ac.uns.ftn.oisis.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class DodavanjeProfesoraNaPredmetDialog extends JDialog {

	private static final long serialVersionUID = 9036797225060112066L;

	JButton potvrdaBtn;
	JButton odustaniBtn;

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
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		panelBottom.add(odustaniBtn);
		panelBottom.add(potvrdaBtn);

		JPanel panelCenar = new JPanel();
		panelCenar.setLayout(new GridBagLayout());
		JLabel tekstLbl = new JLabel("Broj licne karte profesora:");

		JTextField licnaKartaUnos = new JTextField();

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

}
