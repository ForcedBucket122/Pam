//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int liczba = 100;
        System.out.println("Liczba przed konwersją "+liczba);
        konwertuj(liczba);
        System.out.println("Liczba po konwersji "+liczba);

        Liczba liczba2 = new Liczba();
        liczba2.liczba=100;
        System.out.println("Liczba przed kowersją "+liczba2.liczba);
        konwertuj(liczba2);
        System.out.println("Liczba po kowersji "+liczba2.liczba);

    }
    public static void konwertuj(int liczba) {liczba=-5;}

    public static void konwertuj(Liczba liczba2){liczba2.liczba=-5;}
}
//stworz klase ryba i przypisz do niej cechy public rozmiar private
// gatunek private zbiornik nastepnie stworz konstruktor z argumentami
// na podstawie tych cech pozniej w klasie Main stworz 2 obiekty w jednym
// przypisz wartosci na podstawie konstruktora w drugim przypisz wartosci w sposob standardowy