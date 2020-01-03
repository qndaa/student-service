package rs.ac.uns.ftn.oisis.view;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TabelaSifriPredmeta extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4836951469472034922L;

	private static TabelaSifriPredmeta instance = null;

	public static TabelaSifriPredmeta getInstance() {
		if (instance == null) {
			instance = new TabelaSifriPredmeta();
		}

		return instance;

	}
	
	private TabelaSifriPredmeta() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractListaPredmetaTable());
		this.setRowHeight(20);
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
