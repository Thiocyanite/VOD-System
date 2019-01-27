package com.company;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.fxml.FXML;
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

import java.net.URL;
import java.util.*;

import static com.company.Main.symulacja;


public class Controller {

    @FXML
    private Text stanKonta;
    @FXML
    private Text niebezpieczenstwo;
    @FXML
    private Text tydzien;

    @FXML
    private Text nazwa;
    @FXML
    private Text gatunek;
    @FXML
    private Text rokProdukcji;
    @FXML
    private Text ocena;
    @FXML
    private Text cena;
    @FXML
    private Text nrKarty;
    @FXML
    private Text eMail;
    @FXML
    private Text abonament;
    @FXML
    private Text data;
    @FXML
    private Text zyski;
    @FXML
    private Text dystrybutor;

    @FXML
    volatile  private ListView listaOgladanych = new ListView();
    volatile private ListProperty<Ogladadlo> listaOgladanychProperty = new SimpleListProperty<>();

    @FXML
    volatile private ListView listaLivow = new ListView();
    volatile private ListProperty<LiveStream> listaLivowProperty = new SimpleListProperty<>();

    @FXML
    volatile private ListView listaDystrybutorow = new ListView();
    volatile private ListProperty<Dystrybutor> listaDystrybutorowProperty = new SimpleListProperty<>();

    @FXML
    volatile private ListView listaUzyszkodnikow = new ListView();
    volatile private ListProperty<Klient> listaUzyszkodnikowProperty = new SimpleListProperty<>();


    public Controller(){}

    public void initialize(){
        listaDystrybutorow.itemsProperty().bind(listaDystrybutorowProperty);
        listaDystrybutorowProperty.set(symulacja.vod.dystrybutorzy);

        listaLivow.itemsProperty().bind(listaLivowProperty);
        listaLivowProperty.set(symulacja.vod.live);

        listaOgladanych.itemsProperty().bind(listaOgladanychProperty);
        listaOgladanychProperty.set(symulacja.vod.ogladane);

        listaUzyszkodnikow.itemsProperty().bind(listaUzyszkodnikowProperty);
        listaUzyszkodnikowProperty.set(symulacja.vod.uzyskodniki);
    }



    public void zapisz(){
        symulacja.zapis();
    }

    public void odczyt(){
        symulacja.odczyt();
    }

    public void tydzienn(){
        symulacja.tydzien();
    }

    public void dodajDystrybutora(){
        symulacja.dodajDystrybutora();
    }



    public void aktualizuj(Symulacja symulacja){
        tydzien.setText(Integer.toString(symulacja.getTydzien()));
        stanKonta.setText(Double.toString(symulacja.getStanKonta()));
        niebezpieczenstwo.setText(Integer.toString(symulacja.getUwaga()));
    }
}
