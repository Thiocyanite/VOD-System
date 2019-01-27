package com.company;
import java.io.Serializable;
import java.util.Random;

public class LiveStream implements Serializable {
    private String nazwa;
    private double cena;
    private int data;

    public int getWyswietlenia() {
        return wyswietlenia;
    }

    private int wyswietlenia;
    private Dystrybutor dystrybutor;
    private Promocja aktualnaPromocja;

    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }

    public int getData() {
        return data;
    }

    public Dystrybutor getDystrybutor() {
        return dystrybutor;
    }

    public Promocja getAktualnaPromocja() {
        return aktualnaPromocja;
    }

    public LiveStream(int data, Dystrybutor dystrybutor) {
        Random generator = new Random();
        wyswietlenia=0;
        this.dystrybutor=dystrybutor;
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


    /**
     * dodaje promocję do wydarzenia
     * @param tyg aktualny tydzień
     */
    public void dodajPromocje(int tyg){
        aktualnaPromocja=new Promocja(tyg);
    }

    /**
     * usuwa promocję
     */
    public void usunPromocje(){
        aktualnaPromocja=null;
    }

    /**
     *  zwraca cenę
     * @return cena
     */
    public double getcena(){
        if (aktualnaPromocja==null)
            return this.cena;
        return this.cena*(1-aktualnaPromocja.getUpust());
    }

    /**
     * zwiększenie ilości wyświetleń
     */
    public void dodajWyswietlenia(){
        wyswietlenia++;
    }

    /**
     * dodaje dystrybutorowi wyświetlenia - ważne przy płaceniu za obejrzenie
     */
    public void wyswietlenia(){
        dystrybutor.aktualnaUmowa.dodajodtworzenia(wyswietlenia);
    }

    public boolean aktualny(int tydzien){
        if (this.data<tydzien) return false;
        return true;

    }

    @Override
    public String toString() {
        return "LiveStream{" + nazwa + "," + cena + '}';
    }
}
