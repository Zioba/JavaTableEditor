package trash;

import java.util.List;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel {
	private final int columnNumber = 6;
	private final String[] header = {"название книги", "ФИО автора",
			"издательство", "число томов", "тираж", "итого томов" };
	private List<Book> bookList;

	public TableModel(List<Book> bookList) {
		this.bookList = bookList;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int column) {
		return getValueAt(0, column).getClass();
	}

	public int getListSize() {
		return this.bookList.size();
	}

	public String getColumnName(int col) {
		return header[col];
	}

	@Override
	public int getRowCount() {
		return this.bookList.size();
	}

	@Override
	public int getColumnCount() {
		return columnNumber;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Book book = bookList.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return book.getName();
		case 1:
			return book.getNameA()+book.getSurnameA()+book.getOtcA();
		case 2:
			return book.getFirma();
		case 3:
			return book.getNumbOfToms();
		case 4:
			return book.getTir();
		case 5:
			return book.getItogo();
		}
		return "";
	}
}