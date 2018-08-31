package Main;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import komponentStr.componentStr;
import trash.Book;
import trash.ButtonsPanel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel panel;
	JTable table;
	Boolean searchVsDel;
	JFrame searchFrame;
	Controller controller = null;
	ButtonsPanel buttonsPanel;
	componentStr southPanel;
	JScrollPane scrollPane;
	Menu m1;
	MenuItem ID_OPEN;
	MenuItem ID_SAVE;
	MenuItem ID_SEARCH;
	MenuItem delim1;
	MenuItem ID_EXIT;
	Menu m2;
	MenuItem ID_ADD;
	MenuItem ID_DEL;
	Menu m3;
	MenuItem ID_CHANGE;

	public MainFrame() {
		MenuBar toolBar = new MenuBar();
		this.setMenuBar(toolBar);
		m1 = new Menu("Файл");
		toolBar.add(m1);
		ID_OPEN = new MenuItem("Открыть");
		ID_SAVE = new MenuItem("Сохранить");
		ID_SEARCH = new MenuItem("Поиск");
		delim1 = new MenuItem("-");
		ID_EXIT = new MenuItem("Выход");
		m2 = new Menu("Редактирование");
		toolBar.add(m2);
		ID_ADD = new MenuItem("Добавить");
		ID_DEL = new MenuItem("Удалить");
		m3 = new Menu("Управление страницами");
		toolBar.add(m3);
		ID_CHANGE = new MenuItem("Изменить число записей на странице");
		m1.add(ID_OPEN);
		m1.add(ID_SAVE);
		m1.add(ID_SEARCH);
		m1.add(delim1);
		m1.add(ID_EXIT);
		m2.add(ID_ADD);
		m2.add(ID_DEL);
		m3.add(ID_CHANGE);
		controller = new Controller(this);
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setTitle("Easy tablVSrabl v3.0.02");
		this.setResizable(false);
		this.setLayout(null);
		buttonsPanel = new ButtonsPanel();
		buttonsPanel.setBounds(5, 10, 250, 350);
		this.add(buttonsPanel);
		table = new JTable();
		southPanel = new componentStr(table);
		southPanel.updateList(controller.model.bookList);
		scrollPane = new JScrollPane(table);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(280, 10, 800, 500);
		this.add(scrollPane);
		// southPanel = new SouthPanel(table);
		// southPanel.updateList(controller.model.bookList);
		southPanel.setBounds(280, 520, 800, 100);
		this.add(southPanel);
	}

	void run() {
		buttonsPanel.addButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.toAdd();
			}
		});
		buttonsPanel.delButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.toDelete();
			}
		});
		buttonsPanel.findButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.toSearch();
			}
		});
		buttonsPanel.openButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.model.load();
			}
		});
		buttonsPanel.saveButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.model.save();
			}
		});
		buttonsPanel.exitButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		ID_ADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.toAdd();
			}
		});
		ID_DEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.toDelete();
			}
		});
		ID_SEARCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.toSearch();
			}
		});
		ID_OPEN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.model.load();
			}
		});
		ID_SAVE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.model.save();
			}
		});
		ID_EXIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
	}

	public void setSearchVsDel(Boolean bool) {
		this.searchVsDel = bool;
	}

	public void setFirstContent() {
		JTextField name = new JTextField("", 30);
		JTextField surname = new JTextField("", 30);
		JTextField otch = new JTextField("", 30);
		JButton butt = new JButton("OK");
		panel.add(new JLabel("Введите имя"));
		panel.add(name);
		panel.add(new JLabel("Введите фамилию"));
		panel.add(surname);
		panel.add(new JLabel("Введите отчество"));
		panel.add(otch);
		panel.add(butt);
		butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.model.searchOne(name.getText(), surname.getText(),
						otch.getText());
				searchFrame.setVisible(false);
				searchFrame.dispose();
			}
		});
	}

	public void setSecondContent() {
		JTextField firma = new JTextField("", 30);
		JTextField name = new JTextField("", 30);
		JTextField surname = new JTextField("", 30);
		JTextField otch = new JTextField("", 30);
		JButton butt = new JButton("OK");
		panel.add(new JLabel("Введите имя"));
		panel.add(name);
		panel.add(new JLabel("Введите фамилию"));
		panel.add(surname);
		panel.add(new JLabel("Введите отчество"));
		panel.add(otch);
		panel.add(new JLabel("Введите издательство"));
		panel.add(firma);
		panel.add(new JLabel(""));
		panel.add(butt);
		butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.model.searchTwo(firma.getText(), name.getText(),
						surname.getText(), otch.getText());
				searchFrame.setVisible(false);
				searchFrame.dispose();
			}
		});
	}

	public void setThirdContent() {
		JTextField name = new JTextField("", 30);
		JButton butt = new JButton("OK");
		panel.add(new JLabel("Введите название книги"));
		panel.add(name);
		panel.add(butt);
		butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.model.searchThree(name.getText());
				searchFrame.setVisible(false);
				searchFrame.dispose();
			}
		});
	}

	public void setForthContent() {
		JTextField name = new JTextField("", 30);
		JTextField surname = new JTextField("", 30);
		JTextField otch = new JTextField("", 30);
		JButton butt = new JButton("OK");
		JTextField begin = new JTextField("", 30);
		JTextField end = new JTextField("", 30);
		panel.add(new JLabel("Введите имя"));
		panel.add(name);
		panel.add(new JLabel("Введите фамилию"));
		panel.add(surname);
		panel.add(new JLabel("Введите отчество"));
		panel.add(otch);
		panel.add(new JLabel("Введите минимальное количество томов"));
		panel.add(begin);
		panel.add(new JLabel("Введите максимальное количество томов"));
		panel.add(end);
		panel.add(butt);
		butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.model.searchFour(name.getText(), surname.getText(),
						otch.getText(), Integer.parseInt(begin.getText()),
						Integer.parseInt(end.getText()));
				searchFrame.setVisible(false);
				searchFrame.dispose();
			}
		});
	}

	public void setFiveContent() {
		JTextField up = new JTextField("", 30);
		JTextField down = new JTextField("", 30);
		JButton butt = new JButton("OK");
		panel.add(new JLabel("Введите верхний предел"));
		panel.add(up);
		panel.add(new JLabel("Введите нижний"));
		panel.add(down);
		panel.add(butt);
		butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.model.searchFive(Integer.parseInt(up.getText()),
						Integer.parseInt(down.getText()));
				searchFrame.setVisible(false);
				searchFrame.dispose();
			}
		});
	}

	public void createSearchFrames() {
		searchFrame = new JFrame();
		searchFrame.setSize(400, 350);
		searchFrame.setLocation(700, 200);
		searchFrame.setVisible(true);
		panel = new JPanel();
		JMenuBar menuBar = new JMenuBar();
		JMenu searchMenu = new JMenu("Параметры поиска/удаления");
		JMenuItem first = new JMenuItem("по ФИО автора");
		JMenuItem second = new JMenuItem("по издательству и ФИО автора");
		JMenuItem third = new JMenuItem("по названию книги");
		JMenuItem forth = new JMenuItem("по ФИО автора и числу томов ");
		JMenuItem five = new JMenuItem("тираж больше/меньше заданной границы");
		searchMenu.add(first);
		searchMenu.add(second);
		searchMenu.add(third);
		searchMenu.add(forth);
		searchMenu.add(five);
		menuBar.add(searchMenu);
		searchFrame.setJMenuBar(menuBar);
		setFirstContent();
		searchFrame.setContentPane(panel);
		first.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchFrame.getContentPane().removeAll();
				setFirstContent();
				searchFrame.setContentPane(panel);
			}
		});
		second.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchFrame.getContentPane().removeAll();
				setSecondContent();
				searchFrame.setContentPane(panel);
			}
		});
		third.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchFrame.getContentPane().removeAll();
				setThirdContent();
				searchFrame.setContentPane(panel);
			}
		});
		forth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchFrame.getContentPane().removeAll();
				setForthContent();
				searchFrame.setContentPane(panel);
			}
		});
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchFrame.getContentPane().removeAll();
				setFiveContent();
				searchFrame.setContentPane(panel);
			}
		});

	}

	public void createAddForm() {
		JFrame addForm = new JFrame();
		addForm.setVisible(true);
		JPanel panel = new JPanel();
		JTextField nameB = new JTextField("", 30);
		JTextField nameA = new JTextField("", 30);
		JTextField surnameA = new JTextField("", 30);
		JTextField otchA = new JTextField("", 30);
		JTextField firma = new JTextField("", 30);
		JTextField numbOfToms = new JTextField("", 30);
		JTextField tir = new JTextField("", 30);
		JButton butt = new JButton("OK");
		addForm.setTitle("Диалог добавления");
		addForm.setLocation(700, 200);
		addForm.setSize(370, 420);
		addForm.setLayout(null);
		panel.add(new JLabel("Введите название книги"));
		panel.add(nameB);
		panel.add(new JLabel("Введите имя автора"));
		panel.add(nameA);
		panel.add(new JLabel("Введите фамилию автора"));
		panel.add(surnameA);
		panel.add(new JLabel("Введите отчество автора"));
		panel.add(otchA);
		panel.add(new JLabel("Введите издательство"));
		panel.add(firma);
		panel.add(new JLabel("Введите количество томов"));
		panel.add(numbOfToms);
		panel.add(new JLabel("тираж"));
		panel.add(tir);
		panel.add(butt);
		addForm.setContentPane(panel);
		butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.model.add(nameB.getText(), nameA.getText(),
						surnameA.getText(), otchA.getText(), firma.getText(),
						Integer.parseInt(numbOfToms.getText()),
						Integer.parseInt(tir.getText()));
				addForm.dispose();
			}
		});
	}

	public void showResult(List<Book> list) {
		JTable findTable;
		componentStr findSouthPanel;
		JFrame additionalFrame = new JFrame();
		JButton butt = new JButton("OK");
		JScrollPane scrll;
		JLabel npanel = new JLabel();
		additionalFrame.setSize(850, 800);
		additionalFrame.setLocation(450, 100);
		additionalFrame.setFocusable(false);
		additionalFrame.setLayout(null);
		JLabel lable = new JLabel();
		if (list.isEmpty()) {
			lable.setText("Совпадения не найдены");
			lable.setBounds(300, 10, 250, 30);
			additionalFrame.add(lable);
			additionalFrame.setVisible(true);
			return;
		}
		if (searchVsDel) {
			npanel.setText("Результаты поиска");
			npanel.setBounds(400, 10, 250, 30);
		} else {
			npanel.setText("Следующие элементы были удалены");
			npanel.setBounds(300, 10, 250, 30);
		}
		findTable = new JTable();
		findSouthPanel = new componentStr(findTable);
		findSouthPanel.updateList(list);
		scrll = new JScrollPane(findTable);
		scrll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrll.setBounds(10, 50, 800, 500);
		findSouthPanel.setBounds(10, 560, 800, 50);
		butt.setBounds(400, 620, 60, 40);
		additionalFrame.add(npanel);
		additionalFrame.add(scrll);
		additionalFrame.add(findSouthPanel);
		additionalFrame.add(butt);
		butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				additionalFrame.dispose();
			}
		});
		additionalFrame.setVisible(true);
	}
}
