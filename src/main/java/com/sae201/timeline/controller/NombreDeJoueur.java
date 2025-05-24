package com.sae201.timeline.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static com.sae201.timeline.utilitaire.StyleUtilitaire.styleBouton;

public class NombreDeJoueur {
    @FXML
    private VBox root;

    @FXML
    private void initialize() {
        Platform.runLater(this::styleButton);
    }

    private void styleButton() {
        for (Node node : root.getChildren()) {
            if (node instanceof HBox hbox) {
                for (Node hboxChild : hbox.getChildren()) {
                    if (hboxChild instanceof Button btn) {
                        styleBouton(btn);
                    }
                }
            }
        }
    }
}
