import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Collections;
public class Main {
    public static void main(String[] args) {
        LinkedList<String> lista=new LinkedList<>();
        for (int i =1; i<7; i++){
            lista.add(String.valueOf(i));
        }
        for (String l: lista){
            System.out.println(l);
        }
        Collections.sort(lista);
        System.out.println(lista.contains("1"));
        System.out.println(lista.indexOf("2"));
        System.out.println(lista.get(5));
        System.out.println("-----------------------------------");
        HashMap<Integer, String> mapa = new HashMap<>();
        for (int i =1; i<7; i++){
            mapa.put(i,String.valueOf(i));
        }
        for (String m: mapa.values()){
            System.out.println(m);
        }
        System.out.println(mapa.containsKey(3));
        System.out.println(mapa.isEmpty());
        System.out.println(Collections.max(mapa.keySet()));
        mapa.clear();
    }
}
//podobienstwa: mapa i lista nie moga miec pustych wartosci oraz posiadaja prawie te same metody
//roznice: mapa uzywa metody put a lista add. Mapa dziala na kluczach oraz wartosciach
//przez co wiele metod z klasy Collections nie działa