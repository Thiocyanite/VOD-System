package com.company;

public class Main {

    public static void main(String[] args) {
        String s;
        Systemik systemik=new Systemik();
        Dystrybutor dystrybutor=new Dystrybutor(systemik, "Nuclear Blast");
        Dystrybutor dystrybutor1=new Dystrybutor(systemik,"Best");
        dystrybutor1.produkuj();
        dystrybutor.produkuj();
        dystrybutor.produkuj();
        Klient klient=new Klient(systemik);
        klient.ogladaj();
        System.out.println(systemik);

    }
}
