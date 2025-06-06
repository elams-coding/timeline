package com.sae201.timeline.controller;

import com.sae201.timeline.io.CarteLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class DeckListe {
    @FXML
    private VBox listeDecks;

    private List<CarteLoader> decks;

    public void setDecks(List<CarteLoader> decks) {
        this.decks = decks;
        afficherDecks();
    }

    private void afficherDecks() {
        listeDecks.getChildren().clear();

        for (CarteLoader deck : decks) {
            HBox deckItem = creerDeckItem(deck);
            listeDecks.getChildren().add(deckItem);
        }
    }

    private HBox creerDeckItem(CarteLoader deck) {
        HBox container = new HBox();
        container.setAlignment(Pos.CENTER_LEFT);
        container.setSpacing(15);
        container.setPadding(new Insets(10));
        container.setStyle("-fx-background-color: #000000; -fx-background-radius: 5;");

        // Image
        ImageView imageView = new ImageView();
        imageView.setFitHeight(80);
        imageView.setFitWidth(80);
        imageView.setPreserveRatio(true);

        if (!deck.getCartes().isEmpty()) {
            try {
                Image image = new Image(deck.getCartes().get(0).getUrlImage());
                imageView.setImage(image);
            } catch (Exception e) {
                imageView.setStyle("-fx-background-color: #cccccc;");
            }
        }

        // Informations
        VBox info = new VBox(5);
        Label titre = new Label(deck.getTitre());
        titre.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");
        Label nbCartes = new Label(deck.getCartes().size() + " cartes");
        info.getChildren().addAll(titre, nbCartes);

        // Spacer
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Bouton Supprimer
        Button supprimerBtn = new Button("Supprimer");
        supprimerBtn.getStyleClass().add("bouton-supprimer");
        supprimerBtn.setStyle("-fx-background-color: #ff4444; -fx-text-fill: white;");
        supprimerBtn.setOnAction(e -> confirmerSuppression(deck));

        container.getChildren().addAll(imageView, info, spacer, supprimerBtn);

        // Effets hover
        container.setOnMouseEntered(e ->
                container.setStyle("-fx-background-color: #aeaeae; -fx-background-radius: 5;"));
        container.setOnMouseExited(e ->
                container.setStyle("-fx-background-color: #000000; -fx-background-radius: 5;"));

        return container;
    }

    private void confirmerSuppression(CarteLoader deck) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression");
        alert.setHeaderText("Supprimer le deck");
        alert.setContentText("Êtes-vous sûr de vouloir supprimer le deck \"" + deck.getTitre() + "\" ?");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                supprimerDeck(deck);
            }
        });
    }

    private void supprimerDeck(CarteLoader deck) {
        decks.remove(deck);
        afficherDecks();
    }

    @FXML
    private void retourVersGestion() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/sae201/timeline/gererDeck.fxml"));
            Node gestionPage = fxmlLoader.load();

            GererDeck controller = fxmlLoader.getController();
            // Mettre à jour la liste des decks dans GererDeck
            controller.mettreAJourDecks(decks);

            listeDecks.getScene().setRoot((Parent) gestionPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}