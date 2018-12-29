package com.company;

public class Main {

    public static void main(String[] args) {

    Symulacja symulacja=new Symulacja();
    //symulacja.dodajDystrybutora("Nuclear Blast");
    //symulacja.dodajDystrybutora("jeed");

    for (int i=0; i<6; i++)
        {
        symulacja.tydzien();
        System.out.println(symulacja.vod.toString());
        symulacja.dodajDystrybutora("kk");
        }
    System.out.println(symulacja.vod.toString());
    }

}
