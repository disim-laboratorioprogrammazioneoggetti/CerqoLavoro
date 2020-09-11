package it.univaq.disim.oop.cerqolavoro.business.impl.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import it.univaq.disim.oop.cerqolavoro.business.UserService;
import it.univaq.disim.oop.cerqolavoro.business.WorkerService;
import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.business.UserNotFoundException;
import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileData;
import it.univaq.disim.oop.cerqolavoro.business.impl.file.Utility;
import it.univaq.disim.oop.cerqolavoro.business.OfferService;
import it.univaq.disim.oop.cerqolavoro.business.CerqoLavoroBusinessFactory;
import it.univaq.disim.oop.cerqolavoro.business.EmployerService;
import it.univaq.disim.oop.cerqolavoro.business.CandidacyService;
import it.univaq.disim.oop.cerqolavoro.business.MessageService;
import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileUserServiceImpl;
import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileCandidacyServiceImpl;
import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileMessageServiceImpl;

public class FileCerqoLavoroBusinessFactoryImpl extends CerqoLavoroBusinessFactory {

	private UserService userService;
	private WorkerService workerService;
	private EmployerService employerService;
	private OfferService offerService;
	private CandidacyService candidacyService;
	private MessageService messageService;

	public static final String REPOSITORY_BASE = "src" + File.separator + "resources" + File.separator + "Data";
	public static final String WORKER_FILE_DIRECTORY = REPOSITORY_BASE + File.separator + "UserProfiles" + File.separator;
	public static final String USER_FILE_NAME = REPOSITORY_BASE + File.separator + "UserProfiles" + File.separator + "profiles.txt";
	public static final String EMPLOYER_FILE_DIRECTORY = REPOSITORY_BASE + File.separator + "EmployerProfiles" + File.separator;
	public static final String OFFERS_FILE_NAME = REPOSITORY_BASE + File.separator + "Offers" + File.separator + "offerte.txt";
	public static final String CANDIDATES_FILE_NAME = REPOSITORY_BASE + File.separator + "Candidates" + File.separator + "candidature.txt";
	public static final String MESSAGES_FILE_DIRECTORY = REPOSITORY_BASE + File.separator + "Messages" + File.separator;

	public FileCerqoLavoroBusinessFactoryImpl() {
		
		userService = new FileUserServiceImpl(WORKER_FILE_DIRECTORY, userService);
		workerService = new FileWorkerServiceImpl();
		employerService = new FileEmployerServiceImpl();
		offerService = new FileOfferServiceImpl(OFFERS_FILE_NAME, offerService);
		candidacyService = new FileCandidacyServiceImpl(CANDIDATES_FILE_NAME, candidacyService);	
		messageService = new FileMessageServiceImpl(MESSAGES_FILE_DIRECTORY, messageService);	
		
	}

	@Override
	public UserService getUserService() {
		return userService;
	}
	
	@Override
	public WorkerService getWorkerService() {
		return workerService;
	}
	
	@Override
	public EmployerService getEmployerService() {
		return employerService;
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