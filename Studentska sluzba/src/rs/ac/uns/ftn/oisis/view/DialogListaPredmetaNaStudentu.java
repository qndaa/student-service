package rs.ac.uns.ftn.oisis.view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;


public class DialogListaPredmetaNaStudentu extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6761121462519660180L;
	
	
	private JPanel down;
	protected JButton odustani;
	private JTable listaSifriPredmeta;
  
	
	public DialogListaPredmetaNaStudentu(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setLayout(new BorderLayout());
		setSize(300,400);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		down = new JPanel();
		down.setLayout(new BorderLayout());
		
		odustani = new JButton("Zatvori");
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		down.add(odustani, BorderLayout.CENTER);
		PrikazTabele();
		add(down, BorderLayout.SOUTH);
		setResizable(false);
	}
	
	private void PrikazTabele() {
		listaSifriPredmeta =  TabelaSifriPredmeta.getInstance();
		
		JScrollPane scrol =  new JScrollPane(listaSifriPredmeta);
		add(scrol, BorderLayout.CENTER);
		TabelaIndeksa.getInstance().OsveziTabelu();
	}

	
	
	
	
}
