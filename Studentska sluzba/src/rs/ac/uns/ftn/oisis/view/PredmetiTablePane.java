package rs.ac.uns.ftn.oisis.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import rs.ac.uns.ftn.oisis.controller.PredmetiController;

public class PredmetiTablePane extends JPanel {

	private static final long serialVersionUID = -4954990778466131805L;
	private JScrollPane scrollPane;
	private PredmetiTable predmetiTable;

	private static int selectedRow = -1;
	
	public PredmetiTablePane() {
		setLayout(new BorderLayout());
		setOpaque(false);
		createProfesoriTable();
	}


	private void createProfesoriTable() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		JPanel top = new JPanel();
		JPanel down = new JPanel();
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		down.setOpaque(false);
		top.setOpaque(false);
		left.setOpaque(false);
		right.setOpaque(false);
		top.setPreferredSize(new Dimension(screenWidth, screenHeight/10));
		down.setPreferredSize(new Dimension(screenWidth, screenHeight/10));
		
		add(top, BorderLayout.NORTH);
		add(down, BorderLayout.SOUTH);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
		
		//predmetiTable.setPreferredSize(new Dimension(screenHeight/4, screenWidth/4*3-20));
				// ucitava postojece podatke iz predmeti.txt
		try {
			PredmetiController.getInstance().loadData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		predmetiTable = PredmetiTable.getInstance();
		//predmetiTable.setPreferredSize(new Dimension(screenHeight/4, screenWidth/4*3-20));
		// ucitava postojece podatke iz predmeti.txt
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(predmetiTable.getModel());
		predmetiTable.setRowSorter(sorter);
		
		predmetiTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				JTable table = (JTable) e.getComponent();
				selectedRow = table.convertRowIndexToModel(table.getSelectedRow());	
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		scrollPane = new JScrollPane(predmetiTable);
		add(scrollPane, BorderLayout.CENTER);
		
	}


	public static int getSelectedRow() {
		return selectedRow;
	}


	public static void setSelectedRow(int selectedRow) {
		PredmetiTablePane.selectedRow = selectedRow;
	}
}
