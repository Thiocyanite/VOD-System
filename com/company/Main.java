package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Scene scena;
    private Symulacja symulacja;

    public static void main(String[] args) {

    Symulacja symulacja=new Symulacja();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("gui1.fxml"));
    scena= new Scene(root, 600,400);
        primaryStage.setTitle("Symulator systemu VOD");
    primaryStage.setScene(scena);
    primaryStage.show();


    }
}
