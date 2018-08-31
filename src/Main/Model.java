package Main;

import java.awt.FileDialog;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import trash.Book;

public class Model {
    //всего страниц кол-во записей/onPage
	//текущая страница currentPage
	Controller controller = null;
	public List<Book> bookList = new ArrayList<Book>();
	
	public Model(Controller controller) {
		super();
		this.controller = controller;
	}
	
	public void add(String nameB, String nameA, String surnameA, String otchA,
			String firma, int numbOfToms, int tir) {
		Book book = new Book(nameB, nameA, surnameA, otchA, firma, numbOfToms, tir);
		bookList.add(book);
		controller.view.southPanel.updateList(bookList);
	}
	
	public void delete(List<Book> toDelete) {
		for (int m = 0; m < toDelete.size(); m++) {
			for (int mark = 0; mark < bookList.size(); mark++) {
				if (bookList.get(mark).equals(toDelete.get(m))) {
					bookList.remove(bookList.get(mark));
				}
			}
		}
		controller.view.southPanel.updateList(bookList);
	}
	
	public void searchOne(String name, String surname, String otch) {
		List<Book> result = new ArrayList<Book>();
		Book book;
		for (int mark = 0; mark < bookList.size(); mark++) {
			book = bookList.get(mark);
			if ( book.getNameA().equals(name)
					&& book.getSurnameA().equals(surname)
					&& book.getOtcA().equals(otch)) {
				result.add(book);
			}
		}
		controller.view.showResult(result);
		if (!controller.view.searchVsDel) {
			delete(result);
		}
	}

	public void searchTwo(String firma, String name, String surname, String otch) {
		Book book;
		List<Book> result = new ArrayList<Book>();
		for (int mark = 0; mark < bookList.size(); mark++) {
			book = bookList.get(mark);
			if (book.getFirma().equals(firma)
					&& book.getNameA().equals(name)
					&& book.getSurnameA().equals(surname)
					&& book.getOtcA().equals(otch)) {
				result.add(book);
			}
		}
		controller.view.showResult(result);
		if (!controller.view.searchVsDel) {
			delete(result);
		}
	}

	public void searchThree(String name) {
		Book book;
		List<Book> result = new ArrayList<Book>();
		for (int mark = 0; mark < bookList.size(); mark++) {
			book = bookList.get(mark);
			if (book.getName().equals(name)) {
				result.add(book);
			}
		}
		controller.view.showResult(result);
		if (!controller.view.searchVsDel) {
			delete(result);
		}
	}
	
	public void searchFive(int up, int down) {
		Book book;
		List<Book> result = new ArrayList<Book>();
		for (int mark = 0; mark < bookList.size(); mark++) {
			book = bookList.get(mark);
			if (book.getTir() < up && book.getTir() > down) {
				result.add(book);
			}
		}
		controller.view.showResult(result);
		if (!controller.view.searchVsDel) {
			delete(result);
		}
	}

	public void searchFour(String name, String surname, String otch, int begin,
			int end) {
		Book book;
		List<Book> result = new ArrayList<Book>();
		for (int mark = 0; mark < bookList.size(); mark++) {
			book = bookList.get(mark);
			if (book.getNumbOfToms()>begin && book.getNumbOfToms() < end
					&& book.getNameA().equals(name)
					&& book.getSurnameA().equals(surname)
					&& book.getOtcA().equals(otch)) {
				result.add(book);
			}
		}
		controller.view.showResult(result);
		if (!controller.view.searchVsDel) {
			delete(result);
		}
	}

	public void save() {
		Book book;
		Element rootElement = new Element("bookList");
		Document doc = new Document(rootElement);
		FileDialog saveDia = new FileDialog(controller.view, "Choose a file",
				FileDialog.SAVE);
		saveDia.setDirectory("C:\\Users\\ZioBa\\Desktop\\");
		saveDia.setVisible(true);
		String filename = saveDia.getFile();
		if (filename == null) {
			JOptionPane.showMessageDialog(null, "Вы отменили выбор файла");
		} else {
			XMLOutputter outputter = new XMLOutputter();
			outputter.setFormat(Format.getPrettyFormat());
			filename = saveDia.getDirectory() + filename;
			if (!filename.contains(".")) {
				filename += ".xml";
			}
			for (int mark = 0; mark < bookList.size(); mark++) {
				book = bookList.get(mark);
				rootElement.addContent(new Element("book")
						.setAttribute("name", book.getName())
						.setAttribute("nameA", book.getName())
						.setAttribute("surnameA", book.getSurnameA())
						.setAttribute("otcA", book.getOtcA())
						.setAttribute("firma", book.getFirma())
						.setAttribute("numbToms",
								Integer.toString(book.getNumbOfToms()))
						.setAttribute("tir", Integer.toString(book.getTir())));
			}
			try {
				FileWriter fw = new FileWriter(filename);
				outputter.output(doc, fw);
				fw.close();
				JOptionPane.showMessageDialog(controller.view,
						"сохранение прошло успешно");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(controller.view,
						"не удалось сохранить");
			}
		}
	}

	public void load() {
		Book book;
		FileDialog loadDia = new FileDialog(controller.view, "Choose a file",
				FileDialog.LOAD);
		loadDia.setDirectory("C:\\Users\\ZioBa\\Desktop\\");
		loadDia.setVisible(true);
		String filename = loadDia.getFile();
		if (filename == null) {
			JOptionPane.showMessageDialog(null, "Вы отменили выбор файла");
		} else {
			filename = loadDia.getDirectory() + filename;
			try {
				SAXBuilder parser = new SAXBuilder();
				FileReader fr = new FileReader(filename);
				Document rDoc = parser.build(fr);
				this.bookList.clear();
				List<Element> temp = rDoc.getRootElement().getChildren();
				for (int mark = 0; mark < temp.size(); mark++) {
					List<Attribute> atrs = temp.get(mark).getAttributes();
					book = new Book(atrs.get(0).getValue(), 
							atrs.get(1).getValue(), 
							atrs.get(2).getValue(),
							atrs.get(3).getValue(),
							atrs.get(4).getValue(),
							Integer.parseInt(atrs.get(5).getValue()),
							Integer.parseInt(atrs.get(6).getValue()));
					this.bookList.add(book);
				}
				controller.view.southPanel.updateList(bookList);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		controller.view.southPanel.updateList(bookList);
	}
}