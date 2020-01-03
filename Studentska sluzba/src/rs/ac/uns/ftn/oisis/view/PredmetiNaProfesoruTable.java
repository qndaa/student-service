package rs.ac.uns.ftn.oisis.view;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class PredmetiNaProfesoruTable extends JTable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5251502875500977682L;
	private static PredmetiNaProfesoruTable instance = null;
	
	public static PredmetiNaProfesoruTable getInstance() {
		if(instance == null) {
			instance = new PredmetiNaProfesoruTable();
		}
		return instance;
	}
	
	public PredmetiNaProfesoruTable() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractPredmetiNaProfesoruTable());
		this.setRowHeight(20);
	}
	
	
}
