package it.univaq.disim.oop.cerqolavoro.business.impl.ram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.business.CandidacyService;
import it.univaq.disim.oop.cerqolavoro.business.UserNotFoundException;
import it.univaq.disim.oop.cerqolavoro.domain.Candidacy;

public class RAMCandidacyServiceImpl implements CandidacyService {
	
	private static List<Candidacy> candidacy = new ArrayList<>();
	private CandidacyService candidacyService;
	
	public RAMCandidacyServiceImpl(CandidacyService candidacyService) {
		this.candidacyService = candidacyService;
	}

	@Override
	public List<Candidacy> findMyCandidacy(String email) throws BusinessException {
		return new ArrayList<>();
	}

	@Override
	public void createCandidacy(String email, String candidacyTitle) throws BusinessException {
		
		// throw new UserNotFoundException();
	}

	@Override
	public void deleteCandidacy(String email, String candidacyTitle) {
		
	}

}
