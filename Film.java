package com.company;

import java.io.Serializable;
import java.util.Random;


public class Film extends Ogladadlo implements Serializable{

    @Override
    public String toString() {
        return "Film{"+ super.toString() + "," + zwiastun + "," + dniDoOgladaniaPoZakupie + ", " + czasTrwania + '}';
    }
    private String zwiastun;
    private int dniDoOgladaniaPoZakupie;
    private double czasTrwania;

    public Film(String nazwa,int rok, double ocena, String gatunek, double cena, String link, int dni, double czas){
        super(nazwa,rok, ocena, gatunek, cena);
        this.zwiastun=link;
        this.dniDoOgladaniaPoZakupie=dni;

    }

    public Film(){
        super();
        Random generator= new Random();
        this.dniDoOgladaniaPoZakupie=generator.nextInt(60);
    }
}
