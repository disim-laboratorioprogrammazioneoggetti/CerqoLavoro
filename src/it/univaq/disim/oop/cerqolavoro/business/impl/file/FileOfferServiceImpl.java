package it.univaq.disim.oop.cerqolavoro.business.impl.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.business.CandidacyService;
import it.univaq.disim.oop.cerqolavoro.business.OfferService;
import it.univaq.disim.oop.cerqolavoro.domain.Candidacy;
import it.univaq.disim.oop.cerqolavoro.domain.Offer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class FileOfferServiceImpl implements OfferService {
	private OfferService offerService;
	private String offerFilename;

	public FileOfferServiceImpl(String offerFilename, OfferService offerService) {
		this.offerFilename = offerFilename;
		this.offerService = offerService;
	}
	
	@Override
	public List<Offer> findAllOffers(String region, String category) throws BusinessException {
		List<Offer> allOffers = new ArrayList<Offer>(4);
		try {
		File offerCheck = new File(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME);
		BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME));
		int lines = 0;
		while (reader.readLine() != null) {
		  lines++;
		}
		reader.close();
		int cont = lines / 13;
		BufferedReader read = new BufferedReader(
		          new InputStreamReader(
		              new FileInputStream(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME)));
		 List<String> line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME));
		 int i = 0, k = 0, j = 0, p = 1, q = 2, r = 4, s = 5, t = 6, u = 7, v = 8, w = 9, x = 10, y = 11, z = 12;
         if( region.equals("Tutte") && category != "Tutte" ) {
        	 while (( line != null ) && ( i < cont ) && (k < 4)) {
            	 if ( category.equals(line.get(p)) ) {
            		Offer offer = new Offer();
 			        offer.setRegion(line.get(j));
 			        offer.setSector(line.get(p));
 			        offer.setTitle(line.get(q));
 			        offer.setPosition(line.get(r));
 			        offer.setContractType(line.get(s));
 			        offer.setContractTime(line.get(t));
 			        offer.setWage(line.get(u));
 			        offer.setExperience(line.get(v));
 			        offer.setWageTime(line.get(w));
 			        offer.setBonus(line.get(x));
 			        offer.setEducation(line.get(y));
 			        offer.setInfo(line.get(z));
                    k++; allOffers.add(offer);
                	 }
                     i++; j += 13; p += 13; q += 13; r += 13; s += 13; t += 13; u += 13; v += 13; w += 13; x += 13; y += 13; z += 13;
        		 }
         }
         if ( region.equals("Tutte") && category.equals("Tutte")) {
        	 while (( line != null ) && ( i < cont ) && (k < 4)) {
        		    Offer offer = new Offer();
			        offer.setRegion(line.get(j));
			        offer.setSector(line.get(p));
			        offer.setTitle(line.get(q));
			        offer.setPosition(line.get(r));
			        offer.setContractType(line.get(s));
			        offer.setContractTime(line.get(t));
 			        offer.setWage(line.get(u));
 			        offer.setExperience(line.get(v));
 			        offer.setWageTime(line.get(w));
 			        offer.setBonus(line.get(x));
 			        offer.setEducation(line.get(y));
 			        offer.setInfo(line.get(z));
			        allOffers.add(offer);
                 i++; k++; j += 13; p += 13; q += 13; r += 13; s += 13; t += 13; u += 13; v += 13; w += 13; x += 13; y += 13; z += 13;
    		 }
      }
         if ( region != "Tutte" && category.equals("Tutte") ) {
        	 while (( line != null ) && ( i < cont ) && (k < 4)) {
            	 if ( region.equals( line.get(j)) ) {
            		Offer offer = new Offer();
 			        offer.setRegion(line.get(j));
 			        offer.setSector(line.get(p));
 			        offer.setTitle(line.get(q));
 			        offer.setPosition(line.get(r));
 			        offer.setContractType(line.get(s));
 			        offer.setContractTime(line.get(t));
 			        offer.setWage(line.get(u));
 			        offer.setExperience(line.get(v));
 			        offer.setWageTime(line.get(w));
 			        offer.setBonus(line.get(x));
 			        offer.setEducation(line.get(y));
 			        offer.setInfo(line.get(z));
 			        k++; allOffers.add(offer);
            	 }
            	 i++; j += 13; p += 13; q += 13; r += 13; s += 13; t += 13; u += 13; v += 13; w += 13; x += 13; y += 13; z += 13;
    		 }
         }
         if ( region != "Tutte" && category != "Tutte" ) {
        	 while (( line != null ) && ( i < cont ) && (k < 4)) {
            	 if ( region.equals( line.get(j)) && category.equals( line.get(p) )) {
            		Offer offer = new Offer();
 			        offer.setRegion(line.get(j));
 			        offer.setSector(line.get(p));
 			        offer.setTitle(line.get(q));
 			        offer.setPosition(line.get(r));
 			        offer.setContractType(line.get(s));
 			        offer.setContractTime(line.get(t));
 			        offer.setWage(line.get(u));
 			        offer.setExperience(line.get(v));
 			        offer.setWageTime(line.get(w));
 			        offer.setBonus(line.get(x));
 			        offer.setEducation(line.get(y));
 			        offer.setInfo(line.get(z));
 			        k++; allOffers.add(offer);
            	 }
            	 i++; j += 13; p += 13; q += 13; r += 13; s += 13; t += 13; u += 13; v += 13; w += 13; x += 13; y += 13; z += 13;
            	 }
         }
			  read.close();
			  return allOffers;
	     } catch  (IOException e) {
		     e.printStackTrace();
		     throw new BusinessException(e);
	     }
	}
	
	@Override
	public List<Offer> findMyOffers(String email) throws BusinessException {
		List<Offer> myOffers = new ArrayList<Offer>(3);
		try {
		File offerCheck = new File(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME);
		if(!offerCheck.exists()) {
			Alert errorAlert = new Alert(AlertType.ERROR);
		    errorAlert.setHeaderText("Attenzione - Non hai creato annunci");
		    errorAlert.setContentText("Visita la sezione Crea per pubblicare il tuo primo annuncio");
		    errorAlert.showAndWait();
		}
		if (offerCheck.exists()) {
		BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME));
		int lines = 0;
		while (reader.readLine() != null) {
		  lines++;
		}
		reader.close();
		int cont = lines / 13;
		BufferedReader read = new BufferedReader(
		          new InputStreamReader(
		              new FileInputStream(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME)));
		 List<String> line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME));
		 int i = 0, k = 0, j = 0, p = 1, q = 2, em = 3, r = 4, s = 5, t = 6, u = 7, w = 8, v = 9, x = 10, y = 11, z = 12;  
			  while ( ( line != null ) && ( i < cont ) && ( k < 3 )) {
				if ( line.get(em).equals(email) ) {
					Offer offer = new Offer();
			        offer.setRegion(line.get(j));
			        offer.setSector(line.get(p));
			        offer.setTitle(line.get(q));
			        offer.setPosition(line.get(r));
			        offer.setContractType(line.get(s));
			        offer.setContractTime(line.get(t));
 			        offer.setWage(line.get(u));
 			        offer.setExperience(line.get(v));
 			        offer.setWageTime(line.get(w));
 			        offer.setBonus(line.get(x));
 			        offer.setEducation(line.get(y));
 			        offer.setInfo(line.get(z));
			        k++; myOffers.add(offer);
			       }
			    i++; j += 13; p += 13; q += 13; em += 13; r += 13; s += 13; t += 13; u += 13; v += 13; x += 13; y += 13; z += 13;
			  }
			  read.close();
		   }
		      return myOffers;
	     } catch  (IOException e) {
		     e.printStackTrace();
		     throw new BusinessException(e);
	     }
	}
	
	@Override
	public List<Offer> findLuckyOffers(String esperienza, String categoria, String istruzione) throws BusinessException {
		List<Offer> luckyOffers = new ArrayList<Offer>(4);
		try {
		BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME));
		int lines = 0;
		while (reader.readLine() != null) {
		  lines++;
		}
		reader.close();
		int cont = lines / 13;
		BufferedReader read = new BufferedReader(
		          new InputStreamReader(
		              new FileInputStream(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME)));
		 List<String> line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME));
		 int i = 0, k = 0, j = 0, p = 1, q = 2, r = 4, s = 5, t = 6, u = 7, v = 8, w = 9, x = 10, y = 11, z = 12; 
		    while ( ( line != null ) && ( i < cont ) && ( k < 4 ) ) {
		    	if ( line.get(v).equals(esperienza) && line.get(p).equals(categoria) && line.get(y).equals(istruzione) ) {
					Offer offer = new Offer();
			        offer.setRegion(line.get(j));
			        offer.setSector(line.get(p));
			        offer.setTitle(line.get(q));
			        offer.setPosition(line.get(r));
			        offer.setContractType(line.get(s));
			        offer.setContractTime(line.get(t));
 			        offer.setWage(line.get(u));
 			        offer.setExperience(line.get(v));
 			        offer.setWageTime(line.get(w));
 			        offer.setBonus(line.get(x));
 			        offer.setEducation(line.get(y));
 			        offer.setInfo(line.get(z));
			        k++; luckyOffers.add(offer);
			       }
		    	i++; j += 13; p += 13; q += 13; r += 13; s += 13; t += 13; u += 13; v += 13; w += 13; x += 13; y += 13; z += 13;
			  }
			  read.close();
			  if (k == 0) {
					Alert errorAlert = new Alert(AlertType.ERROR);
				    errorAlert.setHeaderText("Siamo spiacenti");
				    errorAlert.setContentText("Non abbiamo trovato alcun annuncio attinente");
				    errorAlert.showAndWait();
		   }
		      return luckyOffers;
	     } catch  (IOException e) {
		     e.printStackTrace();
		     throw new BusinessException(e);
	     }
	}
	
	@Override
	public void deleteOffer(String titleOffer, String email) throws BusinessException {
		  try {
		      int a1 = -1, a2 = -1, a3 = -1, a4 = -1, a5 = -1, a6 = -1, a7 = -1, a8 = -1, a9 = -1, a10 = -1, a11 = -1, a12 = -1, i = 0, j = 0, p = 1, q = 2, em = 3, r = 4, s = 5, t = 6, u = 7, w = 8, v = 9, x = 10, y = 11, z = 12, am = -1;
		    BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME));
		      int lines = 0;
		      while (reader.readLine() != null) {
		        lines++;
		      }
		      reader.close();
		      int cont = lines / 13;
		      BufferedReader read = new BufferedReader(
		              new InputStreamReader(
		                  new FileInputStream(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME), StandardCharsets.UTF_8));
		      List<String> line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME), StandardCharsets.UTF_8);
		        delcand1:
		          while (line != null && i < cont ) {
		            if ( line.get(q).equals( titleOffer ) && line.get(em).equals( email )) {
		                    a1 = j; a2 = p; a3 = q; am = em; a4 = r; a5 = s; a6 = t; a7 = u; a8 = w; a9 = v; a10 = x; a11 = y; a12 = z;
		                    read.close();
		                    break delcand1;
		              }
		            i++; j += 13; p += 13; q += 13; em += 13; r += 13; s += 13; t += 13; u += 13; v += 13; x += 13; y += 13; z += 13;
		              }
		                read.close();
		    i = 0;
		    File f = new File(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME);
		      StringBuilder sb = new StringBuilder();
		      try (Scanner sc = new Scanner(f)) {
		          String currentLine;
		          while(sc.hasNext() && i < (lines)) {
		            if ( lines % 13 == 0 ) {
		              cont++;
		            }
		              currentLine = sc.nextLine();
		              if ( i != a1 && i != a2 && i != am && i != a3 && i != a4 && i != a5 && i != a6 && i != a7 && i != a8 && i != a9 && i != a10 && i != a11 && i != a12 ) {
		                  sb.append(currentLine).append("\n");
		              }
		              i++;
		          }
		      }
		      PrintWriter pw = new PrintWriter(f);
		      pw.close();
		      BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
		      writer.append(sb.toString());
		      writer.close();
		      
	          } catch (IOException e) {
	      		e.printStackTrace();
	    		throw new BusinessException(e);
	    	}
   }
}
