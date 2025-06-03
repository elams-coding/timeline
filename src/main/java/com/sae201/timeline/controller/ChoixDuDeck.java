package com.sae201.timeline.controller;

import com.sae201.timeline.objet.Deck;
import com.sae201.timeline.util.StyleUtilitaire;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class ChoixDuDeck {
	public static int temps;

	@FXML
	private VBox root;
	@FXML
	private ChoiceBox<Deck> choixDeck;
	@FXML
	private Slider sliderTemps;
	@FXML
	private Label label;
	@FXML
	private Label labelTemps;

	@FXML
	public void initialize() {
		Platform.runLater(() -> StyleUtilitaire.effetOmbreEtGlow(choixDeck));

		if (NombreDeJoueur.nbJoueur == 1) {
			cacherNode(sliderTemps, label, labelTemps);
		}

		afficherTemps();
	}

	private void afficherTemps() {
		int valeurInitial = (int) sliderTemps.getValue();
		temps = valeurInitial;
		labelTemps.setText(String.format("%02d", valeurInitial));

		sliderTemps.valueProperty().addListener((obs, oldVal, newVal) -> {
			int valeur = newVal.intValue();
			temps = valeur;
			labelTemps.setText(String.format("%02d", valeur));
		});
	}

	private void cacherNode(Node... nodes) {
		if (nodes.length == 0 || nodes == null) {
			return;
		}

		for (Node node : nodes) {
			node.setManaged(false);
			node.setVisible(false);
		}
	}
}
