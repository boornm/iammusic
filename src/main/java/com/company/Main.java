package com.company;

import com.company.controllers.UserController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.UserRepository;
import com.company.repositories.interfaces.IUserRepository;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String connectionUrl = "jdbc:postgresql://localhost:5432/iammusic";
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(connectionUrl, "postgres", "1111");

            stmt = con.createStatement();

            rs = stmt.executeQuery("select mistake * from users");

            while (rs.next())
                System.out.println(rs.getInt("id") + "  "
                        + rs.getString("name") + "  " + rs.getString("song name"));
        }
        catch (Exception e) {
            System.out.println("Exception occurred!");
        } finally {

            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Exception occurred!");
            }
        }

        System.out.println("Finished!");

        IDB db = new PostgresDB();
        IUserRepository repo = new UserRepository(db);
        UserController controller = new UserController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}
