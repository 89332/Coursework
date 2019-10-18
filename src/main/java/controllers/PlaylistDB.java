package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    public static void readPlaylist (int ProfileID, int PlaylistID){

        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT FROM Playlist (ProfileID, PlaylistID)" );

            ResultSet results = ps.executeQuery();
            while (results.next()) {
                ProfileID   = results.getInt(1);
                PlaylistID = results.getInt(2);
                System.out.println("The Profile ID is: " + ProfileID);
                System.out.println("Length: " + PlaylistID);
            }

        } catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
        }
    }
    public static void updatePlaylist(String PlaylistName, int UserID){

        try {
            PreparedStatement ps = Main.db.prepareStatement ("UPDATE Playlist SET PlaylistName = x,  WHERE UserID = y");
            ps.setString(1,PlaylistName);
            ps.setInt(2,UserID);

            ps.execute();
        } catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
        }
    }
    public static void deletePlaylist(String PlaylistID){
        try{
            PreparedStatement ps = server.Main.db.prepareStatement("DELETE FROM Playlist WHERE PlaylistID = ?");

            ps.setString(1,PlaylistID);
            ps.execute();

        }catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());

}
