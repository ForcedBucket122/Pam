public class Czlowiek {
    Czlowiek(){
        liczebnosc++;
    }
    //konstruktor w postaci metody bezargumentowy wykona sie przy tworzeniu obiektu
    Czlowiek(String imie){ //konstruktor z argumentami
        this.imie=imie; //rozpoczyna wyszukiwanie na rzecz obiektu na rzecz, którego został wywołany
        liczebnosc++;
    }//Mogą istniec dwa te same konstruktory, ale w argumentach muszą róznić się typem patrz niżej


    public String imie;

    static int liczebnosc=0;//jedna dla calej klasy nie obiektu
}
