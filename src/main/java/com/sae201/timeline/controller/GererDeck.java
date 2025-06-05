package com.sae201.timeline.controller;

import com.sae201.timeline.io.CarteFakeLoader;
import com.sae201.timeline.io.CarteLoader;
import com.sae201.timeline.model.Carte;
import com.sae201.timeline.model.Deck;
import com.sae201.timeline.util.StyleUtilitaire;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GererDeck {
	@FXML
	private StackPane root;

	@FXML
	private VBox conteneurBouton;

	@FXML
	private AnchorPane centreDeck;

	@FXML
	private ImageView flecheGauche, flecheDroite;

	private int indexDeckActuel = 0;
	private final List<CarteLoader> deckLoaders = new ArrayList<>();


	@FXML
	public void initialize() {
		CarteLoader fakeDeck = new CarteFakeLoader();
		fakeDeck.load();
		deckLoaders.add(fakeDeck); // Ajoute ton deck de test
		afficherDeck(); // Affiche le premier deck

		Platform.runLater(this::styliserBoutons);
	}


	private void styliserBoutons() {
		for (Node node : conteneurBouton.getChildren()) {
			if (node instanceof Button btn) {
				StyleUtilitaire.effetOmbreEtGlow(btn);
			}
		}
	}
	private void afficherDeck() {
		centreDeck.getChildren().clear();

		if (deckLoaders.isEmpty()) return;

		Node node = creerDeckNode(deckLoaders.get(indexDeckActuel), 150, 1.0);
		// Centrage parfait en utilisant les quatre ancres
		AnchorPane.setTopAnchor(node, 0.0);
		AnchorPane.setBottomAnchor(node, 0.0);
		AnchorPane.setLeftAnchor(node, 0.0);
		AnchorPane.setRightAnchor(node, 0.0);
		centreDeck.getChildren().add(node);
	}




	private Node creerDeckNode(CarteLoader loader, double taille, double opacite) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/sae201/timeline/deckItem.fxml"));
			Node node = fxmlLoader.load();

			DeckItem controller = fxmlLoader.getController();
			controller.setNom(loader.getTitre());

			if (!loader.getCartes().isEmpty()) {
				String imgUrl = loader.getCartes().get(0).getUrlImage(); // on prend l’image de la première carte
				controller.setImage(imgUrl);
			}

			controller.setTaille(taille, opacite);
			return node;
		} catch (IOException e) {
			e.printStackTrace();
			return new Label("Erreur");
		}
	}

	@FXML
	private void deckSuivant() {
		if (indexDeckActuel < deckLoaders.size() - 1) {
			indexDeckActuel++;
			afficherDeck();
		}
	}

	@FXML
	private void deckPrecedent() {
		if (indexDeckActuel > 0) {
			indexDeckActuel--;
			afficherDeck();
		}
	}
}
