package rs.ac.uns.ftn.oisis.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import rs.ac.uns.ftn.oisis.controller.PredmetiController;
import rs.ac.uns.ftn.oisis.controller.StudentiController;
import rs.ac.uns.ftn.oisis.model.Predmet;
import rs.ac.uns.ftn.oisis.model.Student;

public class DialogStudenaNaPredmet extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1126689005936796176L;
	protected JTextField indeks;
	protected JButton odustani;
	protected JButton potvrdi;
	protected JPanel gore;
	protected JPanel dole;

	public DialogStudenaNaPredmet(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setLayout(new BorderLayout());
		setSize(400, 100);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		gore = new JPanel();
		gore.setLayout(new FlowLayout());
		dole = new JPanel();
		dole.setLayout(new FlowLayout());

		JLabel lbl = new JLabel("Indeks");
		indeks = new JTextField(20);
		indeks.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Provera()) {
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

		potvrdi = new JButton("Potvrdi");
		potvrdi.setEnabled(false);

		potvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String p = brIndeksa();

				int row = PredmetiTable.getInstance().getSelectedRow();
				Predmet pred = PredmetiController.getInstance().getPredmetPoIndeksu(row); // vraca Predmet selektovan
				Student s = StudentiController.getInstance().getStudentPoIndeksu(p);// vraca studenta sa prosledjenim
																					// indeksom
				boolean IndeksPostoji = StudentiController.getInstance().IndeksPostoji(p);// vraca true ako postoji
																							// student sa prosledjenim
																							// indeksom
				boolean StudentNapredmetuPostoji = PredmetiController.getInstance().PostojiStudentSaIndeksom(p, row);// vraca
																														// false
																														// //
																														// predmetu
			
				boolean odgovarajucaGodina = false;
				if (s != null) {
					if (pred.getGodIzv().equals(s.getGodinaS())) {
						odgovarajucaGodina = true;
					}
				}

				boolean DodajStudentaNaPredmet = false;

				if (IndeksPostoji == false && StudentNapredmetuPostoji == true && odgovarajucaGodina == true) {
					DodajStudentaNaPredmet = true;

				}
				if (DodajStudentaNaPredmet) {
					dispose();
	
					PredmetiController.getInstance().DodavanjeStudentaNaPredmet(s, row);
					StudentiController.getInstance().DodavanjePredmetaStudentu(pred, p); // dodali smo predmet studentu
					JOptionPane.showMessageDialog((Component) e.getSource(), "Uspesno ste dodali studenta na predmet");
				} else {
	
					if (IndeksPostoji) {
						setVisible(false);
						JOptionPane.showMessageDialog((Component) e.getSource(),
								"Student sa unteim indeksom ne postoji u bazi studenata", "Eror",
								JOptionPane.ERROR_MESSAGE);
						setVisible(true);
						return;

					} else if (!StudentNapredmetuPostoji) {
						setVisible(false);
						JOptionPane.showMessageDialog((Component) e.getSource(), "Student postoji vec na predmetu",
								"Eror", JOptionPane.ERROR_MESSAGE);
						setVisible(true);
						return;
					} else if (!DodajStudentaNaPredmet) {
						setVisible(false);
						JOptionPane.showMessageDialog((Component) e.getSource(),
								"Student nije odgovarajuca godina da bi pohadjao predmet", "Eror",
								JOptionPane.ERROR_MESSAGE);
						setVisible(true);
						return;
					}
				}

			}
		});

		odustani = new JButton("Odustani");

		odustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		gore.add(lbl);
		gore.add(indeks);
		dole.add(odustani);
		dole.add(potvrdi);

		add(gore, BorderLayout.NORTH);
		add(dole, BorderLayout.SOUTH);

	}

	protected String brIndeksa() {
		String br = new String();
		br = indeks.getText().toString();
		return br;
	}

	private boolean Provera() {
		boolean ret = true;
		String brIn = brIndeksa();

		if (brIn.length() != 0) { // indeks
			if (!Pattern.matches("[A-Z]{2,3}-[0-9]{1,3}-[0-9]{4}", brIn)) {
				indeks.setBackground(Color.RED);
				return false;
			}
		}
		if ((brIn = brIn.trim()).length() == 0) {
			indeks.setBackground(Color.WHITE);
			return false;
		}

		indeks.setBackground(Color.WHITE);

		return ret;

	}

}
