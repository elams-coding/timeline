package com.sae201.timeline.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import static com.sae201.timeline.utilitaire.DialogueUtilitaire.afficherFonctionnaliteNonDisponible;
import static com.sae201.timeline.utilitaire.DialogueUtilitaire.alerterChargementVueImpossible;
import static com.sae201.timeline.utilitaire.StyleUtilitaire.styleBouton;

public class Accueil {
    public static boolean estModeSolo;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource(cheminVueNombreDeJoueurs));
        try {
            Scene scene = new Scene(loader.load());
            Scene sceneInitiale = ((Button) event.getSource()).getScene();
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
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
            if (e.getCause() != null) {
                alerterChargementVueImpossible(e.getCause().getMessage());
            } else {
                alerterChargementVueImpossible(e.getMessage());
            }
        }
    }

    @FXML
    private void chargerPartie() {
        afficherFonctionnaliteNonDisponible("Charger partie",
                "Il n'est pas possible de charger une partie pour le moment.");
    }

    @FXML
    private void gererDecks() {
        afficherFonctionnaliteNonDisponible("Aucun deck pour le moment.");
    }

    @FXML
    private void reglages() {
        afficherFonctionnaliteNonDisponible("Aucune option pour l'instant.");

        /*
        TODO faire les options de réglages :
            - choix de la langue,
            - choix du thème,
            - activer/désactiver le son,
            - activer/désactiver la musique de fond.
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