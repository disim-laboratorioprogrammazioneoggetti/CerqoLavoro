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
import it.univaq.disim.oop.cerqolavoro.domain.Candidacy;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FileCandidacyServiceImpl implements CandidacyService {
	private CandidacyService candidacyService;
	private String candidacyFilename;

	public FileCandidacyServiceImpl(String candidacyFilename, CandidacyService candidacyService) {
		this.candidacyFilename = candidacyFilename;
		this.candidacyService = candidacyService;
	}
	
	// Trova candidature nel file
	@Override
	public List<Candidacy> findMyCandidacy(String email) throws BusinessException { 
		List<Candidacy> candidatesList = new ArrayList<Candidacy>(6);
    	try {
    	     int n = 0, k = 0;   	                	
    	     BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME));
    	     int lines = 0;
    	     while (reader.readLine() != null) {
    	        lines++;
    	     }
    	     reader.close();
    	     int cont = lines / 2;                	
    	     // Cerca tutte le candidature nei limiti di spazio grafici
    	     BufferedReader read = new BufferedReader(new InputStreamReader(
    	         new FileInputStream(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME), StandardCharsets.UTF_8));
    	         List<String> line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME), StandardCharsets.UTF_8);
                 int j = 0, m = 1;
    	         candidates:
    	         while ( line != null && n < cont ) {
    	            if ( k < 6 ) {
    	                if ( line.get(j).equals( email ) ) {
    	                	Candidacy candidacy = new Candidacy();
    	                	candidacy.setTitle(line.get(m).toString());
    	                	candidatesList.add(candidacy);
    	                k++;
    	                }
    	            } else {
    	             break candidates; }
                     j += 2; m += 2; n++;
    	          }   	        
                  read.close();
    	          return candidatesList;
    	    } catch (IOException e) {
			e.printStackTrace();
			throw new BusinessException(e);
		}
	}

	// Pubblica candidatura	
	@Override
	public void createCandidacy(String email, String candidacyTitle) throws BusinessException {
    	try {
        	boolean cand = true;
        	BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME));
        	int lines = 0;
        	while (reader.readLine() != null) lines++;
        	reader.close();
        	int cont = lines / 2;
    	    BufferedReader candad = new BufferedReader(
    	        new InputStreamReader(
    	            new FileInputStream(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME), StandardCharsets.UTF_8));
            List<String> line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME), StandardCharsets.UTF_8);
            int i = 0, j = 0, m = 1; 
            candCheck:
            // Cerca nel file se la candidatura è già presente
    	    while (line != null && i < cont ) {
    		   if ( line.get(j).equals( email) ) {
    			   if ( line.get(m).equals( candidacyTitle ) ) {
                   candad.close();
                   cand = false;
                   break candCheck;
                   }
    	       }
              i++; j += 2; m += 2;
    	    }
            candad.close();
            // Scrive candidatura nel file aggiungendo le due linee
        	if ( cand == true ) {
            StringBuilder ca =  new StringBuilder();
            ca.append( ( email ) + "\n");
            ca.append( ( candidacyTitle ) + "\n");
        	File c1 = new File(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME);
            BufferedWriter bw = new BufferedWriter(new FileWriter(c1, true));
            bw.append(ca);
            bw.close();
        	}
        	if ( cand == false ) {
        	    Alert confirmAlert = new Alert(AlertType.ERROR);
        	    confirmAlert.setHeaderText("Attenzione");
        	    confirmAlert.setContentText("La candidatura è già presente nel sistema");
        	    confirmAlert.showAndWait();
        	}
    	}
		catch (IOException e) {
			e.printStackTrace();
            throw new BusinessException(e);
		}
	}
	
	// Elimina candidatura
	@Override
	public void deleteCandidacy(String email, String candidacyTitle) throws BusinessException {
    	try {
    		BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME));
        	int lines = 0;
        	while (reader.readLine() != null) {
        		lines++;
        	}
        	reader.close();
        	int cont = lines / 2;
            int i = 0, n = 0, j = 0, m = 1, r = -1, s = -1;
        	BufferedReader read = new BufferedReader(
        	        new InputStreamReader(
        	            new FileInputStream(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME), StandardCharsets.UTF_8));
        	List<String> line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME), StandardCharsets.UTF_8);
            deleteCandidacy:
            	// Trova le linee della candidatura
            	while (line != null && i < cont ) {
            		if ( line.get(j).equals( email) ) {
            			if ( line.get(m).equals( candidacyTitle ) ) {
            			r = j;
            			s = m;
                        read.close();
                        break deleteCandidacy;
                        }
            	    }
                    i++; j += 2; m += 2;
            	    }
                    read.close();	
            // File scritto omettendo le linee della candidatura
    		File f = new File(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME);
    	    StringBuilder sb = new StringBuilder();
    	    try (Scanner sc = new Scanner(f)) {
    	        String currentLine;
    	        while(sc.hasNext() && n < (lines)) {
    	            currentLine = sc.nextLine();
    	            if ( n != r && n != s ) {
        	            sb.append(currentLine).append("\n");
    	            }
    	            n++;
    	        }
    	    }	    
    	    PrintWriter pw = new PrintWriter(f);
    	    pw.close();
    	    BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
    	    writer.append(sb.toString());
    	    writer.close();
    	    Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
    	    confirmAlert.setHeaderText("Avviso");
    	    confirmAlert.setContentText("La candidatura è stata rimossa con successo");
    	    confirmAlert.showAndWait();
    	}
         catch (IOException e) {
			e.printStackTrace();
			throw new BusinessException(e);
	    }
	}
}
