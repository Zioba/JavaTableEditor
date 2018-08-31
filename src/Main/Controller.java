package Main;

public class Controller {

	MainFrame view;
	Model model = null;

	public Controller(MainFrame view) {
		this.view = view;
		model = new Model(this);
	}

	public void toAdd() {
		view.createAddForm();
		view.southPanel.updateList(model.bookList);
	}

	public void toDelete() {
		view.setSearchVsDel(false);
		view.createSearchFrames();
	}

	public void toSearch() {
		view.setSearchVsDel(true);
		view.createSearchFrames();
	}
}
