public class Ryba {
    Ryba(float rozmiar, double waga){
        this.rozmiar=rozmiar;
        this.waga=waga;
        plywa();
    }
    float rozmiar;
    double waga;
    protected void plywa(){
        System.out.println("No pływa, a co ma robić biegać?!");
    }
}
