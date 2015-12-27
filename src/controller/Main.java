package controller;

import model.DataStore;
import view.MainWindow;

public class Main {
	private MainWindow main;
	private MainWindowListener listen;
	private MenuListener ml;
	private DataStore ds;

	public Main() {
		ds = new DataStore();
		listen = new MainWindowListener();
		ml = new MenuListener();
		main = new MainWindow(listen, ml);
		main.setVisible(true);
	}
}
