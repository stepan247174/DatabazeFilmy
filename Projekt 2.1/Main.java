import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        FilmManager filmManager = new FilmManager();
        sqlite sqLite = new sqlite();
        try{
        while (true) {
            System.out.println("\n-----------------------");
            System.out.println("1. Přidání nového filmu");
            System.out.println("2. Upravení filmu");
            System.out.println("3. Smazání filmu");
            System.out.println("4. Přidání hodnocení");
            System.out.println("5. Výpis filmů");
            System.out.println("6. Vyhledání filmu");
            System.out.println("7. Výpis herců nebo animátorů, kteří se podíleli na více než jednom filmu");
            System.out.println("8. Výpis filmů podle herce nebo animátora");
            System.out.println("9. Výpis filmů podle herce nebo animátora");
            System.out.println("10. Uložení filmu do souboru");
            System.out.println("11. Načtení filmu ze souboru");
            System.out.println("12. Uložení databáze do SQL databáze");
            System.out.println("13. Načtení databáze z SQL databáze");
            System.out.println("14. Konec");

            System.out.print("\nVyberte akci (1-14): ");
            int volba = scanner.nextInt();
            scanner.nextLine(); // vyčištění bufferu
            
           
            switch (volba) {
                case 1:
                    filmManager.pridejFilm(null, null, volba, null, volba, null, volba);
                    break;
                case 2:
                    filmManager.upravFilm(null, null, null, volba, null, volba, null);
                    break;
                case 3:
                    filmManager.smazFilm(null);
                    break;
                case 4:
                    filmManager.pridejHodnoceni(null, volba, volba);
                    break;
                case 5:
                    filmManager.vypisFilmy();
                    break;
                case 6:
                    filmManager.najdiFilm(null);
                    break;
                case 7:
                    filmManager.vypisHercuAnimatoru(null, null, null);
                    break;
                case 8:
                    filmManager.vypisPodleHerce(null);
                case 9:
                    filmManager.vypisPodleAnimatora(null);
                    break;
                case 10:
                    filmManager.ulozDoSouboru(null);
                    break;
                case 11:
                    filmManager.nactiZeSouboru();
                    break;
                case 12:
                    sqLite.ulozDoSQL(volba, null, volba, null, null, volba, volba, volba, null, null);
                    break;
                case 13:
                    sqLite.nasctiZSQL();
                    break;
                case 14:
                    System.out.println("\nDěkujeme za použití programu!");
                    return;
                default:
                    System.out.println("Neplatná volba, zadejte číslo od 1 do 14.");
                    break;
            }
        }
    } finally{
        scanner.close();
    }
    }
}
