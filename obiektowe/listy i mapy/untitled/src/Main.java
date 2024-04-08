import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>(); //pracuje na dużych zbiorach, metody te same jak w arraylist
        lista.add("Polska");
        lista.add("Polska");
        lista.add("portugalia");
        lista.add("Pakistan");
        for (String l: lista){
            System.out.println(l);
        }
        System.out.println("...................................");
        HashMap<Integer,String> mapa = new HashMap<>(); //mapa przyjmuje klucz i wartosc, podobnie jak w tablicach asocjacycjnch, typ generyczny podwojny
        mapa.put(1,"Polska");
        mapa.put(2,"Polska"); //Te sane klucze nie beda funkcjonowac
        mapa.put(3,"portugalia");
        mapa.put(4,"Pakistan");
        System.out.println(mapa.get(2)); //get dziala na kluczach nie na indeksach
        System.out.println("...................................");
        for (String m: mapa.values()){
            System.out.println(m); //W tej mapie nie mozemy wyswietlac za pomoca petli obiektowej samych wartosci, dlatego trzeba odwołac się do metody
        }
        System.out.println("...................................");
        HashSet<String> mapa2 = new HashSet<>();
        mapa2.add("Polska");
        mapa2.add("portugalia");
        mapa2.add("Pakistan");
        for (String m2: mapa2){
            System.out.println(m2); //Po1 nie wyswietla po kolei wartosci, tylkmo losowo, po 2 te same wartosci nie sa wyswietlane
        }
        //porownaj z linkedhashset
    }
}