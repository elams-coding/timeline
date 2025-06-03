package com.sae201.timeline.model;

import com.sae201.timeline.io.CarteFakeLoader;
import com.sae201.timeline.io.CarteLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private String titre;
	private List<Carte> cartes;

	public Deck() {
		cartes = new ArrayList<>();

		setup();
	}

	private void setup() {
		CarteLoader loader = new CarteFakeLoader();
		loader.load();
		cartes = loader.getCartes();
		titre = loader.getTitre();
		Collections.shuffle(cartes);
	}

	public Carte drawCard() {
		if (cartes.isEmpty()) {
			return null;
		}
		return cartes.remove(0);
	}

	public boolean hasMoreCards() {
		return !cartes.isEmpty();
	}

	public String getTitre() {
		return titre;
	}

}
