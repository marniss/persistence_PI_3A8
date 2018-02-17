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
 * @author makni
 */
public class ListeDesVetirinaires {

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

    public ListeDesVetirinaires() {
    }

    public ListeDesVetirinaires(int id, String nom, String prenom, String tel, String adresse, String mail, String photo) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.adresse = adresse;
        this.mail = mail;
        this.photo = photo;
    }

    public ListeDesVetirinaires(String nom, String prenom, String tel, String adresse, String mail, String photo) {

        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.adresse = adresse;
        this.mail = mail;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

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

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
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

    @Override
    public String toString() {
        return "ListeDesVetirinaires{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", adresse=" + adresse + ", mail=" + mail + ", photo=" + photo + '}';
    }

    /*
     * Attribus relatives au DB**
     */
    Connection conn = DataSource.getInstance().getConnection();

    public String getTel() {
        return tel;
    }
    private PreparedStatement ps;
    private Statement stme;
    private ResultSet rs;

    /*
     *Les Methodes
     */
    public int ajouterVetirinaire() {

        try {

            /**
             * Creation du req*
             */
            String req = "INSERT INTO `listedesvetirinaire`(`nom`, `prenom`, `tel`, `adresse`, `mail`, `photo`,`etat`) VALUES (?,?,?,?,?,?,1)";

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

    public int modifierVetirinaire() {

        try {

            /**
             * Creation du req*
             */
            String req = "update listedesvetirinaire set `nom`=?,`prenom`=?,`tel`=?,`adresse`=?,`mail`=?,`photo`=?  WHERE `id_ved`=? ";

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

    public int supprimerVetirinaire() {

        try {

            /**
             * Creation du req*
             */
            String req = "update listedesvetirinaire set etat=0 where `id_ved`=? ";

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

    public int rechercheVetirinaire() {

        try {

            /**
             * Creation du req*
             */
            String req = "";

            try {
                /*
                *Creation Du Statememnt
                 */
                ps = conn.prepareStatement(req);
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

    public ArrayList ListVetirinaire() {
        ArrayList<ListeDesVetirinaires> listeDesVetirinaireses = new ArrayList<>();
        try {

            /**
             * Creation du req*
             */
            String req = "select * from listedesvetirinaire where etat=1 ";

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
                ListeDesVetirinaires ldv = new ListeDesVetirinaires();
                ldv.id = rs.getInt(1);
                ldv.nom = rs.getString(2);
                ldv.prenom = rs.getString(3);
                ldv.tel = rs.getString(4);
                ldv.adresse = rs.getString(5);
                ldv.mail = rs.getString(6);
                ldv.photo = rs.getString(7);
                listeDesVetirinaireses.add(ldv);
            }
            return listeDesVetirinaireses;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listeDesVetirinaireses;
    }
}
