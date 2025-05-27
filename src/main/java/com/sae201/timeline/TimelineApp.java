package com.sae201.timeline;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.sae201.timeline.utilitaire.DialogueUtilitaire.alerterChargementVueImpossible;

public class TimelineApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) {
        String cheminVueAccueil = "/com/sae201/timeline/accueil.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(cheminVueAccueil));
        try {
            Scene scene = new Scene(loader.load());
            stage.setTitle("Timeline");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            if (e.getCause() != null) {
                alerterChargementVueImpossible(e.getCause().getMessage());
            } else {
                alerterChargementVueImpossible(e.getMessage());
            }
        }
    }
}
