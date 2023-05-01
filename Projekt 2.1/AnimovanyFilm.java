import java.util.List;

public class AnimovanyFilm extends Film{

    public List<String> animatori;
    public int bodoveHodnoceni;
    public int vekovaHranice;
    public AnimovanyFilm(String nazev, String reziser, int rokVydani,List<String> animatori, int hodnoceni, int vekovaHranice){
        super(nazev, reziser, rokVydani);
        this.animatori=animatori;
        this.bodoveHodnoceni=hodnoceni;
        this.vekovaHranice = vekovaHranice;
    }
    public List<String> getAnimatori() {
        return animatori;
    }

    public void setAnimatori(List<String> animatori) {
        this.animatori = animatori;
    }

    public int getBodoveHodnoceni(){
        return bodoveHodnoceni;
    }

    public void setBodoveHodnoceni(int bodoveHodnoceni){
        this.bodoveHodnoceni = bodoveHodnoceni;
    }
    public int getVekovaHranice(){
        return vekovaHranice;
    }

    public void setvekovaHranice(int vekovaHranice){
        this.vekovaHranice = vekovaHranice;
    }
}
