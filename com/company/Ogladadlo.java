package com.company;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


public class Ogladadlo implements Serializable {
    private String nazwa;
    private String gatunek;
    private int rokProdukcji;
    private ArrayList<String> krajeProdukcji;
    private double ocena;
    private ArrayList<String> listaAktorow;
     double cena;
    private int wyswietleniaTydzien;
    private ArrayList wyswietlenia;
    private Dystrybutor dystrybutor;

    public String toString(){
        return nazwa+","+gatunek+","+rokProdukcji+","+krajeProdukcji+","+ocena+","+listaAktorow+","+cena+","+wyswietlenia+","+wyswietleniaTydzien;
    }


    public Ogladadlo(String nazwa, int rok, double ocena, String gatunek, double cena, Dystrybutor dystrybutor){
        this.nazwa=nazwa;
        this.gatunek=gatunek;
        this.rokProdukcji=rok;
        this.cena=cena;
        this.dystrybutor=dystrybutor;
        krajeProdukcji=new ArrayList();
        listaAktorow=new ArrayList<>();
        wyswietlenia=new ArrayList();
        wyswietleniaTydzien=0;
    }
    public Ogladadlo(Dystrybutor dystrybutor){
        Random generator = new Random();
        this.dystrybutor=dystrybutor;
        wyswietleniaTydzien=0;
        ocena=generator.nextInt(10);
        int ster= generator.nextInt(6);
        switch (ster){
            case 0:
            { this.gatunek="sensacyjny";
                this.nazwa="Szkalan Pulapka";
            break;}
            case 1:
            {
                this.gatunek="dramat";
                ster=generator.nextInt(3);
                switch (ster){
                    case 0:
                        this.nazwa="Zielona";
                        break;
                    case 1:
                        this.nazwa="Piekny";
                        break;
                    case 2:
                        this.nazwa="Kobiety";
                }
                ster=generator.nextInt(3);
                switch(ster){
                    case 0:
                        this.nazwa=this.nazwa+" Mila";
                        break;
                    case 1:
                        this.nazwa=this.nazwa+" Umysl";
                        break;
                    case 2:
                        this.nazwa=this.nazwa+" Zapach";
                }
                break;}
            case 2:
            {
                this.gatunek="komedia";
                ster=generator.nextInt(3);
                switch (ster){
                    case 0:
                        this.nazwa="Rodzina";
                        break;
                    case 1:
                        this.nazwa="Przygody";
                        break;
                    case 2:
                        this.nazwa="Niedzielny spacer";
                }
                ster=generator.nextInt(3);
                switch (ster){
                    case 0:
                        this.nazwa=this.nazwa+" Addamsow";
                        break;
                    case 1:
                        this.nazwa=this.nazwa+" Tomka";
                        break;
                    case 2:
                        this.nazwa=this.nazwa+" pani Hildegardy";
                }
                break;}
            case 3:
            { this.gatunek="dla dzieci";
                ster= generator.nextInt(5);
                switch (ster){
                    case 0:
                        this.nazwa="Tomek";
                        break;
                    case 1:
                        this.nazwa="Koralina";
                        break;
                    case 2:
                        this.nazwa="Ania";
                        break;
                    case 3:
                        this.nazwa="Charlie";
                        break;
                    case 4:
                        this.nazwa="Alicja";
                }
                ster=generator.nextInt(5);
                switch(ster){
                    case 0:
                        this.nazwa=this.nazwa+" i przyjaciele";
                        break;
                    case 1:
                        this.nazwa=this.nazwa+" i tajemnicze drzwi";
                        break;
                    case 2:
                        this.nazwa=this.nazwa+" z Zielonego Wzgorza";
                        break;
                    case 3:
                        this.nazwa=this.nazwa+" i Fabryka Czekolady";
                        break;
                    case 4:
                        this.nazwa=this.nazwa+" w Krainie Czarow";
                }
                break;}
            case 4:
            {
                this.gatunek="akcja";
                ster=generator.nextInt(4);
                switch(ster){
                    case 0:
                        this.nazwa="Spider";
                        break;
                    case 1:
                        this.nazwa="Iron";
                        break;
                    case 2:
                        this.nazwa="Ant";
                        break;
                    case 3:
                        this.nazwa="Wonder";
                }
                if (generator.nextBoolean())
                    this.nazwa=this.nazwa+" Man";
                else this.nazwa=this.nazwa+" Woman";
                break;}
            case 5:
            {
                this.gatunek="dokument";
                this.nazwa="Zycie ";
                ster=generator.nextInt(6);
                switch(ster){
                    case 0:
                        this.nazwa=this.nazwa+"tygrysow ";
                        break;
                    case 1:
                        this.nazwa=this.nazwa+"niewolnikow ";
                        break;
                    case 2:
                        this.nazwa=this.nazwa+"arystokratow ";
                        break;
                    case 3:
                        this.nazwa=this.nazwa+"pingwinow ";
                        break;
                    case 4:
                        this.nazwa=this.nazwa+"chlopow ";
                        break;
                    case 5:
                        this.nazwa=this.nazwa+"koni ";
                }
                ster=generator.nextInt(5);
                switch(ster){
                    case 0:
                        this.nazwa=this.nazwa+"w XVII wieku";
                        break;
                    case 1:
                        this.nazwa=this.nazwa+ "na terenie Luizjany";
                        break;
                    case 2:
                        this.nazwa=this.nazwa+"w Wersalu";
                        break;
                    case 3:
                        this.nazwa=this.nazwa+"w zatrwazajacym zimnie";
                        break;
                    case 4:
                        this.nazwa=this.nazwa+"cesarskich";
                }
                break;}
        }
        this.rokProdukcji=1980+generator.nextInt(39);
        this.wyswietlenia=new ArrayList();
        this.krajeProdukcji=new ArrayList<>();
        krajeProdukcji.add("USA");
        krajeProdukcji.add("Japonia");
        krajeProdukcji.add("Polska");
        this.listaAktorow=new ArrayList<>();
        listaAktorow.add("Johny Depp");
    }

    /**
     *
     * @return cena produktu
     */
    public double getCena(){
        return this.cena;
    }

    /**
     * zwiększenie ilości wyświetleń
     */
    public void dodajwyswietlenie(){
        synchronized (this) {wyswietleniaTydzien=wyswietleniaTydzien+1;}
    }


    /**
     * dodawanie wyświetleń z tego tygodnia do listy wyświetleń
     */
    public void zmianaTygodnia(){
        wyswietlenia.add(wyswietleniaTydzien);
        dystrybutor.aktualnaUmowa.dodajodtworzenia(wyswietleniaTydzien);
        wyswietleniaTydzien=0;
    }
}
