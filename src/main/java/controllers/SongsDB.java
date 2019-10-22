package controllers;

import java.lang.annotation.Target;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import server.Main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)

    public String listSongs(){
        System.out.println("songs/list");
        JSONArray list = new JSONArray();
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT SongID, SongName, Artist, Genre, Length FROM Songs" );

            ResultSet results = ps.executeQuery();
            while (results.next()) {
                JSONObject item = new JSONObject();
                item.put("SongID ", results.getInt(1));
                item.put("SongName ", results.getString(1));
                item.put("Artist ", results.getString(1));
                item.put("Genre ", results.getString(1));
                item.put("Length ", results.getInt(1));
                list.add(item);
            }
            return list.toString();
        } catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
            return "{\" error\": \"Unable to list items, please see server console for more info.\"}";
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
    public static void deleteSongs(String SongID) {
        try {
            PreparedStatement ps = server.Main.db.prepareStatement("DELETE FROM Songs WHERE SongId = ?");

            ps.setString(1, SongID);
            ps.execute();

        } catch (Exception exception) {
            ;
            System.out.println("Database error:" + exception.getMessage());
        }
    }


}
