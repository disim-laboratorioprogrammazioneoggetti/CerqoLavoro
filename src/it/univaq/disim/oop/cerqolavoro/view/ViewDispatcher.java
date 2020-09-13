package it.univaq.disim.oop.cerqolavoro.view;

import java.io.IOException;
import it.univaq.disim.oop.cerqolavoro.controller.DataInitializable;
import it.univaq.disim.oop.cerqolavoro.domain.User;
import it.univaq.disim.oop.cerqolavoro.domain.Worker;
import it.univaq.disim.oop.cerqolavoro.view.ViewException;
import it.univaq.disim.oop.cerqolavoro.view.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ViewDispatcher implements DataInitializable<Object> {

  private static final String RESOURCE_BASE = "/resources/Fxml/";
  private static final String FXML_SUFFIX = ".fxml";

  private static ViewDispatcher instance = new ViewDispatcher();

  private Stage stage;
  
  private BorderPane layout;
  
  private User user;

  private ViewDispatcher() {
  }
  
  public void loginView(Stage stage) throws ViewException {
	  this.stage = stage;
	  Parent loginView = loadView("login").getView();
	  Scene scene = new Scene(loginView);
	  stage.setScene(scene);
	  stage.show();
	  }
  
  public void loggedIn(User user) {
	  try {
	  View<User> layoutView = loadView("Layout");
	  //Deve essere invocato il metodo initializeData per fornire al controllore di
	  //layout l'utente
	  DataInitializable<User> layoutController = layoutView.getController();
	  layoutController.initializeData(user);
	  layout = (BorderPane) layoutView.getView();
	  //Anche in questo caso viene passato l'utente perche' nella vista di
	  //benvenuto il testo varia a seconda se e' docente od utente
	  renderView("Home", user);
	  Scene scene = new Scene(layout);
	  stage.setScene(scene);
	  } catch (ViewException e) {
	  renderError(e);
	  }
  }

  public void logout() {
	  try {
	  Parent loginView = loadView("Login").getView();
	  Scene scene = new Scene(loginView);
	  stage.setScene(scene);
	  } catch (ViewException e) {
	  renderError(e);
	  }
  }

  public void usersignupView(Stage stage) throws ViewException {
	    this.stage = stage;
	    Parent usersignup = loadView("UserSignUp").getView();
	    Scene scene = new Scene(usersignup);
	    stage.setScene(scene);
	    stage.setResizable(false);
	    stage.show();
	  }
  
  public void employersignupView(Stage stage) throws ViewException {
	    this.stage = stage;
	    Parent employersignupView = loadView("EmployerSignUp").getView();
	    Scene scene = new Scene(employersignupView);
	    stage.setScene(scene);
	    stage.setResizable(false);
	    stage.show();
	  }

  public void renderError(Exception e) {
		e.printStackTrace();
		System.exit(1);
	}
  
  public static ViewDispatcher getInstance() {
	    return instance;
	  }
  
  public <T> void renderView(String viewName, T data) {
	  try {
	  View<T> view = loadView(viewName);
	  DataInitializable<T> controller = view.getController();
	  controller.initializeData(data);
	  layout.setCenter(view.getView());
	  } catch (ViewException e) {
	  renderError(e);
	  }
  }
  
  private <T> View<T> loadView(String viewName) throws ViewException {
	  try {
	  FXMLLoader loader = new FXMLLoader(getClass().getResource(
	  RESOURCE_BASE + viewName + FXML_SUFFIX));
	  Parent parent = (Parent) loader.load();
	  return new View<>(parent, loader.getController());
	  } catch (IOException ex) {
	  throw new ViewException(ex);
	  }
  }
  
}