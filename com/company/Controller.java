package com.company;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import javax.swing.text.html.ListView;

public class Controller {

    @FXML
    private Text stanKonta, niebezpieczenstwo, tydzien;

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



}
