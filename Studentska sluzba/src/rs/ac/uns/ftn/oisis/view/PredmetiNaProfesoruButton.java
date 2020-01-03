package rs.ac.uns.ftn.oisis.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class PredmetiNaProfesoruButton extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2390976185333880537L;
	private JButton renderButton;
	private JButton edirotButton;

	private JTable table;

	private boolean isEditorActive = false;

	public PredmetiNaProfesoruButton(JTable table, int column) {

		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);

		this.setRenderButton(new JButton("Profesori"));
		this.edirotButton = new JButton("Profesori");

		this.edirotButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Dovrsi");

			}
		});

		this.setEditorActive(false);

	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) value;
		return btn;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) value;
		return btn;
	}

	public boolean isEditorActive() {
		return isEditorActive;
	}

	public void setEditorActive(boolean isEditorActive) {
		this.isEditorActive = isEditorActive;
	}

	public JButton getRenderButton() {
		return renderButton;
	}

	public void setRenderButton(JButton renderButton) {
		this.renderButton = renderButton;
	}

}
