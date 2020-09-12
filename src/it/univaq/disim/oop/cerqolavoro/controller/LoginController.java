package it.univaq.disim.oop.cerqolavoro.controller;

import java.net.URL;
import java.util.ResourceBundle;
import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.business.CerqoLavoroBusinessFactory;
import it.univaq.disim.oop.cerqolavoro.business.UserNotFoundException;
import it.univaq.disim.oop.cerqolavoro.business.UserService;
import it.univaq.disim.oop.cerqolavoro.business.impl.ram.RAMUserServiceImpl;
import it.univaq.disim.oop.cerqolavoro.domain.User;
import it.univaq.disim.oop.cerqolavoro.view.ViewDispatcher;
import it.univaq.disim.oop.cerqolavoro.view.ViewException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable, DataInitializable<Object> {

    @FXML private TextField email;
    @FXML private PasswordField password;
    @FXML private Button loginButton;   
    @FXML private Label loginErrorLabel;
    @FXML private Button employerSignUpButton;
    @FXML private Button workerSignUpButton;
    
	private ViewDispatcher dispatcher;
	private UserService userService;    
    public Stage stage = new Stage();
    
    // Pulsante Registrazione Azienda
    
    @FXML
    void employerSignUp(ActionEvent event) throws ViewException {
         dispatcher.employersignupView(stage);
    }

    // Pulsante Registrazione Impiegato
    
    @FXML
    void workerSignUp(ActionEvent event) throws ViewException {
        dispatcher.usersignupView(stage);
    }
	
	public LoginController() {
		dispatcher = ViewDispatcher.getInstance();
		userService = new RAMUserServiceImpl(userService);
		CerqoLavoroBusinessFactory factory = CerqoLavoroBusinessFactory.getInstance();
		userService = factory.getUserService();
	}
    
    // Pulsante Login 
	
    @FXML
    void loginAction(ActionEvent event) throws ViewException {
    	try {
        User user = userService.authenticate(email.getText(), password.getText());
            if ( user != null ) {
            	dispatcher.loggedIn(user);	
            }
		} catch (UserNotFoundException e) {
			loginErrorLabel.setText("Username e/o password errati!");
		} catch (BusinessException e) {
			dispatcher.renderError(e);
		}
    }
        
          @Override
          public void initialize(URL location, ResourceBundle resources) {     
        	  loginButton.disableProperty().bind(email.textProperty().isEmpty().or(password.textProperty().isEmpty()));
              assert loginButton != null;
          }

}