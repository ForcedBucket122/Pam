public class Czlowiek implements Comparable<Czlowiek>{
    public Czlowiek(String imie){
        this.imie=imie;
    }
    String imie;
    //zaimplementowalem metode alt enter i wybor z listy
    @Override
    public int compareTo(Czlowiek o) {
        return this.imie.compareTo(o.imie);
    }
}
