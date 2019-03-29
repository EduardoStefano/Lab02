package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	AlienDictionary dizionario;
	
	public AlienController() {
		dizionario = new AlienDictionary();
	}
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
      
    
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	txtResult.clear();
    	txtWord.clear();
    	this.dizionario.clearDictionary();

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	txtResult.clear();
    	String[] word = txtWord.getText().split(" ");
    	
    	if(word==null || word.length==0 || word[0].equals("")) {
    		txtResult.setText("Immetti una o due parole");
    		return;
    	}
    	
    	if(word.length==2) {
    		this.dizionario.addWord(word[0], word[1]);
    		txtResult.setText("Traduzione parola: "+this.dizionario.translateWord(word[0]));
    		return;
    	}
    	
    	if(word.length==1) {
    		
        	if (!word[0].matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici.");
    			return;
    		}
        	
    		if(this.dizionario.translateWord(word[0])!=null) {
    			txtResult.setText("Traduzione: "+this.dizionario.translateWord(word[0]));
    		}
    		
    		else {
    			txtResult.setText("Inesistente");
    		}
    	}
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
    
}
