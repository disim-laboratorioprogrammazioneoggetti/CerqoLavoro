package it.univaq.disim.oop.cerqolavoro.business.impl.ram;

import it.univaq.disim.oop.cerqolavoro.business.CerqoLavoroBusinessFactory;
import it.univaq.disim.oop.cerqolavoro.business.UserService;
import it.univaq.disim.oop.cerqolavoro.business.OfferService;
import it.univaq.disim.oop.cerqolavoro.business.CandidacyService;
import it.univaq.disim.oop.cerqolavoro.business.MessageService;

public class RAMCerqoLavoroBusinessFactoryImpl extends CerqoLavoroBusinessFactory {

	private UserService userService;
	private OfferService offerService;
	private CandidacyService candidacyService;
	private MessageService messageService;

	public RAMCerqoLavoroBusinessFactoryImpl() {
		userService = new RAMUserServiceImpl(userService);
		offerService = new RAMOfferServiceImpl(offerService);
		candidacyService = new RAMCandidacyServiceImpl(candidacyService);
		messageService = new RAMMessageServiceImpl(messageService);
	}

	@Override
	public UserService getUserService() {
		return userService;
	}

	@Override
	public OfferService getOfferService() {
		return offerService;
	}

	@Override
	public CandidacyService getCandidacyService() {
		return candidacyService;
	}
	
	@Override
	public MessageService getMessageService() {
		return messageService;
	}

}
