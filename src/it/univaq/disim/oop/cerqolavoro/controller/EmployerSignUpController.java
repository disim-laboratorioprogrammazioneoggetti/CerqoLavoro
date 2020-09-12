package it.univaq.disim.oop.cerqolavoro.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileCerqoLavoroBusinessFactoryImpl;
import it.univaq.disim.oop.cerqolavoro.view.ViewDispatcher;
import it.univaq.disim.oop.cerqolavoro.view.ViewException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmployerSignUpController implements Initializable, DataInitializable<Object> {
  
    // Campi registrazione
    
    @FXML private TextField Namefield;
    @FXML private TextField Surnamefield;
    @FXML private TextField EmailField;
    @FXML private TextField CMailField;
    @FXML private PasswordField PasswordField;
    @FXML private TextField CNameField;
    @FXML private TextField IVAFIeld;
    @FXML private TextField PhoneField;
    @FXML private TextField CPhoneField;    
    @FXML private TextArea DescriptionArea;
    @FXML private Button empSUBack;
    @FXML private Button employerSUButton;
    @FXML private Label employerSUStatus;
    
    public Stage stage = new Stage();
    
    // Pulsante Torna al Login
    
    @FXML
    void employerGoToLoginButton(ActionEvent event) throws IOException {
        try {
    		ViewDispatcher viewDispatcher = ViewDispatcher.getInstance();
    		viewDispatcher.loginView(stage);
    	} catch (ViewException e) {
    		e.printStackTrace();
    	}
    }
    
    // Pulsante Registrazione Impiegato
    
    @FXML
    void employerSignUpButton(ActionEvent event2) throws IOException {
    	
      try {
    	  
        // Controllo campi
    
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
    	  employerSUStatus.setText("Si prega di compilare tutti i campi");
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

            File file = new File (FileCerqoLavoroBusinessFactoryImpl.EMPLOYER_FILE_DIRECTORY + (EmailField.getText().toString()) + ".csv");
            FileWriter W = null;
            W = new FileWriter (file);
            W.write(sb.toString());
            W.close();
            
            employerSUStatus.setText("Registrazione completata con successo");
      }
     } catch (IOException e) {
         e.printStackTrace();
     }
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
             
    }

}