public class Film {

    public String nazev;
    public String reziser;
    public int rokVydani;
  


    public Film(String nazev, String reziser, int rokVydani) {
        this.nazev = nazev;
        this.reziser = reziser;
        this.rokVydani = rokVydani;
       
        
        }   
        public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getReziser() {
        return reziser;
    }

    public void setReziser(String reziser) {
        this.reziser = reziser;
    }

    public int getRokVydani() {
        return rokVydani;
    }

    public void setRokVydani(int rokVydani) {
        this.rokVydani = rokVydani;
    }


}
