/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import services.DataSource;

/**
 *
 * @author houssem
 */
public class Animal {
    // les attributs
    private int id_animal;
    private String photo;
    private String nom;
    private String sexe;
    private String race;
    // les geters and setters 

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
    
    
    //les constructeurs

    public Animal(String photo, String nom, String sexe,String race) {
        this.photo = photo;
        this.nom = nom;
        this.sexe = sexe;
        this.race = race;
    }

    public Animal() {
    }
    
    
    // les methodes 
     // les attributs relatifs au methodes CRUD
    Connection conn = DataSource.getInstance().getConnection();
    private Statement stmt;
    
    public ArrayList<Animal> selectAll(int id) {
         ArrayList<Animal> le = new ArrayList();
        try {
            PreparedStatement st = conn.prepareStatement(
            "SELECT `id_animal`, `race`, `photo`, `sexe`, `nom`, `etat`, `id_membre`"
                    + " FROM `animal` WHERE `etat`=1 "
                    + "AND `id_membre` = "+id);
           
            ResultSet res = st.executeQuery();
            while (res.next()) {
                Animal e = new Animal();
                e.setId_animal(res.getInt(1));
                e.setSexe(res.getString(4));
                e.setRace(res.getString(2));
                e.setPhoto(res.getString(3));
                e.setNom(res.getString(5));
               
                
                le.add(e);
            }
            return le;
        } catch (SQLException ex) {
            System.out.println("ereuur dans l'aafichage");
        return null;
        }
    }
    
    
    
    
}
