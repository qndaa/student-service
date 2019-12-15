package rs.ac.uns.ftn.oisis.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisis.model.BazaProfesora;
;

public class AbstractProfesoriTable extends AbstractTableModel {

	private static final long serialVersionUID = 896226746368774679L;

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getNaziviKolona().size();
	}

	@Override
	public int getRowCount() {
		return 17;
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaProfesora.getInstance().getValueAt(row, column);		
	}
	
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getNaziviKolona().get(column);
	}

	
}
