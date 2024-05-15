public class Samochod extends Pojazd{
    boolean otwarty = false;
    void zamknijOtworz(){
        otwarty = !otwarty;
        if (otwarty)
            System.out.println("Otwart");
        else
            System.out.println("Zamknięto");
    }
}
