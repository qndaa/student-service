package rs.ac.uns.ftn.oisis.view;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class StudentiTable extends JTable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9214635334888450896L;

	public StudentiTable() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractStudentiTable());
		this.setRowHeight(20);
	}
}
