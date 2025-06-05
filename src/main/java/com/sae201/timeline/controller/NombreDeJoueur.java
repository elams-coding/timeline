package com.sae201.timeline.controller;

import com.sae201.timeline.util.DialogueUtilitaire;
import com.sae201.timeline.util.StyleUtilitaire;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NombreDeJoueur {
	public static int nbJoueur;
	@FXML
	private VBox root;
	@FXML
	private Button unJoueur;
	@FXML
	private Button deuxJoueurs;

	@FXML
	private void initialize() {
		Platform.runLater(this::styliserBouton);
		nbJoueur = 0;
	}

	private void styliserBouton() {
		for (Node node : root.getChildren()) {
			if (node instanceof HBox hbox) {
				for (Node hboxChild : hbox.getChildren()) {
					if (hboxChild instanceof Button btn) {
						StyleUtilitaire.effetOmbreEtGlow(btn);
					}
				}
			}
		}
	}

	@FXML
	private void jouer(ActionEvent event) {
		if (event.getSource() == unJoueur) {
			nbJoueur = 1;
		} else if (event.getSource() == deuxJoueurs) {
			nbJoueur = 2;
		}

		ouvrirPopUp();
	}

	@FXML
	private void retourMaison(MouseEvent event) {
		String cheminAccueil = "/com/sae201/timeline/accueil.fxml";
		FXMLLoader loader = new FXMLLoader(getClass().getResource(cheminAccueil));
		try {
			Parent root = loader.load();
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			DialogueUtilitaire.afficherAlerte(e);
		}
	}

	private void ouvrirPopUp() {
		String cheminChoixDeck = "/com/sae201/timeline/choixDeck.fxml";
		FXMLLoader loader = new FXMLLoader(getClass().getResource(cheminChoixDeck));
		try {
			Scene scene = new Scene(loader.load());
			Stage nouvelleStage = new Stage();
			nouvelleStage.setScene(scene);
			nouvelleStage.initModality(Modality.APPLICATION_MODAL);
			nouvelleStage.setTitle("Choix du deck");
			nouvelleStage.setResizable(false);
			nouvelleStage.showAndWait();
			
			// todo fermer la page si la pop est fermé
			if (ChoixDuDeck.jeuSOuvre) {
				System.out.println(ChoixDuDeck.jeuSOuvre);
				Stage stage = (Stage) root.getScene().getWindow();
				ouvrirJeu(stage);
			}
		} catch (IOException e) {
			if (e.getCause() != null) {
				DialogueUtilitaire.alerterChargementVueImpossible(e.getCause().getMessage());
			} else {
				DialogueUtilitaire.alerterChargementVueImpossible(e.getMessage());
			}
		}
	}
	
	private void ouvrirJeu(Stage stage) {
		String cheminPlateauJeu = "/com/sae201/timeline/plateauJeu.fxml";
		FXMLLoader loader = new FXMLLoader(getClass().getResource(cheminPlateauJeu));
		try {
			Scene scene = new Scene(loader.load());
			stage.setScene(scene);
		} catch (IOException e) {
			DialogueUtilitaire.afficherAlerte(e);
		}
	}
}
