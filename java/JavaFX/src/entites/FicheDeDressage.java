/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import ientites.ficheDeDressageInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import services.DataSource;

/**
 *
 * @author makni
 */
public class FicheDeDressage implements ficheDeDressageInterface {
//Les attributs

    private int id_f_Dressage;
    private int id_membre;
    private String espece;
    private String nom;
    private float poids;
    private String proprietaire;
    private String specialite;
    private String photo;
    private float displine;
    private float obeissance;
    private float accompagnement;
    private float interception;
    private float noteTotal;
    private Date dateDebut;
    private Date dateFin;
    private int etat;

//Les attributs DB
    static Connection conn = DataSource.getInstance().getConnection();
    private ResultSet rs = null;
    private PreparedStatement ps = null;
//Les Constructeurs

    /*
* *** 1 ****
     */
    public FicheDeDressage() {
    }

    /*
* *** 2 ****
     */
    public FicheDeDressage(int id_f_Dressage, int id_membre, String espece, String nom, float poids, String proprietaire, String specialite, String photo, float displine, float obeissance, float accompagnement, float interception, float noteTotal, Date dateDebut, Date dateFin) {
        this.id_f_Dressage = id_f_Dressage;
        this.id_membre = id_membre;
        this.espece = espece;
        this.nom = nom;
        this.poids = poids;
        this.proprietaire = proprietaire;
        this.specialite = specialite;
        this.photo = photo;
        this.displine = displine;
        this.obeissance = obeissance;
        this.accompagnement = accompagnement;
        this.interception = interception;
        this.noteTotal = noteTotal;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public FicheDeDressage(int id_membre, String espece, String nom, float poids, String proprietaire, String specialite) {

        this.id_membre = id_membre;
        this.espece = espece;
        this.nom = nom;
        this.poids = poids;
        this.proprietaire = proprietaire;
        this.specialite = specialite;

    }
//Les Getters et les setters

    public int getId_f_Dressage() {
        return id_f_Dressage;
    }

    public void setId_f_Dressage(int id_f_Dressage) {
        this.id_f_Dressage = id_f_Dressage;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public float getDispline() {
        return displine;
    }

    public void setDispline(float displine) {
        this.displine = displine;
    }

    public float getObeissance() {
        return obeissance;
    }

    public void setObeissance(float obeissance) {
        this.obeissance = obeissance;
    }

    public float getAccompagnement() {
        return accompagnement;
    }

    public void setAccompagnement(float accompagnement) {
        this.accompagnement = accompagnement;
    }

    public float getInterception() {
        return interception;
    }

    public void setInterception(float interception) {
        this.interception = interception;
    }

    public float getNoteTotal() {
        return noteTotal;
    }

    public void setNoteTotal(float noteTotal) {
        this.noteTotal = noteTotal;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
//toString()

    @Override
    public String toString() {
        return "FicheDeDressage{" + "id_f_Dressage=" + id_f_Dressage + ", id_membre=" + id_membre + ", espece=" + espece + ", nom=" + nom + ", poids=" + poids + ", proprietaire=" + proprietaire + ", specialite=" + specialite + ", photo=" + photo + ", displine=" + displine + ", obeissance=" + obeissance + ", accompagnement=" + accompagnement + ", interception=" + interception + ", noteTotal=" + noteTotal + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", etat=" + etat + ", rs=" + rs + ", ps=" + ps + '}';
    }

////nos methodes

    /*
* *** L'ajout ****
     */
    @Override
    public int ajouterFicheDeDressage() {
        String req1 = "INSERT INTO `f_dressage`(`id_membre`, `espece`, `nom`, `poids`, `proprietaire`, `photo`, `displine`, `obeissance`, `specialite`, `accompagnement`, `interception`, `noteTotal`, `dateDebut`, `datFin`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            ps = conn.prepareStatement(req1);
            ps.setInt(1, this.id_membre);
            ps.setString(2, this.nom);
            ps.setString(3, this.espece);
            ps.setFloat(4, this.poids);
            ps.setString(5, this.proprietaire);
            ps.setString(6, this.photo);
            ps.setFloat(7, this.displine);
            ps.setFloat(8, this.obeissance);
            ps.setString(9, this.specialite);
            ps.setFloat(10, this.accompagnement);
            ps.setFloat(11, this.interception);
            ps.setFloat(12, this.noteTotal);
            ps.setDate(13, (java.sql.Date) this.dateDebut);
            ps.setDate(14, (java.sql.Date) this.dateFin);
            ps.execute();
            System.out.println("Insertion Ok");
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    /*
* *** Modification ****
     */
    @Override
    public int modifierFicheDeDressage() {
        try {
            String req = "UPDATE `f_dressage` SET `id_membre`=?,`espece`=?,`nom`=?,`poids`=?,`proprietaire`=?,`photo`=?,`displine`=?,`obeissance`=?,`specialite`=?,`accompagnement`=?,`interception`=?,`noteTotal`=?,`dateDebut`=?,`datFin`=? Where id_f_soin =? ";
            ps = conn.prepareStatement(req);
            ps.setInt(1, this.id_membre);
            ps.setString(2, this.nom);
            ps.setString(3, this.espece);
            ps.setFloat(4, this.poids);
            ps.setString(5, this.proprietaire);
            ps.setString(6, this.photo);
            ps.setFloat(7, this.displine);
            ps.setFloat(8, this.obeissance);
            ps.setString(9, this.specialite);
            ps.setFloat(10, this.accompagnement);
            ps.setFloat(11, this.interception);
            ps.setFloat(12, this.noteTotal);
            ps.setDate(13, (java.sql.Date) this.dateDebut);
            ps.setDate(14, (java.sql.Date) this.dateFin);
            ps.setInt(15, this.id_f_Dressage);
            ps.execute();
            return 1;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    /*
* *** Recherche ****
     */
    @Override
    public int rechercheFicheDeDressage(int id_f_Dressage) {
        FicheDeDressage fdd = new FicheDeDressage();
        try {

            String req = "Select *From f_dressage where id_f_Dressage=?";
            ps = conn.prepareStatement(req);
            ps.setInt(1, this.id_f_Dressage);
            rs = ps.executeQuery();
            if (rs.next()) {
                fdd.id_f_Dressage = rs.getInt(1);
                fdd.id_membre = rs.getInt(2);
                fdd.espece = rs.getString(3);
                fdd.nom = rs.getString(4);
                fdd.poids = rs.getFloat(5);
                fdd.proprietaire = rs.getString(6);
                fdd.photo = rs.getString(7);
                fdd.displine = rs.getFloat(8);
                fdd.obeissance = rs.getFloat(9);
                fdd.specialite = rs.getString(10);
                fdd.accompagnement = rs.getFloat(11);
                fdd.interception = rs.getFloat(12);
                fdd.noteTotal = rs.getInt(13);
                fdd.dateDebut = rs.getDate(14);
                fdd.dateFin = rs.getDate(15);
            }

            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    /*
* *** Consultation ****
     */
    @Override
    public int displayFicheDeDressage() {
        FicheDeDressage fdd = new FicheDeDressage();
        try {

            String req = "Select *From f_dressage  ";
            ps = conn.prepareStatement(req);

            rs = ps.executeQuery();
            if (rs.next()) {
                fdd.id_f_Dressage = rs.getInt(1);
                fdd.id_membre = rs.getInt(2);
                fdd.espece = rs.getString(3);
                fdd.nom = rs.getString(4);
                fdd.poids = rs.getFloat(5);
                fdd.proprietaire = rs.getString(6);
                fdd.photo = rs.getString(7);
                fdd.displine = rs.getFloat(8);
                fdd.obeissance = rs.getFloat(9);
                fdd.specialite = rs.getString(10);
                fdd.accompagnement = rs.getFloat(11);
                fdd.interception = rs.getFloat(12);
                fdd.noteTotal = rs.getInt(13);
                fdd.dateDebut = rs.getDate(14);
                fdd.dateFin = rs.getDate(15);
            }

            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    /*
* *** Supprission ****
     */
    @Override
    public int supprimerFicheDeDressage() {
        try {
            String req = "update f_dressage set etat= 0 where id_f_soin =? ";
            ps = conn.prepareStatement(req);
            ps.setInt(1, this.id_f_Dressage);
            ps.execute();
            return 1;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

}
