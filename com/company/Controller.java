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

import java.io.IOException;
import java.net.URL;
import java.util.*;

import static com.company.Main.symulacja;


public class Controller {
    private Scene bankrut;

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



    private void noweOknoBankructwa(Stage okno){
        okno.setTitle("Nie udalo sie, system zbankrutowal");
        okno.setScene(bankrut);
        okno.show();
    }

    private void zaladujBankruta(){
        try {
            ResourceBundle resources = ResourceBundle.getBundle("/");;
            Parent bankrucik = FXMLLoader.load(getClass().getResource("end.fxml"));
            bankrut=new Scene(bankrucik,400,400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
