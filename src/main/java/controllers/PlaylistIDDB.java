package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import server.Main;
public class PlaylistIDDB {
    public static void createPlaylistID(int PlaylistID, int SongID){

        try {


            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO PlaylistID(PlaylistID, SongID) VALUES (?,?)");
            ps.setInt(1,PlaylistID);
            ps.setInt(2,SongID);


        } catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
        }
    }
    public static void readPlaylistID (int PlaylistID, int SongID){

        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT FROM PlaylistID(PlaylistID, SongID)" );

            ResultSet results = ps.executeQuery();
            while (results.next()) {
                PlaylistID   = results.getInt(1);
                SongID = results.getInt(2);
                System.out.println("The PlaylistID is: " + PlaylistID);
                System.out.println("SongID: " + SongID);
            }

        } catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
        }
    }
    public static void updatePlaylist(String PlaylistID, int SongID){

        try {
            PreparedStatement ps = Main.db.prepareStatement ("UPDATE PlaylistID SET PlaylistID = x,  WHERE SongID = y");
            ps.setString(1,PlaylistID);
            ps.setInt(2,SongID);

            ps.execute();
        } catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
        }
    }
}

}
