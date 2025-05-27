package com.sae201.timeline.controller;

import static com.sae201.timeline.util.DialogueUtilitaire.afficherFonctionnaliteNonDisponible;
import static com.sae201.timeline.util.StyleUtilitaire.styleBouton;

import com.sae201.timeline.util.DialogueUtilitaire;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Accueil {
    public static boolean estModeSolo;
    private FXMLLoader loader;
    private Stage stage;

    @FXML
    private VBox conteneurChoix;

    @FXML
    private void initialize() {
        Platform.runLater(this::tailleBouton);
    }

    private void tailleBouton() {
        double largeurInitiale = conteneurChoix.getWidth();
        for (Node node : conteneurChoix.getChildren()) {
            if (node instanceof Button btn) {
                btn.setMaxWidth(largeurInitiale);
                largeurInitiale -= 10;
                styleBouton(btn);
            }
        }
    }

    @FXML
    private void nouvellePartie(ActionEvent event) {
        String cheminVueNombreDeJoueurs = "/com/sae201/timeline/nombreDeJoueurs.fxml";
        loader = new FXMLLoader(getClass().getResource(cheminVueNombreDeJoueurs));
        try {
            Scene scene = new Scene(loader.load());
            Scene sceneInitiale = ((Button) event.getSource()).getScene();
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.close();
            stage.setScene(scene);
            stage.setTitle("Nombre de joueurs");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setOnCloseRequest(e -> {
                e.consume();
                retourAccueil(sceneInitiale, stage);
            });
            stage.show();
        } catch (IOException e) {
        	DialogueUtilitaire.afficherAlerte(e);
        }
    }

    @FXML
    private void chargerPartie() {
        afficherFonctionnaliteNonDisponible("Charger partie",
                "Il n'est pas possible de charger une partie pour le moment.");
    }

    @FXML
    private void gererDecks(ActionEvent event) {
        String cheminVueGererDeck = "/com/sae201/timeline/gererDeck.fxml";
        loader = new FXMLLoader(getClass().getResource(cheminVueGererDeck));
        try {
			Scene scene = new Scene(loader.load());
			stage = new Stage();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Gérer les decks");
			Scene sceneInitiale = ((Button) event.getSource()).getScene();
			stage.setOnCloseRequest(e -> {
                e.consume();
                retourAccueil(sceneInitiale, stage);
            });
			stage.show();
		} catch (IOException e) {
			DialogueUtilitaire.afficherAlerte(e);
		}
    }

    @FXML
    private void reglages() {
        afficherFonctionnaliteNonDisponible("Aucune option pour l'instant.");

        /*
         * TODO faire les options de réglages :
         * - choix de la langue,
         * - choix du thème,
         * - activer/désactiver le son,
         * - activer/désactiver la musique de fond.
         */
    }

    @FXML
    private void quitter() {
        Platform.exit();
    }

    private void retourAccueil(Scene sceneInitiale, Stage stage) {
        stage.close();
        stage.setScene(sceneInitiale);
        stage.setTitle("Timeline");
        stage.setResizable(true);
        stage.setOnCloseRequest(e -> Platform.exit());
        stage.show();
    }
}