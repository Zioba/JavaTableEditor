package komponentStr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import trash.Book;
import trash.TableModel;

public class componentStr extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton manageButt;
	private JButton firstButt;
	private JButton prevButt;
	private JButton nextButt;
	private JButton lastButt;
	private int currentPage = 0;
	private int onPage = 0;
	List<Book> bookList = new ArrayList<Book>();
	List<Book> answer;
	private JLabel textAll;
	private JLabel textOnPage;
	private JLabel textFir;
	private JLabel textSec;
	JTable table;
	TableModel tableModel;

	public componentStr(JTable table) {
		this.setLayout(null);
		currentPage = 0;
		onPage = 0;
		this.table = table;
		tableModel = new TableModel(bookList);
		this.table.setModel(tableModel);
		manageButt = new JButton("изменить число записей на странице");
		firstButt = new JButton("<<");
		prevButt = new JButton("<");
		nextButt = new JButton(">");
		lastButt = new JButton(">>");
		textFir = new JLabel("Всего записей:");
		textAll = new JLabel();
		textSec = new JLabel("На странице:");
		textOnPage = new JLabel();
		manageButt.setBounds(5, 10, 280, 30);
		firstButt.setBounds(290, 10, 50, 30);
		prevButt.setBounds(345, 10, 50, 30);
		nextButt.setBounds(400, 10, 50, 30);
		lastButt.setBounds(455, 10, 50, 30);
		textFir.setBounds(550, 10, 90, 30);
		textAll.setBounds(640, 10, 10, 30);
		textSec.setBounds(670, 10, 80, 30);
		textOnPage.setBounds(750, 10, 80, 30);
		this.add(manageButt);
		this.add(firstButt);
		this.add(prevButt);
		this.add(nextButt);
		this.add(lastButt);
		this.add(textFir);
		this.add(textAll);
		this.add(textSec);
		this.add(textOnPage);

		this.manageButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onPage = Integer.parseInt(JOptionPane
						.showInputDialog("Введите сколько"));
				currentPage = 0;
				update();
			}
		});
		this.nextButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bookList.size() > (currentPage + 1) * onPage)
					currentPage++;
				update();
			}
		});
		this.prevButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPage > 0)
					currentPage--;
				update();
			}
		});
		this.firstButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPage = 0;
				update();
			}
		});
		this.lastButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bookList.size() % onPage == 0)
					currentPage = bookList.size() / onPage - 1;
				else
					currentPage = bookList.size() / onPage;
				update();
			}
		});
	}

	public void update() {
		if (onPage == 0)
			onPage = bookList.size();
		makePage();
		// mod = (TableModel) view.table.getModel();
		// table.updateUI();
		tableModel = null;
		tableModel = new TableModel(answer);
		table.setModel(tableModel);
		textAll.setText(Integer.toString(bookList.size()));
		textOnPage.setText(Integer.toString(onPage));
	}

	public void makePage() {
		answer = null;
		answer = new ArrayList<Book>();
		for (int i = 0; i < onPage; i++) {
			if ((currentPage) * onPage + i < bookList.size())
				answer.add(bookList.get((currentPage) * onPage + i));
		}
	}

	public void updateList(List<Book> bookList) {
		this.bookList = bookList;
		update();
	}
}