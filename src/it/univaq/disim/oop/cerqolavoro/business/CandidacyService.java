package it.univaq.disim.oop.cerqolavoro.business;

import java.util.List;

import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.domain.Candidacy;

public interface CandidacyService {

	String[] findCandidacy(String email) throws CandidacyNotFoundException, BusinessException;

	void createCandidacy(String email, String candidacyTitle) throws CandidacyNotFoundException, BusinessException;

	void deleteCandidacy(String email, String candidacyTitle) throws CandidacyNotFoundException, BusinessException;
	
}
