import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>();
        lista.add("Polska");
        lista.add("Polska");
        lista.add("portugalia");
        lista.add("Pakistan");
        for (String l: lista){
            System.out.println(l);
        }
        System.out.println("...................................");
        HashMap<Integer,String> mapa = new HashMap<>();
        mapa.put(1,"Polska");
        mapa.put(2,"Polska");
        mapa.put(3,"portugalia");
        mapa.put(4,"Pakistan");
        System.out.println(mapa.get(2));
        System.out.println("...................................");
        for (String m: mapa.values()){
            System.out.println(m);
        }
        System.out.println("...................................");
        HashSet<String> mapa2 = new HashSet<>();
        mapa2.add("Polska");
        mapa2.add("portugalia");
        mapa2.add("Pakistan");
        for (String m2: mapa2){
            System.out.println(m2);
        }
        //porownaj z linkedhashset
    }
}