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
 public class DataSource_1 {
    private  static DataSource_1 data ;
        String url = "jdbc:mysql://localhost:3306/zanimo"; 
        private String username = "root";
    private String pasword = "";
    private Connection con;

    private DataSource_1() {
        try {
            con = (Connection) DriverManager.getConnection(url, username, pasword);
            System.out.println("connexion etablie");

        } catch (SQLException e) {

            System.out.println("Erreur de Connexion");
        }
    }

    public Connection getConnection() {
        return con;

    }

    public static DataSource_1 getInstance() {
        if (data == null) {
            data = new DataSource_1();
        }
        return data;

    }
}
