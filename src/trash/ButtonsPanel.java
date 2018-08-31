package trash;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public JButton addButt;
	public JButton delButt;
	public JButton findButt;
	public JButton saveButt;
	public JButton exitButt;
	public JButton openButt;

	public ButtonsPanel() {
		this.setLayout(null);
		addButt = new JButton("Добавить");
		delButt = new JButton("Удалить");
		findButt = new JButton("Поиск");
		openButt = new JButton("Открыть");
		saveButt = new JButton("Сохранить");
		exitButt = new JButton("Выход");
		addButt.setBounds(5, 10, 120, 40);
		delButt.setBounds(5, 55, 120, 40);
		findButt.setBounds(5, 100, 120, 40);
		openButt.setBounds(5, 145, 120, 40);
		saveButt.setBounds(5, 190, 120, 40);
		exitButt.setBounds(5, 280, 120, 40);
		this.add(addButt);
		this.add(delButt);
		this.add(findButt);
		this.add(openButt);
		this.add(saveButt);
		this.add(exitButt);
	}
}