package com.company;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ControllerUsr {

    @FXML
    private Text nazwa;
    @FXML
    private Text nrKarty;
    @FXML
    private Text eMail;
    @FXML
    private Text abonament;

    public void wyswietlUzyszkodnika(Klient klient){
        nazwa.setText(klient.getNazwa());
        eMail.setText(klient.getEmail());
        nrKarty.setText(Integer.toString(klient.getNrKarty()));
        if (klient.getAbonament()!= null)
            abonament.setText(klient.getAbonament().getTyp());
        else abonament.setText("Niewykupiony");

    }
}
