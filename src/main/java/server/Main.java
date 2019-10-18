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
        openDatabase("things.db");
        ResourceConfig config = new ResourceConfig();
        config.packages("Controllers");
        config.register(MultiPartFeature.class);
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));
        Server server = new Server(8081);
        ServletContextHandler context = new ServletContextHandler(server, "/");
        context.addServlet(servlet, "/*");
        try {
            server.start();
            System.out.println("Server successfully started.");
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }




     ConnectDB.Close();
    }




}
