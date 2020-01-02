package rs.ac.uns.ftn.oisis.view;

import javax.swing.JButton;
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
		if(BazaStudent.getBrStudenataPretga() == 0) {
			return BazaStudent.getBrStudenata();
			
		}
		return BazaStudent.getBrStudenataPretga();
	}

	@Override
	public Object getValueAt(int row, int column) {
		if(column<11) {
		
		return BazaStudent.getInstance().getValueAt(row,column);
		}else if(column == 11) {
			JButton bt = new JButton("Predmeti");
			return bt;
		}	
		return null;
	}
	
	public String getColumnName(int column) {
		
		return BazaStudent.getInstance().getColon().get(column);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		case 5:
			return String.class;
		case 6:
			return String.class;
		case 7:
			return String.class;
		case 8:
			return String.class;
		case 9:
			return String.class;
		case 10:
			return String.class;
		case 11:
			return JButton.class;		
		default:
			return null;
		}

	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	
		return columnIndex>=11;
	}
	
 
	
	
	
	
	
	
	
	
	
}
