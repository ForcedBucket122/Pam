import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Czlowiek> mezczyzna = new ArrayList<>();
        Czlowiek marcin = new Czlowiek("Marcin");
        Czlowiek michal = new Czlowiek("Michał");
        Czlowiek ernest = new Czlowiek("Ernest");
        Czlowiek boleslaw = new Czlowiek("Bolesław");
        Czlowiek stanislaw = new Czlowiek("Stanisław");
        Czlowiek mieszko = new Czlowiek("Mieszko");

        mezczyzna.add(marcin);
        mezczyzna.add(michal);
        mezczyzna.add(ernest);
        mezczyzna.add(boleslaw);
        mezczyzna.add(stanislaw);
        mezczyzna.add(mieszko);

        Collections.sort(mezczyzna);
        //klasa Collection nie zadziała bezpośrednio w obiekcie np. sort, dlatego warto skorzystac z interfejsu

        for (Czlowiek l: mezczyzna){
            System.out.println(l.imie);
        }
        Collections.addAll(mezczyzna,marcin,michal); // dodaje wiele elementow do listy na raz
    }
}