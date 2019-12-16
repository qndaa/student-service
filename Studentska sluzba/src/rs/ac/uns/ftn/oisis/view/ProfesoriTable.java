package rs.ac.uns.ftn.oisis.view;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;



public class ProfesoriTable extends JTable {
	
	private static final long serialVersionUID = 6534430224487357381L;

	public ProfesoriTable() {
		this.setRowSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractProfesoriTable());
		this.setRowHeight(20);
		//this.
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		// selektovani red ce imati drugaciju boju od ostalih
		
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
