import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Czlowiek mezczyzna1= new Czlowiek("Marcin");
        Czlowiek mezczyzna2= new Czlowiek("Michał");
        Czlowiek mezczyzna3= new Czlowiek("Jan");

        ArrayList lista= new ArrayList();//tworzymy liste
        lista.add(mezczyzna1);
        lista.add(mezczyzna2);
        lista.add(mezczyzna3);

        System.out.println("...............................");
        for(Object p: lista){
            System.out.println(((Czlowiek)p).imie);//stworzenie petli obiektowej ktora rzutuje na klase czlowiek, nastepnie jest nazwa potem cecha

        }
        System.out.println("...............................");
        System.out.println(lista.get(0));//pobieramy dane ale wyswietla jak obiekt tego imienia
        System.out.println(((Czlowiek)lista.get(0)).imie);//II sposob, ktora wyswietli konkretna wartosc, taka drobna wada zwyklej listy

        System.out.println("...............................");
        System.out.println(lista.size());//ile jest elementow na liscie

        System.out.println("...............................");
        System.out.println(lista.contains(mezczyzna2));//sprawdza konkretna wartosc na liscie ty boolean
        System.out.println("...............................");
        lista.remove(mezczyzna3);//wdrazamy typ object i usuwa pozycje z listy poprzez nazwe lub indeks

        for (Object p: lista){
            System.out.println(((Czlowiek) p).imie);
            System.out.println("...............................");
            lista.clear();//usuwa wszystko z listy
            System.out.println("Lista generyczna");
            ArrayList<Czlowiek> lista2=new ArrayList<Czlowiek>();//tworzymy liste generyczna
            lista2.add(mezczyzna1);
            lista2.add(mezczyzna2);
            lista2.add(mezczyzna3);
            for (Czlowiek g: lista2){
                System.out.println(g.imie);//prostrza budowa petli
            }
            System.out.println("...............................");
            System.out.println((lista2.get(0).imie));
        }


//        do listy generycznej wprowadz 4 nowe metody, wyjasnij ich znaczeine w komentarzach i
//        zastosuj w praktyce, nastepnie w komentarzach wyjasnij roznice i podobiensta pomiedzy lista zwykla a generyczna
    }
}