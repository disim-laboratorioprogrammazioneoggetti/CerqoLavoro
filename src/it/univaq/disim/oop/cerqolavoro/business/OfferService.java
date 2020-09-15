package it.univaq.disim.oop.cerqolavoro.business;

import java.util.List;
import it.univaq.disim.oop.cerqolavoro.domain.Offer;

public interface OfferService {
	
	 public List<Offer> findAllOffers(String region, String category) throws BusinessException;
	
	 public List<Offer> findMyOffers(String email) throws BusinessException;
	 
	 public List<Offer> findLuckyOffers(String esperienza, String categoria, String istruzione) throws BusinessException;
	 
	 void deleteOffer(String titleOffer, String email) throws BusinessException;

}
