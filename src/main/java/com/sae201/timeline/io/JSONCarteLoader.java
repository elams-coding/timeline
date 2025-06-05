package com.sae201.timeline.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sae201.timeline.model.Carte;
import com.sae201.timeline.pojo.CartePOJO;
import com.sae201.timeline.pojo.CollectionPOJO;

import java.io.File;
import java.io.IOException;

public class JSONCarteLoader extends CarteLoader {

	private static final String PATH = "data.json";

	@Override
	public void load() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		CollectionPOJO result;
		try {
			File file = new File(PATH);
			result = objectMapper.readValue(file, CollectionPOJO.class);

			setTitre(result.nom);

			int pos = 0;
			for (CartePOJO cardP : result.cartes) {
				ajouterCarte(new Carte(cardP, pos++));
			}
		} catch (JsonProcessingException e) {
			System.err.println("Probleme avec le json");
		} catch (IOException e) {
			System.err.println("Probleme avec le fichier des données");
			e.printStackTrace();
		}
	}
}
