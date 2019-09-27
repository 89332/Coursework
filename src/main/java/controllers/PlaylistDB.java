package controllers;

import java.sql.PreparedStatement;
import server.Main;
public class PlaylistDB {
    public static void createPlaylist(int ProfileID, int PlaylistID){

        try {


            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Playlist(ProfileID, PlaylistID) VALUES (?,?)");
            ps.setInt(1,ProfileID);
            ps.setInt(2,PlaylistID);


        } catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
        }
    }

}
