package com.company;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sun.awt.SunHints;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import static com.company.Main.symulacja;


public class Controller {
    private Scene bankrut, scenaBoczna;
    ControllerLiv cl;
    ControllerOgldn og;
    ControllerUsr us;
    ControllerDystr dy;

    @FXML
    private Text stanKonta;
    @FXML
    private Text niebezpieczenstwo;
    @FXML
    private Text tydzien;


    @FXML
    volatile  private ListView<Ogladadlo> listaOgladanych = new ListView();
    volatile private ListProperty<Ogladadlo> listaOgladanychProperty = new SimpleListProperty<>();

    @FXML
    volatile private ListView<LiveStream> listaLivow = new ListView();
    volatile private ListProperty<LiveStream> listaLivowProperty = new SimpleListProperty<>();

    @FXML
    volatile private ListView<Dystrybutor> listaDystrybutorow = new ListView();
    volatile private ListProperty<Dystrybutor> listaDystrybutorowProperty = new SimpleListProperty<>();

    @FXML
    volatile private ListView<Klient> listaUzyszkodnikow = new ListView();
    volatile private ListProperty<Klient> listaUzyszkodnikowProperty = new SimpleListProperty<>();


    public Controller(){

    }



    public void initialize(){
        listaDystrybutorow.itemsProperty().bind(listaDystrybutorowProperty);
        listaDystrybutorowProperty.set(symulacja.vod.dystrybutorzy);

        listaLivow.itemsProperty().bind(listaLivowProperty);
        listaLivowProperty.set(symulacja.vod.live);

        listaOgladanych.itemsProperty().bind(listaOgladanychProperty);
        listaOgladanychProperty.set(symulacja.vod.ogladane);

        listaUzyszkodnikow.itemsProperty().bind(listaUzyszkodnikowProperty);
        listaUzyszkodnikowProperty.set(symulacja.vod.uzyskodniki);

        listaUzyszkodnikow.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    zaladujUzyszkodnika();
                    us.initialize(newValue);
                    Stage sc= new Stage();
                    noweOknoBoczne(sc);
                });
        listaOgladanych.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            zaladujOgladane();
            og.initialize(newValue);
            Stage sc=new Stage();
            noweOknoBoczne(sc);
        });

        listaLivow.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            zaladujLive();
            cl.initialize(newValue);
            Stage sc=new Stage();
            noweOknoBoczne(sc);
        });

        listaDystrybutorow.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            zaladujDystrybutora();
            dy.initialize(newValue);
            Stage sc=new Stage();
            noweOknoBoczne(sc);
        });



    }



    public void zapisz(){
        symulacja.zapis();
    }

    public void odczyt(){
        symulacja.odczyt();
    }

    public void tydzienn(){
        symulacja.tydzien();
        aktualizuj(symulacja);
    }

    public void dodajDystrybutora(){
        symulacja.dodajDystrybutora();
    }



    public void aktualizuj(Symulacja symulacja){
        tydzien.setText(Integer.toString(symulacja.getTydzien()));
        stanKonta.setText(Double.toString(symulacja.getStanKonta()));
        niebezpieczenstwo.setText(Integer.toString(symulacja.getUwaga()));
        if (symulacja.getUwaga()==3){
            Stage end =new Stage();
            zaladujBankruta();
            noweOknoBankructwa(end);
        }

    }



    private void noweOknoBoczne(Stage okno){
        okno.setTitle("Przegladaj dane systemu");
        okno.setScene(scenaBoczna);
        okno.show();
    }


    private void noweOknoBankructwa(Stage okno){
        okno.setTitle("Nie udalo sie, system zbankrutowal");
        okno.setScene(bankrut);
        okno.show();
    }

    private void zaladujBankruta(){
        try {
            Parent bankrucik = FXMLLoader.load(getClass().getResource("end.fxml"));
            bankrut=new Scene(bankrucik,400,400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void zaladujOgladane(){
        try {
            Parent dodatkowy = FXMLLoader.load(getClass().getResource("ogladane.fxml"));
            scenaBoczna=new Scene(dodatkowy,600,400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void zaladujLive(){
        try {
            Parent dodatkowy = FXMLLoader.load(getClass().getResource("live.fxml"));
            scenaBoczna=new Scene(dodatkowy,600,400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void zaladujDystrybutora(){
        try {

            Parent dodatkowy = FXMLLoader.load(getClass().getResource("dystry.fxml"));
            scenaBoczna=new Scene(dodatkowy,600,400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void zaladujUzyszkodnika(){
        try {

            Parent dodatkowy = FXMLLoader.load(getClass().getResource("user.fxml"));
            scenaBoczna=new Scene(dodatkowy,600,400);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
