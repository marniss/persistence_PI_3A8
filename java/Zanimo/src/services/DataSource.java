/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ahmed
 */
 public class DataSource {
    private  static DataSource data ;
    private String url = "jdbc:mysql://localhost:3306/Zanimo";
    private String username = "root";
    private String pasword = "";
    private Connection con;

    private DataSource() {
        try {
            con = (Connection) DriverManager.getConnection(url, username, pasword);
            System.out.println("Class DataSource : connexion etablie");

        } catch (SQLException e) {

            System.out.println("Class DataSource :  Erreur de Connexion ");
            System.out.println(e.getMessage());
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
