import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FilmManager {
    
    
    public ArrayList<HranyFilm> hraneFilmy;
    public ArrayList<AnimovanyFilm> animovaneFilmy;
    List<String>vsichni;

    public static sqlite sqlDatabase = new sqlite(); 
    
    public FilmManager() throws SQLException { 
        this.animovaneFilmy =  new ArrayList<AnimovanyFilm>();
        this.hraneFilmy = new ArrayList<HranyFilm>();      
    }
    
    public void pridejFilm(String nazev, String reziser, int rokVydani, ArrayList<String> herci, int vekovaHranice, ArrayList<String> animatori, int hodnoceni) {
        Scanner sc = new Scanner(System.in);
    System.out.println("Stisknete 1 pro pridani animovaneho filmu a 2 pro pridani hraneho filmu.");
    int typ = sc.nextInt();
        try{
            if (typ == 1) {
                AnimovanyFilm novyFilm = new AnimovanyFilm(nazev, reziser, rokVydani, animatori, hodnoceni, vekovaHranice);
                animovaneFilmy.add(novyFilm);
            } else if (typ == 2) {
                HranyFilm novyFilm = new HranyFilm(nazev, reziser, rokVydani, herci, hodnoceni);
                hraneFilmy.add(novyFilm);
            }
            else {
                System.out.println("Vlozte cislo 1 nebo 2");
            }
        }
            finally {
                sc.close();
                }

    }
    
    public void upravFilm(String nazev, String novyNazev, String novyReziser, int novyRokVydani, ArrayList<String> noviAnimatori, int novaVekovaHranice, ArrayList<String> noviHerci) throws SQLException {
        
        Film film = this.najdiFilm(nazev);
        if (film instanceof AnimovanyFilm) {
            AnimovanyFilm animovanyFilm = (AnimovanyFilm) film;
            animovanyFilm.setNazev(novyNazev);
            animovanyFilm.setReziser(novyReziser);
            animovanyFilm.setRokVydani(novyRokVydani);
            animovanyFilm.setAnimatori(noviAnimatori);
            animovanyFilm.setvekovaHranice(novaVekovaHranice);
        } else if(film instanceof HranyFilm){ HranyFilm hranyFilm = (HranyFilm) film;
            hranyFilm.setNazev(novyNazev);
            hranyFilm.setReziser(novyReziser);
            hranyFilm.setRokVydani(novyRokVydani);
            hranyFilm.setHerci(noviHerci);
        }
    }
    
    public void smazFilm(String nazev) throws SQLException {
       
        Film film = this.najdiFilm(nazev);
        animovaneFilmy.remove(film);
    }
    
    public void pridejHodnoceni(String nazev, int bodoveHodnoceni, int hvezdyHodnoceni) throws SQLException {
        
        HranyFilm hranyFilm = new HranyFilm(nazev, nazev, bodoveHodnoceni, vsichni, hvezdyHodnoceni);
        Film film = this.najdiFilm(nazev);
        Hodnoceni hodnoceni = new Hodnoceni(bodoveHodnoceni, hvezdyHodnoceni);
        hranyFilm.setHvezdyHodnoceni(hvezdyHodnoceni);
    }
    
    public void vypisFilmy(){
        for (Film film : sqlDatabase.getFilms(hraneFilmy)) {
        System.out.println(film.toString());
        }
    }
    public Film najdiFilm(String nazev) throws SQLException {
        for (Film film : this.animovaneFilmy) {
            if(film.nazev==nazev) {
                return film;
            }
        }
        return null;
    }
       public void vypisHercuAnimatoru(List<String> herci, List<String>animatori, List<String>vsichni){
        vsichni.addAll(herci);
        vsichni.addAll(animatori);

        final Set<String> setToreturn = new HashSet<>(); 
        final Set<String> set1 = new HashSet<>();
        
        for (String yourInt : vsichni) {
            if (!set1.add(yourInt)) {
                setToreturn.add(yourInt);
            }
        }
    }

    public void vypisPodleHerce(List<String> herci){
        HranyFilm hranyFilm = new HranyFilm(null, null, 0, herci, 0);
        for (Film film : sqlDatabase.getFilms(hraneFilmy)) {
            if (hranyFilm.getHerci().contains(herci)) {
                System.out.println(film.getNazev());
            }
        }
    }

    public void vypisPodleAnimatora(List<String> animatori){
        AnimovanyFilm animovanyFilm = new AnimovanyFilm(null, null, 0, animatori, 0, 0);
        for (Film film : sqlDatabase.getFilms(hraneFilmy)){
            if (animovanyFilm.getAnimatori().contains(animatori)){
                System.out.println(film.getNazev());

            }
        }
    }
    public void ulozDoSouboru(String Databazetxt) {
        try {
            PrintWriter writer = new PrintWriter(Databazetxt, "UTF-8");
            List<HranyFilm> hraneFilmy = sqlDatabase.getFilms(null);    
            for (HranyFilm film : hraneFilmy) {
                writer.println("Zanr: Hrany");
                writer.println("Nazev: " + film.getNazev());
                writer.println("Rok: " + film.getRokVydani());
                writer.println("Hodnoceni: " + film.getHvezdyHodnoceni() );
                writer.println("Reziser: " + film.getReziser());
                writer.println("Herci: " + film.getHerci());
            }
            List<AnimovanyFilm> animovaneFilmy = sqlDatabase.getAnimaky(null);
            for (AnimovanyFilm film : animovaneFilmy) {        
                writer.println("Zanr: Animovany");
                writer.println("Nazev: " + film.getNazev());
                writer.println("Rok: " + film.getRokVydani());
                writer.println("Hodnoceni: " + film.getBodoveHodnoceni() );
                writer.println("Reziser: " + film.getReziser());
                writer.println("Animatori: " + film.getAnimatori());
                writer.println("Dostupne od: " + film.getVekovaHranice() + "let");
            }
            writer.close();
            System.out.println("Databaze byla uspesne ulozena do souboru " + Databazetxt);
        } catch (IOException e) {
            System.out.println("Nepodarilo se ulozit databazi do souboru.");
            e.printStackTrace();
        }
    }
    public void nactiZeSouboru() {
        
    }
 }
