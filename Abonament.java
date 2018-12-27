package com.company;
import java.io.Serializable;
import java.util.Random;

public class Abonament implements Serializable {
    private String typ;
    private double cena;
    private int urzadzenia;
    private String rozdzielczosc;

    @Override
    public String toString() {
        return "Abonament{" + "typ=" + typ + ", cena=" + cena + ", urzadzenia=" + urzadzenia + ", rozdzielczosc=" + rozdzielczosc + '}';
    }


    public Abonament(){
        Random generator =new Random();
        int pom=generator.nextInt(3);
        switch(pom){
            case 0:
            {typ="Basic";
                cena=30;
                urzadzenia=1;
                rozdzielczosc="FullHD";}
            case 1:
            {typ="Premium";
                cena=80;
                urzadzenia=3;
                rozdzielczosc="4k";}
            case 2:
            {typ="Family";
                cena=90;
                urzadzenia=5;
                rozdzielczosc="FullHD";}
        }
    }

    public double getCena() {
        return cena;
    }

}
