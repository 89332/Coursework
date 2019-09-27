package controllers;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import server.Main;
public class ProfileDB {
    public static void createProfile(String ProfileID, String UserName, String FirstName, String LastName, String DOB){

        try {


            PreparedStatement ps = Main.db.prepareStatement("INSERT INTO Profile(ProfileID, UserName, FirstName, LastName, DOB); VALUES (?,?,?,?,?)");
            ps.setString(1,ProfileID);
            ps.setString(2,UserName);
            ps.setString(3,FirstName);
            ps.setString(4,LastName);
            ps.setString(5,DOB);

        } catch (Exception exception){;
            System.out.println("Database error:" + exception.getMessage());
        }
    }
    public static void readProfiles (int ProfileID, String UserName, String FirstName, String LastName, String DOB){

        try {
            PreparedStatement ps = Main.db.prepareStatement("SELECT FROM Profiles (ProfileID, UserName, FirstName, LastName, DOB)" );

            ResultSet results = ps.executeQuery();
            while (results.next()) {
                 ProfileID = results.getInt(1);
                 UserName = results.getString(2);
                 FirstName = results.getString(3);
                 LastName = results.getString(4);
                 DOB = results.getString(5);
                System.out.println("The ProfileID is: " + ProfileID);
                System.out.println("Name: " + FirstName + LastName);
                System.out.println("DOB: " + DOB);
            }

            } catch (Exception exception){;
                System.out.println("Database error:" + exception.getMessage());
            }
        }




    }
