package rs.ac.uns.ftn.oisis.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisis.model.BazaPredmeta;

public class AbstractPredmetTable extends AbstractTableModel {

	private int rowCount = 17;
	private static final long serialVersionUID = 3147616286287644448L;

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getNazivKolona().size();
	}

	@Override
	public int getRowCount() {
		if(BazaPredmeta.getBrojUnetihPredmeta() > 17)
			rowCount = BazaPredmeta.getBrojUnetihPredmeta();
		else 
			rowCount = 17;
		return rowCount;
	}

	

	@Override
	public Object getValueAt(int row, int column) {
		return BazaPredmeta.getInstance().getValueAt(row, column);
	}

	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getNazivKolona().get(column);
	}

}
