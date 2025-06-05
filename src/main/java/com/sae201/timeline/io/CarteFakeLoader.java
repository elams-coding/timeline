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
		setTitre("Les Distributions Linux");
		ajouterCarte(new Carte("Ubuntu", "2004", 1, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Ubuntu-logo-2022.svg/langfr-330px-Ubuntu-logo-2022.svg.png"));
		ajouterCarte(new Carte("Debian", "1993", 2, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Debian-OpenLogo.svg/langfr-75px-Debian-OpenLogo.svg.png"));
		ajouterCarte(new Carte("Fedora", "2002", 3, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8f/Fedora_logo_%282021%29.svg/langfr-330px-Fedora_logo_%282021%29.svg.png"));
		ajouterCarte(new Carte("Arch Linux", "2002",  4, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/Archlinux-logo-standard-version.svg/langfr-500px-Archlinux-logo-standard-version.svg.png"));

	}
}
