package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


public class Systemik extends Thread implements Serializable {
     ArrayList<Klient> uzyskodniki;
     ArrayList<Dystrybutor> dystrybutorzy;
     ArrayList<Ogladadlo> ogladane;
     ArrayList<LiveStream> live;
    private double stanKonta;
    private double saldo;
    double saldoPoMiesiacu;
    int tydzien;
    Symulacja symulacja;

    public Systemik(Symulacja symulacja){
        this.symulacja=symulacja;
        uzyskodniki=new ArrayList();
        dystrybutorzy=new ArrayList<>();
        ogladane=new ArrayList<>();
        live=new ArrayList<>();
        stanKonta=0;
        saldo=0;
        tydzien=0;
    }

    public void wyplac(double zabrane){
        stanKonta-=zabrane;
        saldo-=zabrane;
    }

    public void wplac(double zysk){
        stanKonta+=zysk;
        saldo+=zysk;
    }

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

    @Override
    public String toString() {
        return "Systemik{"+uzyskodniki+","+dystrybutorzy+","+ogladane+","+live+","+stanKonta+","+saldo+","+tydzien+"}";
    }
}


