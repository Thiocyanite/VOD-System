package com.company;


import java.io.Serializable;
import java.util.Random;




public class Dystrybutor extends Thread implements Serializable {
     Umowa aktualnaUmowa;
    private int czasDoNowejUmowy;
    private String nazwa;
    Systemik systemik;



    public Dystrybutor(Systemik systemik, String nazwa){
        this.nazwa=nazwa;
        this.systemik=systemik;
        systemik.dystrybutorzy.add(this);
        czasDoNowejUmowy=4;
        aktualnaUmowa = new Umowa();
        this.start();
    }

    public void wyprodukujFilm(){
        Film nowProdukcja = new Film(this);
        systemik.ogladane.add(nowProdukcja);
    }

    public void wyprodukujSerial(){
        Serial nowaProdukcja=new Serial(this);
        systemik.ogladane.add(nowaProdukcja);
    }

    public void wyprodukujLive(){
        LiveStream nowaProdukcja=new LiveStream(9 ,this);
        systemik.live.add(nowaProdukcja);
    }


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


    public void rozliczenie(){
        if (czasDoNowejUmowy==0)
        {systemik.wyplac(aktualnaUmowa.wyplac());
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
