package com.sae201.timeline.controller;

import com.sae201.timeline.util.StyleUtilitaire;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class PlateauJeu {
	@FXML
	private Label temps;
	@FXML
	private HBox plateau;
	@FXML
	private HBox main;
	
	@FXML
	private void initialize() {
		if (NombreDeJoueur.nbJoueur == 1) {
			StyleUtilitaire.cacherNode(temps);
		} else {
			String string = Integer.toString(ChoixDuDeck.temps);
			temps.setText(string);
		}
	}
}
