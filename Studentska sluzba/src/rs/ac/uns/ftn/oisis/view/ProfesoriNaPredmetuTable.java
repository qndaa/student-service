package rs.ac.uns.ftn.oisis.view;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ProfesoriNaPredmetuTable extends JTable{

	private static final long serialVersionUID = -156870853483894396L;
	
	private static ProfesoriNaPredmetuTable instance = null;
	
	public static ProfesoriNaPredmetuTable getInstance() {
		if (instance == null) {
			instance = new ProfesoriNaPredmetuTable();
		}
		return instance;
	}
	
	
	private ProfesoriNaPredmetuTable() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractProfesoriNaPredmetuTable());
		this.setRowHeight(20);
		new ObrisiProfesoraSaPredmetaButton(this, 1);
	}
	
	public void refreshTable() {
		AbstractProfesoriNaPredmetuTable apt = (AbstractProfesoriNaPredmetuTable) this.getModel();
		apt.fireTableDataChanged();
		
		validate();
		
	}	

}
