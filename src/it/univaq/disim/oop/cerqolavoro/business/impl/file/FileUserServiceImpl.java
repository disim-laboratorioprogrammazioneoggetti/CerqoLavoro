package it.univaq.disim.oop.cerqolavoro.business.impl.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.business.UserNotFoundException;
import it.univaq.disim.oop.cerqolavoro.business.UserService;
import it.univaq.disim.oop.cerqolavoro.domain.Employer;
import it.univaq.disim.oop.cerqolavoro.domain.User;
import it.univaq.disim.oop.cerqolavoro.domain.Worker;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FileUserServiceImpl implements UserService {
	private String userFilename;
	private UserService userService;

	public FileUserServiceImpl(String userFilename, UserService userService) {
		this.userFilename = userFilename;
		this.userService = userService;
	}
	
	@Override
	public User authenticate(String email, String password) throws UserNotFoundException, BusinessException {
		try {
		  boolean workerCheck = false, employerCheck = false;
	      User user = null;
	      File u = new File(FileCerqoLavoroBusinessFactoryImpl.WORKER_FILE_DIRECTORY + email + ".csv");
	      File e = new File(FileCerqoLavoroBusinessFactoryImpl.EMPLOYER_FILE_DIRECTORY + email + ".csv");
	      // Ricerca utente
	      if (u.exists()) {
	    	  workerCheck = true; } 
          if (e.exists()) {
	    	  employerCheck = true; }
	      if (!u.exists() && !e.exists()) {
      	    throw new UserNotFoundException();
	      }	      
	      // Verifica password
	      if ( workerCheck == true ) {
	      FileReader read = new FileReader(u);
	      String line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.WORKER_FILE_DIRECTORY + email + ".csv")).get(0);  
	      read.close();
	      if(line.equals(password)) {
	            user = new Worker();
	            user.setEmail(email);
	            user.setPassword(password); 
	        } else {       
	        	 throw new UserNotFoundException(); }		
	      }	      
	      if ( employerCheck == true ) {
	      FileReader read = new FileReader(e);
	      String line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.EMPLOYER_FILE_DIRECTORY + email + ".csv")).get(0);  
	      read.close();
	      if(line.equals(password)) {
	            user = new Employer();
	            user.setEmail(email);
	            user.setPassword(password);
	        } else {       
	        	 throw new UserNotFoundException(); }		
	      }
			return user;	
		}   catch (IOException e) {
			e.printStackTrace();
			throw new BusinessException(e);
		} 
	}
	
}