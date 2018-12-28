package com.company;
import java.io.Serializable;
import java.util.Random;

public class  Umowa implements Serializable {
    private String typ;
    private int zyski;
    private int odtworzenia;

    public Umowa(){
        Random generator= new Random();
        odtworzenia=0;

        if (generator.nextInt(2)==1){
            typ="Ryczalt";
            zyski=500*(generator.nextInt(15)+1);
        }
        else
            typ="Odtworzenia";

            zyski=6;
    }

    public  int wyplac(){
        if (typ=="Ryczalt")
            return zyski;
        else
            return odtworzenia*zyski;
    }

    public  void dodajodtworzenia(int ilosc){
        odtworzenia+=ilosc;
    }
    @Override
    public String toString() {
        return "Umowa{" + typ  + ", " + zyski + '}';
    }


}
