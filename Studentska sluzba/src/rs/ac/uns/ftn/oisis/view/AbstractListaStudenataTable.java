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

		return 1;
	}

	@Override
	public int getRowCount() {
		int selektovan = PredmetiTablePane.getSelectedRow();
		Predmet p;
		
			if(BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) {
				p = BazaPredmeta.getInstance().getSviPredmeti().get(selektovan);

			}else {
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
				return p.getStudenti().get(rowIndex).getBrIndeksa();
			}else {
				Predmet p = BazaPredmeta.getInstance().getRazultatPretrage().get(selektovan);
				return p.getStudenti().get(rowIndex).getBrIndeksa();
				
			}
		}

		return null;
	}

	public String getColumnName(int column) {

		return "Br.Indeksa";
	}

}
