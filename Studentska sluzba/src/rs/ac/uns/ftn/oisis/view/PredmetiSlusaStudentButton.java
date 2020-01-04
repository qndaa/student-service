package rs.ac.uns.ftn.oisis.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class PredmetiSlusaStudentButton extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{


	private static final long serialVersionUID = 7571585957736109417L;

	private JButton renderButton; //dugme koje se iscrtava
	
	private JButton editorButton; // dugme koje obradjuje akciju

	private JTable table; //referenca na table
	
	private boolean isEditorActive = false;
	
	public PredmetiSlusaStudentButton(JTable table, int column) {
		
		this.table=table;
		
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		
		this.renderButton = new JButton("Predmeti");
		this.editorButton = new JButton("Predmeti");
		
		this.editorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogListaPredmetaNaStudentu d = new DialogListaPredmetaNaStudentu(MainFrame.getInstance(), "Predmeti",true);
				d.setVisible(true);
			}
		});

		this.isEditorActive = false;
	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		
		return editorButton;
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		return renderButton;
	}

	public boolean isEditorActive() {
		return isEditorActive;
	}

	public void setEditorActive(boolean isEditorActive) {
		this.isEditorActive = isEditorActive;
	}
	
	
}
