package it.univaq.disim.oop.cerqolavoro.business.impl.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.business.MessageService;
import it.univaq.disim.oop.cerqolavoro.business.UserService;
import it.univaq.disim.oop.cerqolavoro.domain.Message;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FileMessageServiceImpl implements MessageService{
	private String messageFilename;
	private MessageService messageService;

	public FileMessageServiceImpl(String messageFilename, MessageService messageService) {
		this.messageFilename = messageFilename;
		this.messageService = messageService;
	}

	@Override
	public List<Message> findAllMessages(Message message) throws BusinessException {
		return null;
	}

	@Override
	public Message createMessages(String workerEmail, String textMessage) throws BusinessException, IOException {   	
		Message message = null;
		try {
	 File messagesFile = new File(FileCerqoLavoroBusinessFactoryImpl.MESSAGES_FILE_DIRECTORY + workerEmail + "_mex" + ".txt");
     if(!messagesFile.exists()) {
     StringBuilder sb =  new StringBuilder();
     sb.append( "Messaggio inviato tramite EmployerSearch"+"\n");
     sb.append( textMessage + "\n");
   //  File mex = new File(FileCerqoLavoroBusinessFactoryImpl.MESSAGES_FILE_DIRECTORY + workerEmail + "_" + employerEmail + ".txt");
     FileWriter W = null;
     try {
       W = new FileWriter (messagesFile);
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
     } catch (IOException e) {
       e.printStackTrace();
     }
       Alert errorAlert = new Alert(AlertType.CONFIRMATION);
       errorAlert.setHeaderText("Successo");
       errorAlert.setContentText("Messaggio inviato con successo");
       errorAlert.showAndWait();
    }
    	if(messagesFile.exists()) {
    	//	File exstmex = new File(FileCerqoLavoroBusinessFactoryImpl.MESSAGES_FILE_DIRECTORY + workerEmail + "_" + employerEmail + ".txt");
    		FileWriter fratm = new FileWriter(messagesFile,true);
            BufferedWriter bw = new BufferedWriter(fratm);
            bw.append( "Messaggio inviato tramite EmployerSearch"+"\n");
            bw.append( textMessage+ "\n");
            bw.close();      
        Alert errorAlert = new Alert(AlertType.CONFIRMATION);
        errorAlert.setHeaderText("Successo");
        errorAlert.setContentText("Messaggio inviato con successo");
        errorAlert.showAndWait();
    	}   
        message = new Message();
    	message.setText(textMessage);
    	return message;
	} catch (IOException e) {
		e.printStackTrace();
		Alert error1Alert = new Alert(AlertType.ERROR);
        error1Alert.setHeaderText("ERRORE");
        error1Alert.setContentText("File non trovato");
        error1Alert.showAndWait();
		throw new BusinessException(e);
	}
  }
}