package it.univaq.disim.oop.cerqolavoro.business;

public interface CandidacyService {

	String[] findCandidacy(String email) throws BusinessException;

	void createCandidacy(String email, String candidacyTitle) throws BusinessException;

	void deleteCandidacy(String email, String candidacyTitle) throws BusinessException;
	
}
