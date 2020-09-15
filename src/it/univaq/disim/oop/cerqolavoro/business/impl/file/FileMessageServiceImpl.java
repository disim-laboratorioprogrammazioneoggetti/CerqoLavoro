package it.univaq.disim.oop.cerqolavoro.business.impl.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.business.MessageService;
import it.univaq.disim.oop.cerqolavoro.domain.Candidacy;
import it.univaq.disim.oop.cerqolavoro.domain.Message;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
public class FileMessageServiceImpl implements MessageService{
	private String messageFilename;
	private MessageService messageService;

	public FileMessageServiceImpl(String messageFilename, MessageService messageService) {
		this.messageFilename = messageFilename;
		this.messageService = messageService;
	}
	
	@Override
	public List<Message> findMessages(String email) throws BusinessException {
		List<Message> messagesList = new ArrayList<Message>(3);
		try {
			File mexCheck = new File(FileCerqoLavoroBusinessFactoryImpl.MESSAGES_FILE_DIRECTORY + email + "_mex.txt");
			if(mexCheck.exists()) {		
				int i = 0, a = 0, b = 1;		
				BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.MESSAGES_FILE_DIRECTORY + email + "_mex.txt"));
				int lines = 0;
				while (reader.readLine() != null) {
				  lines++; }
				reader.close();
				BufferedReader read = new BufferedReader(
				          new InputStreamReader(
				              new FileInputStream(FileCerqoLavoroBusinessFactoryImpl.MESSAGES_FILE_DIRECTORY + email + "_mex.txt"), StandardCharsets.UTF_8));
				 List<String> line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.MESSAGES_FILE_DIRECTORY + email + "_mex.txt"), StandardCharsets.UTF_8);  
					  while ( (line != null) && (i < lines) ) {		  
						  Message message = new Message();
						  message.setTitle(line.get(a).toString());
						  message.setText(line.get(b).toString());
  	                	  messagesList.add(message);
					      i += 2; a += 2; b += 2;	
					  }
					  read.close(); 
			}
		      return messagesList;
	       } catch (IOException e) {
	    	   e.printStackTrace();
	    	   throw new BusinessException(e);
	       }
	}

	@Override
	public void createMessages(String workerEmail, String textMessage) throws BusinessException, IOException {   	
		Message message = null;
		try {
	 File messagesFile = new File(FileCerqoLavoroBusinessFactoryImpl.MESSAGES_FILE_DIRECTORY + workerEmail + "_mex" + ".txt");
     if(!messagesFile.exists()) {
     StringBuilder sb =  new StringBuilder();
     sb.append( "Messaggio inviato dall' azienda tramite ricerca candidati:"+"\n");
     sb.append( textMessage + "\n");
     FileWriter W = null;
       W = new FileWriter (messagesFile);
       W.write(sb.toString());
       W.close();
     }
    	if(messagesFile.exists()) {
    		FileWriter newMessage = new FileWriter(messagesFile,true);
            BufferedWriter bw = new BufferedWriter(newMessage);
            bw.append( "Messaggio inviato dall' azienda tramite ricerca candidati:"+"\n");
            bw.append( textMessage+ "\n");
            bw.close();      
    	}   
        message = new Message();
    	message.setText(textMessage);
	    Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
	    confirmAlert.setHeaderText("Avviso");
	    confirmAlert.setContentText("Messaggio inviato con successo");
	    confirmAlert.showAndWait();
	} catch (IOException e) {
		e.printStackTrace();
		throw new BusinessException(e);
	}
  }
}