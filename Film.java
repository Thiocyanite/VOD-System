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
    private Promocja aktualnaPromocja;


    public Film(String nazwa,int rok, double ocena, String gatunek, double cena, String link, int dni, double czas, Dystrybutor dystrybutor){
        super(nazwa,rok, ocena, gatunek, cena, dystrybutor);
        this.zwiastun=link;
        this.dniDoOgladaniaPoZakupie=dni;

    }

    public void dodajPromocje(int tyg){
        aktualnaPromocja=new Promocja(tyg);
    }

    public void usunPromocje(){
        aktualnaPromocja=null;
    }

    public double getcena(){
        if (aktualnaPromocja==null)
                return this.cena;
        return this.cena*(1-aktualnaPromocja.getUpust());
    }

    public Film(Dystrybutor dystrybutor){
        super(dystrybutor);
        Random generator= new Random();
        this.dniDoOgladaniaPoZakupie=generator.nextInt(60);
    }
}
