import java.util.List;

public class HranyFilm extends Film {
    public List<String> herci;
    public int hvezdyHodnoceni;
    public HranyFilm(String nazev, String reziser, int rokVydani, List<String> herci, int hodnoceni){
        super(nazev, reziser, rokVydani);
        this.herci = herci;
        this.hvezdyHodnoceni = hodnoceni;
    }

    public List<String> getHerci() {
        return this.herci;
    }

    public void setHerci(List<String> herci) {
        this.herci = herci;
    }
    public int getHvezdyHodnoceni() {
        return this.hvezdyHodnoceni;
    }

    public void setHvezdyHodnoceni(int hvezdyHodnoceni) {
        this.hvezdyHodnoceni = hvezdyHodnoceni;
    }
}
