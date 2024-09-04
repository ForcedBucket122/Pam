//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        czlowiek Jan = new czlowiek();
        czlowiek Ewa = new czlowiek();
        czlowiek Ala = new czlowiek();

        Jan.plec="mężczyzna";
        Jan.nazwisko="Kowalski";
        Jan.imie="Jan";

        Ewa.plec="kobieta";
        Ewa.nazwisko="Nowak";
        Ewa.imie="Ewa";

        Ala.plec="kobieta";
        Ala.nazwisko="Niezgódka";
        Ala.imie="Ala";

        System.out.println(Jan.liczebnosc);

    }
}