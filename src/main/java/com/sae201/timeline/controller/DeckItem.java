package com.sae201.timeline.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DeckItem {
    @FXML private Label labelNom;
    @FXML private ImageView image;

    public void setNom(String nom) {
        labelNom.setText(nom);
    }

    public void setImage(String url) {
        image.setImage(new Image(url));
    }

    public void setTaille(double largeur, double opacite) {
        image.setFitWidth(largeur);
        image.setOpacity(opacite);
    }
}
