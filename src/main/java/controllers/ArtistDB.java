package controllers;
import java.sql.PreparedStatement;
import server.Main;

public class ArtistDB {
    public static void createArtist(int ArtistID, String Artist, int Followers){

        try {


            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Artist(ArtistID, Artist, Followers); VALUES (?,?,?)");
            ps.setInt(1,ArtistID);
            ps.setString(2,Artist);
            ps.setInt(3,Followers);


        } catch(Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
        }
    }

}
