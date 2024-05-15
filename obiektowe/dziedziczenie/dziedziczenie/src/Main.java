public class Main {
    public static void main(String[] args) {
        Samochod audi = new Samochod();
        audi.ilosckol=4;
        audi.marka="Audi";
        System.out.println(audi.ilosckol + " " + audi.marka);
        audi.odpal();

        audi.zamknijOtworz();
        audi.zamknijOtworz();

        SamochodSportowy subaru = new SamochodSportowy();
        subaru.odpal();
    }
}