package it.univaq.disim.oop.cerqolavoro.business.impl.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileCerqoLavoroBusinessFactoryImpl;
import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.business.EmployerService;
import it.univaq.disim.oop.cerqolavoro.business.UserNotFoundException;
import it.univaq.disim.oop.cerqolavoro.business.UserService;
import it.univaq.disim.oop.cerqolavoro.business.WorkerService;
import it.univaq.disim.oop.cerqolavoro.domain.Employer;
import it.univaq.disim.oop.cerqolavoro.domain.User;
import it.univaq.disim.oop.cerqolavoro.domain.Worker;
import it.univaq.disim.oop.cerqolavoro.view.ViewDispatcher;
import it.univaq.disim.oop.cerqolavoro.view.ViewException;
import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileData;
import it.univaq.disim.oop.cerqolavoro.business.impl.file.Utility;
import it.univaq.disim.oop.cerqolavoro.business.impl.ram.RAMUserServiceImpl;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class FileUserServiceImpl implements UserService {
	private String userFilename;
//	private String workerFilename;
//	private String employerFilename;
	private UserService userService;

	public FileUserServiceImpl(String userFilename, UserService userService) {
		this.userFilename = userFilename;
	//	this.workerFilename = workerFilename;
	//	this.employerFilename = employerFilename;
		this.userService = userService;
	//	this.workerService = workerService;
	//	this.employerService = employerService;
	}
	
//	public Stage stage = new Stage();
	
	@Override
	public User authenticate(String email, String password) throws UserNotFoundException, BusinessException {
		try {
		  boolean workerCheck = false, employerCheck = false;
	      User user = null;
	      File u = new File(FileCerqoLavoroBusinessFactoryImpl.WORKER_FILE_DIRECTORY + email + ".csv");
	      File e = new File(FileCerqoLavoroBusinessFactoryImpl.EMPLOYER_FILE_DIRECTORY + email + ".csv");
	      
	      if (u.exists()) {
	    	  workerCheck = true;
	      } 
          if (e.exists()) {
	    	  employerCheck = true;
	      }
	      if (!u.exists() && !e.exists()) {
				Alert error1Alert = new Alert(AlertType.ERROR);
	            error1Alert.setHeaderText("ERRORE");
	            error1Alert.setContentText("Utente non trovato");
	            error1Alert.showAndWait();
	      }
	      
	      if ( workerCheck == true ) {
	      FileReader read = new FileReader(u);
	      String line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.WORKER_FILE_DIRECTORY + email + ".csv")).get(0);  
	      read.close();
	      if(line.equals(password)) {
	            user = new Worker();
	            user.setEmail(email);
	            user.setPassword(password);
	        } else {       
	                  Alert error2Alert = new Alert(AlertType.ERROR);
	                  error2Alert.setHeaderText("ERRORE");
	                  error2Alert.setContentText("RIP");
	                  error2Alert.showAndWait();
	          }		
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
	                  Alert error2Alert = new Alert(AlertType.ERROR);
	                  error2Alert.setHeaderText("ERRORE");
	                  error2Alert.setContentText("RIP");
	                  error2Alert.showAndWait();
	          }		
	      }
			return user;	
		}   catch (IOException e) {
			e.printStackTrace();
			Alert error1Alert = new Alert(AlertType.ERROR);
            error1Alert.setHeaderText("ERRORE");
            error1Alert.setContentText("1");
            error1Alert.showAndWait();
			throw new BusinessException(e);
		} 

	}
	
}