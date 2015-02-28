package Main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Controller.Controller;

public class RunTime {
	public static void main(String[] args) {
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException
				| InstantiationException | IllegalAccessException e) {
			// handle exception if L&F is not found
		}
		//Here you create a Controller
		Controller.createGame();

	}
}
