package com.company;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ControllerOgldn {

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
    private Text dystrybutor;


    public void wyswietlOgladane(Ogladadlo ogladadlo){
        nazwa.setText(ogladadlo.getNazwa());
        gatunek.setText(ogladadlo.getGatunek());
        rokProdukcji.setText(Integer.toString(ogladadlo.getRokProdukcji()));
        dystrybutor.setText(ogladadlo.getDystrybutor().getNazwa());
        cena.setText(Double.toString(ogladadlo.getCena()));
        ocena.setText(Double.toString(ogladadlo.getOcena()));
    }



}
