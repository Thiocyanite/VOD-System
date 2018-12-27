package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


public class Serial extends Ogladadlo implements Serializable {
    private ArrayList<sezon> sezony;
    private ArrayList<odcinek> odcinkiSpecjalne;


    @Override
    public String toString() {
        return "Serial{" + super.toString() + "," + sezony + ", " + odcinkiSpecjalne + '}';
    }


    public Serial(String nazwa, int rok, double ocena, String gatunek, double cena) {
        super(nazwa, rok, ocena, gatunek, cena);
        sezony = new ArrayList<>();
        sezony.add(new sezon());
        odcinkiSpecjalne=new ArrayList<>();
    }

    public Serial(){
        super();
        sezony=new ArrayList<>();
        sezony.add(new sezon());
        odcinkiSpecjalne=new ArrayList<>();
    }

    public void dodajsezon(){
        Random generator = new Random();
        sezon sez = new sezon();
        int k=generator.nextInt(60);
        for (int i=0; i<k;i++){
            sez.dodajodcinek();
        }
        sezony.add(sez);
    }

    public void dodajspecjala(){
        odcinek odc = new odcinek();
        odcinkiSpecjalne.add(odc);
    }
}
