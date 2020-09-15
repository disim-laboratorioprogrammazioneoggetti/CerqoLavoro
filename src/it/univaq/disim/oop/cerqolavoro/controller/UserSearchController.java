package it.univaq.disim.oop.cerqolavoro.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import org.controlsfx.control.SearchableComboBox;
import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.business.CandidacyService;
import it.univaq.disim.oop.cerqolavoro.business.CerqoLavoroBusinessFactory;
import it.univaq.disim.oop.cerqolavoro.business.OfferService;
import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileCerqoLavoroBusinessFactoryImpl;
import it.univaq.disim.oop.cerqolavoro.business.impl.ram.RAMCandidacyServiceImpl;
import it.univaq.disim.oop.cerqolavoro.business.impl.ram.RAMOfferServiceImpl;
import it.univaq.disim.oop.cerqolavoro.domain.Candidacy;
import it.univaq.disim.oop.cerqolavoro.domain.Offer;
import it.univaq.disim.oop.cerqolavoro.domain.User;
import it.univaq.disim.oop.cerqolavoro.domain.Worker;
import it.univaq.disim.oop.cerqolavoro.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserSearchController implements Initializable, DataInitializable<User> {
    
	@FXML private Pane annuncio2;
    @FXML private Button subann2;
    @FXML private Label regann2;
    @FXML private Label ann2;
    @FXML private TextArea annBio2;
    @FXML private Label posann2;
    @FXML private Label eduann2;
    @FXML private Label wageann2;
    @FXML private Label ctypeann2;
    @FXML private Label ctimeann2;
    @FXML private Label wgtimeann2;
    @FXML private Label bonusann2;
    @FXML private Label expann2;
    @FXML private Pane annuncio3;
    @FXML private Label ann3;
    @FXML private Label regann3;
    @FXML private TextArea annBio3;
    @FXML private Button subann3;
    @FXML private Label posann3;
    @FXML private Label eduann3;
    @FXML private Label wageann3;
    @FXML private Label ctypeann3;
    @FXML private Label ctimeann3;
    @FXML private Label wgtimeann3;
    @FXML private Label bonusann3;
    @FXML private Label expann3;
    @FXML private Pane annuncio4;
    @FXML private TextArea annBio4;
    @FXML private Button subann4;
    @FXML private Label ann4;
    @FXML private Label regann4;
    @FXML private Label posann4;
    @FXML private Label eduann4;
    @FXML private Label wageann4;
    @FXML private Label ctypeann4;
    @FXML private Label ctimeann4;
    @FXML private Label wgtimeann4;
    @FXML private Label bonusann4;
    @FXML private Label expann4;
    @FXML private Label usEmail;
    @FXML private SearchableComboBox<String> categorySrc;
    @FXML private SearchableComboBox<String> regionSrc;
    @FXML private Button srcOffer;
    @FXML private Pane annuncio1;
    @FXML private Label ann1;
    @FXML private Button subann1;
    @FXML private Label regann1;
    @FXML private Label posann1;
    @FXML private Label eduann1;
    @FXML private Label ctypeann1;
    @FXML private Label ctimeann1;
    @FXML private Label wageann1;
    @FXML private Label wgtimeann1;
    @FXML private TextArea annBio1;
    @FXML private Label bonusann1;
    @FXML private Label expann1;
    @FXML private Button luckyOffers;
    
    public Stage stage = new Stage();  
    private ViewDispatcher dispatcher;   
	private User user;	
	private Worker worker;
	private CandidacyService candidacyService;
	private OfferService offerService;
	private Candidacy candidacy;
	private Offer offer;
	private String esperienza;
	private String istruzione;
	private String categoria;
	
	public UserSearchController() {
		dispatcher = ViewDispatcher.getInstance();
		candidacyService = new RAMCandidacyServiceImpl(candidacyService);
		offerService = new RAMOfferServiceImpl(offerService);
		CerqoLavoroBusinessFactory factory = CerqoLavoroBusinessFactory.getInstance();
		candidacyService = factory.getCandidacyService();
		offerService = factory.getOfferService();
	}
	
	@Override
	public void initializeData(User user) {
	      usEmail.setText(user.getEmail());
	      this.esperienza = ((Worker) user).getExperience();
	      this.istruzione = ((Worker) user).getEducation();
	      this.categoria = ((Worker) user).getSector();
	}
	
	// Ricerca offerte attinenti
    
    @FXML
    void luckyOff(ActionEvent event) throws IOException, BusinessException {
    	
    	Pane risultato[] = { annuncio1, annuncio2, annuncio3, annuncio4 };
        Label adtitle[] = { ann1, ann2, ann3, ann4 };
        Label adregion[] = { regann1, regann2, regann3, regann4 };
        TextArea adbio[] = { annBio1, annBio2, annBio3, annBio4 };
        Label adlocation[] = { posann1, posann2, posann3, posann4 };
        Label adstudy[] = { eduann1, eduann2, eduann3, eduann4 };
        Label adwage[] = { wageann1, wageann2, wageann3, wageann4 };
        Label adcontract[] = { ctypeann1, ctypeann2, ctypeann3, ctypeann4 };
        Label adperiod[] = { ctimeann1, ctimeann2, ctimeann3, ctimeann4 };
        Label adcadence[] = { wgtimeann1, wgtimeann2, wgtimeann3, wgtimeann4 };
        Label adexperience[] = { expann1, expann2, expann3, expann4 };
        Label adbonus[] = { bonusann1, bonusann2, bonusann3, bonusann4 };
        
        // Lettura informazioni utili ai fini della ricerca personalizzata 
        try {
        	int i = 0;
        	List<Offer> luckyOfferList = offerService.findLuckyOffers(esperienza, categoria, istruzione);
            	      if ( luckyOfferList.size() < 4 ) {
              		     for ( i = luckyOfferList.size(); i < 4; i++ ) {
              		         risultato[i].setVisible(false);
              		     }
              		  }
            	      i = 0;
            	      for (Offer lo: luckyOfferList) {
                		 risultato[i].setVisible(true);              		 
                		 adtitle[i].setText(lo.getTitle());
                		 adlocation[i].setText(lo.getPosition());
            		     adregion[i].setText(lo.getRegion());
            		     adcontract[i].setText(lo.getContractType()); 
            		     adperiod[i].setText(lo.getContractTime());
            		     adwage[i].setText(lo.getWage());
            		     adcadence[i].setText(lo.getWageTime());
            		     adstudy[i].setText(lo.getEducation());
            		     adbonus[i].setText(lo.getBonus());
            		     adbio[i].setText(lo.getInfo());
            		     adexperience[i].setText(lo.getExperience());  
            		     i++;
             	 }
     	} catch (BusinessException e) {
            e.printStackTrace();
            throw new BusinessException(e);
        } 
    }
    
    // Ricerca offerta tramite filtri selezionati dall' utente
    
    @FXML
    void searchOffer(ActionEvent event) throws IOException, BusinessException {
        
    	Pane risultato[] = { annuncio1, annuncio2, annuncio3, annuncio4 };
        Label adtitle[] = { ann1, ann2, ann3, ann4 };
        Label adregion[] = { regann1, regann2, regann3, regann4 };
        TextArea adbio[] = { annBio1, annBio2, annBio3, annBio4 };
        Label adlocation[] = { posann1, posann2, posann3, posann4 };
        Label adstudy[] = { eduann1, eduann2, eduann3, eduann4 };
        Label adwage[] = { wageann1, wageann2, wageann3, wageann4 };
        Label adcontract[] = { ctypeann1, ctypeann2, ctypeann3, ctypeann4 };
        Label adperiod[] = { ctimeann1, ctimeann2, ctimeann3, ctimeann4 };
        Label adcadence[] = { wgtimeann1, wgtimeann2, wgtimeann3, wgtimeann4 };
        Label adexperience[] = { expann1, expann2, expann3, expann4 };
        Label adbonus[] = { bonusann1, bonusann2, bonusann3, bonusann4 };
        // 4 possibili combinazioni di filtri (Regione / Settore)
        try {
        int i = 0;
        List<Offer> allOfferList = offerService.findAllOffers(regionSrc.getValue().toString(), categorySrc.getValue().toString());
         	  if ( allOfferList.size() < 4 ) {
           		  for ( i = allOfferList.size(); i < 4; i++ ) {
           		    risultato[i].setVisible(false);
           		  }
           	  }
         	  i = 0;
        	  for ( Offer all: allOfferList ) {
         		 risultato[i].setVisible(true);              		 
         		 adtitle[i].setText(all.getTitle());
         		 adlocation[i].setText(all.getPosition());
     		     adregion[i].setText(all.getRegion());
     		     adcontract[i].setText(all.getContractType()); 
     		     adperiod[i].setText(all.getContractTime());
     		     adwage[i].setText(all.getWage());
     		     adcadence[i].setText(all.getWageTime());
     		     adstudy[i].setText(all.getEducation());
     		     adbonus[i].setText(all.getBonus());
     		     adbio[i].setText(all.getInfo());
     		     adexperience[i].setText(all.getExperience());  
                 i++;
               } 
    	} catch (BusinessException e) {
            e.printStackTrace();
            throw new BusinessException(e);
        } 
    } 
    
    // Pulsanti candidatura offerte

    @FXML
    void candidati1(ActionEvent event) throws IOException {
    	try {
    		candidacyService.createCandidacy(usEmail.getText().toString(), ann1.getText().toString());
        	annuncio1.setVisible(false);
		} catch (BusinessException e) {
			e.getCause().printStackTrace();
			dispatcher.renderError(e);
		}
    }


    @FXML
    void candidati2(ActionEvent event) throws IOException {
    	try {
    		candidacyService.createCandidacy(usEmail.getText().toString(), ann2.getText().toString());
        	annuncio2.setVisible(false);
		} catch (BusinessException e) {
			e.getCause().printStackTrace();
			dispatcher.renderError(e);
		}
    }

    @FXML
    void candidati3(ActionEvent event) throws IOException {
    	try {
    		candidacyService.createCandidacy(usEmail.getText().toString(), ann3.getText().toString());
        	annuncio3.setVisible(false);
		} catch (BusinessException e) {
			e.getCause().printStackTrace();
			dispatcher.renderError(e);
		}
    }

    @FXML
    void candidati4(ActionEvent event) throws IOException {
    	try {
    		candidacyService.createCandidacy(usEmail.getText().toString(), ann4.getText().toString());
        	annuncio4.setVisible(false);
		} catch (BusinessException e) {
			e.getCause().printStackTrace();
			dispatcher.renderError(e);
		}
    }
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {   
    	
        // Pane non visibili finché non si cerca
    	
    	annuncio1.setVisible(false);
        annuncio2.setVisible(false);
        annuncio3.setVisible(false);
        annuncio4.setVisible(false);        
        
        // Descrizioni annuncio non editabili
        
        annBio1.setEditable(false);
        annBio2.setEditable(false);
        annBio3.setEditable(false);
        annBio4.setEditable(false);        
        usEmail.setVisible(false);

    	assert regionSrc != null : "fx:id=\"regionSrc\" was not injected: check your FXML file 'UserSearch.fxml'.";
    	assert categorySrc != null : "fx:id=\"categorySrc\" was not injected: check your FXML file 'UserSearch.fxml'.";
    	
        regionSrc.getItems().addAll("Tutte","Abruzzo","Basilicata","Calabria","Campania","Emilia-Romagna",
          		"Friuli-Venezia-Giulia","Lazio","Liguria","Lombardia","Marche","Molise","Piemonte","Puglia",
          		"Sardegna","Sicilia","Toscana","Trentino-Alto Adige","Umbria","Valle d'Aosta","Veneto");
        regionSrc.setValue("Tutte");
        
        categorySrc.getItems().addAll("Tutte","Acquisti-Logica-Trasporti","Affari legali","Amministrazione-Segreteria","Architettura-Arti grafiche-Design","Assistenza Anziani",
                "Commerciale","Commercio-Negozi","Contabilita'-Finanza","Direzione-Consulenza","Edilizia","Editoria-Giornalismo","Estetica-Cura della Persona","Formazione-Istruzione",
                "Informatica-Telecomunicazioni","Ingegneria","Marketing-Comunicazione","Medicina-Salute","Produzione-Operai","Project Managment","Qualita'-Ambiente","Risorse Umane",
                "Sicurezza-Vigilanza","Supporto al cliente","Turismo-Ristorazione","Altro");
        categorySrc.setValue("Tutte");
    	
    };
}
