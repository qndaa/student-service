package rs.ac.uns.ftn.oisis.view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

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
	
	private JToggleButton addStudentNaPredmetBtn;
	private JButton searchBtn;
	public static ToolBar instance = null;
	public static ToolBar getInstance() {
		if (instance == null) {
			instance = new ToolBar(Tip.STUDENT);
		}
		return instance;
		
	}
	
	private ToolBar(Tip tip) {
		super(SwingConstants.HORIZONTAL);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		paintComponents(Tip.STUDENT);
		setFloatable(false);
	}

	public void paintComponents(Tip tip) {
		
		removeAll();
		if ( tip == Tip.STUDENT) {
			addStudentBtn = new JToggleButton();
			addStudentBtn.setToolTipText("Dodaj novog studenta");
			addStudentBtn.setIcon(new ImageIcon("images/student.png"));
			add(addStudentBtn, FlowLayout.LEFT);
		} else if (tip == Tip.PREDMET) {
			addPredmetBtn = new JToggleButton();
			addPredmetBtn.setToolTipText("Dodaj novi predmet.");
			addPredmetBtn.setIcon(new ImageIcon("images/add.png"));
			add(addPredmetBtn, FlowLayout.LEFT);

		} else if (tip == Tip.PROFESOR) {
			addProfesorBtn = new JToggleButton();
			addProfesorBtn.setToolTipText("Dodaj novog profesora");
			addProfesorBtn.setIcon(new ImageIcon("images/student.png"));
			add(addProfesorBtn, FlowLayout.LEFT);
		}
		addSeparator();
		

		changeBtn = new JToggleButton();
		if (tip == Tip.STUDENT) {
			changeBtn.setToolTipText("Izmeni studenta");
		} else if (tip == Tip.PREDMET) {
			changeBtn.setToolTipText("Izmena predmeta");
		} else if (tip == Tip.PROFESOR) {
			changeBtn.setToolTipText("Izmena profesora");
		}
		changeBtn.setIcon(new ImageIcon("images/change.png"));

		add(changeBtn);

		addSeparator();
		deleteBtn = new JToggleButton();
		if (tip == Tip.STUDENT) {
			deleteBtn.setToolTipText("Brisanje studenta");
		} else if (tip == Tip.PREDMET) {
			deleteBtn.setToolTipText("Brisanje predmeta");
		} else if (tip == Tip.PROFESOR) {
			deleteBtn.setToolTipText("Brisanje profesora");
		}
		deleteBtn.setIcon(new ImageIcon("images/delete.png"));
		add(deleteBtn);

		addSeparator();
		
		if (tip == Tip.STUDENT || tip == Tip.PROFESOR) {
			add(Box.createHorizontalStrut(550));
		} else if (tip == Tip.PREDMET) {
			addStudentNaPredmetBtn = new JToggleButton();
			addStudentNaPredmetBtn.setToolTipText("Dodaj novog studenta/profesora na predmet.");
			addStudentNaPredmetBtn.setIcon(new ImageIcon("images/student.png"));
			add(addStudentNaPredmetBtn);
			add(Box.createHorizontalStrut(500));

		}

		searchField = new JTextField(20);
		Font font1 = new Font("SansSerif", Font.BOLD, 18);
		searchField.setFont(font1);
		add(searchField);

		addSeparator();

		searchBtn = new JButton();
		searchBtn.setToolTipText("Pretrazi studenta.");
		searchBtn.setIcon(new ImageIcon("images/search.png"));

		add(searchBtn);
		
	}
	
	public Tip getTip(int i) {
		return Tip.getTip(i);
	}
}
