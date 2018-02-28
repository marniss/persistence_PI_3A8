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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private String specialite;
    private float displine;
    private float obeissance;
    private float accompagnement;
    private float interception;
    private float noteTotal;
    private Date dateDebut;
    private Date dateFin;
    private int id_animal;
    private int etat;

    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

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
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getSpecialite() {
        return specialite;
    }

    public FicheDeDressage(int id_f_Dressage, int id_membre, String specialite, float displine, float obeissance, float accompagnement, float interception, float noteTotal, Date dateDebut, Date dateFin, int id_animal, int etat) {
        this.id_f_Dressage = id_f_Dressage;
        this.id_membre = id_membre;
        this.specialite = specialite;
        this.displine = displine;
        this.obeissance = obeissance;
        this.accompagnement = accompagnement;
        this.interception = interception;
        this.noteTotal = noteTotal;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.id_animal = id_animal;
        this.etat = etat;
    }

    public FicheDeDressage(int id_membre, String specialite, float displine, float obeissance, float accompagnement, float interception, float noteTotal, Date dateDebut, Date dateFin, int id_animal, int etat) {

        this.id_membre = id_membre;
        this.specialite = specialite;
        this.displine = displine;
        this.obeissance = obeissance;
        this.accompagnement = accompagnement;
        this.interception = interception;
        this.noteTotal = noteTotal;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.id_animal = id_animal;
        this.etat = etat;
    }

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

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

////nos methodes

    /*
* *** L'ajout ****
     */
    @Override
    public int ajouterFicheDeDressage() {
        String datdebu = formater.format(this.dateDebut);
        String datfin = formater.format(this.dateFin);
        String req1 = "INSERT INTO `f_dressage`(`id_membre`, `displine`, `obeissance`, `specialite`, `accompagnement`, `interception`, `noteTotal`, `dateDebut`, `datFin`, `id_animal`, `etat`) VALUES (?,?,?,?,?,?,?,?,?,?,1)";
        try {

            ps = conn.prepareStatement(req1);
            ps.setInt(1, this.id_membre);
            ps.setFloat(2, this.displine);
            ps.setFloat(3, this.obeissance);
            ps.setString(4, this.specialite);
            ps.setFloat(5, this.accompagnement);
            ps.setFloat(6, this.interception);
            ps.setFloat(7, this.noteTotal);
            ps.setString(8, datdebu);
            ps.setString(9, datfin);
            ps.setInt(10, this.id_animal);
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
            String datdebu = formater.format(this.dateDebut);
            String datfin = formater.format(this.dateFin);
            String req = "UPDATE `f_dressage` SET `id_membre`=?,`displine`=?,`obeissance`=?,`specialite`=?,`accompagnement`=?,`interception`=?,`noteTotal`=?,`dateDebut`=?,`datFin`=?,`id_animal`=?,`etat`=1 Where id_f_Dressage =? ";
            ps = conn.prepareStatement(req);
            ps.setInt(1, this.id_membre);
            ps.setFloat(2, this.displine);
            ps.setFloat(3, this.obeissance);
            ps.setString(4, this.specialite);
            ps.setFloat(5, this.accompagnement);
            ps.setFloat(6, this.interception);
            ps.setFloat(7, this.noteTotal);
            ps.setString(8, datdebu);
            ps.setString(9, datfin);
            ps.setInt(10, this.id_animal);
            ps.setInt(11, this.id_f_Dressage);
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
                fdd.displine = rs.getFloat(8);
                fdd.obeissance = rs.getFloat(9);
                fdd.specialite = rs.getString(10);
                fdd.accompagnement = rs.getFloat(11);
                fdd.interception = rs.getFloat(12);
                fdd.noteTotal = rs.getFloat(13);
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
    public ArrayList displayFicheDeDressage() {

        FicheDeDressage fdd;
        ArrayList<FicheDeDressage> fiList = new ArrayList<>();
        try {

            String req = "Select * From f_dressage where etat=1 ";
            ps = conn.prepareStatement(req);

            rs = ps.executeQuery();
            while (rs.next()) {
                fdd = new FicheDeDressage();
                fdd.id_f_Dressage = rs.getInt(1);
                fdd.id_membre = rs.getInt(2);
                fdd.displine = rs.getFloat(3);
                fdd.obeissance = rs.getFloat(4);
                fdd.specialite = rs.getString(5);
                fdd.accompagnement = rs.getFloat(6);
                fdd.interception = rs.getFloat(7);
                fdd.noteTotal = rs.getInt(8);
                fdd.dateDebut = rs.getDate(9);
                fdd.dateFin = rs.getDate(10);
                fdd.id_animal = rs.getInt("id_animal");
                fiList.add(fdd);
            }
            return fiList;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return fiList;
        }
    }

    /*
* *** Supprission ****
     */
    @Override
    public int supprimerFicheDeDressage() {
        try {
            String req = "update f_dressage set etat= 0 where id_f_Dressage =? ";
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
