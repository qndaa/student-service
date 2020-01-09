package rs.ac.uns.ftn.oisis.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisis.model.BazaPredmeta;
import rs.ac.uns.ftn.oisis.model.Predmet;

public class AbstractListaStudenataTable extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1632732570193280986L;

	@Override
	public int getColumnCount() {

		return 3;
	}

	@Override
	public int getRowCount() {
		int selektovan = PredmetiTablePane.getSelectedRow();
		Predmet p;

		if (BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) {
			p = BazaPredmeta.getInstance().getSviPredmeti().get(selektovan);

		} else {
			p = BazaPredmeta.getInstance().getRazultatPretrage().get(selektovan);
		}

		return p.getStudenti().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int selektovan = PredmetiTablePane.getSelectedRow();
		if (selektovan != -1) {
			BazaPredmeta.getInstance();
			if (BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) {
				Predmet p = BazaPredmeta.getInstance().getSviPredmeti().get(selektovan);
				if (rowIndex < p.getStudenti().size()) {
					switch (columnIndex) {
					case 0:
						return p.getStudenti().get(rowIndex).getBrIndeksa();
					case 1:
						return p.getStudenti().get(rowIndex).getIme();
					case 2:
						return p.getStudenti().get(rowIndex).getPrezime();
					default:
						break;
					}

				}

			} else {
				Predmet p = BazaPredmeta.getInstance().getRazultatPretrage().get(selektovan);
				if (rowIndex < p.getStudenti().size()) {
					switch (columnIndex) {
					case 0:
						return p.getStudenti().get(rowIndex).getBrIndeksa();
					case 1:
						return p.getStudenti().get(rowIndex).getIme();
					case 2:
						return p.getStudenti().get(rowIndex).getPrezime();
					default:
						break;
					}

				}
			}

		}
		return null;
	}

	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Broj indeksa";
		case 1:
			return "Ime";
		case 2:
			return "Prezime";
			default:
				return null;
		}
	}

}
