package com.sae201.timeline.model;

public class Joueur {
	private String nom;
	private int score;
	private JoueurMain mainJoueur;

	public Joueur(String nom) {
		this.nom = nom;
		this.score = 0;
		mainJoueur = new JoueurMain();
	}

	public void ajouterPoint(int points) {
		score += points;
	}

	public int getScore() {
		return score;
	}

	public String getNom() {
		return nom;
	}

	public void addInHandCard(Carte carte) {
		mainJoueur.ajouterCarte(carte);
	}

	public boolean hasMoreCardsInHand() {
		return mainJoueur.aPlusDeCarte();
	}

	public JoueurMain getHand() {
		return mainJoueur;
	}

}
