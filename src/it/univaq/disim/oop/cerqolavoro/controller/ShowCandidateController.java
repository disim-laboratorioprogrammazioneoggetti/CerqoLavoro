package it.univaq.disim.oop.cerqolavoro.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.business.CandidacyService;
import it.univaq.disim.oop.cerqolavoro.business.CerqoLavoroBusinessFactory;
import it.univaq.disim.oop.cerqolavoro.business.MessageService;
import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileCerqoLavoroBusinessFactoryImpl;
import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileMessageServiceImpl;
import it.univaq.disim.oop.cerqolavoro.business.impl.ram.RAMCandidacyServiceImpl;
import it.univaq.disim.oop.cerqolavoro.business.impl.ram.RAMMessageServiceImpl;
import it.univaq.disim.oop.cerqolavoro.domain.Candidacy;
import it.univaq.disim.oop.cerqolavoro.domain.Message;
import it.univaq.disim.oop.cerqolavoro.domain.User;
import it.univaq.disim.oop.cerqolavoro.domain.Worker;
import it.univaq.disim.oop.cerqolavoro.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ShowCandidateController implements Initializable, DataInitializable<User> {

	public void TitleFunction (String titletext) {AnntitleLabel.setText(titletext);};
	public void ExpFunction (String exptext) {CompareExpAnn.setText(exptext);
	  if(exptext.equals(CompareExpCan.getText().toString())){ResultLabel.setText("Idoneo");ResultLabel.setVisible(true);}};
	  
	public void SectorFunction (String sectortext) {CompareSectornAnn.setText(sectortext);
	  if(sectortext.equals(CompareSectorCan.getText().toString())){ResultLabel1.setText("Idoneo");ResultLabel1.setVisible(true);}};
	  
	public void RegionFunction (String regiontext) {CompareRegionAnn.setText(regiontext);
	  if(regiontext.equals(CompareRegionCan.getText().toString())){ResultLabel2.setText("Idoneo");ResultLabel2.setVisible(true);}};
    
	@FXML private Label namelabel;	
    @FXML private Label ResultLabel1;    
    @FXML private Label ResultLabel2;
    @FXML private Label explabel;
    @FXML private Label surnamelabel;
    @FXML private Label sectorlabel;
    @FXML private Label regionlabel;
    @FXML private Label citylabel;
    @FXML private Label provlabel;
    @FXML private Label instrctnlabel;
    @FXML private Label CompareRegionAnn;
    @FXML private Label CompareSectornAnn;
    @FXML private Label CompareExpAnn;
    @FXML private Label CompareRegionCan;    
    @FXML private Label maillabel;
    @FXML private Label CompareSectorCan;
    @FXML private Label CompareExpCan;
    @FXML private Label ResultLabel;    
    @FXML private TextArea DescriptionArea;
    @FXML private Label AnntitleLabel;
    @FXML private Label TitleCLabel;   
    @FXML private Label TitleNlabel;   
    @FXML private Pane mexPane;    
    @FXML private Label mexName;   
    @FXML private Label MexSurname;   
    @FXML private TextArea MexArea;   
    @FXML private Button SendMexBtn;
    @FXML private Button Contactbutton;
    @FXML private Button Rejectbutton;    
    @FXML private Button scExitButton;    
    @FXML private Label emplEmail;
    @FXML private Label showCandidateStatus;
    
    public Stage stage = new Stage();   
    private ViewDispatcher dispatcher;    
	private User user;
	private CandidacyService candidacyService;
	private Candidacy candidacy;
	private MessageService messageService;
	private Message message;
	
	public ShowCandidateController() {
		dispatcher = ViewDispatcher.getInstance();
		candidacyService = new RAMCandidacyServiceImpl(candidacyService);
		messageService = new RAMMessageServiceImpl(messageService);
		CerqoLavoroBusinessFactory factory = CerqoLavoroBusinessFactory.getInstance();
		candidacyService = factory.getCandidacyService();
		messageService = factory.getMessageService();
	}
	
	// Passaggio email candidato dall'Hire alla scena attuale
	
	public void emplEmailFunction(String email) {
		emplEmail.setText(email);
	}
	
    @FXML
    void exitButtonAction(ActionEvent event) {
    	Stage stage = (Stage) scExitButton.getScene().getWindow();
        stage.close();
    }
    
    // Contatta candidato
    
    @FXML
    void Contactbtnpushed(ActionEvent event1) {
    	mexPane.setVisible(true);
    	SendMexBtn.setDisable(false);
    }

    @FXML
    void SendMex(ActionEvent event2) throws IOException, BusinessException {
    	try {
    	messageService.createMessages(maillabel.getText().toString(), MexArea.getText().toString() );
    	} catch (Exception e) {
            e.printStackTrace();
            showCandidateStatus.setText("Errore durante l'invio del messaggio");
    	}
    }
    
    // Rifiuta candidatura
    
    @FXML
    void rejectBtn(ActionEvent event) throws FileNotFoundException, IOException {
      try { 
  		candidacyService.deleteCandidacy(maillabel.getText().toString(), AnntitleLabel.getText().toString());
      }
     catch (Exception e) {
        e.printStackTrace();
        showCandidateStatus.setText("Candidatura non trovata");
     }
    }
    
    public void mailFunction (String mailtext) {   	
    maillabel.setText(mailtext);  	
    int a=1,b=2,c=5,d=6,e=8,f=9,g=10,h=13,i=14;	
	List<String> line;
	try {		
		line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.WORKER_FILE_DIRECTORY + maillabel.getText().toString()+".csv"), StandardCharsets.UTF_8);
	    namelabel.setText(line.get(a));
	    mexName.setText(line.get(a));
    	TitleNlabel.setText(line.get(a));
    	surnamelabel.setText(line.get(b));
    	MexSurname.setText(line.get(b));
    	TitleCLabel.setText(line.get(b));
    	explabel.setText(line.get(c));
    	CompareExpCan.setText(line.get(c));
    	instrctnlabel.setText(line.get(d));
    	regionlabel.setText(line.get(e));
    	CompareRegionCan.setText(line.get(e));
    	provlabel.setText(line.get(f));
	    citylabel.setText(line.get(g));
	    sectorlabel.setText(line.get(h));
	    CompareSectorCan.setText(line.get(h));
	    DescriptionArea.setText(line.get(i));	
	    } catch (IOException er) {
		er.printStackTrace();
	    }
    };
    
	@Override
	public void initialize(URL url, ResourceBundle resources) {		
		maillabel.setVisible(false);
		DescriptionArea.setEditable(false);
		mexPane.setVisible(false);
		ResultLabel1.setVisible(true);
		ResultLabel2.setVisible(true);		
	}

}
