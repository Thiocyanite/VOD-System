package com.company;
import java.io.Serializable;
import java.util.Random;

public class  Umowa implements Serializable {
    private String typ;
    private int czas;
    private int zyski;

    public Umowa(){
        Random generator= new Random();
        czas=4;
        if (generator.nextInt(2)==1){
            typ="Ryczalt";
            zyski=500*(generator.nextInt(15)+1);
        }
        else
            typ="Odtworzenia";
    }

    @Override
    public String toString() {
        return "Umowa{" + "typ=" + typ + ", czas=" + czas + ", zyski=" + zyski + '}';
    }


}
