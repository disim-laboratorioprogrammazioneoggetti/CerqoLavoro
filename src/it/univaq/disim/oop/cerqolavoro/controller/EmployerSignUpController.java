package it.univaq.disim.oop.cerqolavoro.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import it.univaq.disim.oop.cerqolavoro.domain.User;
import it.univaq.disim.oop.cerqolavoro.domain.Worker;
import it.univaq.disim.oop.cerqolavoro.view.ViewDispatcher;
import it.univaq.disim.oop.cerqolavoro.view.ViewException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmployerSignUpController implements Initializable, DataInitializable<Object> {
  
    // Campi registrazione
    
    @FXML
    private TextField Namefield;

    @FXML
    private TextField Surnamefield;

    @FXML
    private TextField EmailField;

    @FXML
    private TextField CMailField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private TextField CNameField;

    @FXML
    private TextField IVAFIeld;

    @FXML
    private TextField PhoneField;

    @FXML
    private TextField CPhoneField;
    
    @FXML
    private TextArea DescriptionArea;
    
    public Stage stage = new Stage();
    
    @FXML
    void EmployerBacktoOpening(ActionEvent event) throws IOException
    {
        try {
    		ViewDispatcher viewDispatcher = ViewDispatcher.getInstance();
    		viewDispatcher.openingView(stage);
    	} catch (ViewException e) {
    		e.printStackTrace();
    	}
    }
    @FXML
    void EmployerSignUp(ActionEvent event2) throws IOException
    {
        boolean signupcheck = true;
       
      if(Namefield.getText().isEmpty()) { signupcheck = false; }
      if(Surnamefield.getText().isEmpty()) { signupcheck = false; }
      if(EmailField.getText().isEmpty()) { signupcheck = false; }
      if(CMailField.getText().isEmpty()) { signupcheck = false; }
      if(PasswordField.getText().isEmpty()) { signupcheck = false; }
      if(CNameField.getText().isEmpty()) { signupcheck = false; }
      if(IVAFIeld.getText().isEmpty()) { signupcheck = false; }
      if(PhoneField.getText().isEmpty()) { signupcheck = false; }
      if(CPhoneField.getText().isEmpty()) { signupcheck = false; }
      if(DescriptionArea.getText().isEmpty()) { signupcheck = false; }
       
      // Messaggio di errore se non tutti i campi sono completi
      
      if (signupcheck  == false) {
    	  Alert errorAlert = new Alert(AlertType.ERROR);
    	  errorAlert.setHeaderText("ERRORE");
    	  errorAlert.setContentText("Devi riempire i campi di Registrazione");
    	  errorAlert.showAndWait();
      }
      
      if(signupcheck == true) {
          
          // Crea file profilo Datore di lavoro
          
          StringBuilder sb =  new StringBuilder();
            sb.append( PasswordField.getText().toString()+ "\n");  
            sb.append( Namefield.getText().toString()+ "\n");
            sb.append( Surnamefield.getText().toString()+ "\n");
            sb.append( EmailField.getText().toString()+ "\n");
            sb.append( CMailField.getText().toString()+ "\n");
            sb.append( CNameField.getText().toString()+ "\n"); 
            sb.append( IVAFIeld.getText().toString()+ "\n"); 
            sb.append( PhoneField.getText().toString()+ "\n"); 
            sb.append( CPhoneField.getText().toString()+ "\n");
            sb.append( DescriptionArea.getText().toString()+ "\n");

            File file = new File ("C:\\Users\\user\\git\\Progetto-Lavoro\\CerqoLavoro\\src\\resources\\Data\\EmployerProfiles\\" + (EmailField.getText().toString()) + ".csv");
            FileWriter W = null;
          try {
            W = new FileWriter (file);
          } catch (IOException e) {
            e.printStackTrace();
          }
            try {
            W.write(sb.toString());
          } catch (IOException e) {
            e.printStackTrace();
          }
            try {
            W.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        
            try {
        		ViewDispatcher viewDispatcher = ViewDispatcher.getInstance();
        		viewDispatcher.openingView(stage);
        	} catch (ViewException e) {
        		e.printStackTrace();
        	}
        
      }
    }
    
    @FXML
    void Exit(ActionEvent event3)
    {
    	Platform.exit();
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
             
    }

}