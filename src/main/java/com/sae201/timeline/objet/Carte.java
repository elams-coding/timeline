package com.sae201.timeline.objet;

import java.time.YearMonth;

import javafx.scene.image.Image;

public class Carte {
    private String titre;
    private YearMonth date;
    private Image image;
    private String informations;
    
    public Carte(String titre, YearMonth date, Image image, String informations) {
    	this.titre = titre;
    	this.date = date;
    	this.image = image;
    	this.informations = informations;
    }

	public String getTitre() {
		return titre;
	}

	public YearMonth getDate() {
		return date;
	}

	public Image getImage() {
		return image;
	}

	public String getInformations() {
		return informations;
	}
}
