package com.company;

import java.io.Serializable;
import java.util.ArrayList;


public class sezon implements Serializable {

    @Override
    public String toString() {
        return "sezon{" + "odcinki=" + odcinki + '}';
    }
    private ArrayList<odcinek> odcinki;

    public sezon(){
        odcinki = new ArrayList<>();
        this.dodajodcinek();
    }

    public void dodajodcinek(){
        odcinek pom = new odcinek();
        odcinki.add(pom);
    }
}
