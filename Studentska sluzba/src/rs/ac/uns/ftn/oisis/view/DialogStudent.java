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

public class DialogStudent extends JDialog{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6847297048903882740L;
	private JTextField txtField1;
	private JTextField txtField2;
	private JTextField txtField3;
	private JTextField txtField4;
	private JTextField txtField5;
	private JTextField txtField6;
	private JComboBox<String> god;
	private JRadioButton budz;
	private JRadioButton samo;
	private ButtonGroup bg1;
	private JButton odustani;
	private JButton potvrdi;
	
	public DialogStudent(Frame parent, String title, boolean modal) {
		super(parent,title,modal);
		
		
		setLayout(new GridLayout(9,2,10,20));
		setSize(500,500);
		setLocationRelativeTo(MainFrame.getInstance());	
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
				if(Provera_podataka()) {
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
		
		JLabel lblTxtField2 = new JLabel("Prezime");
		txtField2 = new JTextField(20);
		txtField2.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(Provera_podataka()) {
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
				if(Provera_podataka()) {
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
				if(Provera_podataka()) {
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
				if(Provera_podataka()) {
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
		JLabel lblTxtField6 = new JLabel("Broj indeksa");
		 txtField6 = new JTextField(20);
		 txtField6.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(Provera_podataka()) {
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
		
		JLabel lblTxtField7 = new JLabel("Trenutna godina Studija*");
		String[] godina=new String[]{"I(prva)","II(druga)","III(treca)","IV(cetvrta)"};
		god= new JComboBox<String>(godina);
		god.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Provera_podataka()) {
					potvrdi.setEnabled(true);
				}else {
					potvrdi.setEnabled(false);
				}
			}
		});
		
		
		bg1= new ButtonGroup();
		budz= new JRadioButton("Budzet",true);
		samo= new JRadioButton("Samofinansiranje");
		odustani = new JButton("Odustasni");
		potvrdi = new JButton("Potvird");
		samo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Provera_podataka()) {
					potvrdi.setEnabled(true);
				}else {
					potvrdi.setEnabled(false);
				}
			}
		});
		budz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Provera_podataka()) {
					potvrdi.setEnabled(true);
				}else {
					potvrdi.setEnabled(false);
				}
			}
		});
		
		bg1.add(budz);
		bg1.add(samo);
		add(lblTxtField1);
		add(txtField1);
		
		add(lblTxtField2);
		add(txtField2);
		add(lblTxtField3);
		add(txtField3);
		add(lblTxtField4);
		add(txtField4);
		add(lblTxtField5);
		add(txtField5);
		add(lblTxtField6);
		add(txtField6);
		add(lblTxtField7);
		add(god);
		add(budz);
		add(samo);
		add(odustani);
		add(potvrdi);
		
		setResizable(false);
		
		}
	
	
	private String[] podaci() {
		String []p= new String[8];
		
		for(int i=0; i<p.length; i++) {
			p[i]= new String();
		}
		
		p[0]= txtField1.getText().toString();
		p[1]= txtField2.getText().toString();
		p[2]= txtField3.getText().toString();
		p[3]= txtField4.getText().toString();
		p[4]= txtField5.getText().toString();
		p[5]= txtField6.getText().toString();
		p[6]= god.getSelectedItem().toString();
		if(samo.isSelected()) {
			p[7]="S";
		}else {
			p[7]="B";
		}
		
		return p;
	}
	
	

	
	
	private boolean Provera_podataka() {
		boolean ret= true;
		String []p= podaci();
		System.out.println(p[7]);
		
		
		System.out.println(p[7]);
		if(!Pattern.matches("[A-Za-z]*", p[0])) {
			txtField1.setBackground(Color.RED);
			return false;
		}
		else {
			txtField1.setBackground(Color.WHITE);
		}	
		if(!Pattern.matches("[A-Za-z]*", p[1])) {
			txtField2.setBackground(Color.RED);
			return false;	
		}
		else {
			txtField2.setBackground(Color.WHITE);
		}
		
		if(p[2].length()!=0) {
			if(!Pattern.matches("^(3[01]|[12][0-9]|0[1-9]).(1[0-2]|0[1-9]).[0-9]{4}$", p[2])) {
				txtField3.setBackground(Color.RED);
				return false;  
			}
		}
		if(p[3].length()!=0) {
			if(!Pattern.matches("[A-Z]{1}[a-z]+ [A-Za-z]+, [0-9]{5} [A-Z]{1}[a-z]+",p[3])) {
				txtField4.setBackground(Color.RED);
				return false;
			}
		}
		if(p[4].length()!=0) {
			if(!Pattern.matches("^\\+[0-9]*",p[4])) {
				txtField5.setBackground(Color.RED);
				return false;
			}
			else if (p[4].length()>13) {
				txtField5.setBackground(Color.RED);
				return false;
			}
		}
		if(p[5].length()!=0) {
			if(!Pattern.matches("[A-Z]{2,3}-[0-9]{2,3}-[0-9]{4}",p[5])) {
				txtField6.setBackground(Color.RED);
				return false;
			}
		}
			
		
		for (String string : p) {
			if((string=string.trim()).length()==0) {
				txtField1.setBackground(Color.WHITE);
				txtField2.setBackground(Color.WHITE);
				txtField3.setBackground(Color.WHITE);
				txtField4.setBackground(Color.WHITE);
				txtField5.setBackground(Color.WHITE);
				txtField6.setBackground(Color.WHITE);
				return false;
				
			}
		}
		
		txtField1.setBackground(Color.WHITE);
		txtField2.setBackground(Color.WHITE);
		txtField3.setBackground(Color.WHITE);
		txtField4.setBackground(Color.WHITE);
		txtField5.setBackground(Color.WHITE);
		txtField6.setBackground(Color.WHITE);
		
		return ret;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
