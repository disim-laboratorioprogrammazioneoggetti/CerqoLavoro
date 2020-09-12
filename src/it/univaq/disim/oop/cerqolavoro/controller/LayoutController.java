package it.univaq.disim.oop.cerqolavoro.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.univaq.disim.oop.cerqolavoro.domain.Employer;
import it.univaq.disim.oop.cerqolavoro.domain.Worker;
import it.univaq.disim.oop.cerqolavoro.domain.User;
import it.univaq.disim.oop.cerqolavoro.view.ViewDispatcher;
import it.univaq.disim.oop.cerqolavoro.controller.MenuElement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

public class LayoutController implements Initializable, DataInitializable<User> {

	private static final MenuElement MENU_HOME = new MenuElement("Home", "home");

	private static final MenuElement[] MENU_EMPLOYER = { new MenuElement("Cerca", "EmployerSearch"),
			new MenuElement("Crea", "AddOffer"), new MenuElement("Offerte", "Hire") };
	
	private static final MenuElement[] MENU_WORKER = { new MenuElement("Account", "UserAccount"),
			new MenuElement("Cerca", "UserSearch"), new MenuElement("Candidature", "UserCandidacy"), 
			new MenuElement("Messaggi", "UserMessage") };

	private User user;	
	private ViewDispatcher dispatcher;
	
	@FXML private VBox menuBar;
	
	public LayoutController() {
		dispatcher = ViewDispatcher.getInstance();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	// Differenziazione menù in base al ruolo dell' utente
	
	@Override
	public void initializeData(User user) {
		this.user = user;
		menuBar.getChildren().addAll(createButton(MENU_HOME));
		menuBar.getChildren().add(new Separator());

		if (user instanceof Employer) {
			for (MenuElement menu : MENU_EMPLOYER) {
				menuBar.getChildren().add(createButton(menu));
			}
		}
		
		if (user instanceof Worker) {
			for (MenuElement menu : MENU_WORKER) {
				menuBar.getChildren().add(createButton(menu));
			}
		}
	}

	// Pulsante Logout
	
	@FXML 
	public void logoutAction(MouseEvent event) {
		dispatcher.logout();
	}
	
	// Crea elemento menù

	private Button createButton(MenuElement viewItem) {
		Button button = new Button(viewItem.getName());
		button.setStyle("-fx-background-color: transparent; -fx-font-size: 14;");
		button.setTextFill(Paint.valueOf("white"));
		button.setPrefHeight(10);
		button.setPrefWidth(180);
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			dispatcher.renderView(viewItem.getVista(), user);
			}
			});
			return button;
    }


}

