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
            @FormDataParam("ProfileID") String ProfileID, @FormDataParam("UserName") String UserName, @FormDataParam("Firstname") String FirstName, @FormDataParam("LastName") String LastName, @FormDataParam("DOB") String DOB) {
        try {
            if (ProfileID == null || UserName == null || FirstName == null || LastName == null || DOB == null) {
                throw new Exception("One or more form data parameters are missing in the HTTP request.");
            }
            System.out.println("profile/new id=" + ProfileID);

            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Profile(ProfileID, UserName, FirstName, LastName, DOB); VALUES (?,?,?,?,?)");
            ps.setString(1,ProfileID);
            ps.setString(2,UserName);
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
        System.out.println("profiles/list");
        JSONArray list = new JSONArray();
        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT FROM Profiles (ProfileID, UserName, FirstName, LastName, DOB)" );

            ResultSet results = ps.executeQuery();
            while (results.next()) {
                JSONObject item = new JSONObject();
                item.put("ProfileID", results.getInt(1));
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
