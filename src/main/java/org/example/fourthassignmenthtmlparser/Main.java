package org.example.fourthassignmenthtmlparser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        scene.getStylesheets().add(getClass().getResource("styles/main-page.css").toExternalForm());

        stage.setTitle("Countries Scraper");
        stage.setScene(scene);
        stage.show();
    }

    public static void  main(String[] args){
        launch();
    }
}
