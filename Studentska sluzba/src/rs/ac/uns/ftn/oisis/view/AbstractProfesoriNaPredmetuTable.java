package rs.ac.uns.ftn.oisis.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.oisis.controller.PredmetiController;
import rs.ac.uns.ftn.oisis.controller.ProfesoriController;
import rs.ac.uns.ftn.oisis.model.BazaPredmeta;
import rs.ac.uns.ftn.oisis.model.Predmet;

public class AbstractProfesoriNaPredmetuTable extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2020760993323815221L;

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return JButton.class;
		default:
			return null;
		}
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int column) {
		return (column == 0) ? "Broj licne karte profesora" : "Ukloni profesora sa predmeta";
	}

	@Override
	public int getRowCount() {
		int selectedRow = PredmetiTablePane.getSelectedRow();
		Predmet p;
		if (BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) {
			p = BazaPredmeta.getInstance().getSviPredmeti().get(selectedRow);
		} else {
			p = BazaPredmeta.getInstance().getRazultatPretrage().get(selectedRow);
		}
		return p.getPredmetniProf().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		int selectedRow = PredmetiTablePane.getSelectedRow();
		if (column == 0) {
			Predmet p;
			if (BazaPredmeta.getBrojPredmetaKojiSuUPretrazi() == 0) {
				p = BazaPredmeta.getInstance().getSviPredmeti().get(selectedRow);

			} else {
				p = BazaPredmeta.getInstance().getRazultatPretrage().get(selectedRow);
			}
			return p.getPredmetniProf().get(row).getBrojLicneKarte();

		} else if (column == 1) {
			JButton delete = new JButton("Obrisi");
			delete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ProfesoriController.getInstance().obrisiPredmetSaProfesora();
					PredmetiController.getInstance().obrisiProfesoraSaPredmeta();

					ProfesoriNaPredmetuTable.getInstance().addNotify();

				}
			});
			return delete;
		}

		return null;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return (arg1 == 1) ? true : false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
