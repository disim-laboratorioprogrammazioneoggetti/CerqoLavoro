package it.univaq.disim.oop.cerqolavoro.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import it.univaq.disim.oop.cerqolavoro.domain.Experience;
import it.univaq.disim.oop.cerqolavoro.domain.Regions;
import it.univaq.disim.oop.cerqolavoro.domain.Sectors;
import it.univaq.disim.oop.cerqolavoro.domain.User;
import it.univaq.disim.oop.cerqolavoro.domain.Worker;
import it.univaq.disim.oop.cerqolavoro.view.ViewDispatcher;
import it.univaq.disim.oop.cerqolavoro.view.ViewException;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserSignUpController implements Initializable, DataInitializable<Object> {
  
    // Campi registrazione
    
    @FXML
    private TextField cityField;
    
    @FXML
    private TextField instructionField;
    
    @FXML
    private TextField nameField;

    @FXML
    private Label nameLabel;
    
    @FXML
    private TextField surnameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField numberField;

    @FXML
    private TextField provinceField;

    @FXML
    private ChoiceBox <Regions> regionChoice;

    @FXML
    private TextField capField;

    @FXML
    private DatePicker dateField;

    @FXML
    private PasswordField passwordField;
    
    @FXML
    private TextField addressField;
    
    @FXML
    private ChoiceBox <Sectors> sectorChoice;
    
    @FXML
    private ChoiceBox <Experience> ExpChoice;
    
    @FXML
    private TextArea descriptionArea;
    
    public Stage stage = new Stage();
    
    // Indietro premuto
    @FXML
    void usersignupBackopening(ActionEvent event) throws IOException
    { 		
      try {
		ViewDispatcher viewDispatcher = ViewDispatcher.getInstance();
		viewDispatcher.openingView(stage);
	} catch (ViewException e) {
		e.printStackTrace();
	}
    }
    // Registrazione 
    @FXML
    void userRegistration(ActionEvent event2) throws IOException
    {
        boolean signupcheck = true;
       
      if(nameField.getText().isEmpty()) { signupcheck = false; }
      if(surnameField.getText().isEmpty()) { signupcheck = false; }
      if(emailField.getText().isEmpty()) { signupcheck = false; }
      if(passwordField.getText().isEmpty()) { signupcheck = false; }
      if(ExpChoice.getValue().equals(Experience.Nessuna_Esperienza_Selezionata)){ signupcheck = false; }
      if(sectorChoice.getValue().equals(Sectors.Nessun_Settore_Selezionato)){ signupcheck = false; }
      if(regionChoice.getValue().equals(Regions.Nessuna_Regione_Selezionata)){ signupcheck = false; }
      if(numberField.getText().isEmpty()) { signupcheck = false; }
      if(provinceField.getText().isEmpty()) { signupcheck = false; }
      if(cityField.getText().isEmpty()) { signupcheck = false; }
      if(capField.getText().isEmpty()) { signupcheck = false; }
      if(addressField.getText().isEmpty()) { signupcheck = false; }
      
      if (signupcheck  == false) {
          Alert errorAlert = new Alert(AlertType.ERROR);
          errorAlert.setHeaderText("ERRORE");
          errorAlert.setContentText("Devi riempire i campi di Registrazione");
          errorAlert.showAndWait();
        }
      
      if(signupcheck == true) {
      
        // Crea file profilo utente
        
        StringBuilder sb =  new StringBuilder();
          sb.append( passwordField.getText().toString()+ "\n");  //0 no
          sb.append( nameField.getText().toString()+ "\n");      //1
          sb.append( surnameField.getText().toString()+ "\n");   //2
          sb.append( emailField.getText().toString()+ "\n");     //3 no
          sb.append( dateField.getValue().toString()+ "\n");     //4 no
          sb.append( ExpChoice.getValue().toString()+ "\n");     //5 
          sb.append( instructionField.getText().toString()+ "\n"); //6
          sb.append( numberField.getText().toString()+ "\n");      //7 no
          sb.append( regionChoice.getValue().toString()+ "\n");    //8
          sb.append( provinceField.getText().toString()+ "\n");    //9
          sb.append( cityField.getText().toString()+ "\n");        //10
          sb.append( capField.getText().toString()+ "\n");         //11 no
          sb.append( addressField.getText().toString()+ "\n");     //12 no
          sb.append( sectorChoice.getValue().toString()+ "\n");    //13 
          sb.append( descriptionArea.getText().toString()+ "\n");  //14

          File file = new File ("C:\\Users\\user\\git\\Progetto-Lavoro\\CerqoLavoro\\src\\resources\\Data\\UserProfiles\\" + (emailField.getText().toString()) + ".csv");
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
         
          Alert okregAlert = new Alert(AlertType.CONFIRMATION);
          okregAlert.setHeaderText("Registrazione completata");
          okregAlert.setContentText("Ora puoi fare il LogIn");
          okregAlert.showAndWait();
          
        } catch (IOException e) {
          e.printStackTrace();
        }
          
          File file1 = new File ("C:\\Users\\user\\git\\Progetto-Lavoro\\CerqoLavoro\\src\\resources\\Data\\UserProfiles\\profiles.txt");
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
      
        // Mostra Opening
        
          try {
      		ViewDispatcher viewDispatcher = ViewDispatcher.getInstance();
      		viewDispatcher.openingView(stage);
      	} catch (ViewException e) {
      		e.printStackTrace();
      	}

        } // non cancellare questa parentesi
/*      else {
            Parent MainViewParent = FXMLLoader.load(getClass().getResource("view/UserSignUp.fxml"));
            Scene MainViewScene = new Scene(MainViewParent);
            Stage window = (Stage)((Node)event2.getSource()).getScene().getWindow();           
            window.setScene(MainViewScene);
            window.setResizable(false);
            window.show();                               Inutili Cambi scena?  
      } */
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

          //regione choicebox        
          regionChoice.getItems().addAll(Regions.values());
          regionChoice.setValue(Regions.Nessuna_Regione_Selezionata);
          
          // Settore choicebox
          sectorChoice.getItems().addAll(Sectors.values());
          sectorChoice.setValue(Sectors.Nessun_Settore_Selezionato);
          
          //esperienza choicebox
          ExpChoice.getItems().addAll(Experience.values());
          ExpChoice.setValue(Experience.Nessuna_Esperienza_Selezionata);
    }

}