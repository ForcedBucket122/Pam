public class Czlowiek implements Comparable <Czlowiek>{
    public Czlowiek(String imie){
        this.imie=imie;
    }
    String imie;

    @Override
    public int compareTo(Czlowiek o) {
        return this.imie.compareTo(o.imie);
    }
}