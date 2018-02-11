/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author houssem
 */
<<<<<<< HEAD
 public class DataSource {
    private  static DataSource data ;
    private String url = "jdbc:mysql://localhost:8080/zanimo";
=======
public class DataSource {

    private static DataSource data;
    private String url = "jdbc:mysql://localhost:3306/zanimo";
>>>>>>> 4ea0760859c7adc69664272a874efe9dca294a8d
    private String username = "root";
    private String pasword = "";
    private Connection con;

    private DataSource() {
        try {
            con = (Connection) DriverManager.getConnection(url, username, pasword);
            System.out.println("connexion");

        } catch (SQLException e) {

            System.out.println("Erreur de Connexion");
        }
    }

    public Connection getConnection() {
        return con;

    }

    public static DataSource getInstance() {
        if (data == null) {
            data = new DataSource();
        }
        return data;

    }
}
