package com.sae201.timeline.controller;

import com.sae201.timeline.io.CarteLoader;
import com.sae201.timeline.io.JSONCarteLoader;
import com.sae201.timeline.util.StyleUtilitaire;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoixDuDeck {
	public static int temps;
	public static boolean jeuSOuvre;

	@FXML
	private VBox root;
	@FXML
	private ChoiceBox<String> choixDeck;
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
			StyleUtilitaire.cacherNode(sliderTemps, label, labelTemps);
		}

		afficherTemps();

		choixDeck.setValue("Deck à choisir");

		loadDecksIntoChoiceBox();
		
		jeuSOuvre = false;
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

	private void loadDecksIntoChoiceBox() {
		// choisir soit JSON ou FAKE
		CarteLoader carteLoader = new JSONCarteLoader();
		carteLoader.load();

		choixDeck.getItems().clear();
		System.out.println(carteLoader.getTitre());
		choixDeck.getItems().add(carteLoader.getTitre());
		
		choixDeck.setOnAction(event -> {
			jeuSOuvre = !jeuSOuvre;
			Stage stage = (Stage) root.getScene().getWindow();
			stage.close();
		});
	}
}
