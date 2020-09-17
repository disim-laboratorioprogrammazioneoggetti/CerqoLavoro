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
import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.business.CerqoLavoroBusinessFactory;
import it.univaq.disim.oop.cerqolavoro.business.MessageService;
import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileCerqoLavoroBusinessFactoryImpl;
import it.univaq.disim.oop.cerqolavoro.business.impl.ram.RAMMessageServiceImpl;
import it.univaq.disim.oop.cerqolavoro.domain.Candidacy;
import it.univaq.disim.oop.cerqolavoro.domain.Message;
import it.univaq.disim.oop.cerqolavoro.domain.User;
import it.univaq.disim.oop.cerqolavoro.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class UserMessagesController implements Initializable, DataInitializable<User> {
	
	@FXML private Label umEmail;
    @FXML private TextArea MexArea1;
    @FXML private TextArea MexArea2;
    @FXML private TextArea MexArea3;
    @FXML private Button ShowMexBtn;
	
    public Stage stage = new Stage();
    private ViewDispatcher dispatcher;   
	private User user;
	private MessageService messageService;
	private Message message;
	
	public UserMessagesController() {
		dispatcher = ViewDispatcher.getInstance();
		messageService = new RAMMessageServiceImpl(messageService);
		CerqoLavoroBusinessFactory factory = CerqoLavoroBusinessFactory.getInstance();
		messageService = factory.getMessageService();
	}
    
	@Override
	public void initializeData(User user) {
	umEmail.setText(user.getEmail());
	}
          
	// Mostra messaggi ricevuti dalle aziende
	
    @FXML
    void ShowMex(ActionEvent event) throws BusinessException, IOException {	
	try {
	File mexCheck = new File(FileCerqoLavoroBusinessFactoryImpl.MESSAGES_FILE_DIRECTORY + umEmail.getText().toString() + "_mex.txt");
	if(mexCheck.exists()) {		
		TextArea mex[] = { MexArea1, MexArea2, MexArea3 };
		String preMex[] = new String [3];
		String listaMex[] = new String [3];	
		int i = 0;		
		List<Message> messagesList = messageService.findMessages(umEmail.getText().toString());
    	for (Message m: messagesList) {
    	    preMex[i] = m.getTitle().toString();
    	    listaMex[i] = m.getText().toString();
    	    i++;
    	}
			  if ( messagesList.size() < 3 ) {
			  for ( i = messagesList.size(); i < 3; i++ ) {
				  mex[i].setVisible(false); }
			  }			  
			  for ( i = 0; i < messagesList.size() ; i++ ) {   
				  mex[i].setVisible(true);
				  mex[i].setText(preMex[i] + "\n" + listaMex[i]); }
			  }
	if ( !mexCheck.exists() ) {
		Alert errorAlert = new Alert(AlertType.ERROR);
	    errorAlert.setHeaderText("Avviso");
	    errorAlert.setContentText("Non sono presenti messaggi");
	    errorAlert.showAndWait();
	}
	 } catch (BusinessException e) {
		e.printStackTrace();
		throw new BusinessException(e);
	 }
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
    	MexArea1.setVisible(false);
    	MexArea1.setEditable(false);
    	MexArea2.setVisible(false);
    	MexArea2.setEditable(false);
    	MexArea3.setVisible(false);
    	MexArea3.setEditable(false);
    	umEmail.setVisible(false);
	};

}
