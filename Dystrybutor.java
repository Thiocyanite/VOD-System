package com.company;

import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Random;

import static java.lang.Thread.sleep;


public class Dystrybutor implements Serializable {
    private Umowa aktualnaUmowa;
    private int czasDoNowejUmowy;
    private String nazwa;
    Systemik systemik;

    public Dystrybutor(Systemik systemik, String nazwa){
        this.nazwa=nazwa;
        this.systemik=systemik;
        systemik.dystrybutorzy.add(this);
        czasDoNowejUmowy=4;
        aktualnaUmowa = new Umowa();
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


    public void produkuj(){
        Random generator = new Random();
        int wait=generator.nextInt(9000), produce=generator.nextInt(3);
        try {
            sleep(wait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
