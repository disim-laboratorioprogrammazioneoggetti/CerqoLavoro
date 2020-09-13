package it.univaq.disim.oop.cerqolavoro.controller;

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
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import it.univaq.disim.oop.cerqolavoro.business.CerqoLavoroBusinessFactory;
import it.univaq.disim.oop.cerqolavoro.business.OfferService;
import it.univaq.disim.oop.cerqolavoro.business.impl.file.FileCerqoLavoroBusinessFactoryImpl;
import it.univaq.disim.oop.cerqolavoro.business.impl.ram.RAMOfferServiceImpl;
import it.univaq.disim.oop.cerqolavoro.domain.Offer;
import it.univaq.disim.oop.cerqolavoro.domain.User;
import it.univaq.disim.oop.cerqolavoro.view.ViewDispatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HireController implements Initializable, DataInitializable<User> {

// Pane annunci
	
@FXML private Pane Annuncio1;
@FXML private Pane Annuncio2;
@FXML private Pane Annuncio3;

// Bottoni

@FXML private Button ShowOfferbtn;
@FXML private Button Editbtn1;
@FXML private Button Editbtn2;
@FXML private Button Editbtn3;
@FXML private Button Removebtn;
@FXML private Button Removebtn1;
@FXML private Button Removebtn11;

// ChoiceBox Annuncio n. 1
@FXML private ChoiceBox<String> EditRetxTField;
@FXML private ChoiceBox<String> EditSectorBOx;
@FXML private ChoiceBox<String> EditTypeContBox;
@FXML private ChoiceBox<String> EditTimeContBox;
@FXML private ChoiceBox<String> EditRegionBox;
@FXML private ChoiceBox<String> EditExpbox;
// ChoiceBox Annuncio n. 2
@FXML private ChoiceBox<String> EditTypeContBox1;
@FXML private ChoiceBox<String> EditTimeContBox1;
@FXML private ChoiceBox<String> EditRegionBox1;
@FXML private ChoiceBox<String> EditRetxTField1;
@FXML private ChoiceBox<String> EditSectorBOx1;
@FXML private ChoiceBox<String> EditExpbox1;
// ChoiceBox Annuncio n. 3
@FXML private ChoiceBox<String> EditSectorBOx11;
@FXML private ChoiceBox<String> EditRetxTField11;
@FXML private ChoiceBox<String> EditTypeContBox11;
@FXML private ChoiceBox<String> EditTimeContBox11;
@FXML private ChoiceBox<String> EditRegionBox11;
@FXML private ChoiceBox<String> EditExpbox11;

@FXML private Label eoEmail;

// Label Annuncio n. 1
@FXML private Label TitleLabel;
@FXML private Label PositionLabel;
@FXML private Label ContractTypeLabel;
@FXML private Label ContractTimeLabel;
@FXML private Label RetributionLabel;
@FXML private Label SectorLabel;
@FXML private Label RegionLabel;
@FXML private Label RetxTLabel;
@FXML private Label DegreeLabel;
@FXML private Label BonusLabel;
@FXML private Label ExpLabel;
// Label Annuncio n. 2
@FXML private Label TitleLabel1;
@FXML private Label PositionLabel1;
@FXML private Label ContractTypeLabel1;
@FXML private Label ContractTimeLabel1;
@FXML private Label RetributionLabel1;
@FXML private Label SectorLabel1;
@FXML private Label RegionLabel1;
@FXML private Label RetxTLabel1;
@FXML private Label DegreeLabel1;
@FXML private Label BonusLabel1;
@FXML private Label ExpLabel1;
// Label Annuncio n. 3
@FXML private Label TitleLabel11;
@FXML private Label PositionLabel11;
@FXML private Label ContractTypeLabel11;
@FXML private Label ContractTimeLabel11;
@FXML private Label RetributionLabel11;
@FXML private Label SectorLabel11;
@FXML private Label RegionLabel11;
@FXML private Label RetxTLabel11;
@FXML private Label DegreeLabel11;
@FXML private Label BonusLabel11;
@FXML private Label ExpLabel11;

// TextArea annunci
@FXML private TextArea EditWorkInfoArea;
@FXML private TextArea EditWorkInfoArea1;
@FXML private TextArea EditWorkInfoArea11;

// TextArea Annuncio n. 1
@FXML private TextField EditTitleField;
@FXML private TextField EditPositionField;
@FXML private TextField EditRetribution;
@FXML private TextField EditDegreeField;
@FXML private TextField EditBonusField;
// TextArea Annuncio n. 2
@FXML private TextField EditTitleField1;
@FXML private TextField EditPositionField1;
@FXML private TextField EditRetribution1;
@FXML private TextField EditDegreeField1;
@FXML private TextField EditBonusField1;
// TextArea Annuncio n. 3
@FXML private TextField EditTitleField11;
@FXML private TextField EditPositionField11;
@FXML private TextField EditRetribution11;
@FXML private TextField EditDegreeField11;
@FXML private TextField EditBonusField11;

// Candidature Annuncio n. 1
@FXML private Label candTitle1;
@FXML private Label c1p1;
@FXML private Label mailc1p1;
@FXML private Label c2p1;
@FXML private Label mailc2p1;
@FXML private Label c3p1;
@FXML private Label mailc3p1;
// Candidature Annuncio n. 2
@FXML private Label candTitle2;
@FXML private Label c1p2;
@FXML private Label mailc1p2;
@FXML private Label c2p2;
@FXML private Label mailc2p2;
@FXML private Label c3p2;
@FXML private Label mailc3p2;
// Candidature Annuncio n. 3
@FXML private Label candTitle3;
@FXML private Label c1p3;
@FXML private Label mailc1p3;
@FXML private Label c2p3;
@FXML private Label mailc2p3;
@FXML private Label mailc3p3;
@FXML private Label c3p3;

private ViewDispatcher dispatcher;
private User user;
public Stage stage = new Stage();
private OfferService offerService;
private Offer offer;

public HireController() {
	dispatcher = ViewDispatcher.getInstance();
	offerService = new RAMOfferServiceImpl(offerService);
	CerqoLavoroBusinessFactory factory = CerqoLavoroBusinessFactory.getInstance();
	offerService = factory.getOfferService();
}

@Override
public void initializeData(User user) {
      eoEmail.setText(user.getEmail());
}

// Bottone mostra offerte pubblicate

@FXML void ShowOffer(ActionEvent event4) throws IOException {

	//check se esiste il file
	boolean OfferFileExistCheck = false;
	File offerCheck = new File(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME);
	  OfferFileExistCheck = offerCheck.exists();

	  if (OfferFileExistCheck == false) {
	    Alert errorAlert = new Alert(AlertType.ERROR);
	      errorAlert.setHeaderText("ERRORE: Non Hai Creato Annunci");
	      errorAlert.setContentText("Non hai creato alcun Annuncio,clicca sul pulsante 'Crea un Annuncio' per crearne uno");
	      errorAlert.showAndWait();
	  }
	  
	//array
	  if (OfferFileExistCheck == true) {
	//Pane
	Pane annunci[] = { Annuncio1, Annuncio2, Annuncio3};
	//textarea
	TextArea embio[] = {EditWorkInfoArea,EditWorkInfoArea1,EditWorkInfoArea11};
	//label
	Label Titoli[] = { TitleLabel,TitleLabel1,TitleLabel11};
	Label Posizioni[] = {PositionLabel,PositionLabel1,PositionLabel11};
	Label TipoContratto[] = {ContractTypeLabel,ContractTypeLabel1,ContractTypeLabel11}; 
	Label TempoContratto[] = {ContractTimeLabel,ContractTimeLabel1,ContractTimeLabel11};
	Label Retribuzioni[] = {RetributionLabel,RetributionLabel1,RetributionLabel11};
	Label Settori[] = {SectorLabel,SectorLabel1,SectorLabel11};
	Label Regioni[] = {RegionLabel,RegionLabel1,RegionLabel11};
	Label RetxTempo[] = {RetxTLabel,RetxTLabel1,RetxTLabel11};
	Label Bonus [] = {BonusLabel,BonusLabel1,BonusLabel11};
	Label Studi[] = {DegreeLabel,DegreeLabel1,DegreeLabel11};
	Label Esperienze[] = {ExpLabel,ExpLabel1,ExpLabel11};
	//String
	String listatitoli[] = new String [3];
	String listaposizioni[] = new String [3];
	String listatipocontratto[] = new String [3];
	String listatempocontratto[] = new String [3];
	String listaretribuzioni[] = new String [3];
	String listasettori[] = new String [3];
	String listaregioni[] = new String [3];
	String listaRextempo[] = new String [3];
	String listaStudi[] = new String [3];
	String listaBonus[] = new String [3];
	String listaBio[] = new String [3];  
	String listaExp[] = new String [3];

	BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME));
	int lines = 0;
	while (reader.readLine() != null) {
	  lines++;
	}
	reader.close();
	int cont = lines / 13;
	BufferedReader read = new BufferedReader(
	          new InputStreamReader(
	              new FileInputStream(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME)));
	 List<String> line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME));
	 int i = 0, k = 0, j = 0, p = 1, q = 2, email = 3, r = 4, s = 5, t = 6, u = 7, w = 8, v = 9, x = 10, y = 11, z = 12;
	 try {   
		  while ( ( line != null ) && ( i < cont ) && ( k < 3 )) {
			if ( line.get(email).equals(eoEmail.getText().toString()) ) {
		    listaregioni[k] = line.get(j);
		    listasettori[k] = line.get(p);
		    listatitoli[k] = line.get(q);
		    listaposizioni[k] = line.get(r);
		    listatipocontratto[k] = line.get(s);
		    listatempocontratto[k] = line.get(t);
		    listaretribuzioni[k] = line.get(u);
		    listaRextempo[k] = line.get(v);
		    listaStudi[k] = line.get(y);
		    listaBonus[k] = line.get(x);
		    listaBio[k] = line.get(z);
		    listaExp[k] = line.get(w);
		    k++;
		    }
		    i++; j += 13; p += 13; q += 13; email += 13; r += 13; s += 13; t += 13; u += 13; v += 13; x += 13; y += 13; z += 13;
		  }
		  if ( k < 3 ) {
		  for ( i = k; i < 3; i++ ) {
		    annunci[i].setVisible(false); }
		  }
		  for ( i = 0; i < k ; i++ ) {   
		     annunci[i].setVisible(true);
		     Titoli[i].setText(listatitoli[i]);
		     Posizioni[i].setText(listaposizioni[i]);
		     Settori[i].setText(listasettori[i]);
		     Regioni[i].setText(listaregioni[i]);
		     TipoContratto[i].setText(listatipocontratto[i]); 
		     TempoContratto[i].setText(listatempocontratto[i]);
		     Retribuzioni[i].setText(listaretribuzioni[i]);
		     RetxTempo[i].setText(listaRextempo[i]);
		     Studi[i].setText(listaStudi[i]);
		     Bonus[i].setText(listaBonus[i]);
		     embio[i].setText(listaBio[i]);
		     Esperienze[i].setText(listaExp[i]);
		  }
		  read.close();
		    } catch (FileNotFoundException ex) {
		   ex.printStackTrace();
		    } catch (IOException ex) {
		   ex.printStackTrace(); }
		    }
		}

// Bottoni per modifica offerte

@FXML void editbtnpushed(ActionEvent event5) {	
	Label Orig[] = { TitleLabel, PositionLabel, RetributionLabel, DegreeLabel, BonusLabel, ContractTypeLabel, ContractTimeLabel, SectorLabel, RegionLabel, RetxTLabel, ExpLabel };
	int i = 0, k = -1;
	TextField TxtEd[] = { EditTitleField, EditPositionField, EditRetribution, EditDegreeField, EditBonusField };
	ChoiceBox ChbEd[] = { EditTypeContBox, EditTimeContBox, EditSectorBOx, EditRegionBox, EditRetxTField, EditExpbox };
	String preset[] = { "Modifica Tipo Contratto", "Modifica Tempo Contratto", "Modifica Settore", "Modifica Regione", 
			"Modifica Tempo Retribuzione", "Modifica Esperienza" };
	String s1[] = new String [12];	
	for ( i = 0; i < 11; i++ ) {
	if ( i < 5 ) { 
		if (!TxtEd[i].getText().isEmpty()) {
		s1[i] = TxtEd[i].getText().toString(); }
	else { s1[i] = Orig[i].getText().toString(); }
	} 
	if ( i > 4 ) { 
		++k;
		 if (  !ChbEd[k].getValue().toString().contentEquals(preset[k])) {
			s1[i] = ChbEd[k].getValue().toString(); }
		else { s1[i] = Orig[i].getText().toString(); } 
		}
	}   s1[11] = EditWorkInfoArea.getText().toString(); 
		k = -1;
	for ( i = 0; i < 11; i++ ) {
		if ( i < 5 ) { TxtEd[i].setText(s1[i]); } 
		if ( i > 4 ) { 
			++k;
			ChbEd[k].setValue(s1[i]); }
	}  	
	try {
		int n = 0, j = 0, p = 1, q = 2, email = 3, r = 4, s = 5, t = 6, u = 7, w = 8, v = 9, x = 10, y = 11, z = 12; i = 0; k = 0; 
	  BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME));
	      int lines = 0;
	      while (reader.readLine() != null) {
	        lines++; }
	      reader.close(); int cont = lines / 13;
	      File f = new File(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME);
  	    StringBuilder sb = new StringBuilder();
  	    try (Scanner sc = new Scanner(f)) {
  	        String currentLine;
  	        boolean trovato = false;
  	        while ( sc.hasNext() && n < (lines) ) {
  	            currentLine = sc.nextLine();
  	            if ( n == j ) { sb.append(EditRegionBox.getValue().toString()+"\n"); }
	            if ( n == p ) { sb.append(EditSectorBOx.getValue().toString()+"\n"); }
	            if ( n == q ) { sb.append(EditTitleField.getText().toString()+"\n"); }
  	            if ( n == r ) { sb.append(EditPositionField.getText().toString()+"\n"); }
  	            if ( n == s ) { sb.append(EditTypeContBox.getValue().toString()+"\n"); }
  	            if ( n == t ) { sb.append(EditTimeContBox.getValue().toString()+"\n"); }
  	            if ( n == u ) { sb.append(EditRetribution.getText().toString()+"\n"); }
  	            if ( n == v ) { sb.append(EditExpbox.getValue().toString()+"\n"); }
  	            if ( n == w ) { sb.append(EditRetxTField.getValue().toString()+"\n"); }
  	            if ( n == x ) { sb.append(EditBonusField.getText().toString()+"\n"); }
  	            if ( n == y ) { sb.append(EditDegreeField.getText().toString()+"\n"); }
  	            if ( n == z ) { sb.append(EditWorkInfoArea.getText().toString()+"\n"); }
  	          if ( n != j && n != p && n != q && n != r && n != s && n != t && n != u && n != v && n != w && n != x && n != y && n != z ) {
  	        	if ( n == (lines-1) ) { sb.append(currentLine); }
	            	else { sb.append(currentLine).append("\n"); }
  	            } n++; 
  	            }
  	    }
  	    PrintWriter pw = new PrintWriter(f); pw.close();
  	    BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
  	    writer.append(sb.toString()); writer.close(); 	    
  		if ( !EditTitleField.getText().isEmpty() ) { TitleLabel.setText(EditTitleField.getText()); } 		
  		if ( !EditPositionField.getText().isEmpty() ) { PositionLabel.setText(EditPositionField.getText()); }  		
  		if ( !EditTypeContBox.getValue().contentEquals("Modifica Tipo Contratto") ) { ContractTypeLabel.setText(EditTypeContBox.getValue()); }  		
  		if ( !EditTimeContBox.getValue().contentEquals("Modifica Tempo Contratto") ) { ContractTimeLabel.setText(EditTimeContBox.getValue()); }  		
  		if ( !EditRetribution.getText().isEmpty()) { RetributionLabel.setText(EditRetribution.getText() ); }  		
  		if ( !EditSectorBOx.getValue().contentEquals("Modifica Settore") ) { SectorLabel.setText(EditSectorBOx.getValue()); }  		
  		if ( !EditRegionBox.getValue().contentEquals("Modifica Regione") ) { RegionLabel.setText(EditRegionBox.getValue()); } 		
  		if ( !EditRetxTField.getValue().contentEquals("Modifica Tempo Retribuzione") ) { RetxTLabel.setText(EditRetxTField.getValue()); } 		
  		if ( !EditBonusField.getText().isEmpty() ) { BonusLabel.setText(EditBonusField.getText()); }  		
  		if ( !EditDegreeField.getText().isEmpty() ) { DegreeLabel.setText(EditDegreeField.getText()); }		    
        Alert offmodAlert = new Alert(AlertType.CONFIRMATION);
        offmodAlert.setHeaderText("Operazione completata");
        offmodAlert.setContentText("Hai modificato questa offerta");
        offmodAlert.showAndWait();    
	} catch (Exception e) {
	    e.printStackTrace();
        Alert ripmodAlert = new Alert(AlertType.ERROR);
        ripmodAlert.setHeaderText("Attenzione");
        ripmodAlert.setContentText("Si è verificato un errore");
        ripmodAlert.showAndWait();
	} 
}

@FXML void editbtn2pushed(ActionEvent event6) {
	
	Label Orig[] = { TitleLabel1, PositionLabel1, RetributionLabel1, DegreeLabel1, BonusLabel1, ContractTypeLabel1, ContractTimeLabel1, SectorLabel1, RegionLabel1, RetxTLabel1, ExpLabel1 };
    int i = 0, k = -1;
	TextField TxtEd[] = { EditTitleField1, EditPositionField1, EditRetribution1, EditDegreeField1, EditBonusField1 };
	ChoiceBox ChbEd[] = { EditTypeContBox1, EditTimeContBox1, EditSectorBOx1, EditRegionBox1, EditRetxTField, EditExpbox1 };
	String preset[] = { "Modifica Tipo Contratto", "Modifica Tempo Contratto", "Modifica Settore", "Modifica Regione", 
			"Modifica Tempo Retribuzione", "Modifica Esperienza" };
	String s1[] = new String [12];	
	for ( i = 0; i < 11; i++ ) {
		if ( i < 5 ) {
		if (!TxtEd[i].getText().isEmpty()) {
			s1[i] = TxtEd[i].getText().toString(); }
		else {
			s1[i] = Orig[i].getText().toString(); }
		} 
		if ( i > 4 ) {
			 ++k;
			 if (  !ChbEd[k].getValue().toString().contentEquals(preset[k])) {
				s1[i] = ChbEd[k].getValue().toString(); }
			else {
				s1[i] = Orig[i].getText().toString(); } 
			}
		}	      
			s1[11] = EditWorkInfoArea1.getText().toString();	
		k = -1;
		for ( i = 0; i < 11; i++ ) {
			if ( i < 5 ) {
				TxtEd[i].setText(s1[i]);
			} 
			if ( i > 4 ) {
				++k;
				ChbEd[k].setValue(s1[i]);
			}
		}  		
		try {
			int n = 0, j = 0, p = 1, q = 2, email = 3, r = 4, s = 5, t = 6, u = 7, w = 8, v = 9, x = 10, y = 11, z = 12; i = 0; k = 0; 
		  BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME));
		      int lines = 0;
		      while (reader.readLine() != null) {
		        lines++; }
		      reader.close(); int cont = lines / 13;
		      File f = new File(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME);
	  	    StringBuilder sb = new StringBuilder();
	  	    try (Scanner sc = new Scanner(f)) {
	  	        String currentLine;
	  	        boolean trovato = false;
	  	        while ( sc.hasNext() && n < (lines) ) {
	  	            currentLine = sc.nextLine();
	  	            if ( n == j ) { 
	  	            	sb.append(EditRegionBox1.getValue().toString()+"\n"); }
		            if ( n == p ) { 
	  	  	            sb.append(EditSectorBOx1.getValue().toString()+"\n"); }
		            if ( n == q ) { 
	  	  	            sb.append(EditTitleField1.getText().toString()+"\n"); }
	  	            if ( n == r ) {
	  	            	sb.append(EditPositionField1.getText().toString()+"\n"); }
	  	            if ( n == s ) {
	  	            	sb.append(EditTypeContBox1.getValue().toString()+"\n"); }
	  	            if ( n == t ) {
	  	            	sb.append(EditTimeContBox1.getValue().toString()+"\n"); }
	  	            if ( n == u ) {
	  	            	sb.append(EditRetribution1.getText().toString()+"\n"); }
	  	            if ( n == v ) {
	  	            	sb.append(EditExpbox1.getValue().toString()+"\n"); }
	  	            if ( n == w ) {
	  	            	sb.append(EditRetxTField1.getValue().toString()+"\n"); }
	  	            if ( n == x ) {
	  	            	sb.append(EditBonusField1.getText().toString()+"\n"); }
	  	            if ( n == y ) {
	  	            	sb.append(EditDegreeField1.getText().toString()+"\n"); }
	  	            if ( n == z ) {
	  	            	sb.append(EditWorkInfoArea1.getText().toString()+"\n"); }
	  	          if ( n != j && n != p && n != q && n != r && n != s && n != t && n != u && n != v && n != w && n != x && n != y && n != z ) {
	  	        	if ( n == (lines-1) ) {
	                     sb.append(currentLine); }
		            	else {
		      	            sb.append(currentLine).append("\n"); }
	  	            }  n++;
	  	        }
	  	    }
  	    PrintWriter pw = new PrintWriter(f);
  	    pw.close();
  	    BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
  	    writer.append(sb.toString());
  	    writer.close(); 	    
  		if ( !EditTitleField1.getText().isEmpty() ) {
  			TitleLabel1.setText(EditTitleField1.getText()); }  		
  		if ( !EditPositionField1.getText().isEmpty() ) { 
  			PositionLabel1.setText(EditPositionField1.getText()); }  		
  		if ( !EditTypeContBox1.getValue().contentEquals("Modifica Tipo Contratto") ) { 
  			ContractTypeLabel1.setText(EditTypeContBox1.getValue()); } 		
  		if ( !EditTimeContBox1.getValue().contentEquals("Modifica Tempo Contratto") ) {
            ContractTimeLabel1.setText(EditTimeContBox1.getValue()); } 		
  		if ( !EditRetribution1.getText().isEmpty()) {
  			RetributionLabel1.setText(EditRetribution1.getText() ); }  		
  		if ( !EditSectorBOx1.getValue().contentEquals("Modifica Settore") ) {
  			SectorLabel1.setText(EditSectorBOx1.getValue()); }  		
  		if ( !EditRegionBox1.getValue().contentEquals("Modifica Regione") ) { 
  			RegionLabel1.setText(EditRegionBox1.getValue()); }  		
  		if ( !EditRetxTField1.getValue().contentEquals("Modifica Tempo Retribuzione") ) {
  		    RetxTLabel1.setText(EditRetxTField1.getValue()); }  		
  		if ( !EditBonusField1.getText().isEmpty() ) {
  			BonusLabel1.setText(EditBonusField1.getText()); } 		
  		if ( !EditDegreeField1.getText().isEmpty() ) {
  			DegreeLabel1.setText(EditDegreeField1.getText()); }	
  	    
        Alert offmodAlert = new Alert(AlertType.CONFIRMATION);
        offmodAlert.setHeaderText("Operazione completata");
        offmodAlert.setContentText("Hai modificato questa offerta");
        offmodAlert.showAndWait();  	    
	} catch (Exception e) {
	    e.printStackTrace();
        Alert ripmodAlert = new Alert(AlertType.ERROR);
        ripmodAlert.setHeaderText("Attenzione");
        ripmodAlert.setContentText("Si è verificato un errore");
        ripmodAlert.showAndWait();
	}
}

@FXML void editbtn3pushed(ActionEvent event7) {
	
	Label Orig[] = { TitleLabel11, PositionLabel11, RetributionLabel11, DegreeLabel11, BonusLabel11, ContractTypeLabel11, ContractTimeLabel11, SectorLabel11, RegionLabel11, RetxTLabel11, ExpLabel11 };
	int i = 0, k = -1;
	TextField TxtEd[] = { EditTitleField11, EditPositionField11, EditRetribution11, EditDegreeField11, EditBonusField11 };
	ChoiceBox ChbEd[] = { EditTypeContBox11, EditTimeContBox11, EditSectorBOx11, EditRegionBox11, EditRetxTField11, EditExpbox11 };
	String preset[] = { "Modifica Tipo Contratto", "Modifica Tempo Contratto", "Modifica Settore", "Modifica Regione", 
			"Modifica Tempo Retribuzione", "Modifica Esperienza" };
	String s1[] = new String [12];	
	for ( i = 0; i < 11; i++ ) {
		if ( i < 5 ) {
		if (!TxtEd[i].getText().isEmpty()) {
			s1[i] = TxtEd[i].getText().toString(); }
		else {
			s1[i] = Orig[i].getText().toString(); }
		} 
		if ( i > 4 ) {
			 ++k;
			 if (  !ChbEd[k].getValue().toString().contentEquals(preset[k])) {
				s1[i] = ChbEd[k].getValue().toString(); }
			else {
				s1[i] = Orig[i].getText().toString(); } 
			}
		}	      
			s1[11] = EditWorkInfoArea11.getText().toString();		
		k = -1;
		for ( i = 0; i < 11; i++ ) {
			if ( i < 5 ) {
				TxtEd[i].setText(s1[i]); } 
			if ( i > 4 ) {
				++k;
				ChbEd[k].setValue(s1[i]); }
		}  
		try {
			int n = 0, j = 0, p = 1, q = 2, email = 3, r = 4, s = 5, t = 6, u = 7, w = 8, v = 9, x = 10, y = 11, z = 12; i = 0; k = 0; 
		  BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME));
		      int lines = 0;
		      while (reader.readLine() != null) {
		        lines++; }
		      reader.close(); int cont = lines / 13;
		      File f = new File(FileCerqoLavoroBusinessFactoryImpl.OFFERS_FILE_NAME);
	  	    StringBuilder sb = new StringBuilder();
	  	    try (Scanner sc = new Scanner(f)) {
	  	        String currentLine;
	  	        boolean trovato = false;
	  	        while ( sc.hasNext() && n < (lines) ) {
	  	            currentLine = sc.nextLine();
	  	            if ( n == j ) { 
	  	            	sb.append(EditRegionBox11.getValue().toString()+"\n"); }
		            if ( n == p ) { 
	  	  	            sb.append(EditSectorBOx11.getValue().toString()+"\n"); }
		            if ( n == q ) { 
	  	  	            sb.append(EditTitleField11.getText().toString()+"\n"); }
	  	            if ( n == r ) {
	  	            	sb.append(EditPositionField11.getText().toString()+"\n"); }
	  	            if ( n == s ) {
	  	            	sb.append(EditTypeContBox11.getValue().toString()+"\n"); }
	  	            if ( n == t ) {
	  	            	sb.append(EditTimeContBox11.getValue().toString()+"\n"); }
	  	            if ( n == u ) {
	  	            	sb.append(EditRetribution11.getText().toString()+"\n"); }
	  	            if ( n == v ) {
	  	            	sb.append(EditExpbox11.getValue().toString()+"\n"); }
	  	            if ( n == w ) {
	  	            	sb.append(EditRetxTField11.getValue().toString()+"\n"); }
	  	            if ( n == x ) {
	  	            	sb.append(EditBonusField11.getText().toString()+"\n"); }
	  	            if ( n == y ) {
	  	            	sb.append(EditDegreeField11.getText().toString()+"\n"); }
	  	            if ( n == z ) {
	  	            	sb.append(EditWorkInfoArea11.getText().toString()+"\n"); }
	  	          if ( n != j && n != p && n != q && n != r && n != s && n != t && n != u && n != v && n != w && n != x && n != y && n != z ) {
	  	        	if ( n == (lines-1) ) {
	                     sb.append(currentLine); }
		            	else {
		      	            sb.append(currentLine).append("\n"); }
	  	            }  n++;
	  	        }
	  	    }
  	    PrintWriter pw = new PrintWriter(f);
  	    pw.close();
  	    BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
  	    writer.append(sb.toString());
  	    writer.close();	    
  		if ( !EditTitleField11.getText().isEmpty() ) {
  			TitleLabel11.setText(EditTitleField11.getText()); } 		
  		if ( !EditPositionField11.getText().isEmpty() ) { 
  			PositionLabel11.setText(EditPositionField11.getText()); }  		
  		if ( !EditTypeContBox11.getValue().contentEquals("Modifica Tipo Contratto") ) { 
  			ContractTypeLabel11.setText(EditTypeContBox11.getValue()); }  		
  		if ( !EditTimeContBox11.getValue().contentEquals("Modifica Tempo Contratto") ) {
            ContractTimeLabel11.setText(EditTimeContBox11.getValue()); }  		
  		if ( !EditRetribution11.getText().isEmpty()) {
  			RetributionLabel11.setText(EditRetribution11.getText() ); }  		
  		if ( !EditSectorBOx11.getValue().contentEquals("Modifica Settore") ) {
  			SectorLabel11.setText(EditSectorBOx11.getValue()); }  		
  		if ( !EditRegionBox11.getValue().contentEquals("Modifica Regione") ) { 
  			RegionLabel11.setText(EditRegionBox11.getValue()); }  		
  		if ( !EditRetxTField11.getValue().contentEquals("Modifica Tempo Retribuzione") ) {
  		    RetxTLabel11.setText(EditRetxTField11.getValue()); }  		
  		if ( !EditBonusField11.getText().isEmpty() ) {
  			BonusLabel11.setText(EditBonusField11.getText()); }  		
  		if ( !EditDegreeField11.getText().isEmpty() ) {
  			DegreeLabel11.setText(EditDegreeField11.getText()); }	
  		
        Alert offmodAlert = new Alert(AlertType.CONFIRMATION);
        offmodAlert.setHeaderText("Operazione completata");
        offmodAlert.setContentText("Hai modificato questa offerta");
        offmodAlert.showAndWait(); 	    
	} catch (Exception e) {
	    e.printStackTrace();
        Alert ripmodAlert = new Alert(AlertType.ERROR);
        ripmodAlert.setHeaderText("Attenzione");
        ripmodAlert.setContentText("Si è verificato un errore");
        ripmodAlert.showAndWait();
	}
}

// Bottoni per eliminare offerte

@FXML void Removebtnpushed1(ActionEvent event8) throws FileNotFoundException, IOException {
	  try {
	      Pane annunci[] = { Annuncio1, Annuncio2, Annuncio3};
	      offerService.deleteOffer(TitleLabel.getText().toString(), eoEmail.getText().toString());
	      annunci[0].setVisible(false);
	  } catch (Exception e) {
	    e.printStackTrace(); }
	}

@FXML void Removebtnpushed2(ActionEvent event9) throws FileNotFoundException, IOException {
	  try {
	      Pane annunci[] = { Annuncio1, Annuncio2, Annuncio3};
	      offerService.deleteOffer(TitleLabel1.getText().toString(), eoEmail.getText().toString());
	      annunci[1].setVisible(false);
	  } catch (Exception e) {
	    e.printStackTrace(); }
	}

@FXML void Removebtnpushed3(ActionEvent event10) throws FileNotFoundException, IOException {
	  try {
	      Pane annunci[] = { Annuncio1, Annuncio2, Annuncio3};
	      offerService.deleteOffer(TitleLabel11.getText().toString(), eoEmail.getText().toString());
	      annunci[2].setVisible(false);
	  } catch (Exception e) {
	    e.printStackTrace(); }
	}

// Pulsanti mostra lista candidati

@FXML void showclist1(MouseEvent event) throws IOException {
int i = 0, n = 0, k = 0;
String candidature1[] = new String[3];
String emailcandidature1[] = new String[3];
Label candidati1[] = { c1p1, c2p1, c3p1 } ;
Label emailcandidati1[] = { mailc1p1, mailc2p1, mailc3p1 } ;
try {
	BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME));
	int lines = 0;
	while (reader.readLine() != null) {
		lines++; }
	reader.close();
	int cont = lines / 2;	
	for ( i = 0; i < 3; i++ ) {
		if ( candidati1[i] != null ) {
			candidati1[i].setVisible(false); }
	}	
	BufferedReader read = new BufferedReader(
	        new InputStreamReader(
	            new FileInputStream(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME), StandardCharsets.UTF_8));
    List<String> line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME), StandardCharsets.UTF_8);
    int j = 0, m = 1;
	candidates:
    while ( line != null && n < cont ) {
    	if ( k < 3 ) {
                if ( line.get(m).equals( TitleLabel1.getText().toString() )) {
                     emailcandidature1[k] = line.get(j).toString();
                     candidature1[k] = line.get(j).toString();
                     k++; }
           }
           else {
                break candidates; }
         j += 2; m += 2; n++;
        }
        read.close();
            if ( k < 3 ) {
            	for ( i = k; i < 3; i++ ) {
            		candidati1[i].setVisible(false);
            	}
              }           
        if ( k != 0 ) {
        for ( i = 0; i < k; i++ ) {
          candidati1[i].setVisible(true);
          emailcandidati1[i].setText(emailcandidature1[i]);
          candidati1[i].setText(candidature1[i]);
        }
        }
    } catch (FileNotFoundException ex) {
    } catch (IOException e) {
		e.printStackTrace();
	}
}

// Pulsanti mostra candidato selezionato

@FXML void expandc1p1(MouseEvent event) {
	try {
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/resources/Fxml/ShowCandidate.fxml"));
        Parent root = (Parent) loader.load();
        ShowCandidateController SCController=loader.getController();
        SCController.mailFunction(mailc1p1.getText());
        SCController.TitleFunction(TitleLabel.getText());
        SCController.ExpFunction(ExpLabel.getText());
        SCController.SectorFunction(SectorLabel.getText());
        SCController.RegionFunction(RegionLabel.getText());    
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();    
	} catch (IOException e) {
		e.printStackTrace(); }	
}

@FXML void expandc2p1(MouseEvent event) {
	try {
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/resources/Fxml/ShowCandidate.fxml"));
        Parent root = (Parent) loader.load();     
        ShowCandidateController SCController=loader.getController();
        SCController.mailFunction(mailc2p1.getText());
        SCController.TitleFunction(TitleLabel.getText());
        SCController.ExpFunction(ExpLabel.getText());
        SCController.SectorFunction(SectorLabel.getText());
        SCController.RegionFunction(RegionLabel.getText());       
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
	} catch (IOException e) {
		e.printStackTrace(); }	
}

@FXML void expandc3p1(MouseEvent event) {
	try {
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/resources/Fxml/ShowCandidate.fxml"));
        Parent root = (Parent) loader.load();
        ShowCandidateController SCController=loader.getController();
        SCController.mailFunction(mailc3p1.getText());
        SCController.TitleFunction(TitleLabel.getText());
        SCController.ExpFunction(ExpLabel.getText());
        SCController.SectorFunction(SectorLabel.getText());
        SCController.RegionFunction(RegionLabel.getText());      
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();        
	} catch (IOException e) {
		e.printStackTrace(); }	
}

// Pulsanti mostra lista candidati

@FXML void showclist2(MouseEvent event) throws IOException {	
    int i = 0, n = 0, k = 0;
String candidature2[] = new String[3];
String emailcandidature2[] = new String[3];
Label candidati2[] = { c1p2, c2p2, c3p2 } ;
Label emailcandidati2[] = { mailc1p2, mailc2p2, mailc3p2 } ;
try {
	BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME));
	int lines = 0;
	while (reader.readLine() != null) {
		lines++; }
	reader.close();
	int cont = lines / 2;	
	for ( i = 0; i < 3; i++ ) {
		if ( candidati2[i] != null ) {
			candidati2[i].setVisible(false); }
	}	
	BufferedReader read = new BufferedReader(
	        new InputStreamReader(
	            new FileInputStream(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME), StandardCharsets.UTF_8));
    List<String> line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME), StandardCharsets.UTF_8);
    int j = 0, m = 1;
	candidates:
    while ( line != null && n < cont ) {
    	if ( k < 3 ) {
                if ( line.get(m).equals( TitleLabel1.getText().toString() )) {
                     emailcandidature2[k] = line.get(j).toString();
                     candidature2[k] = line.get(j).toString();
                     k++; }
           }
           else {
                break candidates; }
         j += 2; m += 2; n++;
        }
        read.close();
            if ( k < 3 ) {
            	for ( i = k; i < 3; i++ ) {
            		candidati2[i].setVisible(false);
            	}
              }           
        if ( k != 0 ) {
        for ( i = 0; i < k; i++ ) {
          candidati2[i].setVisible(true);
          emailcandidati2[i].setText(emailcandidature2[i]);
          candidati2[i].setText(candidature2[i]);
        }
        }
    } catch (FileNotFoundException ex) {
    } catch (IOException e) {
		e.printStackTrace();
	}
}

// Pulsanti mostra candidato selezionato
   
@FXML void expandc1p2(MouseEvent event) {       
	try {
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/resources/Fxml/ShowCandidate.fxml"));
        Parent root = (Parent) loader.load();
        ShowCandidateController SCController=loader.getController();
        SCController.mailFunction(mailc1p2.getText());
        SCController.TitleFunction(TitleLabel1.getText());
        SCController.ExpFunction(ExpLabel1.getText());
        SCController.SectorFunction(SectorLabel1.getText());
        SCController.RegionFunction(RegionLabel1.getText());       
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();       
	} catch (IOException e) {
		e.printStackTrace(); }	
}

@FXML void expandc2p2(MouseEvent event) {	
	try {
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/resources/Fxml/ShowCandidate.fxml"));
        Parent root = (Parent) loader.load();                
        ShowCandidateController SCController=loader.getController();
        SCController.mailFunction(mailc2p2.getText());
        SCController.TitleFunction(TitleLabel1.getText());
        SCController.ExpFunction(ExpLabel1.getText());
        SCController.SectorFunction(SectorLabel1.getText());
        SCController.RegionFunction(RegionLabel1.getText());        
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();        
	} catch (IOException e) {
		e.printStackTrace(); }
}

@FXML void expandc3p2(MouseEvent event) {	
	try {
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/resources/Fxml/ShowCandidate.fxml"));
        Parent root = (Parent) loader.load();          
        ShowCandidateController SCController=loader.getController();
        SCController.mailFunction(mailc3p2.getText());
        SCController.TitleFunction(TitleLabel1.getText());
        SCController.ExpFunction(ExpLabel1.getText());
        SCController.SectorFunction(SectorLabel1.getText());
        SCController.RegionFunction(RegionLabel1.getText());       
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();      
	} catch (IOException e) {
		e.printStackTrace(); }
}

// Pulsanti mostra lista candidati

@FXML void showclist3(MouseEvent event) throws IOException {		
int i = 0, n = 0, k = 0;
String candidature3[] = new String[3];
String emailcandidature3[] = new String[3];
Label candidati3[] = { c1p3, c2p3, c3p3 } ;
Label emailcandidati3[] = { mailc1p3, mailc2p3, mailc3p3 } ;
try {
	BufferedReader reader = new BufferedReader(new FileReader(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME));
	int lines = 0;
	while (reader.readLine() != null) {
		lines++; }
	reader.close();
	int cont = lines / 2;	
	for ( i = 0; i < 3; i++ ) {
		if ( candidati3[i] != null ) {
			candidati3[i].setVisible(false); }
	}	
	BufferedReader read = new BufferedReader(
	        new InputStreamReader(
	            new FileInputStream(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME), StandardCharsets.UTF_8));
    List<String> line = Files.readAllLines(Paths.get(FileCerqoLavoroBusinessFactoryImpl.CANDIDATES_FILE_NAME), StandardCharsets.UTF_8);
    int j = 0, m = 1;
	candidates:
    while ( line != null && n < cont ) {
    	if ( k < 3 ) {
                if ( line.get(m).equals( TitleLabel1.getText().toString() )) {
                     emailcandidature3[k] = line.get(j).toString();
                     candidature3[k] = line.get(j).toString();
                     k++; }
           }
           else {
                break candidates; }
         j += 2; m += 2; n++;
        }
        read.close();
            if ( k < 3 ) {
            	for ( i = k; i < 3; i++ ) {
            		candidati3[i].setVisible(false);
            	}
              }           
        if ( k != 0 ) {
        for ( i = 0; i < k; i++ ) {
          candidati3[i].setVisible(true);
          emailcandidati3[i].setText(emailcandidature3[i]);
          candidati3[i].setText(candidature3[i]);
        }
        }
    } catch (FileNotFoundException ex) {
    } catch (IOException e) {
		e.printStackTrace();
	}
}

// Pulsanti mostra candidato selezionato

@FXML void expandc1p3(MouseEvent event) {
	try {
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/resources/Fxml/ShowCandidate.fxml"));
        Parent root = (Parent) loader.load();                
        ShowCandidateController SCController=loader.getController();
        SCController.mailFunction(mailc1p3.getText());
        SCController.TitleFunction(TitleLabel11.getText());
        SCController.ExpFunction(ExpLabel11.getText());
        SCController.SectorFunction(SectorLabel11.getText());
        SCController.RegionFunction(RegionLabel11.getText());       
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();        
	} catch (IOException e) {
		e.printStackTrace(); }	
}

@FXML void expandc2p3(MouseEvent event) {	
	try {
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/resources/Fxml/ShowCandidate.fxml"));
        Parent root = (Parent) loader.load();      
        ShowCandidateController SCController=loader.getController();
        SCController.mailFunction(mailc2p3.getText());
        SCController.TitleFunction(TitleLabel11.getText());
        SCController.ExpFunction(ExpLabel11.getText());
        SCController.SectorFunction(SectorLabel11.getText());
        SCController.RegionFunction(RegionLabel11.getText());       
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();        
	} catch (IOException e) {
		e.printStackTrace(); }
}

@FXML void expandc3p3(MouseEvent event) {	
	try {
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/resources/Fxml/ShowCandidate.fxml"));
        Parent root = (Parent) loader.load();      
        ShowCandidateController SCController=loader.getController();
        SCController.mailFunction(mailc3p3.getText());
        SCController.TitleFunction(TitleLabel11.getText());
        SCController.ExpFunction(ExpLabel11.getText());
        SCController.SectorFunction(SectorLabel11.getText());
        SCController.RegionFunction(RegionLabel11.getText());       
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();        
	} catch (IOException e) {
		e.printStackTrace(); }
}

@Override 
public void initialize(URL url, ResourceBundle resources) {
	
    // Annunci non visibili finché non richiesti
	Annuncio1.setVisible(false);
    Annuncio2.setVisible(false);
    Annuncio3.setVisible(false);
    
    // Candidature non visibili finché non richieste
    c1p1.setVisible(false);
    c2p1.setVisible(false);
    c3p1.setVisible(false);  
    c1p2.setVisible(false);
    c2p2.setVisible(false);
    c3p2.setVisible(false);    
    c1p3.setVisible(false);
    c2p3.setVisible(false);
    c3p3.setVisible(false);
    
    mailc3p3.setVisible(false);
    mailc2p3.setVisible(false);
    mailc1p3.setVisible(false);
    mailc3p2.setVisible(false);
    mailc2p2.setVisible(false);
    mailc1p2.setVisible(false);    
    mailc3p1.setVisible(false);
    mailc2p1.setVisible(false);
    mailc1p1.setVisible(false);
    
// Combobox
    // Annuncio n. 1
    EditTypeContBox.getItems().addAll("Modifica Tipo Contratto","Tempo indeterminato","Tempo determinato","In somministrazione","Lavoro a Chiamata",
            "Lavoro a progetto","Lavoro accessorio","Lavoro in apprendistato","Tirocinio Formativo");
    EditTypeContBox.setValue("Modifica Tipo Contratto");
    
    EditTimeContBox.getItems().addAll("Modifica Tempo Contratto","FullTime","Part-Time");
    EditTimeContBox.setValue("Modifica Tempo Contratto");
    
    EditRetxTField.getItems().addAll("Modifica Tempo Retribuzione","Al giorno","Alla Settimana","Al mese","All'anno");
    EditRetxTField.setValue("Modifica Tempo Retribuzione");
    
    EditRegionBox.getItems().addAll("Modifica Regione","Abruzzo","Basilicata","Calabria","Campania","Emilia-Romagna",
            "Friuli-Venezia-Giulia","Lazio","Liguria","Lombardia","Marche","Molise","Piemonte","Puglia",
            "Sardegna","Sicilia","Toscana","Trentino-Alto Adige","Umbria","Valle d'Aosta","Veneto");
    EditRegionBox.setValue("Modifica Regione");
    
    EditSectorBOx.getItems().addAll("Modifica Settore","Acquisti-Logica-Trasporti","Affari legali","Amministrazione-Segreteria","Architettura-Arti grafiche-Design","Assistenza Anziani",
            "Commerciale","Commercio-Negozi","Contabilita'-Finanza","Direzione-Consulenza","Edilizia","Editoria-Giornalismo","Estetica-Cura della Persona","Formazione-Istruzione",
            "Informatica-Telecomunicazioni","Ingegneria","Marketing-Comunicazione","Medicina-Salute","Produzione-Operai","Project Managment","Qualita'-Ambiente","Risorse Umane",
            "Sicurezza-Vigilanza","Supporto al cliente","Turismo-Ristorazione","Altro");
    EditSectorBOx.setValue("Modifica Settore");
    
    EditExpbox.getItems().addAll("Modifica Esperienza","Meno di un Anno","Un anno","Due anni","Tre anni","Quattro anni","Cinque anni","Sei anni","Sette anni","Otto anni","Nove anni","Dieci anni","Piu' di Dieci Anni");
    EditExpbox.setValue("Modifica Esperienza");
    
    // Annuncio n. 2
    EditTypeContBox1.getItems().addAll("Modifica Tipo Contratto","Tempo indeterminato","Tempo determinato","In somministrazione","Lavoro a Chiamata",
            "Lavoro a progetto","Lavoro accessorio","Lavoro in apprendistato","Tirocinio Formativo");
    EditTypeContBox1.setValue("Modifica Tipo Contratto");
    
    EditTimeContBox1.getItems().addAll("Modifica Tempo Contratto","FullTime","Part-Time");
    EditTimeContBox1.setValue("Modifica Tempo Contratto");
    
    EditRetxTField1.getItems().addAll("Modifica Tempo Retribuzione","Al giorno","Alla settimana","Al mese","All'anno");
    EditRetxTField1.setValue("Modifica Tempo Retribuzione");
    
    EditRegionBox1.getItems().addAll("Modifica Regione","Abruzzo","Basilicata","Calabria","Campania","Emilia-Romagna",
            "Friuli-Venezia-Giulia","Lazio","Liguria","Lombardia","Marche","Molise","Piemonte","Puglia",
            "Sardegna","Sicilia","Toscana","Trentino-Alto Adige","Umbria","Valle d'Aosta","Veneto");
    EditRegionBox1.setValue("Modifica Regione");
    
    EditSectorBOx1.getItems().addAll("Modifica Settore","Acquisti-Logica-Trasporti","Affari legali","Amministrazione-Segreteria","Architettura-Arti grafiche-Design","Assistenza Anziani",
            "Commerciale","Commercio-Negozi","Contabilita'-Finanza","Direzione-Consulenza","Edilizia","Editoria-Giornalismo","Estetica-Cura della Persona","Formazione-Istruzione",
            "Informatica-Telecomunicazioni","Ingegneria","Marketing-Comunicazione","Medicina-Salute","Produzione-Operai","Project Managment","Qualita'-Ambiente","Risorse Umane",
            "Sicurezza-Vigilanza","Supporto al cliente","Turismo-Ristorazione","Altro");
    EditSectorBOx1.setValue("Modifica Settore");
    
    EditExpbox1.getItems().addAll("Modifica Esperienza","Meno di un Anno","Un anno","Due anni","Tre anni","Quattro anni","Cinque anni","Sei anni","Sette anni","Otto anni","Nove anni","Dieci anni","Piu' di Dieci Anni");
    EditExpbox1.setValue("Modifica Esperienza");
    
    // Annuncio n. 3
    EditTypeContBox11.getItems().addAll("Modifica Tipo Contratto","Tempo indeterminato","Tempo determinato","In somministrazione","Lavoro a Chiamata",
            "Lavoro a progetto","Lavoro accessorio","Lavoro in apprendistato","Tirocinio Formativo");
    EditTypeContBox11.setValue("Modifica Tipo Contratto");
    
    EditTimeContBox11.getItems().addAll("Modifica Tempo Contratto","FullTime","Part-Time");
    EditTimeContBox11.setValue("Modifica Tempo Contratto");
    
    EditRetxTField11.getItems().addAll("Modifica Tempo Retribuzione","Al giorno","Alla settimana","Al mese","All'anno");
    EditRetxTField11.setValue("Modifica Tempo Retribuzione");
    
    EditRegionBox11.getItems().addAll("Modifica Regione","Abruzzo","Basilicata","Calabria","Campania","Emilia-Romagna",
            "Friuli-Venezia-Giulia","Lazio","Liguria","Lombardia","Marche","Molise","Piemonte","Puglia",
            "Sardegna","Sicilia","Toscana","Trentino-Alto Adige","Umbria","Valle d'Aosta","Veneto");
    EditRegionBox11.setValue("Modifica Regione");
    
    EditSectorBOx11.getItems().addAll("Modifica Settore","Acquisti-Logica-Trasporti","Affari legali","Amministrazione-Segreteria","Architettura-Arti grafiche-Design","Assistenza Anziani",
            "Commerciale","Commercio-Negozi","Contabilita'-Finanza","Direzione-Consulenza","Edilizia","Editoria-Giornalismo","Estetica-Cura della Persona","Formazione-Istruzione",
            "Informatica-Telecomunicazioni","Ingegneria","Marketing-Comunicazione","Medicina-Salute","Produzione-Operai","Project Managment","Qualita'-Ambiente","Risorse Umane",
            "Sicurezza-Vigilanza","Supporto al cliente","Turismo-Ristorazione","Altro");
    EditSectorBOx11.setValue("Modifica Settore");
    
    EditExpbox11.getItems().addAll("Modifica Esperienza","Meno di un Anno","Un anno","Due anni","Tre anni","Quattro anni","Cinque anni","Sei anni","Sette anni","Otto anni","Nove anni","Dieci anni","Piu' di Dieci Anni");
    EditExpbox11.setValue("Modifica Esperienza");
    }

}