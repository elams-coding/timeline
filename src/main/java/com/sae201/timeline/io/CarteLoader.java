package com.sae201.timeline.io;

import com.sae201.timeline.objet.Carte;

import java.util.ArrayList;
import java.util.List;

public abstract class CarteLoader {
	private List<Carte> cartes;
	private String titre;

	public CarteLoader() {
		cartes = new ArrayList<>();
	}

	public abstract void load();

	public List<Carte> getCards() {
		return cartes;
	}

	public void ajouterCarte(Carte carte) {
		cartes.add(carte);
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
}
