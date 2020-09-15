package it.univaq.disim.oop.cerqolavoro.business;

import java.util.List;

import it.univaq.disim.oop.cerqolavoro.domain.Candidacy;

public interface CandidacyService {

	List<Candidacy> findMyCandidacy(String email) throws BusinessException;
	
	// List<Candidacy> findOfferCandidacy(String email) throws BusinessException;

	void createCandidacy(String email, String candidacyTitle) throws BusinessException;

	void deleteCandidacy(String email, String candidacyTitle) throws BusinessException;
	
}
