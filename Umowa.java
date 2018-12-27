package com.company;
import java.io.Serializable;
import java.util.Random;

public class  Umowa implements Serializable {
    private String typ;
    private int czas;
    private int zyski;
    private int odtworzenia;

    public Umowa(){
        Random generator= new Random();
        czas=4;
        if (generator.nextInt(2)==1){
            typ="Ryczalt";
            zyski=500*(generator.nextInt(15)+1);
        }
        else
            typ="Odtworzenia";
            odtworzenia=0;
            zyski=6;
    }

    @Override
    public String toString() {
        return "Umowa{"  + typ + ", " + czas + ", " + zyski + '}';
    }


}
