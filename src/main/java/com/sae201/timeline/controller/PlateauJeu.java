package com.sae201.timeline.controller;

import com.sae201.timeline.util.StyleUtilitaire;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class PlateauJeu {
	@FXML
	private Label temps;
	@FXML
	private HBox plateau;
	@FXML
	private HBox main;

	private int tempsRestant; // Temps restant en secondes
	private Timeline timer;

	@FXML
	private void initialize() {
		if (NombreDeJoueur.nbJoueur == 1) {
			StyleUtilitaire.cacherNode(temps);
		} else {
			tempsRestant = ChoixDuDeck.temps; // Initialisation du temps
			temps.setText(Integer.toString(tempsRestant));
			lancerTimer();
		}
	}

	private void lancerTimer() {
		timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
			tempsRestant--;
			temps.setText(Integer.toString(tempsRestant));

			if (tempsRestant <= 0) {
				timer.stop();
				temps.setText("Temps écoulé !");
			}
		}));
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
	}
}
