package rs.ac.uns.ftn.oisis.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;


public class StudentNaPredmetuButton extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

	private static final long serialVersionUID = 3419255571741324469L;

	private JButton renderButton;
	private JButton editorButton;
	
	private JTable table;
	
	private boolean isEditorActive = false;
	
	
	public StudentNaPredmetuButton(JTable table, int column) {
		
		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		
		
		this.renderButton = new JButton("Studenti");
		this.editorButton = new JButton("Studenti");
		
		this.editorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Dovrsi");
				
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
		JButton btn = (JButton) value;
		return btn;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JButton btn = (JButton) value;
		return btn;
	}


	public JButton getRenderButton() {
		return renderButton;
	}


	public void setRenderButton(JButton renderButton) {
		this.renderButton = renderButton;
	}


	public JButton getEditorButton() {
		return editorButton;
	}


	public void setEditorButton(JButton editorButton) {
		this.editorButton = editorButton;
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public boolean isEditorActive() {
		return isEditorActive;
	}


	public void setEditorActive(boolean isEditorActive) {
		this.isEditorActive = isEditorActive;
	}

}
