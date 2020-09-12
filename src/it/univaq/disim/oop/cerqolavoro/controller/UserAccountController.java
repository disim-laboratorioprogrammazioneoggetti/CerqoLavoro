package it.univaq.disim.oop.cerqolavoro.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileCerqoLavoroBusinessFactoryImpl;
import it.univaq.disim.oop.cerqolavoro.domain.User;
import it.univaq.disim.oop.cerqolavoro.view.ViewDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UserAccountController implements Initializable, DataInitializable<User> {

	@FXML private Label upName;
    @FXML private Label upSurname;
    @FXML private Label upEmail;
    @FXML private Label upBirth;
    @FXML private Label upCell;
    @FXML private Label upRegion;
    @FXML private Label upProvince;
    @FXML private Label upCity;
    @FXML private Label upCap;
    @FXML private Label upAddress;
    @FXML private Label upEducation;
    @FXML private Label upExp;
    @FXML private Label upSector;
    @FXML private TextArea upBioArea;
    
    public Stage stage = new Stage();    
    private ViewDispatcher dispatcher;    
	private User user;
  
    @Override
    public void initialize(URL location, ResourceBundle resources) {
     Font.loadFont(getClass().getResourceAsStream("src/Fonts/ahronbd.ttf"), 14);
      upBioArea.setEditable(false);
    }; 

	@Override
	public void initializeData(User user) {
	      upEmail.setText(user.getEmail());
	      
	      // Lettura informazioni da file
	      
		  try {
	          File u = new File(FileCerqoLavoroBusinessFactoryImpl.WORKER_FILE_DIRECTORY + upEmail.getText() + ".csv");
	    	  List<String> line;
			  line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.WORKER_FILE_DIRECTORY + upEmail.getText() + ".csv"), StandardCharsets.UTF_8);
	    	  
	    	  int a = 0, b = 1, c = 2, d = 3, e = 4, f = 5, g = 6, h = 7, i = 8, j = 9, k = 10, l = 11, m = 12, n = 13, o = 14;
	    	  
	    	  upName.setText(line.get(b));
	    	  upSurname.setText(line.get(c));
	          upEmail.setText(line.get(d));
	          upBirth.setText(line.get(e));
	          upExp.setText(line.get(f));                 
	          upEducation.setText(line.get(g));
	          upCell.setText(line.get(h));
	          upRegion.setText(line.get(i));
	          upProvince.setText(line.get(j));
	          upCity.setText(line.get(k));
	          upCap.setText(line.get(l));
	          upAddress.setText(line.get(m));
	          upSector.setText(line.get(n));
	          upBioArea.setText(line.get(o));
	    	  
			} catch (IOException e1) {
		        Alert errorAlert = new Alert(AlertType.ERROR);
	            errorAlert.setHeaderText("Errore");
	            errorAlert.setContentText("Utente non trovato");
	            errorAlert.showAndWait();
				e1.printStackTrace();
			}
	} 
  
}