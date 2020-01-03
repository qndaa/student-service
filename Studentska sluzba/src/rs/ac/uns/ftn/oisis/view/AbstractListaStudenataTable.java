package rs.ac.uns.ftn.oisis.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisis.model.BazaPredmeta;
import rs.ac.uns.ftn.oisis.model.BazaStudent;
import rs.ac.uns.ftn.oisis.model.Predmet;

public class AbstractListaStudenataTable extends AbstractTableModel {

	@Override
	public int getColumnCount() {

		return 1;
	}

	@Override
	public int getRowCount() {
		int selektovan = PredmetiTablePane.getSelectedRow();
		if (selektovan != -1) {
			Predmet p = BazaPredmeta.getInstance().getSviPredmeti().get(selektovan);
			return p.getStudenti().size();
		}

		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int selektovan = PredmetiTablePane.getSelectedRow();
		if (selektovan != -1) {
			if (rowIndex < BazaPredmeta.getInstance().getSviPredmeti().get(selektovan).getStudenti().size() && BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() ==0) {
				Predmet p = BazaPredmeta.getInstance().getSviPredmeti().get(selektovan);
				return p.getStudenti().get(rowIndex).getBrIndeksa();

			}
		}

		return null;
	}

	public String getColumnName(int column) {

		return "Br.Indeksa";
	}

	public void addRow(Object[] dates) {

	}

}
