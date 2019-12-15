package rs.ac.uns.ftn.oisis.view;


import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6671747755061967982L;

	private JLabel time;
	private Thread th;

	public StatusBar() {
		setPreferredSize(new Dimension(100, 20));
		add(new JLabel("Studentska sluzba"));
		
		time= new JLabel();

		add(Box.createHorizontalStrut(780));



		add(time);
		th = new Thread(this);
		th.start();

	}

	@Override
	public void run() {
		try {

				do {
			
					DateFormat date= new SimpleDateFormat("HH:mm dd.MM.yyyy");
					Calendar cal = Calendar.getInstance();
					time.setText(date.format(cal.getTime()));
					Thread.sleep(1000);
					
				}while(th.isAlive());
			}catch (Exception e) {
		}

	}
}