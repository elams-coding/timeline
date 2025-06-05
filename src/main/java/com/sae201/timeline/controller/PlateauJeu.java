package com.sae201.timeline.controller;

import com.sae201.timeline.util.DialogueUtilitaire;
import com.sae201.timeline.util.StyleUtilitaire;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class PlateauJeu {
	@FXML
	private VBox root;
	@FXML
	private Label temps;
	@FXML
	private HBox plateau;
	@FXML
	private HBox main;

	private int tempsRestant;
	private Timeline timer;
	private boolean enPause = false;
	
	private static double positionLabelInitial;

	@FXML
	private void initialize() {
		if (NombreDeJoueur.nbJoueur == 1) {
			StyleUtilitaire.cacherNode(temps);
		} else {
			tempsRestant = ChoixDuDeck.temps;
			temps.setText(Integer.toString(tempsRestant));
			lancerTimer();
		}
		
		positionLabelInitial = temps.getLayoutX();
	}

	private void lancerTimer() {
		timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
			if (!enPause) {
				tempsRestant--;
				temps.setText(Integer.toString(tempsRestant));

				if (tempsRestant <= 0) {
					timer.stop();
					temps.setText("Temps écoulé !");
					temps.setLayoutX(positionLabelInitial - 100);
				}
			}
		}));
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
	}

	@FXML
	private void pause() {
		if (NombreDeJoueur.nbJoueur == 1) {
			return;
		}
		
		if (!enPause) {
			enPause = true;
			timer.pause();
			temps.setText("Pause");
			temps.setLayoutX(positionLabelInitial - 20);
			root.setDisable(true);
		} else {
			enPause = false;
			timer.play();
			temps.setText(Integer.toString(tempsRestant));
			temps.setLayoutX(positionLabelInitial);
			root.setDisable(false);
		}
	}

	@FXML
	private void quitter() {
		Platform.exit();
	}

	@FXML
	private void sauvegarder() {
		DialogueUtilitaire.afficherFonctionnaliteNonDisponible();
	}
}
