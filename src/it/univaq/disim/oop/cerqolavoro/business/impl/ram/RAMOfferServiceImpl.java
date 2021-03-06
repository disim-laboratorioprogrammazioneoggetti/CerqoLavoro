package it.univaq.disim.oop.cerqolavoro.business.impl.ram;

import java.util.ArrayList;
import java.util.List;

import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.business.CandidacyService;
import it.univaq.disim.oop.cerqolavoro.business.OfferService;
import it.univaq.disim.oop.cerqolavoro.domain.Candidacy;
import it.univaq.disim.oop.cerqolavoro.domain.Offer;

public class RAMOfferServiceImpl implements OfferService {

	private static List<Offer> offer = new ArrayList<>();
	private OfferService offerService;
	
	public RAMOfferServiceImpl(OfferService offerService) {
		this.offerService = offerService;
	}
	
	@Override
	public List<Offer> findAllOffers(String region, String category) throws BusinessException {
	    return new ArrayList<>();
	}

	@Override
	public List<Offer> findMyOffers(String email) throws BusinessException {
		return new ArrayList<>();
	}
	
	@Override
	public List<Offer> findLuckyOffers(String esperienza, String categoria, String istruzione) throws BusinessException {
		return new ArrayList<>();
	}
	
	@Override
	public void deleteOffer(String titleOffer, String email) throws BusinessException {
		
	}

}
