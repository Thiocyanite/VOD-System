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

    public void wyswietlLive(LiveStream live){
    nazwa.setText(live.getNazwa());
    data.setText(Integer.toString(live.getData()));
    cena.setText(Double.toString(live.getCena()));
    dystrybutor.setText(live.getDystrybutor().getNazwa());
    }

    public void wyswietlOgladane(Ogladadlo ogladadlo){
        nazwa.setText(ogladadlo.getNazwa());
        gatunek.setText(ogladadlo.getGatunek());
        rokProdukcji.setText(Integer.toString(ogladadlo.getRokProdukcji()));
        dystrybutor.setText(ogladadlo.getDystrybutor().getNazwa());
        cena.setText(Double.toString(ogladadlo.getCena()));
        ocena.setText(Double.toString(ogladadlo.getOcena()));
    }

    public void wyswietlUzyszkodnika(Klient klient){
        nazwa.setText(klient.getNazwa());
       eMail.setText(klient.getEmail());
       nrKarty.setText(Integer.toString(klient.getNrKarty()));
       if (klient.getAbonament()!= null)
            abonament.setText(klient.getAbonament().getTyp());
       else abonament.setText("Niewykupiony");

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

    public void wyswietlDystrybutora(Dystrybutor dystrybutor){
        nazwa.setText(dystrybutor.getNazwa());
        zyski.setText(Integer.toString(dystrybutor.getZarobione()));
        abonament.setText(dystrybutor.getAktualnaUmowa().getTyp());
    }

    public void aktualizuj(Symulacja symulacja){
        tydzien.setText(Integer.toString(symulacja.getTydzien()));
        stanKonta.setText(Double.toString(symulacja.getStanKonta()));
        niebezpieczenstwo.setText(Integer.toString(symulacja.getUwaga()));
    }
}
