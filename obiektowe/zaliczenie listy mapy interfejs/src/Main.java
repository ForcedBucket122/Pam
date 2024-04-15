import java.util.*;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {

        Czlowiek mateusz=new Czlowiek("Mateusz");
        Czlowiek adam=new Czlowiek("Adam");
        Czlowiek konrad=new Czlowiek("Konrad");

        ArrayList lista=new ArrayList();
        lista.add(mateusz);
        lista.add(adam);
        lista.add(konrad);

        Collections.sort(lista);
        System.out.println(lista.contains(mateusz));
        System.out.println(lista.size());
        System.out.println(lista.isEmpty());
        for(Object i: lista){
            System.out.println(((Czlowiek)i).imie);
        }

        HashMap<Integer, String> mapa = new HashMap();
        mapa.put(1,"a");
        mapa.put(2,"b");
        mapa.put(3,"c");
        mapa.put(4,"d");

        System.out.println(mapa.get(1));
        System.out.println(mapa.remove(1));
        System.out.println(mapa.containsKey(1));
        System.out.println(Collections.min(mapa.keySet()));

        for (String m: mapa.values()){
            System.out.println(m);
        }

    }
}
//podobienstwa: wspolne metody (oprocz add -> w mapach jest put),
//przeciwienstwa: zamiast add jest put, mapa zawiera klucze ktorych wartosci nie moga sie powtarzac, mapa dziala tylko na 2 podawanych typach danych dla klucza i elementow
//dziala tylko na wybranym typie danych, przez klucze nie mozna na mapach uzyc niektorych metod klasy collections