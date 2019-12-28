package rs.ac.uns.ftn.oisis.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class StudentiTable extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9214635334888450896L;
	
	private static StudentiTable instance = null;
	
	public static StudentiTable getInstance() {
		if(instance == null) {
			instance = new StudentiTable();
		}
		return instance;
		
	}
	
	
	
	private StudentiTable() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractStudentiTable());
		this.setRowHeight(20);
	}

	
	public void OsveziTabelu() {
		AbstractStudentiTable model = (AbstractStudentiTable) this.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);

		if (isRowSelected(row)) {
			c.setBackground(Color.GRAY);

		} else {
			if (row % 2 == 0) {

				c.setBackground(new Color(224, 235, 255));
			} else {
				c.setBackground(Color.WHITE);

			}
		}
		return c;
	}

}
