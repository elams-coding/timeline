package com.sae201.timeline.model;

import com.sae201.timeline.pojo.CartePOJO;

public class Carte {
	private String titre;
	private String date;
	private int position;
	private String urlImage;
	
	public Carte(String titre, String date, int position, String urlImage) {
		super();
		this.titre = titre;
		this.date = date;
		this.position = position;
		this.urlImage = urlImage;
	}

	public Carte(CartePOJO cardP, int position) {
		super();
		this.titre = cardP.nom;
		this.date = cardP.date;
		this.position = position;
		this.urlImage = cardP.url;
	}

	public String getTitre() {
		return titre;
	}

	public String getDate() {
		return date;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public int getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "Carte [titre=" + titre + ", date=" + date + ", position=" + position + "]";
	}
}
