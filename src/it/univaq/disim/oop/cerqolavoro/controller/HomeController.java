package it.univaq.disim.oop.cerqolavoro.controller;

import java.net.URL;
import java.util.ResourceBundle;
import it.univaq.disim.oop.cerqolavoro.domain.Worker;
import it.univaq.disim.oop.cerqolavoro.domain.Employer;
import it.univaq.disim.oop.cerqolavoro.domain.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class HomeController implements Initializable, DataInitializable<User> {
	
	@FXML
	private Label benvenutoLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@Override
	public void initializeData(User user) {
		StringBuilder testo = new StringBuilder();
		testo.append("Benvenuto ");

		if (user instanceof Worker) {
			Worker worker = (Worker) user;
			testo.append(user.getEmail());
			testo.append(",");
			testo.append(" in cerca di lavoro? ");
		}
		if (user instanceof Employer) {
			Employer employer = (Employer) user;
			testo.append(user.getEmail());
			testo.append(",");
			testo.append(" in cerca di dipendenti? ");
		}
		benvenutoLabel.setText(testo.toString());
	}
}

