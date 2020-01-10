package rs.ac.uns.ftn.oisis.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import rs.ac.uns.ftn.oisis.controller.PredmetiController;
import rs.ac.uns.ftn.oisis.model.BazaPredmeta;
import rs.ac.uns.ftn.oisis.model.Predmet;

public class DodavanjeStudentaProfesoraNaPredmetDialog extends JDialog {

	private static final long serialVersionUID = -8764610600946433965L;

	public DodavanjeStudentaProfesoraNaPredmetDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setLayout(new BorderLayout());
		setSize(400, 200);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		JPanel centar = new JPanel();
		centar.setLayout(new GridBagLayout());
		add(centar, BorderLayout.CENTER);

		JButton addStudenta = new JButton();
		addStudenta.setBackground(Color.WHITE);
		addStudenta.setIcon(new ImageIcon("images/student_na_predmet.png"));
		addStudenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PredmetiController.getInstance().DodavanjeStudNaPred();
				PredmetiTable.getInstance().refreshTable();

			}
		});

		JButton addProfesor = new JButton();
		addProfesor.setIcon(new ImageIcon("images/profesor_na_predmet.png"));
		addProfesor.setBackground(Color.WHITE);
		addProfesor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

				int selectedRow = PredmetiTablePane.getSelectedRow();
				Predmet predmet;
				if (BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) {
					predmet = PredmetiController.getInstance().getPredmetPoIndeksu(selectedRow);
				} else {
					predmet = BazaPredmeta.getInstance().getRazultatPretrage().get(selectedRow);
				}

				if (predmet.getPredmetniProf() == null) {

					DodavanjeProfesoraNaPredmetDialog dialog = new DodavanjeProfesoraNaPredmetDialog(
							MainFrame.getInstance(), "Dodavanje profesora na predmet", true);
					dialog.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(MainFrame.getInstance(),
							"Selektovani predmet ima predmetnog profesora!", "Greska", JOptionPane.ERROR_MESSAGE);
					ToolBar.getInstance().setSelectedButton();
					
				}
			}
		});

		JButton closeBtn = new JButton();
		closeBtn.setBackground(Color.WHITE);
		closeBtn.setIcon(new ImageIcon("images/close.png"));
		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ToolBar.getInstance().setSelectedButton();
			}
		});

		add(centar);

		JLabel student = new JLabel("Dodaj studenta");
		student.setForeground(new Color(0, 51, 102));
		JLabel profesor = new JLabel("Dodaj profesora");
		profesor.setForeground(new Color(0, 51, 102));
		JLabel odustani = new JLabel("Odustani");
		odustani.setForeground(new Color(0, 51, 102));

		centar.setOpaque(true);
		centar.setBackground(new Color(204, 227, 249));

		GridBagConstraints gbcAddStudent = new GridBagConstraints();
		gbcAddStudent.gridx = 0;
		gbcAddStudent.gridy = 0;
		gbcAddStudent.insets = new Insets(20, 20, 0, 20);
		centar.add(addStudenta, gbcAddStudent);

		GridBagConstraints gbcClose = new GridBagConstraints();
		gbcClose.gridx = 1;
		gbcClose.gridy = 0;
		gbcClose.insets = new Insets(20, 20, 0, 20);
		centar.add(closeBtn, gbcClose);

		GridBagConstraints gbcAddProfesor = new GridBagConstraints();
		gbcAddProfesor.gridx = 2;
		gbcAddProfesor.gridy = 0;
		gbcAddProfesor.insets = new Insets(20, 20, 0, 20);
		centar.add(addProfesor, gbcAddProfesor);

		GridBagConstraints gbcStudent = new GridBagConstraints();
		gbcStudent.gridx = 0;
		gbcStudent.gridy = 1;
		gbcStudent.insets = new Insets(20, 5, 0, 20);
		centar.add(student, gbcStudent);

		GridBagConstraints gbcProfesor = new GridBagConstraints();
		gbcProfesor.gridx = 1;
		gbcProfesor.gridy = 1;
		gbcProfesor.insets = new Insets(20, 5, 0, 20);
		centar.add(odustani, gbcProfesor);

		GridBagConstraints gbcOdustani = new GridBagConstraints();
		gbcOdustani.gridx = 2;
		gbcOdustani.gridy = 1;
		gbcOdustani.insets = new Insets(20, 5, 0, 20);
		centar.add(profesor, gbcOdustani);

	}

}
