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

import rs.ac.uns.ftn.oisis.controller.ProfesoriController;

public class ProfesoriTablePane extends JPanel {

	private static final long serialVersionUID = 3185855001667405798L;
	private JScrollPane scrollPane;
	private ProfesoriTable profesoriTable;
	private static int selektovanaVrsta = -1;

	public ProfesoriTablePane() {
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
		top.setPreferredSize(new Dimension(screenWidth, screenHeight / 10));
		down.setPreferredSize(new Dimension(screenWidth, screenHeight / 10));

		add(top, BorderLayout.NORTH);
		add(down, BorderLayout.SOUTH);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);

		profesoriTable = ProfesoriTable.getInstance();
		
		TableRowSorter<TableModel> sort = new TableRowSorter<TableModel>(profesoriTable.getModel());
		profesoriTable.setRowSorter(sort);

		profesoriTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				JTable table = (JTable) e.getComponent();

				setSelektovanaVrsta(table.convertRowIndexToModel(table.getSelectedRow()));

				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				JTable table = (JTable) e.getComponent();

				setSelektovanaVrsta(table.convertRowIndexToModel(table.getSelectedRow()));

				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		try {
			ProfesoriController.getInstance().loadData();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scrollPane = new JScrollPane(profesoriTable);
		add(scrollPane, BorderLayout.CENTER);
	}

	public static int getSelektovanaVrsta() {
		return selektovanaVrsta;
	}

	public static void setSelektovanaVrsta(int selektovanaVrsta) {
		ProfesoriTablePane.selektovanaVrsta = selektovanaVrsta;
	}

}
