package com.company;

import java.io.Serializable;

import static java.lang.Thread.sleep;

public class Dystrybutor implements Serializable {
    private Umowa aktualnaUmowa;
    private int czasDoNowejUmowy;
    private String nazwa;


    public Dystrybutor(String nazwa){
        this.nazwa=nazwa;
        czasDoNowejUmowy=4;
        aktualnaUmowa = new Umowa();
    }

    public void pracuj(){
        try {
            sleep(10);
            if (czasDoNowejUmowy==0)
                {aktualnaUmowa.wyplac();
                aktualnaUmowa=new Umowa();
                czasDoNowejUmowy=4;}
            else czasDoNowejUmowy--;
            sleep(90);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "Dystrybutor{"+ nazwa+ ","+czasDoNowejUmowy+ ","+ aktualnaUmowa.toString() + "}";
    }
}
