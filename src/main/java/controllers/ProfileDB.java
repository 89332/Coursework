package controllers;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


import org.glassfish.jersey.media.multipart.FormDataParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import server.Main;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class ProfileDB {
    @POST
    @Path("new")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public String createProfile(
            @FormDataParam("UserID") String UserID, @FormDataParam("username") String username, @FormDataParam("Firstname") String FirstName, @FormDataParam("LastName") String LastName, @FormDataParam("DOB") String DOB) {
        try {
            if (UserID == null || username == null || FirstName == null || LastName == null || DOB == null) {
                throw new Exception("One or more form data parameters are missing in the HTTP request.");
            }
            System.out.println("profile/new id=" + UserID);

            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Users(UserID, UserName, FirstName, LastName, DOB); VALUES (?,?,?,?,?)");
            ps.setString(1,UserID);
            ps.setString(2,username);
            ps.setString(3,FirstName);
            ps.setString(4,LastName);
            ps.setString(5,DOB);
            ps.execute();
            return "{\"status\": \"OK\"}";

        } catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
            return "{\"error\": \"Unable to create new item, please see server console for more info.\"}";
        }
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public String listProfiles() {
        System.out.println("user/list");
        JSONArray list = new JSONArray();
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT FROM Users (UserID, UserName, FirstName, LastName, DOB)" );

            ResultSet results = ps.executeQuery();
            while (results.next()) {
                JSONObject item = new JSONObject();
                item.put("UserID", results.getInt(1));
                item.put("UserName", results.getString(2));
                item.put("FirstName", results.getString(2));
                item.put("LastName", results.getString(2));
                item.put("DOB", results.getString(2));
                list.add(item);
            }
            return list.toString();


        } catch (Exception exception){;
                System.out.println("Database error:" + exception.getMessage());
            return "{\"error\": \"Unable to list items, please see server console for more info.\"}";
            }
        }




    }
