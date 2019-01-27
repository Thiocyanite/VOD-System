package com.company;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ControllerLiv {
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


    public void wyswietlLive(LiveStream live){
        nazwa.setText(live.getNazwa());
        data.setText(Integer.toString(live.getData()));
        cena.setText(Double.toString(live.getCena()));
        dystrybutor.setText(live.getDystrybutor().getNazwa());
    }

}
