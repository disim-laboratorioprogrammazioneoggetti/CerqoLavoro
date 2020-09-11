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
import java.util.List;
import java.util.Scanner;

import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.business.CandidacyService;
import it.univaq.disim.oop.cerqolavoro.business.OfferService;
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
	public List<Offer> findAllOffers(Offer offer) throws BusinessException {
		return null;
	}

	@Override
	public void createOffer(Offer offer) throws BusinessException {
		// da eliminare
	}

	@Override
	public void updateOffer(Offer offer) throws BusinessException {
		
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
	    		Alert error1Alert = new Alert(AlertType.ERROR);
	            error1Alert.setHeaderText("ERRORE");
	            error1Alert.setContentText("File non trovato");
	            error1Alert.showAndWait();
	    		throw new BusinessException(e);
	    	}
   }
}
