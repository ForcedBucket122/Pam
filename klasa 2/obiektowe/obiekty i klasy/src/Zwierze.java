public class Zwierze {
    static int liczebnosc=0; //jak nie damy static to wyjdzie nam inna liczba
    Zwierze(){
        liczebnosc++;
    }
    String imie;
    String glos = "wrr"; //wdrazanie argumentow czyli cech
    public  void dajGlos(int x){
        for (int i=0; i<x;i++){
            System.out.println(glos+" ");
        }
        System.out.println();
    }
    public void przedstawSie(){
        System.out.println("Nazywam się "+imie);
    }
}
