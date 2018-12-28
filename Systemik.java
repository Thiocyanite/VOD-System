package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Systemik  implements Serializable {
     Collection<Klient> uzyskodniki;
     Collection<Dystrybutor> dystrybutorzy;
     Collection<Ogladadlo> ogladane;
     Collection<LiveStream> live;
    private double stanKonta;
    private double saldo;
    private int tydzien;

    public Systemik(){
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


    @Override
    public String toString() {
        return "Systemik{"+uzyskodniki+","+dystrybutorzy+","+ogladane+","+live+","+stanKonta+","+saldo+","+tydzien+"}";
    }
}


