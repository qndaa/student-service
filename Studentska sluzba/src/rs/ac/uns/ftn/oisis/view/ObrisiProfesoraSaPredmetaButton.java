package rs.ac.uns.ftn.oisis.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ObrisiProfesoraSaPredmetaButton extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2933356557531124549L;
	private JButton renderButton;
	private JButton editorButton;
	private JTable table;

	private boolean isEditableActive = false;

	public ObrisiProfesoraSaPredmetaButton(JTable table, int column) {

		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);

		this.renderButton = new JButton("Obrisi");
		this.editorButton = new JButton("Obrisi");

		this.editorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Dovrsi");

			}
		});

		this.isEditableActive = false;

	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
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

	public boolean isEditableActive() {
		return isEditableActive;
	}

	public void setEditableActive(boolean isEditableActive) {
		this.isEditableActive = isEditableActive;
	}

}
