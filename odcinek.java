package com.company;

import java.io.Serializable;
import java.util.Random;


public class odcinek implements Serializable{
    private int dataPremiery;
    private int czasTrwania;
    private int czasDoOgladaniaPoZakupie;

    public odcinek(){
        Random generator = new Random();
        dataPremiery=1980+generator.nextInt(39);
        czasTrwania=generator.nextInt(91);
        czasDoOgladaniaPoZakupie=generator.nextInt(61);
    }


    @Override
    public String toString(){
        return "(" + dataPremiery + ","+czasTrwania+","+czasDoOgladaniaPoZakupie+")";
    }

    public int getDataPremiery() {
        return dataPremiery;
    }

    public int getCzasTrwania() {
        return czasTrwania;
    }

    public int getCzasDoOgladaniaPoZakupie() {
        return czasDoOgladaniaPoZakupie;
    }


}
