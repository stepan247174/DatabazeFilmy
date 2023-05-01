
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class sqlite {
  private Connection connection;
    private ArrayList<HranyFilm> films;
    private ArrayList<AnimovanyFilm> animaky;
  Connection conn = null;


  public static void java(String[] args) {
    Connection conn = null;
    try {
      String url = "jdbc:sqlite:myDB.db";

      conn = DriverManager.getConnection(url);

      System.out.println("Pripojeni k databazi probehlo uspesne");
      
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException ex) {
        System.out.println(ex.getMessage());
      }
    }
  }

  public static void createTable() {
    String url = "jdbc:sqlite:myDB.db";
    String sql = "CREATE TABLE IF NOT EXISTS filmy (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " nazev varchar(255) NOT NULL,\n"
            + " rok_vydani INTEGER NOT NULL,\n"
            + " zanr varchar(255) NOT NULL,\n"
            + " reziser varchar(255) NOT NULL,\n"
            + " vekova_hranice INTEGER,\n"
            + " bodove_hodnoceni INTEGER,\n"
            + " hvezdy_hodnoceni INTEGER"
            + " animatori varchar(255), \n"
            + " herci varchar(255) NOT NULL"
            + ");";

    try (Connection conn = DriverManager.getConnection(url);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        stmt.execute(sql);
        System.out.println("Tabulka se uspesne vytvorila");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
  public void ulozDoSQL(int id, String nazev, int rok_vydani, String zanr, String reziser, int vekova_hranice, int bodove_hodnoceni, int hvezdy_hodnoceni, String animatori, String herci) {
        String sql = "INSERT INTO filmy(id, nazev, rok_vydani, zanr, reziser, vekova_hranice, bodove_hodnoceni, hvezdy_hodnoceni, animatori, herci) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, nazev);
            pstmt.setInt(3, rok_vydani);
            pstmt.setString(4, zanr);
            pstmt.setString(5, reziser);
            pstmt.setInt(6, vekova_hranice);
            pstmt.setInt(7, bodove_hodnoceni);
            pstmt.setInt(8, hvezdy_hodnoceni);
            pstmt.setString(9, animatori);
            pstmt.setString(10, herci);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void nasctiZSQL(){
      String sql = "SELECT id,nazev, rok_vydani, zanr, reziser, vekova_hranice, bodove_hodnoceni, hvezdy_hodnoceni, animatori, herci FROM filmy";
        try {
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
             while (rs.next()) {
                	System.out.println(rs.getInt("id") +  "\t" +  
rs.getInt("id") + "\t" + 
rs.getString("nazev") + "\t" + 
rs.getInt("rok_vydani") + "\t" + 
rs.getString("zanr") + "\t"+
rs.getString("zanr")+ "\t"+
rs.getInt("vekova_hranice") + "\t" +
rs.getInt("bodove_hodnoceni") + "\t" +
rs.getInt("hvezdy_hodnoceni") + "\t" +
rs.getString("animatori") + "\t" +
rs.getString("herci"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
      }
       public ArrayList<HranyFilm> getFilms(ArrayList<HranyFilm> hraneFilmy) {
        ArrayList<HranyFilm> filmy = new ArrayList<>();
    for (HranyFilm film : hraneFilmy) {
        if (film instanceof HranyFilm) {
            filmy.add(film);
        }
    }
    return filmy;
  }

    public ArrayList<AnimovanyFilm> getAnimaky(ArrayList<AnimovanyFilm> animovaneFilmy) {
        ArrayList<AnimovanyFilm> animaky = new ArrayList<>();
    for (AnimovanyFilm film : animovaneFilmy) {
        if (film instanceof AnimovanyFilm) {
            animaky.add(film);
    }
  }
  return animaky;
    }
  }


