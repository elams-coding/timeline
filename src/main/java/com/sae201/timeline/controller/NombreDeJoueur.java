package com.sae201.timeline.controller;

import com.sae201.timeline.util.DialogueUtilitaire;
import com.sae201.timeline.util.StyleUtilitaire;
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

import java.io.IOException;

public class NombreDeJoueur {
	public static int nbJoueur;
	@FXML
	private VBox root;
	@FXML
	private Button unJoueur, deuxJoueurs;

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
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sae201/timeline/accueil.fxml"));
			Parent root = loader.load();

			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.setResizable(false);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
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
		} catch (IOException e) {
			if (e.getCause() != null) {
				DialogueUtilitaire.alerterChargementVueImpossible(e.getCause().getMessage());
			} else {
				DialogueUtilitaire.alerterChargementVueImpossible(e.getMessage());
			}
		}
	}
}
