package it.univaq.disim.oop.cerqolavoro;

import it.univaq.disim.oop.cerqolavoro.view.ViewDispatcher;
import it.univaq.disim.oop.cerqolavoro.view.ViewException;
import javafx.application.Application;
import javafx.stage.Stage;

public class CerqoLavoroApplication extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		try {
			ViewDispatcher viewDispatcher = ViewDispatcher.getInstance();
			viewDispatcher.loginView(stage);
		} catch (ViewException e) {
			e.printStackTrace();
		}
	}

}