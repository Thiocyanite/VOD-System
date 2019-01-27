package com.company;

import java.io.Serializable;
import java.util.Random;


public class Promocja implements Serializable {
    private int tydzienRozpoczecia;
    private int tydzienZakonczenia;
    private double upust;

    public Promocja(int aktualnyTydzien){
        Random generator=new Random();
        tydzienRozpoczecia= aktualnyTydzien+generator.nextInt(4);
        tydzienZakonczenia=tydzienRozpoczecia+generator.nextInt(5);
        upust=(5+generator.nextInt(45))*0.01;
    }


    /**
     * wyświetl upust
     * @return upust
     */
    public double getUpust(){
        return upust;
    }

    /**
     * zwróć tydzień zakończenia promocji
     * @return koniec promocji
     */
    public int getKoniec(){
        return tydzienZakonczenia;
    }


    @Override
    public String toString() {
        return "Promocja{" +  tydzienRozpoczecia + "," + tydzienZakonczenia + ", " + upust + '}';
    }

}
