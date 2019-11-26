package controllers;

import java.lang.annotation.Target;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import com.sun.jersey.multipart.FormDataParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import server.Main;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


public class Login {
    @POST
    @Path("login")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public String login(@FormDataParam("UserName") String username, @FormDataParam("Password") String password){
        try{
            PreparedStatement ps1 = Main.db.prepareStatement("SELECT Password FROM Profiles WHERE UserName= ?");
            ps1.setString(1, username);
            ResultSet loginResults = ps1.executeQuery();
            if (loginResults.next()) {

                String correctPassword = loginResults.getString(1);

                if (password.equals(correctPassword)) {

                    String token = UUID.randomUUID().toString();

                    PreparedStatement ps2 = Main.db.prepareStatement("UPDATE Users SET Token = ? WHERE Username = ?");
                    ps2.setString(1, token);
                    ps2.setString(2, username);
                    ps2.executeUpdate();

                    return "{\"token\": \""+ token + "\"}";

                } else {

                    return "{\"error\": \"Incorrect password!\"}";

                }

            } else {

                return "{\"error\": \"Unknown user!\"}";

            }

        }catch (Exception exception){
            System.out.println("Database error during /user/login: " + exception.getMessage());
            return "{\"error\": \"Server side error!\"}";
        }


    }

}



