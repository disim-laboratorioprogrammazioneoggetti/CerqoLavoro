package it.univaq.disim.oop.cerqolavoro.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import it.univaq.disim.oop.cerqolavoro.business.BusinessException;
import it.univaq.disim.oop.cerqolavoro.business.CandidacyNotFoundException;
import it.univaq.disim.oop.cerqolavoro.business.CandidacyService;
import it.univaq.disim.oop.cerqolavoro.business.CerqoLavoroBusinessFactory;
import it.univaq.disim.oop.cerqolavoro.business.impl.ram.RAMCandidacyServiceImpl;
import it.univaq.disim.oop.cerqolavoro.domain.Candidacy;
import it.univaq.disim.oop.cerqolavoro.domain.User;
import it.univaq.disim.oop.cerqolavoro.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserCandidacyController implements Initializable, DataInitializable<User> {

    @FXML private Button uchBtn;
    @FXML private Button ucaBtn;
    @FXML private Button ucsBtn;
    @FXML private Pane candann1;
    @FXML private Button rc1Btn;
    @FXML private Label caGet1;
    @FXML private Pane candann2;
    @FXML private Button rc2Btn;
    @FXML private Label caGet2;
    @FXML private Pane candann3;
    @FXML private Button rc3Btn;
    @FXML private Label caGet3;
    @FXML private Pane candann4;
    @FXML private Button rc4Btn;
    @FXML private Label caGet4;
    @FXML private Label ucEmail;
    @FXML private Pane candann5;
    @FXML private Button rc5Btn;
    @FXML private Label caGet5;
    @FXML private Pane candann6;
    @FXML private Button rc6Btn;
    @FXML private Label caGet6;  
    @FXML private Button usrcCandidates;
    
    public Stage stage = new Stage();
    private ViewDispatcher dispatcher;   
	private User user;
	private CandidacyService candidacyService;
	private Candidacy candidacy;
	
	public UserCandidacyController() {
		dispatcher = ViewDispatcher.getInstance();
		candidacyService = new RAMCandidacyServiceImpl(candidacyService);
		CerqoLavoroBusinessFactory factory = CerqoLavoroBusinessFactory.getInstance();
		candidacyService = factory.getCandidacyService();
	}
	
	@Override
	public void initializeData(User user) {
	ucEmail.setText(user.getEmail());
	}
	
	// Ricerca candidature nel file
    
    @FXML
    void usrcCandidatesBtn(ActionEvent event) throws CandidacyNotFoundException, BusinessException {
        Pane risultato[] = { candann1, candann2, candann3, candann4, candann5, candann6 };
        String candidature[] = new String[6];
        Label adcand[] = { caGet1, caGet2, caGet3, caGet4, caGet5, caGet6 };
    	                try {
    	                    int i = 0, n = 0, k = 0;
    	                	for ( i = 0; i < 6; i++ ) {
	                			if ( risultato[i] != null ) {
	                			risultato[i].setVisible(false);
	                		    }
    	                	}
                            candidature = candidacyService.findCandidacy(ucEmail.getText().toString());
                            for ( i = 0; i < candidature.length; i++) {
                            	if ( candidature[i] != null ) {
                            		k++;
                            	}
                            }
    	    	                if ( k < 6 ) {
    	    	                	for ( i = k; i < 6; i++ ) {
    	    	                		risultato[i].setVisible(false);
    	    	                	}
    	    	                  }    	    	                
    	    	        if ( k != 0 ) {
    	    	            for ( i = 0; i < k; i++ ) {
    	                	  risultato[i].setVisible(true);
    	    	              adcand[i].setText(candidature[i]);
    	    	            } 
    	    	        }
    	                } catch (BusinessException e) {
                            e.printStackTrace();
                            throw new CandidacyNotFoundException(e);
                          }
                        }
    
    // Pulsanti ritira candidatura
    
    @FXML
    void rc1Button(ActionEvent event) throws CandidacyNotFoundException, IOException {
    	try {
            Pane risultato[] = { candann1, candann2, candann3, candann4, candann5, candann6 };
    		candidacyService.deleteCandidacy(ucEmail.getText().toString(), caGet1.getText().toString());
    	    risultato[0].setVisible(false);
    	}
     catch (Exception e) {
        e.printStackTrace();
     }
    }

    @FXML
    void rc2Button(ActionEvent event) throws CandidacyNotFoundException, IOException {
    	try {
            Pane risultato[] = { candann1, candann2, candann3, candann4, candann5, candann6 };
    		candidacyService.deleteCandidacy(ucEmail.getText().toString(), caGet1.getText().toString());
    	    risultato[1].setVisible(false);
    	}
     catch (Exception e) {
        e.printStackTrace();
     }
    }

    @FXML
    void rc3Button(ActionEvent event) throws CandidacyNotFoundException, IOException {
    	try {
            Pane risultato[] = { candann1, candann2, candann3, candann4, candann5, candann6 };
    		candidacyService.deleteCandidacy(ucEmail.getText().toString(), caGet1.getText().toString());
    	    risultato[2].setVisible(false);
    	}
     catch (Exception e) {
        e.printStackTrace();
     }
    }

    @FXML
    void rc4Button(ActionEvent event) throws CandidacyNotFoundException, IOException {
    	try {
            Pane risultato[] = { candann1, candann2, candann3, candann4, candann5, candann6 };
    		candidacyService.deleteCandidacy(ucEmail.getText().toString(), caGet1.getText().toString());
    	    risultato[3].setVisible(false);
    	}
     catch (Exception e) {
        e.printStackTrace();
     }
    }
    
    @FXML
    void rc5Button(ActionEvent event) throws CandidacyNotFoundException, IOException {
         try {
                Pane risultato[] = { candann1, candann2, candann3, candann4, candann5, candann6 };
        		candidacyService.deleteCandidacy(ucEmail.getText().toString(), caGet1.getText().toString());
        	    risultato[4].setVisible(false);
        	}
         catch (Exception e) {
            e.printStackTrace();
         }
    }
    
    @FXML
    void rc6Button(ActionEvent event) throws CandidacyNotFoundException, IOException {
         try {
                Pane risultato[] = { candann1, candann2, candann3, candann4, candann5, candann6 };
        		candidacyService.deleteCandidacy(ucEmail.getText().toString(), caGet1.getText().toString());
        	    risultato[5].setVisible(false);
        	}
         catch (Exception e) {
            e.printStackTrace();
         }
    }
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
      // Pane non visibili finché non si cerca
    	
      candann1.setVisible(false);
      candann2.setVisible(false);
      candann3.setVisible(false);
      candann4.setVisible(false);
      candann5.setVisible(false);
      candann6.setVisible(false);      
      ucEmail.setVisible(false); 
      
  	  assert uchBtn != null;
      assert ucaBtn != null;
      assert ucsBtn != null;
      
    }; 

}
