package com.sae201.timeline.objet;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	private List<Carte> collectionCarte;
	private String nom;
	
	public Deck(String nom) {
		this.nom = nom;
		collectionCarte = new ArrayList<>();
	}
}
