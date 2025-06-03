package com.sae201.timeline.model;

import java.util.ArrayList;
import java.util.List;

public class JoueurMain {
	private Carte carteSelectionnee;
    private List<Carte> cartes;
    
    public JoueurMain() {
    	cartes = new ArrayList<>();
        carteSelectionnee = null;
    }
     
    public void ajouterCarte(Carte carte) {
    	cartes.add(carte);
    }
    
    public boolean aPlusDeCarte() {
    	return !cartes.isEmpty();
    }

	public List<Carte> getCards() {
		return cartes;
	}

	public boolean aUneCarteSelectionnee() {
		return carteSelectionnee != null;
	}

	public Carte getCarteSelectionnee() {
		return carteSelectionnee;
	}

	public void retirerCarte(Carte carte) {
		cartes.remove(carte);
	}

}
