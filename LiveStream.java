package com.company;
import java.io.Serializable;
import java.util.Random;

public class LiveStream implements Serializable {
    private String nazwa;
    private double cena;
    private int data;

    public LiveStream(int data) {
        Random generator = new Random();
        this.data = data + generator.nextInt(120);
        cena=50+generator.nextInt(191)*5; //between 50 and 1k
        int pom = generator.nextInt(9);
        switch(pom){
            case 0:
                nazwa="Epica: ";
            case 1:
                nazwa="Nightwish: ";
            case 2:
                nazwa="Within Temptation: ";
            case 3:
                nazwa="XIII Stoleti: ";
            case 4:
                nazwa="Iron Maiden: ";
            case 5:
                nazwa="Hatsune Miku: ";
            case 6:
                nazwa="Rammstein: ";
            case 7:
                nazwa="Sabaton: ";
            case 8:
                nazwa="Xandria: ";
        }
        pom=generator.nextInt(12);
        switch(pom){
            case 0:
                nazwa=nazwa+"Londyn";
            case 1:
                nazwa=nazwa+"Poznan";
            case 2:
                nazwa=nazwa+"Berlin";
            case 3:
                nazwa=nazwa+"Tokio";
            case 4:
                nazwa=nazwa+"Paryz";
            case 5:
                nazwa=nazwa+"Amsterdam";
            case 6:
                nazwa=nazwa+"Oslo";
            case 7:
                nazwa=nazwa+"Praga";
            case 8:
                nazwa=nazwa+"Moskwa";
            case 9:
                nazwa=nazwa+"Wieden";
            case 10:
                nazwa=nazwa+"Sztokholm";
            case 11:
                nazwa=nazwa+"Helsinki";
        }

    }


    @Override
    public String toString() {
        return "LiveStream{" + "nazwa=" + nazwa + ", cena=" + cena + '}';
    }
}
