package controllers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import server.Main;

public class ArtistDB {
    public static void createArtist(int ArtistID, String Artist, int Followers) {

        try {


            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Artist(ArtistID, Artist, Followers); VALUES (?,?,?)");
            ps.setInt(1, ArtistID);
            ps.setString(2, Artist);
            ps.setInt(3, Followers);


        } catch (Exception exception) {
            ;
            System.out.println("Database error:" + exception.getMessage());
        }
    }

    public static void readArtist(int ArtistID, String Artist, int Followers) {

        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT FROM Artist (ArtistID, Artist, Followers)");

            ResultSet results = ps.executeQuery();
            while (results.next()) {
                ArtistID = results.getInt(1);
                Artist = results.getString(2);
                Followers = results.getInt(3);

                System.out.println("The ArtistID is: " + ArtistID);
                System.out.println("The Artist Name is: " + Artist);
                System.out.println("Followers: " + Followers);
            }

        } catch (Exception exception) {
            ;
            System.out.println("Database error:" + exception.getMessage());
        }
    }

    public static void deleteArtist(String ArtistID) {
        try {
            PreparedStatement ps = server.Main.db.prepareStatement("DELETE FROM Artist WHERE ArtistId = ?");

            ps.setString(1, ArtistID);
            ps.execute();

        } catch (Exception exception) {
            ;
            System.out.println("Database error:" + exception.getMessage());


        }
    }
}