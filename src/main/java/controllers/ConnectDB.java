package controllers;

import org.sqlite.SQLiteConfig;
import server.Main;
import java.sql.DriverManager;

    public class ConnectDB {
        public static void Open(String dbFile){
            try {
                Class.forName("org.sqlite.JDBC");
                SQLiteConfig config = new SQLiteConfig();
                config.enforceForeignKeys(true);
                Main.db = DriverManager.getConnection("jdbc:sqlite:resources/" + dbFile, config.toProperties());
                System.out.println("Database connection successfully established.");
            } catch (Exception exception) {
                System.out.println("Database connection error: " + exception.getMessage());
            }

        }

        public static void Close() {
            try {
                Main.db.close();
                System.out.println("Disconnected from database.");
            } catch (Exception exception) {
                System.out.println("Database disconnection error: " + exception.getMessage());
            }
        }
    }


