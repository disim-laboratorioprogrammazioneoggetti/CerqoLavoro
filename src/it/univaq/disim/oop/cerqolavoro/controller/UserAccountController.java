package it.univaq.disim.oop.cerqolavoro.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ResourceBundle;
import it.univaq.disim.oop.cerqolavoro.domain.User;
import it.univaq.disim.oop.cerqolavoro.domain.Worker;
import it.univaq.disim.oop.cerqolavoro.view.ViewDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
	private Worker worker;
  
    @Override
    public void initialize(URL location, ResourceBundle resources) {
     Font.loadFont(getClass().getResourceAsStream("src/Fonts/ahronbd.ttf"), 14);
      upBioArea.setEditable(false);
    }; 

	@Override
	public void initializeData(User user) {
		LocalDate birthDate = ((Worker) user).getBirthdate();
		String workerBirthdate = birthDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
	      // Setta le label con i dettagli dell'utente
	      upEmail.setText(user.getEmail());
	      int a = 0, b = 1, c = 2, d = 3, e = 4, f = 5, g = 6, h = 7, i = 8, j = 9, k = 10, l = 11, m = 12, n = 13, o = 14;		  
		  upName.setText(((Worker) user).getName());
		  upSurname.setText(((Worker) user).getSurname());
		  upBirth.setText(workerBirthdate);
		  upExp.setText(((Worker) user).getExperience());                 
		  upEducation.setText(((Worker) user).getEducation());
		  upCell.setText(String.valueOf(((Worker) user).getPhone()));
		  upRegion.setText(((Worker) user).getRegion());
		  upProvince.setText(((Worker) user).getProvince());
		  upCity.setText(((Worker) user).getCity());
		  upCap.setText(String.valueOf(((Worker) user).getCap()));
		  upAddress.setText(((Worker) user).getAddress());
		  upSector.setText(((Worker) user).getSector());
		  upBioArea.setText(((Worker) user).getBio());
		  
	} 
  
}