package com.company;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import javax.print.DocFlavor;
import javax.swing.text.html.ListView;
import java.awt.*;

public class Controller {

    @FXML
    private Text stanKonta, niebezpieczenstwo, tydzien;

    @FXML
    private Text nazwa, gatunek, rokProdukcji, ocena;
    @FXML
    private Text cena, nrKarty, eMail, abonament;
    @FXML
    private Text data, zyski;
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
