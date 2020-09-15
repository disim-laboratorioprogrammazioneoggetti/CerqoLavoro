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
    void luckyOff(ActionEvent event) throws IOException {
    	
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
        String listExperience[] = new String[4];
        String listRegion[] = new String[4];
        String listCategory[] = new String[4];
        String listTitle[] = new String[4];
        String listBio[] = new String[4];
        String listLocation[] = new String[4];
        String listStudy[] = new String[4];
        String listWage[] = new String[4];
        String listTypeContract[] = new String[4];
        String listPeriodContract[] = new String[4];
        String listBonus[] = new String[4];
        String listCadence[] = new String[4];
        String charset = "UTF-8";
        
        // Lettura informazioni utili ai fini della ricerca personalizzata        
    	BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME));
    	int lines = 0;
    	while (reader.readLine() != null) {
    		lines++;
    	}
    	reader.close();
    	int cont = lines / 13;
    	
    	// Ricerca nel file offerte    	
         BufferedReader read = new BufferedReader(
        	        new InputStreamReader(
        	            new FileInputStream(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME), charset));
         List<String> line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME), StandardCharsets.UTF_8);
         try {
        	 int i = 0, k = 0, j = 0, p = 1, q = 2, r = 4, s = 5, t = 6, u = 7, v = 8, w = 9, x = 10, y = 11, z = 12;
            	 while ( ( line != null ) && ( i < cont ) && ( k < 4 ) ) {
            		 if ( line.get(v).equals(esperienza) && line.get(p).equals(categoria) && line.get(y).equals(istruzione) ) {
            			 listRegion[i] = line.get(j);
                         listCategory[i] = line.get(p);
                         listTitle[i] = line.get(q);
                         listLocation[i] = line.get(r);
                         listTypeContract[i] = line.get(s);
                         listPeriodContract[i] = line.get(t);
                         listWage[i] = line.get(u);
                         listExperience[i] = line.get(v);
                         listCadence[i] = line.get(w);
                         listBonus[i] = line.get(x);
                         listStudy[i] = line.get(y);
                         listBio[i] = line.get(z);
                         k++;
                    	 }
            		 i++; j += 13; p += 13; q += 13; r += 13; s += 13; t += 13; u += 13; v += 13; w += 13; x += 13; y += 13; z += 13;
            		 }
            	      if ( k < 4 ) {
              		     for ( i = k; i < 4; i++ ) {
              		         risultato[i].setVisible(false);
              		     }
              		  }
                	 for ( i = 0; i < k ; i++ ) {
                		 risultato[i].setVisible(true);
                         adtitle[i].setText(listTitle[i]);
                         adregion[i].setText(listRegion[i]);
                         adlocation[i].setText(listLocation[i]); 
                         adcontract[i].setText(listTypeContract[i]); 
                         adperiod[i].setText(listPeriodContract[i]);
                         adwage[i].setText(listWage[i]);
                         adexperience[i].setText(listExperience[i]); 
                         adcadence[i].setText(listCadence[i]);
                         adbonus[i].setText(listBonus[i]); 
                         adstudy[i].setText(listStudy[i]); 
                         adbio[i].setText(listBio[i]); 
             	 }
             read.close();
     	} catch (FileNotFoundException ex) {
         ex.printStackTrace();
         } catch (IOException ex) {
         ex.printStackTrace();
         } 
    }
    
    // Ricerca offerta tramite filtri selezionati dall' utente
    
    @FXML
    void searchOffer(ActionEvent event) throws IOException {
        
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
        String listExperience[] = new String[4];
        String listRegion[] = new String[4];
        String listCategory[] = new String[4];
        String listTitle[] = new String[4];
        String listBio[] = new String[4];
        String listLocation[] = new String[4];
        String listStudy[] = new String[4];
        String listWage[] = new String[4];
        String listTypeContract[] = new String[4];
        String listPeriodContract[] = new String[4];
        String listBonus[] = new String[4];
        String listCadence[] = new String[4];
        int i = 0, k = 0, j = 0, p = 1, q = 2, r = 4, s = 5, t = 6, u = 7, v = 8, w = 9, x = 10, y = 11, z = 12; String charset = "UTF-8";
    	BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME));
    	int lines = 0;
    	while (reader.readLine() != null) {
    		lines++;
    	}
    	reader.close();
    	int cont = lines / 13;
         BufferedReader read = new BufferedReader(
        	        new InputStreamReader(
        	            new FileInputStream(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME), charset));
         List<String> line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME), StandardCharsets.UTF_8);
         
         // 4 possibili combinazioni di filtri (Regione / Settore)
         
         try {
        	 i = 0; k = 0; j = 0; p = 1; q = 2; r = 4; s = 5; t = 6; u = 7; v = 8; w = 9; x = 10; y = 11; z = 12;
             if( regionSrc.getValue().toString().equals("Tutte") && categorySrc.getValue().toString() != "Tutte" ) {
            	 while (( line != null ) && ( i < cont ) && (k < 4)) {
                	 if ( categorySrc.getValue().toString().equals(line.get(p)) ) {
                         listRegion[k] = line.get(j);
                         listCategory[k] = line.get(p);
                         listTitle[k] = line.get(q);
                         listLocation[k] = line.get(r);
                         listTypeContract[k] = line.get(s);
                         listPeriodContract[k] = line.get(t);
                         listWage[k] = line.get(u);
                         listExperience[k] = line.get(v);
                         listCadence[k] = line.get(w);
                         listBonus[k] = line.get(x);
                         listStudy[k] = line.get(y);
                         listBio[k] = line.get(z);
                         k++;
                    	 }
                         i++; j += 13; p += 13; q += 13; r += 13; s += 13; t += 13; u += 13; v += 13; w += 13; x += 13; y += 13; z += 13;
            		 }
             }
             if ( regionSrc.getValue().toString().equals("Tutte") && categorySrc.getValue().toString().equals("Tutte")) {
            	 while (( line != null ) && ( i < cont ) && (k < 4)) {
                     listRegion[k] = line.get(j);
                     listCategory[k] = line.get(p);
                     listTitle[k] = line.get(q);
                     listLocation[k] = line.get(r);
                     listTypeContract[k] = line.get(s);
                     listPeriodContract[k] = line.get(t);
                     listWage[k] = line.get(u);
                     listExperience[k] = line.get(v);
                     listCadence[k] = line.get(w);
                     listBonus[k] = line.get(x);
                     listStudy[k] = line.get(y);
                     listBio[k] = line.get(z);
                     i++; k++; j += 13; p += 13; q += 13; r += 13; s += 13; t += 13; u += 13; v += 13; w += 13; x += 13; y += 13; z += 13;
        		 }
          }
             if ( regionSrc.getValue().toString() != "Tutte" && categorySrc.getValue().toString().equals("Tutte") ) {
            	 while (( line != null ) && ( i < cont ) && (k < 4)) {
                	 if ( regionSrc.getValue().toString().equals( line.get(j)) ) {
                         listRegion[k] = line.get(j);
                         listCategory[k] = line.get(p);
                         listTitle[k] = line.get(q);
                         listLocation[k] = line.get(r);
                         listTypeContract[k] = line.get(s);
                         listPeriodContract[k] = line.get(t);
                         listWage[k] = line.get(u);
                         listExperience[k] = line.get(v);
                         listCadence[k] = line.get(w);
                         listBonus[k] = line.get(x);
                         listStudy[k] = line.get(y);
                         listBio[k] = line.get(z);
                         k++;
                	 }
                	 i++; j += 13; p += 13; q += 13; r += 13; s += 13; t += 13; u += 13; v += 13; w += 13; x += 13; y += 13; z += 13;
        		 }
             }
             if ( regionSrc.getValue().toString() != "Tutte" && categorySrc.getValue().toString() != "Tutte" ) {
            	 while (( line != null ) && ( i < cont ) && (k < 4)) {
                	 if ( regionSrc.getValue().toString().equals( line.get(j)) && categorySrc.getValue().toString().equals( line.get(p) )) {
                         listRegion[k] = line.get(j);
                         listCategory[k] = line.get(p);
                         listTitle[k] = line.get(q);
                         listLocation[k] = line.get(r);
                         listTypeContract[k] = line.get(s);
                         listPeriodContract[k] = line.get(t);
                         listWage[k] = line.get(u);
                         listExperience[k] = line.get(v);
                         listCadence[k] = line.get(w);
                         listBonus[k] = line.get(x);
                         listStudy[k] = line.get(y);
                         listBio[k] = line.get(z);
                         k++;
                	 }
                	 i++; j += 13; p += 13; q += 13; r += 13; s += 13; t += 13; u += 13; v += 13; w += 13; x += 13; y += 13; z += 13;
                	 }
             }
         	  if ( k < 4 ) {
           		  for ( i = k; i < 4; i++ ) {
           		    risultato[i].setVisible(false);
           		  }
           		  }
        	 for ( i = 0; i < k ; i++ ) {
         	  	 risultato[i].setVisible(true);
                 adtitle[i].setText(listTitle[i]);
                 adregion[i].setText(listRegion[i]);
                 adlocation[i].setText(listLocation[i]); 
                 adcontract[i].setText(listTypeContract[i]); 
                 adperiod[i].setText(listPeriodContract[i]);
                 adwage[i].setText(listWage[i]);
                 adexperience[i].setText(listExperience[i]); 
                 adcadence[i].setText(listCadence[i]);
                 adbonus[i].setText(listBonus[i]); 
                 adstudy[i].setText(listStudy[i]); 
                 adbio[i].setText(listBio[i]); 
                 } 
          	  read.close();
    	} catch (FileNotFoundException ex) {
        ex.printStackTrace();
        } catch (IOException ex) {
        ex.printStackTrace();
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
