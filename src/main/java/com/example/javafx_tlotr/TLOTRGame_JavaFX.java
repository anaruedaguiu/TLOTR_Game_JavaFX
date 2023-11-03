package com.example.javafx_tlotr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TLOTRGame_JavaFX extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TLOTRGame_JavaFX.class.getResource("hello-view.fxml"));
        Pane content = fxmlLoader.load();

        StackPane root = new StackPane(content);
        Scene scene = new Scene(root, 771, 798);

        stage.setTitle("Batalla por la Tierra Media");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}