package rs.ac.uns.ftn.oisis.view;


import javax.swing.JTable;
import javax.swing.ListSelectionModel;



public class ProfesoriTable extends JTable {
	
	private static final long serialVersionUID = 6534430224487357381L;

	public ProfesoriTable() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractProfesoriTable());
		this.setRowHeight(20);
		//this.
	}
	
	
}
