public class czlowiek {
    static int liczebnosc=0; //jak nie damy static to wyjdzie nam inna liczba
    czlowiek(){
        liczebnosc++;
    }
    String plec;
    String imie;
    String nazwisko;

    public void czesc(){
        System.out.println("Mam na imię "+imie+", a na nazwisko "+nazwisko+", identyfikuję się jako "+plec);
    }
}
