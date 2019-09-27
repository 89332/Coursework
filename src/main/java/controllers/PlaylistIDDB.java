package controllers;

import java.sql.PreparedStatement;
import server.Main;
public class PlaylistIDDB {
    public static void PlaylistID(int PlaylistID, int SongID){

    try {


        PreparedStatement ps = Main.db.prepareStatement("INSERT INTO PlaylistID(PlaylistID, SongID) VALUES (?,?)");
        ps.setInt(1,PlaylistID);
        ps.setInt(2,SongID);


    } catch (Exception exception){;
        System.out.println("Database error:" + exception.getMessage());
    }
}

}
