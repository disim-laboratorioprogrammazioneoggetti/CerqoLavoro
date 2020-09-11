package it.univaq.disim.oop.cerqolavoro.business;

import java.io.IOException;
import java.util.List;
import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.domain.Message;

public interface MessageService {
	
	List<Message> findAllMessages(Message message) throws BusinessException;

	Message createMessages(String workerEmail, String textMessages) throws BusinessException, IOException;
	
}