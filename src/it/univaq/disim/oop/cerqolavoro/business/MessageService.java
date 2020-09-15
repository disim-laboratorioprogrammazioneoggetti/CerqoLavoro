package it.univaq.disim.oop.cerqolavoro.business;

import java.io.IOException;
import java.util.List;
import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.domain.Message;

public interface MessageService {
	
	public List<Message> findMessages(String email) throws BusinessException;

	void createMessages(String workerEmail, String textMessages) throws BusinessException, IOException;
	
}