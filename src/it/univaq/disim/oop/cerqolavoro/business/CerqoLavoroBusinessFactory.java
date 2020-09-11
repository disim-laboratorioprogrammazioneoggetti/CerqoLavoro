package it.univaq.disim.oop.cerqolavoro.business;

import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileCerqoLavoroBusinessFactoryImpl;
import it.univaq.disim.oop.cerqolavoro.business.impl.ram.RAMCerqoLavoroBusinessFactoryImpl;

public abstract class CerqoLavoroBusinessFactory {
	
	private static CerqoLavoroBusinessFactory factoryRAM = new RAMCerqoLavoroBusinessFactoryImpl();
	private static CerqoLavoroBusinessFactory factory = new FileCerqoLavoroBusinessFactoryImpl();
	
	public static CerqoLavoroBusinessFactory getInstance() {
		return factory;
	}
	
	public abstract UserService getUserService();
	public abstract WorkerService getWorkerService();
	public abstract EmployerService getEmployerService();
	public abstract OfferService getOfferService();
	public abstract CandidacyService getCandidacyService();
	public abstract MessageService getMessageService();

}
