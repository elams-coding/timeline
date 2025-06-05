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
		deckLoaders.add(fakeDeck);
		afficherCarousel();
		Platform.runLater(this::styliserBoutons);
	}
	
	private void styliserBoutons() {
		for (Node node : conteneurBouton.getChildren()) {
			if (node instanceof Button btn) {
				StyleUtilitaire.effetOmbreEtGlow(btn);
			}
		}
	}
	private void afficherCarousel() {
		centreDeck.getChildren().clear();

		if (deckLoaders.isEmpty()) return;

		// Deck précédent
		if (indexDeckActuel > 0) {
			Node gauche = creerDeckNode(deckLoaders.get(indexDeckActuel - 1), 100, 0.5);
			AnchorPane.setLeftAnchor(gauche, 10.0);
			AnchorPane.setTopAnchor(gauche, 25.0);
			centreDeck.getChildren().add(gauche);
		}

		// Deck courant
		Node centre = creerDeckNode(deckLoaders.get(indexDeckActuel), 180, 1.0);
		AnchorPane.setLeftAnchor(centre, 100.0);
		AnchorPane.setTopAnchor(centre, 10.0);
		centreDeck.getChildren().add(centre);

		// Deck suivant
		if (indexDeckActuel < deckLoaders.size() - 1) {
			Node droite = creerDeckNode(deckLoaders.get(indexDeckActuel + 1), 100, 0.5);
			AnchorPane.setRightAnchor(droite, 10.0);
			AnchorPane.setTopAnchor(droite, 25.0);
			centreDeck.getChildren().add(droite);
		}
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
			afficherCarousel();
		}
	}

	@FXML
	private void deckPrecedent() {
		if (indexDeckActuel > 0) {
			indexDeckActuel--;
			afficherCarousel();
		}
	}
}
