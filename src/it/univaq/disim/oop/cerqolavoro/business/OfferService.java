package it.univaq.disim.oop.cerqolavoro.business;

import java.util.List;

import it.univaq.disim.oop.cerqolavoro.domain.Offer;

public interface OfferService {
	
	 List<Offer> findAllOffers(Offer offer) throws BusinessException;

	 void createOffer(Offer offer) throws BusinessException;

	 void updateOffer(Offer offer) throws BusinessException;
	 
	 void deleteOffer(String titleOffer, String email) throws BusinessException;

}
