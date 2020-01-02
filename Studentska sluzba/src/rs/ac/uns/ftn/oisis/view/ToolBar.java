package rs.ac.uns.ftn.oisis.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import rs.ac.uns.ftn.oisis.controller.BrisanjeListener;
import rs.ac.uns.ftn.oisis.controller.DodavanjeListener;
import rs.ac.uns.ftn.oisis.controller.DodavanjeStudentaProfesoraNaPredmetListener;
import rs.ac.uns.ftn.oisis.controller.IzmenaListener;
import rs.ac.uns.ftn.oisis.controller.PredmetiController;
import rs.ac.uns.ftn.oisis.controller.PretragaListener;
import rs.ac.uns.ftn.oisis.controller.ProfesoriController;
import rs.ac.uns.ftn.oisis.controller.StudentiController;

public class ToolBar extends JToolBar {

	private static final long serialVersionUID = -2522240199851802643L;

	enum Tip {
		STUDENT, PREDMET, PROFESOR;

		static Tip getTip(int i) {
			Tip t = null;
			if (i == 0)
				t = Tip.STUDENT;
			else if (i == 2)
				t = Tip.PROFESOR;
			else if (i == 1)
				t = Tip.PREDMET;
			return t;
		}
	};

	private JToggleButton addStudentBtn;
	private JToggleButton addPredmetBtn;
	private JToggleButton addProfesorBtn;

	private JToggleButton changeBtn;
	private JToggleButton deleteBtn;
	private JTextField searchField;

	private JToggleButton addStudentProfesorNaPredmetBtn;
	private JButton searchBtn;

	private JPanel left;
	private JPanel right;
	private static ToolBar instance = null;

	public static ToolBar getInstance() {
		if (instance == null) {
			instance = new ToolBar(Tip.STUDENT);
		}
		return instance;

	}

	private ToolBar(Tip tip) {
		super(SwingConstants.HORIZONTAL);
		setLayout(new BorderLayout());
		left = new JPanel();
		right = new JPanel();
		left.setLayout(new FlowLayout(FlowLayout.LEFT));
		left.setOpaque(false);
		right.setLayout(new FlowLayout(FlowLayout.RIGHT));
		right.setOpaque(false);

		addStudentBtn = new JToggleButton();
		addStudentBtn.setToolTipText("Dodaj novog studenta(alt+a)");
		addStudentBtn.setIcon(new ImageIcon("images/student.png"));
		addStudentBtn.addActionListener(new DodavanjeListener());
		addStudentBtn.setMnemonic(KeyEvent.VK_A);
		
		addPredmetBtn = new JToggleButton();
		addPredmetBtn.setToolTipText("Dodaj novi predmet(alt+a)");
		addPredmetBtn.setIcon(new ImageIcon("images/add.png"));
		addPredmetBtn.addActionListener(new DodavanjeListener());
		addPredmetBtn.setMnemonic(KeyEvent.VK_A);

		addProfesorBtn = new JToggleButton();
		addProfesorBtn.setToolTipText("Dodaj novog profesora(alt+a)");
		addProfesorBtn.setIcon(new ImageIcon("images/student.png"));
		addProfesorBtn.addActionListener(new DodavanjeListener());
		addProfesorBtn.setMnemonic(KeyEvent.VK_A);
		
		changeBtn = new JToggleButton();
		changeBtn.addActionListener(new IzmenaListener());
		changeBtn.setIcon(new ImageIcon("images/change.png"));
		changeBtn.setMnemonic(KeyEvent.VK_I);

		addStudentProfesorNaPredmetBtn = new JToggleButton();
		addStudentProfesorNaPredmetBtn.setToolTipText("Dodaj novog studenta/profesora na predmet(alt+o)");
		addStudentProfesorNaPredmetBtn.setIcon(new ImageIcon("images/student.png"));
		addStudentProfesorNaPredmetBtn.addActionListener(new DodavanjeStudentaProfesoraNaPredmetListener());
		addStudentProfesorNaPredmetBtn.setMnemonic(KeyEvent.VK_O);
		
		
		deleteBtn = new JToggleButton();
		deleteBtn.addActionListener(new BrisanjeListener());
		deleteBtn.setIcon(new ImageIcon("images/delete.png"));
		deleteBtn.setMnemonic(KeyEvent.VK_D);

		searchField = new JTextField(20);
		Font font1 = new Font("SansSerif", Font.BOLD, 18);
		searchField.setFont(font1);
		searchField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				JTextField txt = (JTextField) e.getComponent();
				if (txt.getText().length() == 0) {
					if (TabbedPane.activeTab == 0) {
						StudentiController.getInstance().pretragaStudenta();
					} else if (TabbedPane.activeTab == 1) {
						PredmetiController.getInstance().pretragaPredmeta();
					} else if (TabbedPane.activeTab == 2) {
						ProfesoriController.getInstance().pretragaProfesora();
					}
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		searchBtn = new JButton();
		searchBtn.setToolTipText("Pretrazi(alt+s)");
		searchBtn.setIcon(new ImageIcon("images/search.png"));

		searchBtn.addActionListener(new PretragaListener());
		searchBtn.setMnemonic(KeyEvent.VK_S);

		paintComponents(Tip.STUDENT);
		setFloatable(false);
	}

	public void paintComponents(Tip tip) {

		removeAll();
		left.removeAll();
		right.removeAll();
		if (tip == Tip.STUDENT) {

			left.add(addStudentBtn);
		} else if (tip == Tip.PREDMET) {

			left.add(addPredmetBtn);

		} else if (tip == Tip.PROFESOR) {

			left.add(addProfesorBtn);
		}

		addSeparator();

		if (tip == Tip.STUDENT) {
			changeBtn.setToolTipText("Izmeni studenta(alt+i)");
		} else if (tip == Tip.PREDMET) {
			changeBtn.setToolTipText("Izmena predmeta(alt+i)");
		} else if (tip == Tip.PROFESOR) {
			changeBtn.setToolTipText("Izmena profesora(alt+i)");
		}

		left.add(changeBtn);

		if (tip == Tip.STUDENT) {
			deleteBtn.setToolTipText("Brisanje studenta(alt+d)");
		} else if (tip == Tip.PREDMET) {
			deleteBtn.setToolTipText("Brisanje predmeta(alt+d)");
		} else if (tip == Tip.PROFESOR) {
			deleteBtn.setToolTipText("Brisanje profesora(alt+d)");
		}

		left.add(deleteBtn);

		if (tip == Tip.PREDMET) {

			left.add(addStudentProfesorNaPredmetBtn);

		}

		right.add(searchField);

		right.add(searchBtn);

		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);

	}

	public Tip getTip(int i) {
		return Tip.getTip(i);
	}

	public void setSelectedButton() {
		addPredmetBtn.setSelected(false);
		addStudentBtn.setSelected(false);
		addProfesorBtn.setSelected(false);
		changeBtn.setSelected(false);
		deleteBtn.setSelected(false);
		addStudentProfesorNaPredmetBtn.setSelected(false);
	}

	public JTextField getSearchField() {
		return searchField;
	}

	public void setSearchField(JTextField searchField) {
		this.searchField = searchField;
	}
}
