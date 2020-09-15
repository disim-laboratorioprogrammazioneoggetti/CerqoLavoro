package it.univaq.disim.oop.cerqolavoro.business.impl.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
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
	    	  int a = 0, b = 1, c = 2, d = 4, f = 5, g = 6, h = 7, i = 8, j = 9, k = 10, l = 11, m = 12, n = 13, o = 14;
	    	  List<String> workerDetails;
	    	  workerDetails = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.WORKER_FILE_DIRECTORY + email + ".csv"), StandardCharsets.UTF_8);
	            user = new Worker();
	            user.setEmail(email);
	            user.setPassword(password); 	    	  
	            ((Worker) user).setName(workerDetails.get(b));
	            ((Worker) user).setSurname(workerDetails.get(c));
	            ((Worker) user).setBirthdate(LocalDate.parse(workerDetails.get(d)));
	            ((Worker) user).setExperience(workerDetails.get(f));                 
	            ((Worker) user).setEducation(workerDetails.get(g));
	            ((Worker) user).setPhone(Long.parseLong(workerDetails.get(h)));
	            ((Worker) user).setRegion(workerDetails.get(i));
	            ((Worker) user).setProvince(workerDetails.get(j));
	            ((Worker) user).setCity(workerDetails.get(k));
	            ((Worker) user).setCap(Integer.parseInt(workerDetails.get(l)));
	            ((Worker) user).setAddress(workerDetails.get(m));
	            ((Worker) user).setSector(workerDetails.get(n));
	            ((Worker) user).setBio(workerDetails.get(o));
	        } else {       
	        	 throw new UserNotFoundException(); }		
	      }	      
	      if ( employerCheck == true ) {
	      FileReader read = new FileReader(e);
	      String line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.EMPLOYER_FILE_DIRECTORY + email + ".csv")).get(0);  
	      read.close();
	      if(line.equals(password)) {
	    	  int a = 1, b = 2, c = 4, d = 5, f = 6, g = 7, h = 8, i = 9;
	    	  List<String> employerDetails;
	    	  employerDetails = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.EMPLOYER_FILE_DIRECTORY + email + ".csv"), StandardCharsets.UTF_8);
	            user = new Employer();
	            user.setEmail(email);
	            user.setPassword(password);
	            ((Employer) user).setName(employerDetails.get(a));
	            ((Employer) user).setSurname(employerDetails.get(b));
	            ((Employer) user).setCompanyEmail(employerDetails.get(c));
	            ((Employer) user).setCompanyName(employerDetails.get(d));                 
	            ((Employer) user).setIVA(Long.parseLong(employerDetails.get(f)));
	            ((Employer) user).setPhone(Long.parseLong(employerDetails.get(g)));
	            ((Employer) user).setCompanyPhone(Long.parseLong(employerDetails.get(h)));
	            ((Employer) user).setCompanyBio(employerDetails.get(i));
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