package com.company;


import java.io.Serializable;
import java.util.Random;




public class Dystrybutor extends Thread implements Serializable {
     Umowa aktualnaUmowa;

    public Umowa getAktualnaUmowa() {
        return aktualnaUmowa;
    }

    public int getCzasDoNowejUmowy() {
        return czasDoNowejUmowy;
    }

    public int getZarobione() {
        return zarobione;
    }

    private int czasDoNowejUmowy;
    private String nazwa;
    private int zarobione;
    Systemik systemik;


    /**
     *
     * @param systemik system VOD

     */
    public Dystrybutor(Systemik systemik){
        zarobione=0;
        Random generator = new Random();
        this.nazwa="Studio "+generator.nextInt(90);
        this.systemik=systemik;
        systemik.dystrybutorzy.add(this);
        czasDoNowejUmowy=4;
        aktualnaUmowa = new Umowa();
        this.start();
    }

    /**
     *
     * @return nazwa dystrybutora
     */
    public String getNazwa(){
        return nazwa;
    }
    /**
     * tworzenie nowego filmu i dodanie go do systemu
     */
    public void wyprodukujFilm(){
        Film nowProdukcja = new Film(this);
        systemik.ogladane.add(nowProdukcja);
    }

    /**
     * tworzenie nowego serialu i dodanie go do systemu
     */
    public void wyprodukujSerial(){
        Serial nowaProdukcja=new Serial(this);
        systemik.ogladane.add(nowaProdukcja);
    }

    /**
     * nie zamierzam tego tłumaczyć
     */
    public void wyprodukujLive(){
        LiveStream nowaProdukcja=new LiveStream(systemik.tydzien,this);
        systemik.live.add(nowaProdukcja);
    }


    /**
     * utworzony dystrybutor bierze się do pracy i w losowym czasie coś dorzuca
     */
    public void run(){
        Random generator = new Random();
        while (true){

            try {
                int wait=generator.nextInt(9000), produce=generator.nextInt(3);
                sleep(wait);
                systemik.symulacja.pisarz.acquire(1);
                systemik.symulacja.pisarz.release(1);
                systemik.symulacja.czytelnik.acquire(1);
                switch (produce){
                    case 0:
                        wyprodukujFilm();
                        break;
                    case 1:
                        wyprodukujSerial();
                        break;
                    case 2:
                        wyprodukujLive();
                }
                systemik.symulacja.czytelnik.release(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * rozliczenie dystrybutora z systemem VOD
     */
    public void rozliczenie(){
        if (czasDoNowejUmowy==0)
        {systemik.wyplac(aktualnaUmowa.wyplac());
        zarobione+=aktualnaUmowa.wyplac();
            czasDoNowejUmowy=4;
            aktualnaUmowa=new Umowa();
        }
        else
            czasDoNowejUmowy--;
    }

    @Override
    public String toString() {
        return "Dystrybutor{"+ nazwa+ ","+czasDoNowejUmowy+ ","+ aktualnaUmowa.toString() + "}";
    }
}
