package rs.ac.uns.ftn.oisis.view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisis.model.BazaProfesora;;

public class AbstractProfesoriTable extends AbstractTableModel {

	private static final long serialVersionUID = 896226746368774679L;

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getNaziviKolona().size();
	}

	@Override
	public int getRowCount() {
		return (BazaProfesora.getBrojProfesoraKojiSuUPretrazi() == 0) ? BazaProfesora.getBrojUnetihProfesora()
				: BazaProfesora.getBrojProfesoraKojiSuUPretrazi();

	}

	@Override
	public Object getValueAt(int row, int column) {
		if (column < 10) {
			return BazaProfesora.getInstance().getValueAt(row, column);
		} else {
			JButton btn = new JButton("Predmeti");

			btn.setOpaque(false);
			return btn;
		}
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
			return JButton.class;
		default:
			return null;
		}

	}

	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getNaziviKolona().get(column);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= 10;
	}

}
