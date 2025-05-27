package com.sae201.timeline.util;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.control.Alert;

/**
 * Service utilitaire pour l'affichage des boîtes de dialogue dans
 * l'application.
 * Cette classe fournit des méthodes statiques pour afficher différents types de
 * dialogues,
 * notamment pour les fonctionnalités non disponibles et les erreurs de
 * chargement.
 */
public abstract class DialogueUtilitaire {
    private static final Logger LOGGER = Logger.getLogger(DialogueUtilitaire.class.getName());
    private static final String TITRE_INFORMATION_PAR_DEFAUT = "Fonctionnalité";
    private static final String MESSAGE_INFORMATION_PAR_DEFAUT = TITRE_INFORMATION_PAR_DEFAUT + " à venir";
    private static final String TITRE_ERREUR_PAR_DEFAUT = "Erreur";
    private static final String PREFIX_ERREUR_DIALOGUE = "Erreur lors de l'affichage de la boîte de dialogue : ";
    private static final String HEADER_VUE_IMPOSSIBLE = "Impossible de charger la vue";

    /**
     * Affiche une boîte de dialogue pour une fonctionnalité non disponible avec un
     * titre et un message personnalisés.
     *
     * @param titre   Le titre de la boîte de dialogue
     * @param message Le message à afficher dans la boîte de dialogue
     */
    public static void afficherFonctionnaliteNonDisponible(String titre, String message) {
        Objects.requireNonNull(titre, "Le titre ne peut pas être null");
        Objects.requireNonNull(message, "Le message ne peut pas être null");
        try {
            Alert information = new Alert(Alert.AlertType.INFORMATION);
            information.setTitle(titre);
            information.setHeaderText(TITRE_INFORMATION_PAR_DEFAUT + " indisponible");
            information.setContentText(message);
            information.showAndWait();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, PREFIX_ERREUR_DIALOGUE, e);
        }
    }

    /**
     * Affiche une boîte de dialogue pour une fonctionnalité non disponible avec un
     * message personnalisé.
     * Le titre par défaut sera utilisé.
     *
     * @param message Le message à afficher dans la boîte de dialogue
     */
    public static void afficherFonctionnaliteNonDisponible(String message) {
        afficherFonctionnaliteNonDisponible(TITRE_INFORMATION_PAR_DEFAUT, message);
    }

    /**
     * Affiche une boîte de dialogue pour une fonctionnalité non disponible avec le
     * message par défaut.
     * Utilise le titre et le message par défaut.
     */
    public static void afficherFonctionnaliteNonDisponible() {
        afficherFonctionnaliteNonDisponible(MESSAGE_INFORMATION_PAR_DEFAUT);
    }

    /**
     * Affiche une boîte de dialogue d'erreur pour un chargement de vue impossible
     * avec un titre et un message personnalisés.
     *
     * @param titre   Le titre de la boîte de dialogue d'erreur
     * @param message Le message d'erreur à afficher
     */
    public static void alerterChargementVueImpossible(String titre, String message) {
        try {
            Alert alerte = new Alert(Alert.AlertType.ERROR);
            alerte.setTitle(titre);
            alerte.setHeaderText(HEADER_VUE_IMPOSSIBLE);
            alerte.setContentText(message);
            alerte.showAndWait();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, PREFIX_ERREUR_DIALOGUE, e);
        }
    }

    /**
     * Affiche une boîte de dialogue d'erreur pour un chargement de vue impossible
     * avec un message personnalisé.
     * Le titre par défaut pour les erreurs sera utilisé.
     *
     * @param message Le message d'erreur à afficher
     */
    public static void alerterChargementVueImpossible(String message) {
        alerterChargementVueImpossible(TITRE_ERREUR_PAR_DEFAUT, message);
    }
    
    public static void afficherAlerte(Exception e) {
    	if (e.getCause() != null) {
			DialogueUtilitaire.alerterChargementVueImpossible(e.getCause().getMessage());
		} else {
			DialogueUtilitaire.alerterChargementVueImpossible(e.getMessage());
		}
    }
}