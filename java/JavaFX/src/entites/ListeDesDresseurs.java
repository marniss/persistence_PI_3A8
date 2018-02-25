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
import java.util.logging.Level;
import java.util.logging.Logger;
import services.DataSource;

/**
 *
 * @author makni
 */
public class ListeDesDresseurs {

    /*
     *Les Attributs
     */
    private int id;
    private String nom;
    private String prenom;
    private String tel;
    private String adresse;
    private String mail;
    private String photo;
    private int id_note;

    public ListeDesDresseurs() {
    }

    public ListeDesDresseurs(int id, String nom, String prenom, String tel, String adresse, String mail, String photo) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.adresse = adresse;
        this.mail = mail;
        this.photo = photo;
    }

    public ListeDesDresseurs(String nom, String prenom, String tel, String adresse, String mail, String photo) {

        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.adresse = adresse;
        this.mail = mail;
        this.photo = photo;
    }

    public ListeDesDresseurs(int id) {

        this.id = id;

    }
//Getters

    public ListeDesDresseurs(int id, int id_note) {
        this.id = id;
        this.id_note = id_note;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getId_note() {
        return id_note;
    }

    public String getTel() {
        return tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMail() {
        return mail;
    }

    public String getPhoto() {
        return photo;
    }
    //setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    //toString
    @Override
    public String toString() {
        return "ListeDesDresseurs{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", adresse=" + adresse + ", mail=" + mail + ", photo=" + photo + '}';
    }
    /*
     * Attribus relatives au DB**
     */
    Connection conn = DataSource.getInstance().getConnection();
    private PreparedStatement ps;
    private Statement stme;
    private ResultSet rs;

    /*Nos Methodes */
    public int ajouterDresseur() {
        NoteDresseur x = new NoteDresseur(1, 0, "");
        x.ajouterNote();
        int i = x.getLastidNote();
        try {

            /**
             * Creation du req*
             */
            String req = "INSERT INTO `listedesdresseurs`(`nom`, `prenom`, `tel`, `adresse`, `mail`, `photo`,`etat`,`idnote`) VALUES (?,?,?,?,?,?,1,?)";

            try {
                /*
                *Creation Du Statememnt
                 */
                ps = conn.prepareStatement(req);
                ps.setString(1, this.nom);
                ps.setString(2, this.prenom);
                ps.setString(3, this.tel);
                ps.setString(4, this.adresse);
                ps.setString(5, this.mail);
                ps.setString(6, this.photo);
                ps.setInt(7, i);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            ps.execute();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public int modifierDresseur() {
        try {

            /**
             * Creation du req*
             */
            String req = "update listedesdresseurs set `nom`=?,`prenom`=?,`tel`=?,`adresse`=?,`mail`=?,`photo`=?  WHERE `id`= ? ;";

            try {
                /*
                *Creation Du Statememnt
                 */
                ps = conn.prepareStatement(req);
                ps.setString(1, this.nom);
                ps.setString(2, this.prenom);
                ps.setString(3, this.tel);
                ps.setString(4, this.adresse);
                ps.setString(5, this.mail);
                ps.setString(6, this.photo);
                ps.setInt(7, this.id);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            ps.execute();

            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;

    }

    public int supprimerDresseur() {
        try {

            /**
             * Creation du req*
             */
            String req = "update listedesdresseurs set etat=0 where `id`=? ";

            try {
                /*
                *Creation Du Statememnt
                 */
                ps = conn.prepareStatement(req);
                ps.setInt(1, this.id);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            ps.execute();

            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public ArrayList<ListeDesDresseurs> afficherDresseur() {
        ArrayList<ListeDesDresseurs> listeDesDresseurses = new ArrayList<>();
        try {

            /**
             * Creation du req*
             */
            String req = "select * from listedesdresseurs where etat=1 ";

            try {
                /*
                *Creation Du Statememnt
                 */
                ps = conn.prepareStatement(req);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            rs = ps.executeQuery();
            while (rs.next()) {
                ListeDesDresseurs ldd = new ListeDesDresseurs();
                ldd.id = rs.getInt(1);
                ldd.nom = rs.getString(2);
                ldd.prenom = rs.getString(3);
                ldd.tel = rs.getString(4);
                ldd.adresse = rs.getString(5);
                ldd.mail = rs.getString(6);
                ldd.photo = rs.getString(7);
                ldd.id_note = rs.getInt("idnote");
                listeDesDresseurses.add(ldd);
            }
            return listeDesDresseurses;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listeDesDresseurses;
    }

    public ListeDesDresseurs getNote() {
        ListeDesDresseurs temp = new ListeDesDresseurs(this.id);
        try {

            /**
             * Creation du req*
             */
            String req = "select idnote from listedesdresseurs where id=" + this.id;
            try {
                /*
                *Creation Du Statememnt
                 */
                ps = conn.prepareStatement(req);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                temp.id_note = rs.getInt("idnote");

            }
            return temp;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return temp;

    }

    public int setidnote() {
        try {

            /**
             * Creation du req*
             */
            String req = "update listedesdresseurs set id_note= ? where `idnote`=? ";

            try {
                /*
                *Creation Du Statememnt
                 */
                ps = conn.prepareStatement(req);
                ps.setInt(1, this.id_note);
                ps.setInt(2, this.id);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            ps.execute();

            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;

    }

}
