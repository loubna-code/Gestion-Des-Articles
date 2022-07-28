package Presentation;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Metier.Article;

@SuppressWarnings("serial")
public class ModelArticle extends AbstractTableModel {
	private ArrayList<Article> list;

	public ModelArticle(ArrayList<Article> list) {
		super();
		this.list = list;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public int getColumnCount() {
		return Article.class.getDeclaredFields().length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return list.get(rowIndex).get(columnIndex);

	}

	@Override
	public String getColumnName(int j) {
		return Article.class.getDeclaredFields()[j].getName();
	}
	
	@Override
	public Class<?> getColumnClass(int j) {
		return Article.class.getDeclaredFields()[j].getType();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public void setValueAt(Object o, int i, int j) {
		
		switch (j) {
		case 0:
			this.list.get(i).setID((Integer) o);
			this.fireTableCellUpdated(i, j);
			break;
		case 1:
			this.list.get(i).setLibele((String) o);
			this.fireTableCellUpdated(i, j);
			break;
		case 2:
			this.list.get(i).setPrix((Float) o);
			this.fireTableCellUpdated(i, j);
			break;
		case 3:
			this.list.get(i).setQuantite((Integer) o);
			this.fireTableCellUpdated(i, j);
			break;
		}
	}
	
	

}
