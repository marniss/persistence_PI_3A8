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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.DataSource;

/**
 *
 * @author makni
 */
public class Animal {

    private int id;
    private String nom;
    private String espece;
    private float poids;
    private Date datePoids;
    private Date neLe;
    private String genre;
    private String photo;
    private String proprietaire;

    //Les attributs DB
    Connection conn = DataSource.getInstance().getConnection();
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement stmt;

    public Animal(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public void setDatePoids(Date datePoids) {
        this.datePoids = datePoids;
    }

    public void setNeLe(Date neLe) {
        this.neLe = neLe;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getEspece() {
        return espece;
    }

    public float getPoids() {
        return poids;
    }

    public Date getDatePoids() {
        return datePoids;
    }

    public Date getNeLe() {
        return neLe;
    }

    public String getGenre() {
        return genre;
    }

    public String getPhoto() {
        return photo;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Animal() {
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", nom=" + nom + ", espece=" + espece + ", poids=" + poids + ", datePoids=" + datePoids + ", neLe=" + neLe + ", genre=" + genre + ", photo=" + photo + ", proprietaire=" + proprietaire + '}';
    }

    public Animal getAnimal(int id) {
        System.out.println("1");
        Animal x = new Animal();
        String req = "Select * From animal where etat=1 and id_animal=" + id + ";";
        try {
            ps = conn.prepareStatement(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                x.id = rs.getInt(1);
                x.nom = rs.getString(5);
                x.espece = rs.getString("espece");
                x.poids = rs.getFloat("poids");
                x.photo = rs.getString("photo");
                x.genre = rs.getString("type");
                x.proprietaire = rs.getString("proprietaire");
                System.out.println(x);
                System.out.println("animal iddddd model");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return x;

    }

    public ArrayList<Animal> displayAnimal() {
        ArrayList<Animal> animals = new ArrayList<>();
        String req = "Select id_animal,nom From animal where etat=1";
        try {
            ps = conn.prepareStatement(req);
            rs = ps.executeQuery();
            while (rs.next()) {
                Animal fs = new Animal();
                fs.id = rs.getInt(1);
                fs.nom = rs.getString(2);
                animals.add(fs);
                System.out.println(fs);
                System.out.println("animal model");
            }
            return animals;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erreuuur d'execution req");
        }
        return animals;

    }

}
