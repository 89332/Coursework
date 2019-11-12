package controllers;

import java.lang.annotation.Target;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.jersey.multipart.FormDataParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import server.Main;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class SongsDB {
    @POST
    @Path("new")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertSongs(
            @FormDataParam("SongID") String SongID, @FormDataParam("SongName") String SongName, @FormDataParam("Artist") String Artist, @FormDataParam("Genre") String Genre, @FormDataParam("Length") String Length) {
        try {
            if (SongID == null || SongName == null || Artist == null || Genre == null || Length == null){
                throw new Exception("One or more form data parameters are missing in the HTTP request.");
            }
            System.out.println("Song/new SongID=" + SongID);



            PreparedStatement ps = server.Main.db.prepareStatement("INSERT INTO Songs(SongID, SongName, Artist, Genre, Length); VALUES (?,?,?,?)");
            ps.setString(1,SongID);
            ps.setString(2,SongName);
            ps.setString(3,Artist);
            ps.setString(4,Genre);
            ps.setString(5,Length);
            ps.executeUpdate();
            return "{\"status\": \"OK\"}";

        } catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
            return "{\"error\": \"Unable to create new item, please see server console for more info.\"}";
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
                item.put("SongName ", results.getString(2));
                item.put("Artist ", results.getString(3));
                item.put("Genre ", results.getString(4));
                item.put("Length ", results.getInt(5));
                list.add(item);
            }
            return list.toString();
        } catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
            return "{\" error\": \"Unable to list items, please see server console for more info.\"}";
        }
    }

    @POST
    @Path("update")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateSongs(
        @FormDataParam("SongID") String SongID, @FormDataParam("SongName") String SongName, @FormDataParam("Artist") String Artist, @FormDataParam("Genre") String Genre, @FormDataParam("Length") String Length) {

        try{
            if (SongID == null || SongName == null || Artist == null || Genre == null || Length == null){
                throw new Exception("One or more form data parameters are missing in the HTTP request.");

            }
            System.out.println("thing/update SongID ="+ SongID);
            PreparedStatement ps = Main.db.prepareStatement ("UPDATE Playlist SET PlaylistName = x,  WHERE UserID = y");
            ps.setString(1,SongID);
            ps.setString(2,SongName);
            ps.setString(3,Artist);
            ps.setString(4,Genre);
            ps.setString(5,Length);
            ps.execute();
            return "{\"status\": \"OK\"}";
        } catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
            return "{\" error\": \"Unable to list items, please see server console for more info.\"}";

        }

    }
    @POST
    @Path("delete")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteSongs(@FormDataParam("SongID") String SongID){
        try {
            if(SongID == null){
                throw new Exception("One or more form data parameters are missing in the HTTP request.");
            }
            System.out.println("thing/delete SongID="+ SongID);
            PreparedStatement ps = server.Main.db.prepareStatement("DELETE FROM Songs WHERE SongId = ?");

            ps.setString(1, SongID);
            ps.execute();
            return "{\"status\": \"OK\"}";


        } catch (Exception exception) {
            System.out.println("Database error:" + exception.getMessage());
            return "{\" error\": \"Unable to list items, please see server console for more info.\"}";
        }
    }


}
