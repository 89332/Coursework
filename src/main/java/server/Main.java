package server;

import controllers.ConnectDB;
import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;

package controllers;

public class Main{
    public static Connection db = null;
    public static void main(String [] args){
        ConnectDB.Open("databaseGOOD.db");





     ConnectDB.Close();
    }




}
