package it.univaq.disim.oop.cerqolavoro.business.impl.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import it.univaq.disim.oop.cerqolavoro.business.CandidacyNotFoundException;
import it.univaq.disim.oop.cerqolavoro.business.CandidacyService;
import it.univaq.disim.oop.cerqolavoro.business.UserNotFoundException;
import it.univaq.disim.oop.cerqolavoro.business.UserService;
import it.univaq.disim.oop.cerqolavoro.domain.Candidacy;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class FileCandidacyServiceImpl implements CandidacyService {
	private CandidacyService candidacyService;
	private String candidacyFilename;

	public FileCandidacyServiceImpl(String candidacyFilename, CandidacyService candidacyService) {
		this.candidacyFilename = candidacyFilename;
		this.candidacyService = candidacyService;
	}

	@Override
	public String[] findCandidacy(String email) throws BusinessException { 
		String[] candidates = new String[6];
    	                try {
    	                    int i = 0, n = 0, k = 0;   	                	
    	                	BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME));
    	                	int lines = 0;
    	                	while (reader.readLine() != null) {
    	                		lines++;
    	                	}
    	                	reader.close();
    	                	int cont = lines / 2;                	
    	                	BufferedReader read = new BufferedReader(
    	                	        new InputStreamReader(
    	                	            new FileInputStream(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME), StandardCharsets.UTF_8));
    	                    List<String> line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME), StandardCharsets.UTF_8);
                            int j = 0, m = 1;
    	                	candidates:
    	                    while ( line != null && n < cont ) {
    	                    	if ( k < 6 ) {
    	                                if ( line.get(j).equals( email )) {
    	                                     candidates[k] = line.get(m).toString();
    	                                     k++;
    	                                	 }
    	                           }
    	                           else {
    	                                break candidates;
    	                           }
                                 j += 2; m += 2;
    	                    	 n++;
    	                        }
    	                        read.close();
    	                		return candidates;
    	    	        }
		catch (IOException e) {
			e.printStackTrace();
	        Alert error2Alert = new Alert(AlertType.ERROR);
	        error2Alert.setHeaderText("ERRORE");
	        error2Alert.setContentText("Operazione rippata");
	        error2Alert.showAndWait();
			throw new BusinessException(e);
		}
	}

	@Override
	public void createCandidacy(String email, String candidacyTitle) throws CandidacyNotFoundException, BusinessException {
    	try {
        	// BufferedReader candad1;
        	boolean cand = true;
        	BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME));
        	int lines = 0;
        	while (reader.readLine() != null) lines++;
        	reader.close();
        	int cont = lines / 2;
    	    BufferedReader candad = new BufferedReader(
    	        new InputStreamReader(
    	            new FileInputStream(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME), StandardCharsets.UTF_8));
            // String line;
            List<String> line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME), StandardCharsets.UTF_8);
            // candad1 = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\Uni\\LPO\\CerqoLavoro\\src\\Candidates\\candidature.csv"));
    	    // String line = candad1.readLine();
            int i = 0, j = 0, m = 1; 
            candCheck:
    	    while (line != null && i < cont ) {
    		if ( line.get(j).equals( email) ) {
    			if ( line.get(m).equals( candidacyTitle ) ) {
                candad.close();
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setHeaderText("Avviso");
                errorAlert.setContentText("Ti sei già candidato per questo annuncio");
                errorAlert.showAndWait();
                cand = false;
                break candCheck;
                }
    	    }
            i++; j += 2; m += 2;
    	    }
            candad.close();
        	// line = candad1.readLine();
        	if ( cand == true ) {
            StringBuilder ca =  new StringBuilder();
            // ca.append( (ann1.getText().toString()) + " " + (usEmail.getText().toString()) + "\n");
            ca.append( ( email ) + "\n");
            ca.append( ( candidacyTitle ) + "\n");
        	File c1 = new File(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME);
            BufferedWriter bw = new BufferedWriter(new FileWriter(c1, true));
            bw.append(ca);
            bw.close();
			Alert error1Alert = new Alert(AlertType.CONFIRMATION);
            error1Alert.setHeaderText("Avviso");
            error1Alert.setContentText("Ti sei candidato a questa offerta");
            error1Alert.showAndWait();
        	}
    	}
		catch (IOException e) {
			e.getCause().printStackTrace();
			// e.printStackTrace();
			Alert error1Alert = new Alert(AlertType.CONFIRMATION);
            error1Alert.setHeaderText("Avviso");
            error1Alert.setContentText("Ti sei candidato a questa offerta");
            error1Alert.showAndWait();
            throw new BusinessException(e);
		}
	}

	@Override
	public void deleteCandidacy(String email, String candidacyTitle) throws CandidacyNotFoundException, BusinessException {
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
    	}
     catch (IOException e) {
			e.printStackTrace();
	        Alert error2Alert = new Alert(AlertType.ERROR);
	        error2Alert.setHeaderText("ERRORE");
	        error2Alert.setContentText("Operazione rippata");
	        error2Alert.showAndWait();
			throw new BusinessException(e);
	    }
	}
}
