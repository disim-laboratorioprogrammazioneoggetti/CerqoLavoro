package it.univaq.disim.oop.cerqolavoro.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
import it.univaq.disim.oop.cerqolavoro.business.MessageService;
import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileCerqoLavoroBusinessFactoryImpl;
import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileMessageServiceImpl;
import it.univaq.disim.oop.cerqolavoro.business.impl.ram.RAMMessageServiceImpl;
import it.univaq.disim.oop.cerqolavoro.business.impl.ram.RAMUserServiceImpl;
import it.univaq.disim.oop.cerqolavoro.domain.Candidacy;
import it.univaq.disim.oop.cerqolavoro.domain.Message;
import it.univaq.disim.oop.cerqolavoro.domain.User;
import it.univaq.disim.oop.cerqolavoro.domain.Worker;
import it.univaq.disim.oop.cerqolavoro.view.ViewDispatcher;
import it.univaq.disim.oop.cerqolavoro.view.ViewException;

public class EmployerSearchController implements Initializable, DataInitializable<User> {
    
    @FXML
    private SearchableComboBox<String> SectorSrc;
    @FXML
    private SearchableComboBox<String> regionSrc;
    @FXML
    private Button srcImp;
    @FXML
    private Pane annuncio1;
    @FXML
    private Label ImpName;
    @FXML
    private Button Contactbtn;
    @FXML
    private Label ImpSurN;
    @FXML
    private Label ImpExp;
    @FXML
    private Label ImpInstr;
    @FXML
    private Label ImpRegion;
    @FXML
    private Label ImpCity;
    @FXML
    private Label ImpProv;
    @FXML
    private Label ImpSec;
    @FXML
    private TextArea ImpDesc;
    @FXML
    private Label mailUser1;
    @FXML
    private TextArea mex1;
    @FXML
    private Pane annuncio11;
    @FXML
    private Label ImpName1;
    @FXML
    private Button Contactbtn1;
    @FXML
    private Label ImpSurN1;
    @FXML
    private Label ImpExp1;
    @FXML
    private Label ImpInstr1;
    @FXML
    private Label ImpRegion1;
    @FXML
    private Label ImpCity1;
    @FXML
    private Label ImpProv1;
    @FXML
    private Label ImpSec1;
    @FXML
    private TextArea ImpDesc1;
    @FXML
    private Label mailUser2;
    @FXML
    private TextArea mex2;
    @FXML
    private Pane annuncio12;
    @FXML
    private Label ImpName2;
    @FXML
    private Button Contactbtn2;
    @FXML
    private Label ImpSurN2;
    @FXML
    private Label ImpExp2;
    @FXML
    private Label ImpInstr2;
    @FXML
    private Label ImpRegion2;
    @FXML
    private Label ImpCity2;
    @FXML
    private Label ImpProv2;
    @FXML
    private Label ImpSec2;
    @FXML
    private TextArea ImpDesc2;
    @FXML
    private Label mailUser3;
    @FXML
    private TextArea mex3;
    @FXML
    private Pane annuncio13;
    @FXML
    private Label ImpName3;
    @FXML
    private Button Contactbtn3;
    @FXML
    private Label ImpSurN3;
    @FXML
    private Label ImpExp3;
    @FXML
    private Label ImpInstr3;
    @FXML
    private Label ImpRegion3;
    @FXML
    private Label ImpCity3;
    @FXML
    private Label ImpProv3;
    @FXML
    private Label ImpSec3;
    @FXML
    private TextArea ImpDesc3;
    @FXML
    private Label mailUser4;
    @FXML
    private TextArea mex4;
    @FXML
    private Pane annuncio14;
    @FXML
    private Label ImpName4;
    @FXML
    private Button Contactbtn4;
    @FXML
    private Label ImpSurN4;
    @FXML
    private Label ImpExp4;
    @FXML
    private Label ImpInstr4;
    @FXML
    private Label ImpRegion4;
    @FXML
    private Label ImpCity4;
    @FXML
    private Label ImpProv4;
    @FXML
    private Label ImpSec4;
    @FXML
    private TextArea ImpDesc4;
    @FXML
    private Label mailUser5;
    @FXML
    private TextArea mex5;
    @FXML
    private Pane annuncio15;
    @FXML
    private Label ImpName5;
    @FXML
    private Button Contactbtn5;
    @FXML
    private Label ImpSurN5;
    @FXML
    private Label ImpExp5;
    @FXML
    private Label ImpInstr5;
    @FXML
    private Label ImpRegion5;
    @FXML
    private Label ImpCity5;
    @FXML
    private Label ImpProv5;
    @FXML
    private Label ImpSec5;
    @FXML
    private TextArea ImpDesc5;
    @FXML
    private Label mailUser6;
    @FXML
    private TextArea mex6;
    @FXML
    private Label esEmail;
    
	public Stage stage = new Stage();
    private ViewDispatcher dispatcher;  
	private User user;
	
	private MessageService messageService;
	private Message message;
	
	public EmployerSearchController() {
		dispatcher = ViewDispatcher.getInstance();
		messageService = new RAMMessageServiceImpl(messageService);
		CerqoLavoroBusinessFactory factory = CerqoLavoroBusinessFactory.getInstance();
		messageService = factory.getMessageService();
		this.messageService = messageService;
	}
	
	@Override
	public void initializeData(User user) {
	      esEmail.setText(user.getEmail());
	}

    @FXML
    void Contact1(ActionEvent event) throws IOException  {
    	try {
    		Message message = messageService.createMessages( mailUser1.getText().toString(), mex1.getText().toString() );
    	} catch (BusinessException e) {
			dispatcher.renderError(e);
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Attenzione!");
            errorAlert.setContentText("Voccape");
            errorAlert.showAndWait();
    	}  
    }
    	   
    @FXML
    void Contact2(ActionEvent event) throws IOException  {
    	try {
    	if(!mex2.getText().isEmpty()) {
    		Message message = messageService.createMessages( mailUser2.getText().toString(), mex2.getText().toString() );
    	}   	
    	} catch (BusinessException e) {
			dispatcher.renderError(e);
    	}
    }
    
    @FXML
    void Contact3(ActionEvent event) throws IOException  {
    	try {
    	if(!mex1.getText().isEmpty()) {
    		Message message = messageService.createMessages( mailUser3.getText().toString(), mex1.getText().toString() );
    	}   	
    	} catch (BusinessException e) {
			dispatcher.renderError(e);
    	}
    }
    
    @FXML
    void Contact4(ActionEvent event) throws IOException  {
    	try {
    	if(!mex1.getText().isEmpty()) {
    		Message message = messageService.createMessages( mailUser4.getText().toString(), mex1.getText().toString() );
    	}   	
    	} catch (BusinessException e) {
			dispatcher.renderError(e);
    	}
    }
    
    @FXML
    void Contact5(ActionEvent event) throws IOException  {
    	try {
    	if(!mex1.getText().isEmpty()) {
    		Message message = messageService.createMessages( mailUser5.getText().toString(), mex1.getText().toString() );
    	}   	
    	} catch (BusinessException e) {
			dispatcher.renderError(e);
    	}
    }
    
    @FXML
    void Contact6(ActionEvent event) throws IOException  {
    	try {
    	if(!mex1.getText().isEmpty()) {
    		Message message = messageService.createMessages( mailUser6.getText().toString(), mex1.getText().toString() );
    	}   	
    	} catch (BusinessException e) {
			dispatcher.renderError(e);
    	}
    }
    

    @FXML
    void searchImp(ActionEvent event) throws IOException {

    	Pane risultato[] = { annuncio1, annuncio11, annuncio12, annuncio13, annuncio14, annuncio15 };
        Label adname[] = { ImpName, ImpName1,ImpName2,ImpName3, ImpName4,ImpName5 };
        Label surname[] = { ImpSurN, ImpSurN1,ImpSurN2, ImpSurN3, ImpSurN4, ImpSurN5 };
        Label Umail[] = {mailUser1,mailUser2,mailUser3,mailUser4,mailUser5,mailUser6};
        Label adregion[] = { ImpRegion, ImpRegion1, ImpRegion2, ImpRegion3, ImpRegion4, ImpRegion5 };       
        Label adlocation[] = { ImpCity, ImpCity1, ImpCity2, ImpCity3, ImpCity4,ImpCity5 };
        Label adstudy[] = { ImpInstr, ImpInstr1, ImpInstr2, ImpInstr3,ImpInstr4,ImpInstr5 };
        Label adprov[] = { ImpProv, ImpProv1, ImpProv2, ImpProv3, ImpProv4, ImpProv5 };
        Label adsec[] = { ImpSec, ImpSec1, ImpSec2, ImpSec3, ImpSec4, ImpSec5 };
        Label adexp[] = { ImpExp, ImpExp1, ImpExp2, ImpExp3, ImpExp4, ImpExp5 };
        TextArea adbio[] = { ImpDesc, ImpDesc1, ImpDesc2, ImpDesc3, ImpDesc4, ImpDesc5 };        
        String listName[] = new String[6];
        String listSurname[] = new String[6];
        String listEmail[] = new String[6];
        String listExp[] = new String[6];
        String listStudy[] = new String[6];
        String listRegion[] = new String[6];
        String listProvince[] = new String[6];
        String listLocation[] = new String[6];
        String listCategory[] = new String[6];
        String listBio[] = new String[6];        
        
        int i = 0, k = 0, j = 0, p = 1, q = 2, r = 4, s = 5, t = 6, u = 9, v = 10, w = 11, x = 12; String charset = "UTF-8";
    	BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.USER_FILE_NAME));
    	int lines = 0;
    	while (reader.readLine() != null) {
    		lines++; }
    	reader.close();
    	int cont = lines / 10;
         BufferedReader read = new BufferedReader(
        	        new InputStreamReader(
        	            new FileInputStream(FileCerqoLavoroBusinessFactoryImpl.USER_FILE_NAME), charset));
         List<String> line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.USER_FILE_NAME), StandardCharsets.UTF_8);         
         try {
             i = 0; k = 0; j = 0; p = 1; q = 2; r = 3; s = 4; t = 5; u = 6; v = 7; w = 8; x = 9;
            	 while (( line != null ) && ( i < cont )) {
            	 if ( regionSrc.getValue().toString().equals( line.get(t)) && SectorSrc.getValue().toString().equals( line.get(w)) ) {              
                 listName[i] = line.get(j); 
                 listSurname[i] = line.get(p); 
                 listExp[i] = line.get(r);
                 listEmail[i] = line.get(q);
                 listStudy[i] = line.get(s);
                 listRegion[i] = line.get(t);
                 listProvince[i] = line.get(u);
                 listLocation[i] = line.get(v);
                 listCategory[i] = line.get(w);
                 listBio[i] = line.get(x);
                 k++;                
            	 }
                 i++; j += 10; p += 10; q += 10; r += 10; s += 10; t += 10; u += 10; v += 10; w += 10; x += 10;
    		 }
       	      if ( k < 6 ) {
       		     for ( i = k; i < 6; i++ ) {
       		         risultato[i].setVisible(false); }
       		  }
        	 for ( i = 0; i < k ; i++ ) {
         	  	 risultato[i].setVisible(true);
         	  	 adname[i].setText(listName[i]);
         	  	 surname[i].setText(listSurname[i]);
         	  	 Umail[i].setText(listEmail[i]);
                 adregion[i].setText(listRegion[i]);
                 adlocation[i].setText(listLocation[i]);
                 adstudy[i].setText(listStudy[i]);  
                 adprov[i].setText(listProvince[i]); 
                 adsec[i].setText(listCategory[i]);
                 adexp[i].setText(listExp[i]);                
                 adbio[i].setText(listBio[i]); 
         	 }
          	  read.close();
    	} catch (FileNotFoundException ex) {
        ex.printStackTrace();
        } catch (IOException ex) {
        ex.printStackTrace();
        }
    }
   
	@Override
	public void initialize(URL Url, ResourceBundle Resources) {
		
		mailUser1.setVisible(false);
		mailUser2.setVisible(false);
		mailUser3.setVisible(false);
		mailUser4.setVisible(false);
		mailUser5.setVisible(false);
		mailUser6.setVisible(false);
		annuncio1.setVisible(false);
		annuncio11.setVisible(false);
		annuncio12.setVisible(false);
		annuncio13.setVisible(false);
		annuncio14.setVisible(false);
		annuncio15.setVisible(false);
		esEmail.setVisible(false);
		ImpDesc.setEditable(false);
		ImpDesc1.setEditable(false);
		ImpDesc2.setEditable(false);
		ImpDesc3.setEditable(false);
		ImpDesc4.setEditable(false);
		ImpDesc5.setEditable(false);
		
		//combobox regione
		regionSrc.getItems().addAll("Abruzzo","Basilicata","Calabria","Campania","Emilia-Romagna",
	              "Friuli-Venezia Giulia","Lazio","Liguria","Lombardia","Marche","Molise","Piemonte","Puglia",
	              "Sardegna","Sicilia","Toscana","Trentino-Alto Adige","Umbria","Valle d'Aosta","Veneto");
	          regionSrc.setValue("Abruzzo");
				
	    //combobox settore
		SectorSrc.getItems().addAll("Acquisti-Logica-Trasporti","Affari legali","Amministrazione-Segreteria","Architettura-Arti grafiche-Design","Assistenza Anziani",
                "Commerciale","Commercio-Negozi","Contabilita'-Finanza","Direzione-Consulenza","Edilizia","Editoria-Giornalismo","Estetica-Cura della Persona","Formazione-Istruzione",
                "Informatica-Telecomunicazioni","Ingegneria","Marketing-Comunicazione","Medicina-Salute","Produzione-Operai","Project Managment","Qualita'-Ambiente","Risorse Umane",
                "Sicurezza-Vigilanza","Supporto al cliente","Turismo-Ristorazione","Altro");
        SectorSrc.setValue("Altro");
        
	}

}


