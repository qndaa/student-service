package rs.ac.uns.ftn.oisis.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisis.model.BazaStudent;

public class AbstractStudentiTable extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1592165881945763800L;

	@Override
	public int getColumnCount() {
		
		return BazaStudent.getInstance().getColon().size();
	}

	@Override
	public int getRowCount() {
		return 17;
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaStudent.getInstance().getValueAt(row,column);
	}
	
	public String getColumnName(int column) {
		
		return BazaStudent.getInstance().getColon().get(column);
	}
	
	
	
	
	
	
}
