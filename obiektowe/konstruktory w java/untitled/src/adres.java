public class adres {
    private String miejscowosc;
    private String kod_pocztowy;
    private String nazwa_ulicy;
    private int nr_domu;

    adres(String miejscowosc, String kod_pocztowy, String nazwa_ulicy, int nr_domu){
        this.miejscowosc=miejscowosc;
        this.kod_pocztowy=kod_pocztowy;
        this.nazwa_ulicy=nazwa_ulicy;
        this.nr_domu=nr_domu;
        return toString(miejscowosc+kod_pocztowy+nazwa_ulicy+nr_domu);

    }
}
