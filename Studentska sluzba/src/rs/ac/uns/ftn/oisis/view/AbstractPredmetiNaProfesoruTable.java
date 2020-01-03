package rs.ac.uns.ftn.oisis.view;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisis.model.BazaProfesora;
import rs.ac.uns.ftn.oisis.model.Profesor;

public class AbstractPredmetiNaProfesoruTable extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4742586247889868144L;

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		default:
			return null;
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		
		return (columnIndex == 0) ? "Sifra predmeta" : "Naziv predmeta";
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getSviProfesori().get(ProfesoriTablePane.getSelektovanaVrsta()).getPredajeNaPredmetima().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Profesor profesor = BazaProfesora.getInstance().getSviProfesori().get(ProfesoriTablePane.getSelektovanaVrsta());
		
		if(rowIndex < profesor.getPredajeNaPredmetima().size()) {
			switch (columnIndex) {
			case 0:
				return profesor.getPredajeNaPredmetima().get(rowIndex).getSifra();
			case 1:
				return profesor.getPredajeNaPredmetima().get(rowIndex).getNaziv();
			default:
				break;
			}
		}
		
		
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

}
