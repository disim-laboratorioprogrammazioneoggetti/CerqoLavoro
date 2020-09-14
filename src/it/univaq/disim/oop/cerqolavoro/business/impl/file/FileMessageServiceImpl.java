package it.univaq.disim.oop.cerqolavoro.business.impl.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.business.MessageService;
import it.univaq.disim.oop.cerqolavoro.domain.Message;
public class FileMessageServiceImpl implements MessageService{
	private String messageFilename;
	private MessageService messageService;

	public FileMessageServiceImpl(String messageFilename, MessageService messageService) {
		this.messageFilename = messageFilename;
		this.messageService = messageService;
	}

	@Override
	public Message createMessages(String workerEmail, String textMessage) throws BusinessException, IOException {   	
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
    	return message;
	} catch (IOException e) {
		e.printStackTrace();
		throw new BusinessException(e);
	}
  }
}