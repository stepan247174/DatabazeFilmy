public class Hodnoceni {
    private int bodoveHodnoceni;
    private int hvezdyHodnoceni;

    public Hodnoceni(int bodoveHodnoceni, int hvezdyHodnoceni) {
        this.bodoveHodnoceni = bodoveHodnoceni;
        this.hvezdyHodnoceni = hvezdyHodnoceni;
    }

    public int getBodoveHodnoceni() {
        return bodoveHodnoceni;
    }

    public int getHvezdyHodnoceni() {
        return hvezdyHodnoceni;
    }
}
