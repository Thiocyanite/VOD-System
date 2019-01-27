package com.company;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ControllerDystr {
    @FXML
    private Text nazwa;

    @FXML
    private Text abonament;

    @FXML
    private Text zyski;


    public void wyswietlDystrybutora(Dystrybutor dystrybutor){
        nazwa.setText(dystrybutor.getNazwa());
        zyski.setText(Integer.toString(dystrybutor.getZarobione()));
        abonament.setText(dystrybutor.getAktualnaUmowa().getTyp());
    }
}
