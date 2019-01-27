package com.company;


import java.io.*;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Symulacja implements Serializable {
    Systemik vod;
    private int uwaga;
    Semaphore pisarz;
    Semaphore czytelnik;

    public Symulacja(){
        vod=new Systemik(this);
        uwaga=0;
        pisarz=new Semaphore(1);
        czytelnik=new Semaphore(30);
    }


    public void tydzien(){
        try {
            sleep(6000);
            vod.tydzien();
            if (vod.tydzien%4==0){
                if (vod.saldoPoMiesiacu< 0) uwaga++;
                else uwaga=0;}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Tworzenie nowego dystrybutora
     */
    public void dodajDystrybutora(){
        Dystrybutor nowy =new Dystrybutor(vod);

        vod.dystrybutorzy.add(nowy);


    }

    /**
     * Odczytanie stanu symulacji
     */
    public void odczyt(){
        String nazwaPliku="ser.txt";

        try {
            ObjectInputStream in = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(nazwaPliku)));
            uwaga=in.readInt();
            vod=(Systemik) in.readObject();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    /**
     * Zapisanie stanu symulacji
     */
    public void zapis(){
        String nazwaPliku="ser.txt";
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(nazwaPliku)));
            out.writeInt(uwaga);
            out.writeObject(vod);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public int getTydzien(){
        return vod.tydzien;
    }

    public double getStanKonta(){
        return vod.getStanKonta();
    }
    public int getUwaga(){
        return uwaga;
    }

    public String toString(){
        return vod.toString();
    }


}

