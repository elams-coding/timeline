package com.sae201.timeline.controller;

import static com.sae201.timeline.util.StyleUtilitaire.styleBouton;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class NombreDeJoueur {
	private static int nbJoueur;
    @FXML
    private VBox root;
    @FXML
    private Button unJoueur, deuxJoueurs;

    @FXML
    private void initialize() {
        Platform.runLater(this::styleButton);
        nbJoueur = 0;
    }

    private void styleButton() {
        for (Node node : root.getChildren()) {
            if (node instanceof HBox hbox) {
                for (Node hboxChild : hbox.getChildren()) {
                    if (hboxChild instanceof Button btn) {
                        styleBouton(btn);
                    }
                }
            }
        }
    }
    
    @FXML
    private void jouer(ActionEvent event) {
    	if (event.getSource() == unJoueur) {
    		nbJoueur = 1;
    	} else if (event.getSource() == deuxJoueurs){
    		nbJoueur = 2;
    	}
    	
    	ouvrirPopUp();
    }
    
    private void ouvrirPopUp() {
    	String cheminChoixDeck;
//    	try {
//    		
//    	} catch (IOException e) {
//    		e.printStackTrace();
//    	}
    }
    
    public static int getNbJoueur() {
    	return nbJoueur;
    }
}
