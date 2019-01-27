package com.company;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ControllerLiv {

    @FXML
    private Text nazwa;

    @FXML
    private Text cena;

    @FXML
    private Text data;

    @FXML
    private Text dystrybutor;


    public void wyswietlLive(LiveStream live){
        nazwa.setText(live.getNazwa());
        data.setText(Integer.toString(live.getData()));
        cena.setText(Double.toString(live.getCena()));
        dystrybutor.setText(live.getDystrybutor().getNazwa());
    }

}
