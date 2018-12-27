package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Systemik  implements Serializable {
    private Collection<Klient> uzyskodniki;
    private Collection<Dystrybutor> dystrybutorzy;
    private Collection<Ogladadlo> ogladane;
    private Collection<LiveStream> live;
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

    @Override
    public String toString() {
        return "Systemik{"+uzyskodniki+","+dystrybutorzy+","+ogladane+","+live+","+stanKonta+","+saldo+","+tydzien+"}";
    }
}


