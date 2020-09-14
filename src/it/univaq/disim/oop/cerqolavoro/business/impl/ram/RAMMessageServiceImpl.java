package it.univaq.disim.oop.cerqolavoro.business.impl.ram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.business.MessageService;
import it.univaq.disim.oop.cerqolavoro.domain.Message;

public class RAMMessageServiceImpl implements MessageService {
	
	private static List<Message> message = new ArrayList<>();
	private MessageService messageService;
	
	public RAMMessageServiceImpl(MessageService messageService) {
		this.messageService = messageService;
	}

	@Override
	public Message createMessages(String workerEmail, String textMessage) throws BusinessException, IOException {
		Message message = new Message();
		message.setText(textMessage);
		return message;
	}

}
