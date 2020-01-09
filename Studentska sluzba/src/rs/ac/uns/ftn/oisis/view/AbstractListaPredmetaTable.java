package rs.ac.uns.ftn.oisis.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisis.model.BazaStudent;
import rs.ac.uns.ftn.oisis.model.Student;

public class AbstractListaPredmetaTable extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2678795261290884128L;

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getRowCount() {
		int selektovan = StudentiTablePane.getSelektovanaVrsta();
		Student s;
		BazaStudent.getInstance();
		if (BazaStudent.getBrStudenataPretga() == 0) {
			s = BazaStudent.getInstance().getSpisakStudenata().get(selektovan);

		} else {
			s = BazaStudent.getInstance().getRezPretrage().get(selektovan);
		}
		return s.getSpisakPredmeta().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int selektovan = StudentiTablePane.getSelektovanaVrsta();
		if (selektovan != -1) {
			Student s;
			BazaStudent.getInstance();
			if (BazaStudent.getBrStudenataPretga() == 0) {
				s = BazaStudent.getInstance().getSpisakStudenata().get(selektovan);
				return s.getSpisakPredmeta().get(rowIndex).getSifra();
			} else {
				s = BazaStudent.getInstance().getRezPretrage().get(selektovan);
				return s.getSpisakPredmeta().get(rowIndex).getSifra();
			}
		}

		return null;
	}

	public String getColumnName(int column) {

		return "Sifra Predmeta";
	}

}
