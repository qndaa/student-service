package rs.ac.uns.ftn.oisis.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PredmetiTable extends JTable {
	
	private static final long serialVersionUID = 1473484278510522821L;

	public PredmetiTable() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractPredmetTable());
		this.setRowHeight(20);
		
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		// selektovani red ce imati drugaciju boju od ostalih
		
		if (row % 2 == 0) {
			c.setBackground(new Color(224, 235, 255));
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}
