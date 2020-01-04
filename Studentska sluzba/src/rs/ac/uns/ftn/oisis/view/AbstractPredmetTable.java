package rs.ac.uns.ftn.oisis.view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisis.model.BazaPredmeta;

public class AbstractPredmetTable extends AbstractTableModel {

	private static final long serialVersionUID = 3147616286287644448L;

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getNazivKolona().size();
	}

	@Override
	public int getRowCount() {
		return (BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) ? BazaPredmeta.getBrojUnetihPredmeta()
				: BazaPredmeta.getBrojPredmetaKojiSuUPretrazi();
	}

	@Override
	public Object getValueAt(int row, int column) {
		if (column < 4) {
			return BazaPredmeta.getInstance().getValueAt(row, column);
		} else if (column == 4) {
			JButton btn = new JButton("Profesori");

			btn.setOpaque(false);
			return btn;

		} else if (column == 5) {
			JButton btn = new JButton("Studenti");
			btn.setOpaque(false);
			return btn;
		}
		return null;
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
			return JButton.class;
		case 5:
			return JButton.class;
		default:
			return null;
		}

	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= 4;
	}

	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getNazivKolona().get(column);
	}

}
