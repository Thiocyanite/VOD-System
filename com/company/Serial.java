package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


public class Serial extends Ogladadlo implements Serializable {
    private ArrayList<sezon> sezony;
    private ArrayList<odcinek> odcinkiSpecjalne;
    private Dystrybutor dystrybutor;


    @Override
    public String toString() {
        return "Serial{" + super.toString() + "," + sezony + ", " + odcinkiSpecjalne + '}';
    }


    public Serial(String nazwa, int rok, double ocena, String gatunek, double cena, Dystrybutor dystrybutor) {
        super(nazwa, rok, ocena, gatunek, cena, dystrybutor);
        sezony = new ArrayList<>();
        sezony.add(new sezon());
        odcinkiSpecjalne=new ArrayList<>();
    }

    public Serial(Dystrybutor dystrybutor){
        super(dystrybutor);
        sezony=new ArrayList<>();
        sezony.add(new sezon());
        odcinkiSpecjalne=new ArrayList<>();
    }

    /**
     * dodawanie nowego sezonu
     */
    public void dodajsezon(){
        Random generator = new Random();
        sezon sez = new sezon();
        int k=generator.nextInt(60);
        for (int i=0; i<k;i++){
            sez.dodajodcinek();
        }
        sezony.add(sez);
    }

    /**
     * dodanie odcinka specjalnego
     */
    public void dodajspecjala(){
        odcinek odc = new odcinek();
        odcinkiSpecjalne.add(odc);
    }
}
