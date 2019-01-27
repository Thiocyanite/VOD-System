package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


public class Systemik extends Thread implements Serializable {
     transient ObservableList<Klient> uzyskodniki= FXCollections.observableArrayList();
     transient ObservableList<Dystrybutor> dystrybutorzy= FXCollections.observableArrayList();
     transient ObservableList<Ogladadlo> ogladane= FXCollections.observableArrayList();
     transient ObservableList<LiveStream> live= FXCollections.observableArrayList();
    private double stanKonta;
    private double saldo;
    double saldoPoMiesiacu;
    int tydzien;
    Symulacja symulacja;

    public Systemik(Symulacja symulacja){
        this.symulacja=symulacja;
        stanKonta=0;
        saldo=0;
        tydzien=0;
    }

    /**
     * Odbieranie nam pieniążków :(
     * @param zabrane ile pieniędzy zabrano
     */
    public void wyplac(double zabrane){
        stanKonta-=zabrane;
        saldo-=zabrane;
    }

    /**
     * Dostajemy pieniądze :) :)
     * @param zysk ile pieniędzy zarobione
     */
    public void wplac(double zysk){
        stanKonta+=zysk;
        saldo+=zysk;
    }

    /**
     * tygodniowe rozliczenia: rozliczenia użytkowników i dystrybutorów, usuwanie przedawnionych wydarzeń etc
     */
    public void tydzien(){
        try {
            symulacja.pisarz.acquire();
            symulacja.czytelnik.acquire(30);
            if(tydzien%4==0)
                saldoPoMiesiacu=0;
            tydzien++;

            Random generator = new Random();
            for (int i=0; i<uzyskodniki.size();i++){
                uzyskodniki.get(i).tygodniuj();
                if (generator.nextInt(10)>8)
                    uzyskodniki.get(i).kupAbonament();
            }
            int pom=generator.nextInt((ogladane.size()+live.size()+1));
            for (int i=0;i<pom;i++){
                Klient klient=new Klient(this);
                uzyskodniki.add(klient);
            }

            for (int i=0; i<dystrybutorzy.size();i++){
                dystrybutorzy.get(i).rozliczenie();
            }

            for (int i=0; i<live.size();i++){
                live.get(i).wyswietlenia();
                if (live.get(i).aktualny(tydzien)==false){
                    live.remove(i);
                }
            }
            for (int i=0; i<ogladane.size();i++){
                ogladane.get(i).zmianaTygodnia();
            }

            saldoPoMiesiacu+=saldo;
            symulacja.czytelnik.release(30);
            symulacja.pisarz.release(1);
        } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }

    public double getStanKonta(){
        return stanKonta;
    }

    @Override
    public String toString() {
        return "Systemik{"+uzyskodniki+","+dystrybutorzy+","+ogladane+","+live+","+stanKonta+","+saldo+","+tydzien+"}";
    }
}


