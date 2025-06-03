package com.sae201.timeline.io;

import com.sae201.timeline.model.Carte;

public class CarteFakeLoader extends CarteLoader {
	@Override
	public void load() {
		setTitre("Fake data");
		ajouterCarte(new Carte("TITRE 1", "1950", 1, "https://upload.wikimedia.org/wikipedia/commons/a/a2/Person_Image_Placeholder.png"));
		ajouterCarte(new Carte("TITRE 2", "1970", 2, "https://upload.wikimedia.org/wikipedia/commons/a/a2/Person_Image_Placeholder.png"));
		ajouterCarte(new Carte("TITRE 3", "1980", 3, "https://upload.wikimedia.org/wikipedia/commons/a/a2/Person_Image_Placeholder.png"));
		ajouterCarte(new Carte("TITRE 4", "1990", 4, "https://upload.wikimedia.org/wikipedia/commons/a/a2/Person_Image_Placeholder.png"));
	}
}
