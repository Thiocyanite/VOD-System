package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;


public class Klient extends Thread implements Serializable {
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
        this.start();

    }

    /**
     * zakup abonamentu
     */
    public void kupAbonament(){
        if (abonament==null) {
            abonament=new Abonament();
            systemik.wplac(abonament.getCena());
            waznoscAbonamentu=4;}
    }

    /**
     * zmniejszanie czasu ważności abonamentu o tydzień
     */
    public void tygodniuj(){
        if (waznoscAbonamentu>0)
            waznoscAbonamentu--;
    }

    /**
     * generowanie losowych obejrzeń
     */
    public void run(){
        while (true) {
            Random generator = new Random();
            int wait=generator.nextInt(90);
            int obejrz=generator.nextInt(5);
            try {
                sleep(wait);
                    systemik.symulacja.pisarz.acquire(1);
                    systemik.symulacja.pisarz.release(1);
                    systemik.symulacja.czytelnik.acquire(1);
                    if (obejrz>3 && systemik.live.size()>0)
                    {obejrz=generator.nextInt(systemik.live.size());
                    systemik.live.get(obejrz).dodajWyswietlenia();
                    systemik.wplac(systemik.live.get(obejrz).getcena());
                    }
                    else if (systemik.ogladane.size()>0) {
                        obejrz=generator.nextInt(systemik.ogladane.size());
                        systemik.ogladane.get(obejrz).dodajwyswietlenie();
                        if (abonament==null)
                            systemik.wplac(systemik.ogladane.get(obejrz).getCena());
                    }
                    systemik.symulacja.czytelnik.release(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


