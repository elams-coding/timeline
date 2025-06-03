package com.sae201.timeline.io;

import com.sae201.timeline.pojo.CartePOJO;

import java.util.ArrayList;
import java.util.List;

public abstract class CarteLoader {
	private List<CartePOJO> cartes;
	private String titre;

	public CarteLoader() {
		cartes = new ArrayList<>();
	}

	public abstract void load();

	public List<CartePOJO> getCards() {
		return cartes;
	}

	public void ajouterCarte(CartePOJO carte) {
		cartes.add(carte);
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
}
