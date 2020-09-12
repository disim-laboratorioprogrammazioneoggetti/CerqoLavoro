package it.univaq.disim.oop.cerqolavoro.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileCerqoLavoroBusinessFactoryImpl;
import it.univaq.disim.oop.cerqolavoro.domain.User;
import it.univaq.disim.oop.cerqolavoro.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddOfferController implements Initializable, DataInitializable<User> {

    @FXML private TextField MaxWageField;
    @FXML private ChoiceBox <String> ContractTypeChoice;
    @FXML private TextField MinWageField;
    @FXML private TextField PositionField;
    @FXML private TextArea WorkInfoArea;
    @FXML private Button AddOfferbtn;
    @FXML private TextField StudyTitleField;
    @FXML private ChoiceBox <String> WageTimeChoice;   
    @FXML private ChoiceBox <String> CategoryChoice;
    @FXML private ChoiceBox <String> ExpChoice;   
    @FXML private ChoiceBox <String> RegionChoice;
    @FXML private ChoiceBox <String> ContractTimeChoice;
    @FXML private TextField WageInfoField;
    @FXML private TextField TitleField;       
    @FXML private Label eadEmail;
    @FXML private Label addOfferStatus;
    
    private ViewDispatcher dispatcher;  
	private User user;
	
	@Override
	public void initializeData(User user) {
	      eadEmail.setText(user.getEmail());
	}
    
    // Bottone per creare annunci
	
    @FXML
    void AddOffer(ActionEvent event2) throws IOException {
    	
     try {
      
      // Controllo campi
    	
        boolean Addoffercheck = true;
      
        if(TitleField.getText().isEmpty()) { Addoffercheck = false; }
        if(PositionField.getText().isEmpty()) { Addoffercheck = false; }
        if(MinWageField.getText().isEmpty()) { Addoffercheck = false; }
        if(MaxWageField.getText().isEmpty()) { Addoffercheck = false; }
        if(ContractTypeChoice.getValue().equals("Seleziona")){ Addoffercheck = false; }
        if(ContractTimeChoice.getValue().equals("Seleziona")){ Addoffercheck = false; }
        if(WageTimeChoice.getValue().equals("Seleziona")){ Addoffercheck = false; }
        if(RegionChoice.getValue().equals("Seleziona")){ Addoffercheck = false; }
        if(CategoryChoice.getValue().equals("Seleziona")){ Addoffercheck = false; }
        if(ExpChoice.getValue().equals("Seleziona")){ Addoffercheck = false; }
        if(StudyTitleField.getText().isEmpty()) { Addoffercheck = false; }
        if(WorkInfoArea.getText().isEmpty()) { Addoffercheck = false; }
        
        if (Addoffercheck  == false) {
        	addOfferStatus.setText("Si prega di compilare tutti i campi");
        }
        
        // Scrittura annuncio su file
        
        File offerCheck = new File(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME);       
        if ( Addoffercheck == true ) {
            StringBuilder sb =  new StringBuilder();
            sb.append( RegionChoice.getValue().toString()+ "\n");
            sb.append( CategoryChoice.getValue().toString()+ "\n");
            sb.append( TitleField.getText().toString()+ "\n"); 
            sb.append( eadEmail.getText().toString()+ "\n"); 
            sb.append( PositionField.getText().toString()+ "\n");
            sb.append( ContractTypeChoice.getValue().toString()+ "\n");
            sb.append( ContractTimeChoice.getValue().toString()+ "\n");
            sb.append( MinWageField.getText().toString()+ "-");
            sb.append( MaxWageField.getText().toString()+ "\n");
            sb.append( ExpChoice.getValue().toString()+ "\n");
            sb.append( WageTimeChoice.getValue().toString()+ "\n");
            sb.append( WageInfoField.getText().toString()+ "\n");    
            sb.append( StudyTitleField.getText().toString()+ "\n");
            sb.append( WorkInfoArea.getText().toString()+ "\n");
            BufferedWriter bw = new BufferedWriter(new FileWriter(offerCheck, true));
            bw.append(sb);
            bw.close();
            
        	addOfferStatus.setText("Annuncio creato correttamente");            
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
        
        @Override
        public void initialize(URL Url, ResourceBundle resources) {
        	
        	eadEmail.setVisible(false);
               
            // Choicebox Tipo di Contratto
            ContractTypeChoice.getItems().addAll("Seleziona","Tempo indeterminato","Tempo determinato","In somministrazione","Lavoro a Chiamata",
                  "Lavoro a progetto","Lavoro accessorio","Lavoro in apprendistato","Tirocinio Formativo");
            ContractTypeChoice.setValue("Seleziona");
            
            // Choicebox Durata Contratto
            ContractTimeChoice.getItems().addAll("Seleziona","FullTime","Part-Time");
            ContractTimeChoice.setValue("Seleziona");
            
            // Choicebox Cadenza Retribuzione
            WageTimeChoice.getItems().addAll("Seleziona","Al giorno","Alla settimana","Al mese","All'anno");
            WageTimeChoice.setValue("Seleziona");
            
            // Choicebox Regione
            RegionChoice.getItems().addAll("Seleziona","Abruzzo","Basilicata","Calabria","Campania","Emilia-Romagna",
                  "Friuli-Venezia-Giulia","Lazio","Liguria","Lombardia","Marche","Molise","Piemonte","Puglia",
                  "Sardegna","Sicilia","Toscana","Trentino-Alto Adige","Umbria","Valle d'Aosta","Veneto");
            RegionChoice.setValue("Seleziona");
            
            // Choicebox Categoria
            CategoryChoice.getItems().addAll("Seleziona","Acquisti-Logica-Trasporti","Affari legali","Amministrazione-Segreteria","Architettura-Arti grafiche-Design","Assistenza Anziani",
                    "Commerciale","Commercio-Negozi","Contabilita'-Finanza","Direzione-Consulenza","Edilizia","Editoria-Giornalismo","Estetica-Cura della Persona","Formazione-Istruzione",
                    "Informatica-Telecomunicazioni","Ingegneria","Marketing-Comunicazione","Medicina-Salute","Produzione-Operai","Project Managment","Qualita'-Ambiente","Risorse Umane",
                    "Sicurezza-Vigilanza","Supporto al cliente","Turismo-Ristorazione","Altro");
              CategoryChoice.setValue("Seleziona");
            
            // Choicebox Esperienza
            ExpChoice.getItems().addAll("Seleziona","Meno di un Anno","Un anno","Due anni","Tre anni","Quattro anni","Cinque anni","Sei anni","Sette anni","Otto anni","Nove anni","Dieci anni","Piu' di Dieci Anni");
            ExpChoice.setValue("Seleziona");

        }

}