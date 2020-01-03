package rs.ac.uns.ftn.oisis.view;

import java.awt.BorderLayout;
import java.awt.Component;
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

import rs.ac.uns.ftn.oisis.controller.StudentiController;

public class StudentiTablePane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7795870561938458998L;
	private StudentiTable studentiTable;
	private JScrollPane scrollPane;
	private static int selektovanaVrsta = -1;

	public StudentiTablePane() {
		setLayout(new BorderLayout());
		setOpaque(false);
		createStudentiTable();
	}

	private void createStudentiTable() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int swidth = screenSize.width;
		int sHeight = screenSize.height;

		JPanel top = new JPanel();
		JPanel down = new JPanel();
		JPanel left = new JPanel();
		JPanel right = new JPanel();

		top.setOpaque(false);
		down.setOpaque(false);
		left.setOpaque(false);
		right.setOpaque(false);

		top.setPreferredSize(new Dimension(swidth, sHeight / 10));
		down.setPreferredSize(new Dimension(swidth, sHeight / 10));

		add(top, BorderLayout.NORTH);
		add(down, BorderLayout.SOUTH);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);

		try {
			StudentiController.getInstance().otvoriFileStudent();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		studentiTable = StudentiTable.getInstance();

		TableRowSorter<TableModel> sort = new TableRowSorter<TableModel>(studentiTable.getModel());
		studentiTable.setRowSorter(sort);

		studentiTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				JTable table = (JTable) e.getComponent();
				setSelektovanaVrsta( table.convertRowIndexToModel(table.getSelectedRow()));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				JTable table = (JTable) e.getComponent();
				setSelektovanaVrsta( table.convertRowIndexToModel(table.getSelectedRow()));

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
				// TODO Auto-generated method stub

			}
		});

		scrollPane = new JScrollPane(studentiTable);
		add(scrollPane, BorderLayout.CENTER);
	}

	public static int getSelektovanaVrsta() {
		return selektovanaVrsta;
	}

	public static void setSelektovanaVrsta(int selektovanaVrsta) {
		StudentiTablePane.selektovanaVrsta = selektovanaVrsta;
	}

}
