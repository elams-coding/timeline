package com.sae201.timeline.controller;

import com.sae201.timeline.util.StyleUtilitaire;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GererDeck {
	@FXML
	private StackPane root;
	@FXML
	private VBox conteneurBouton;
	
	@FXML
	public void initialize() {
		Platform.runLater(this::styliserBoutons);
	}
	
	private void styliserBoutons() {
		for (Node node : conteneurBouton.getChildren()) {
			if (node instanceof Button btn) {
				StyleUtilitaire.effetOmbreEtGlow(btn);
			}
		}
	}

}
