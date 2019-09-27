package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import server.Main;
public class FavouriteSongsDB {
    public static void createFavouriteSongs(int ProfileID, int SongID){

        try {


            PreparedStatement ps = Main.db.prepareStatement(  "INSERT INTO FavouriteSongs(ProfileID, SongID) VALUES (?,?)");
            ps.setInt(1,ProfileID);
            ps.setInt(2,SongID);


        } catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
        }
    }

}
