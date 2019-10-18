package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import server.Main;
public class SongsDB {
    public static void createSongs(String SongID, String SongName, String Artist, String Genre, String Length){

        try {
            PreparedStatement ps = server.Main.db.prepareStatement("INSERT INTO Songs(SongID, SongName, Artist, Genre, Length); VALUES (?,?,?,?)");
            ps.setString(1,SongID);
            ps.setString(2,SongName);
            ps.setString(3,Artist);
            ps.setString(4,Genre);
            ps.setString(5,Length);
            ps.executeUpdate();

        } catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
        }
    }
    public static void readSongs (String SongID, String SongName, String Artist, String Genre, String Length){

        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT FROM Songs (SongID, SongName, Artist, Genre, Length)" );

            ResultSet results = ps.executeQuery();
            while (results.next()) {
                SongID   = results.getString(1);
                SongName = results.getString(2);
                Artist = results.getString(3);
                Genre = results.getString(4);
                Length = results.getString(5);
                System.out.println("The SongID is: " + SongID);
                System.out.println("Name of the song: " + SongName);
                System.out.println("Genre: " + Genre);
                System.out.println("Length: " + Length);
            }

        } catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
        }
    }
    public static void updateSongs(String SongID, String SongName, String Artist, String Genre, String Length){

        try{
            PreparedStatement ps = Main.db.prepareStatement ("UPDATE Playlist SET PlaylistName = x,  WHERE UserID = y");
            ps.setString(1,SongID);
            ps.setString(2,SongName);
            ps.setString(2,Artist);
            ps.setString(2,Genre);
            ps.setString(2,Length);

            ps.execute();
        } catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
        }

    }
    public static void deleteSongs(String SongID){
        try{
            PreparedStatement ps = server.Main.db.prepareStatement("DELETE FROM Songs WHERE SongId = ?");

            ps.setString(1,SongID);
            ps.execute();

        }catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
    }


}
