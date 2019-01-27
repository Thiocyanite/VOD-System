package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {
    private Scene scenaGlowna, scenaBoczna;
    static  Symulacja symulacja;

    public static void main(String[] args) {
    symulacja = new Symulacja();
    launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    zaladujSceneGlowna();
    noweOknoGlowne(primaryStage);
    }


    private void  noweOknoGlowne(Stage okno){
        okno.setTitle("Symulator systemu VOD");
        okno.setScene(scenaGlowna);
        okno.show();
    }

    private void noweOknoBoczne(Stage okno){
        okno.setTitle("Przegladaj dane systemu");
        okno.setScene(scenaBoczna);
        okno.show();
    }


    private void zaladujSceneGlowna(){
        try {

            Parent root = FXMLLoader.load(getClass().getResource("gui1.fxml"));
            scenaGlowna = new Scene(root, 600,400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void zaladujOgladane(){
        try {
            ResourceBundle resources = ResourceBundle.getBundle("/");;
            Parent dodatkowy = FXMLLoader.load(getClass().getResource("ogladane.fxml"));
            scenaBoczna=new Scene(dodatkowy,600,400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void zaladujLive(){
        try {
            ResourceBundle resources = ResourceBundle.getBundle("/");;
            Parent dodatkowy = FXMLLoader.load(getClass().getResource("live.fxml"));
            scenaBoczna=new Scene(dodatkowy,600,400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void zaladujDystrybutora(){
        try {
            ResourceBundle resources = ResourceBundle.getBundle("/");;
            Parent dodatkowy = FXMLLoader.load(getClass().getResource("dystry.fxml"));
            scenaBoczna=new Scene(dodatkowy,600,400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void zaladujUzyszkodnika(){
        try {
            ResourceBundle resources = ResourceBundle.getBundle("/");;
            Parent dodatkowy = FXMLLoader.load(getClass().getResource("user.fxml"));
            scenaBoczna=new Scene(dodatkowy,600,400);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }






}
