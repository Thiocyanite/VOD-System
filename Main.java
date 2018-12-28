package com.company;

public class Main {

    public static void main(String[] args) {
        String s;
        Systemik systemik=new Systemik();
        Dystrybutor dystrybutor=new Dystrybutor(systemik, "Nuclear Blast");
        Dystrybutor dystrybutor1=new Dystrybutor(systemik,"Best");
        Klient klient=new Klient(systemik);
        System.out.println(systemik);
        System.out.println(systemik.tydzien());
        System.out.println(systemik.tydzien());
        System.out.println(systemik.tydzien());
        Klient klient1=new Klient(systemik);
        System.out.println(systemik.tydzien());
        System.out.println(systemik.tydzien());
        System.out.println(systemik.tydzien());
        System.out.println(systemik);

    }
}
