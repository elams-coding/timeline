package com.sae201.timeline.controller;

import com.sae201.timeline.util.DialogueUtilitaire;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Pause {
	@FXML
    private VBox root;
	
	@FXML
	void quitter() {
		Platform.exit();
	}

	@FXML
	void retourJeu() {
		Stage stage = (Stage) root.getScene().getWindow();
		stage.close();
	}

	@FXML
	void sauvegarder() {
		DialogueUtilitaire.afficherFonctionnaliteNonDisponible("Sauvegarder", "Fonctionnalité à venir");
	}
}
