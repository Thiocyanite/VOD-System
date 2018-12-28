package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;



public class Klient implements Serializable {
    private String nazwa;
    private ArrayList dataUrodzenia;
    private String email;
    private int nrKarty;
    private Systemik systemik;
    private Abonament abonament;
    private int waznoscAbonamentu;


    @Override
    public String toString() {
        return "Klient{" + "nazwa=" + nazwa + ", dataUrodzenia=" + dataUrodzenia + ", email=" + email + ", nrKarty=" + nrKarty + ", abonament=" + abonament + ", waznoscAbonamentu=" + waznoscAbonamentu + '}';
    }

    public Klient(Systemik systemik){
        this.systemik=systemik;
        Random generator = new Random();
        dataUrodzenia = new ArrayList();
        dataUrodzenia.add((generator.nextInt(30)+1));
        dataUrodzenia.add((generator.nextInt(12)+1));
        dataUrodzenia.add((generator.nextInt(74)+1945));
        nrKarty=generator.nextInt(99999999);
        int waznoscAbonamentu=0;
        nazwa="BestUser"+generator.nextInt(4000);
        email=nazwa+"@gmail.com";
        systemik.uzyskodniki.add(this);

    }

    public void kupAbonament(){
        abonament=new Abonament();
        systemik.wplac(abonament.getCena());
        waznoscAbonamentu=4;
    }

}
