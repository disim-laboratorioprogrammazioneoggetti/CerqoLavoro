package it.univaq.disim.oop.cerqolavoro.controller;

import java.io.BufferedWriter;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserSignUpController implements Initializable, DataInitializable<Object> {
  
    // Campi registrazione
    
    @FXML private TextField cityField;    
    @FXML private TextField instructionField;    
    @FXML private TextField nameField;
    @FXML private Label nameLabel;    
    @FXML private TextField surnameField;
    @FXML private TextField emailField;
    @FXML private TextField numberField;
    @FXML private TextField provinceField;
    @FXML private ChoiceBox <String> regionChoice;
    @FXML private TextField capField;
    @FXML private DatePicker dateField;
    @FXML private PasswordField passwordField;    
    @FXML private TextField addressField;    
    @FXML private ChoiceBox <String> sectorChoice;    
    @FXML private ChoiceBox <String> ExpChoice;    
    @FXML private TextArea descriptionArea;
    @FXML private Button usExitButton;
    @FXML private Button workerSUButton;
    @FXML private Label workerSUStatus;
    
    public Stage stage = new Stage();
    
    // Pulsante Torna al Login
    
    @FXML
    void exitButtonAction(ActionEvent event) { 		
      	Stage stage = (Stage) usExitButton.getScene().getWindow();
        stage.close();
    }
    
    // Pulsante Registrazione Impiegato
    
    @FXML
    void workerSignUpButton(ActionEvent event2) throws IOException {
    	
     try {
    	 
        // Controllo campi
    	 
        boolean signupcheck = true;
       
      if(nameField.getText().isEmpty()) { signupcheck = false; }
      if(surnameField.getText().isEmpty()) { signupcheck = false; }
      if(emailField.getText().isEmpty()) { signupcheck = false; }
      if(passwordField.getText().isEmpty()) { signupcheck = false; }
      if(ExpChoice.getValue().equals("Scegli Esperienza")){ signupcheck = false; }
      if(sectorChoice.getValue().equals("Scegli Settore")){ signupcheck = false; }
      if(regionChoice.getValue().equals("Scegli Regione")){ signupcheck = false; }
      if(numberField.getText().isEmpty()) { signupcheck = false; }
      if(provinceField.getText().isEmpty()) { signupcheck = false; }
      if(cityField.getText().isEmpty()) { signupcheck = false; }
      if(capField.getText().isEmpty()) { signupcheck = false; }
      if(addressField.getText().isEmpty()) { signupcheck = false; }
      if(descriptionArea.getText().isEmpty()) { signupcheck = false; }
      
      if (signupcheck  == false) {
    	  workerSUStatus.setText("Si prega di compilare tutti i campi");
        }
      
      if(signupcheck == true) {
      
        // Crea file Profilo Utente  
    	  
          StringBuilder sb =  new StringBuilder();
          sb.append( passwordField.getText().toString()+ "\n");   
          sb.append( nameField.getText().toString()+ "\n");       
          sb.append( surnameField.getText().toString()+ "\n");     
          sb.append( emailField.getText().toString()+ "\n");       
          sb.append( dateField.getValue().toString()+ "\n");       
          sb.append( ExpChoice.getValue().toString()+ "\n");        
          sb.append( instructionField.getText().toString()+ "\n"); 
          sb.append( numberField.getText().toString()+ "\n");      
          sb.append( regionChoice.getValue().toString()+ "\n");    
          sb.append( provinceField.getText().toString()+ "\n");    
          sb.append( cityField.getText().toString()+ "\n");        
          sb.append( capField.getText().toString()+ "\n");         
          sb.append( addressField.getText().toString()+ "\n");     
          sb.append( sectorChoice.getValue().toString()+ "\n");    
          sb.append( descriptionArea.getText().toString()+ "\n");  

          File file = new File (FileCerqoLavoroBusinessFactoryImpl.WORKER_FILE_DIRECTORY + (emailField.getText().toString()) + ".csv");
          if (file.exists()) {
        	  workerSUStatus.setText("L'indirizzo email è già in uso");
          }
          if (!file.exists()) {
          FileWriter W = null;
          W = new FileWriter (file);
          W.write(sb.toString());
          W.close();
          
          File file1 = new File (FileCerqoLavoroBusinessFactoryImpl.USER_FILE_NAME);
          BufferedWriter bw = new BufferedWriter(new FileWriter(file1, true));
          bw.append( nameField.getText().toString()+ "\n");     
          bw.append( surnameField.getText().toString()+ "\n");   
          bw.append( emailField.getText().toString()+ "\n");     
          bw.append( ExpChoice.getValue().toString()+ "\n");     
          bw.append( instructionField.getText().toString()+ "\n");      
          bw.append( regionChoice.getValue().toString()+ "\n");   
          bw.append( provinceField.getText().toString()+ "\n");   
          bw.append( cityField.getText().toString()+ "\n");                  
          bw.append( sectorChoice.getValue().toString()+ "\n");    
          bw.append( descriptionArea.getText().toString()+ "\n");
          bw.close();
          
    	  workerSUStatus.setText("Registrazione completata con successo");
          }  
         }
        } catch (IOException e) {
          e.printStackTrace();
        }
   
        /*
          try {
      		ViewDispatcher viewDispatcher = ViewDispatcher.getInstance();
      		viewDispatcher.openingView(stage);
      	} catch (ViewException e) {
      		e.printStackTrace();
      	} */
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

            // Choicebox Regione       
            regionChoice.getItems().addAll("Scegli Regione","Abruzzo","Basilicata","Calabria","Campania","Emilia-Romagna",
            "Friuli-Venezia Giulia","Lazio","Liguria","Lombardia","Marche","Molise","Piemonte","Puglia",
            "Sardegna","Sicilia","Toscana","Trentino-Alto Adige","Umbria","Valle d'Aosta","Veneto");
            regionChoice.setValue("Scegli Regione");
                     
            // Choicebox Settore
            sectorChoice.getItems().addAll("Scegli Settore","Acquisti-Logica-Trasporti","Affari legali","Amministrazione-Segreteria","Architettura-Arti grafiche-Design","Assistenza Anziani",
            "Commerciale","Commercio-Negozi","Contabilita'-Finanza","Direzione-Consulenza","Edilizia","Editoria-Giornalismo","Estetica-Cura della Persona","Formazione-Istruzione",
            "Informatica-Telecomunicazioni","Ingegneria","Marketing-Comunicazione","Medicina-Salute","Produzione-Operai","Project Management","Qualita'-Ambiente","Risorse Umane",
            "Sicurezza-Vigilanza","Supporto al cliente","Turismo-Ristorazione","Altro");
            sectorChoice.setValue("Scegli Settore");
            
            // Choicebox Esperienza
            ExpChoice.getItems().addAll("Scegli Esperienza","Meno di un Anno","Un anno","Due anni","Tre anni","Quattro anni","Cinque anni","Sei anni","Sette anni","Otto anni","Nove anni","Dieci anni","Piu' di Dieci Anni");
            ExpChoice.setValue("Scegli Esperienza");
            
    };
            
            /*
            workerSUButton.disableProperty().bind(
            		(nameField.getText().isEmpty()
            		.and(surnameField.getText().isEmpty())
            		.and(passwordField.getText().isEmpty())));
            assert workerSUButton != null; 
    } */

}