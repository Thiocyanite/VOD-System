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
                break;
            case 1:
                nazwa="Nightwish: ";
                break;
            case 2:
                nazwa="Within Temptation: ";
                break;
            case 3:
                nazwa="XIII Stoleti: ";
                break;
            case 4:
                nazwa="Iron Maiden: ";
                break;
            case 5:
                nazwa="Hatsune Miku: ";
                break;
            case 6:
                nazwa="Rammstein: ";
                break;
            case 7:
                nazwa="Sabaton: ";
                break;
            case 8:
                nazwa="Xandria: ";
        }
        pom=generator.nextInt(12);
        switch(pom){
            case 0:
                nazwa=nazwa+"Londyn";
                break;
            case 1:
                nazwa=nazwa+"Poznan";
                break;
            case 2:
                nazwa=nazwa+"Berlin";
                break;
            case 3:
                nazwa=nazwa+"Tokio";
                break;
            case 4:
                nazwa=nazwa+"Paryz";
                break;
            case 5:
                nazwa=nazwa+"Amsterdam";
                break;
            case 6:
                nazwa=nazwa+"Oslo";
                break;
            case 7:
                nazwa=nazwa+"Praga";
                break;
            case 8:
                nazwa=nazwa+"Moskwa";
                break;
            case 9:
                nazwa=nazwa+"Wieden";
                break;
            case 10:
                nazwa=nazwa+"Sztokholm";
                break;
            case 11:
                nazwa=nazwa+"Helsinki";
        }

    }


    @Override
    public String toString() {
        return "LiveStream{" + nazwa + "," + cena + '}';
    }
}
