/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import services.DataSource;
import ientites.ificheDeSoinInterface;
import javafx.scene.control.Button;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author makni
 */
public class FicheDeSoin implements ificheDeSoinInterface {

//Les attributs
    private int id_f_Soin;
    private int id_membre;
    private String nom;
    private String espece;
    private float poids;
    private Date datePoids;
    private Date neLe;
    private String genre;
    private String observation;
    private String photo;
    private String medicament;
    private String proprietaire;
    private Date prochainRDV;
    private int etat;
    private Button modButton;
    private Button supButton;

    public Button getModButton() {
        return modButton;
    }

    public void setModButton(Button modButton) {
        this.modButton = modButton;
    }

    public Button getSupButton() {
        return supButton;
    }

    public void setSupButton(Button supButton) {
        this.supButton = supButton;
    }

//Les attributs DB
    Connection conn = DataSource.getInstance().getConnection();
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement stmt;

//Les Constructeurs

    /*
* *** 1 ****
     */
    public FicheDeSoin() {

    }

    /*
* *** 2 ****
     */
    public FicheDeSoin(int id_f_Soin, int id_membre, String nom, String espece, float poids, Date datePoids, Date neLe, String genre, String observation, String photo, String medicament, String proprietaire, Date prochainRDV, int etat, Button modButton, Button supButton) {
        this.id_f_Soin = id_f_Soin;
        this.id_membre = id_membre;
        this.nom = nom;
        this.espece = espece;
        this.poids = poids;
        this.datePoids = datePoids;
        this.neLe = neLe;
        this.genre = genre;
        this.observation = observation;
        this.photo = photo;
        this.medicament = medicament;
        this.proprietaire = proprietaire;
        this.prochainRDV = prochainRDV;
        this.etat = etat;
        this.modButton = modButton;
        this.supButton = supButton;

    }

    public FicheDeSoin(int id_f_Soin, int id_membre, String nom, String espece, float poids, Date datePoids, Date neLe, String genre, String observation, String photo, String medicament, String proprietaire, Date prochainRDV, int etat) {
        this.id_f_Soin = id_f_Soin;
        this.id_membre = id_membre;
        this.nom = nom;
        this.espece = espece;
        this.poids = poids;
        this.datePoids = datePoids;
        this.neLe = neLe;
        this.genre = genre;
        this.observation = observation;
        this.photo = photo;
        this.medicament = medicament;
        this.proprietaire = proprietaire;
        this.prochainRDV = prochainRDV;
        this.etat = etat;

    }

    /*
     ****3****
     */
    public FicheDeSoin(int id_membre, String nom, String espece, float poids, Date datePoids, Date neLe, String genre, String observation, String photo, String medicament, String proprietaire, Date prochainRDV, int etat) {

        this.id_membre = id_membre;
        this.nom = nom;
        this.espece = espece;
        this.poids = poids;
        this.datePoids = datePoids;
        this.neLe = neLe;
        this.genre = genre;
        this.observation = observation;
        this.photo = photo;
        this.medicament = medicament;
        this.proprietaire = proprietaire;
        this.prochainRDV = prochainRDV;
        this.etat = etat;

    }

    public FicheDeSoin(String nom, String espece, float poids, Date datePoids, Date neLe, String genre, String observation, String photo, String medicament, String proprietaire, Date prochainRDV, int etat) {

        this.nom = nom;
        this.espece = espece;
        this.poids = poids;
        this.datePoids = datePoids;
        this.neLe = neLe;
        this.genre = genre;
        this.observation = observation;
        this.photo = photo;
        this.medicament = medicament;
        this.proprietaire = proprietaire;
        this.prochainRDV = prochainRDV;
        this.etat = etat;

    }
//Les Getters et les setters

    @Override
    public String toString() {
        return "FicheDeSoin{" + "id_f_Soin=" + id_f_Soin + ", id_membre=" + id_membre + ", nom=" + nom + ", espece=" + espece + ", poids=" + poids + ", datePoids=" + datePoids + ", neLe=" + neLe + ", genre=" + genre + ", observation=" + observation + ", photo=" + photo + ", medicament=" + medicament + ", proprietaire=" + proprietaire + ", prochainRDV=" + prochainRDV + '}';
    }

    public int getId_f_Soin() {
        return id_f_Soin;
    }

    public void setId_f_Soin(int id_f_Soin) {
        this.id_f_Soin = id_f_Soin;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public Date getDatePoids() {
        return datePoids;
    }

    public void setDatePoids(Date datePoids) {
        this.datePoids = datePoids;
    }

    public Date getNeLe() {
        return neLe;
    }

    public void setNeLe(Date neLe) {
        this.neLe = neLe;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Date getProchainRDV() {
        return prochainRDV;
    }

    public void setProchainRDV(Date prochainRDV) {
        this.prochainRDV = prochainRDV;
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
    public int ajouterFicheDeSoin() {
        /**
         * Creation de Statement**
         */
        try {

            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        /**
         * Creation de la Requette**
         */

        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String datepoid = formater.format(this.datePoids);
        String datNai = formater.format(this.neLe);
        String dateRDV = formater.format(this.prochainRDV);
        String req = "INSERT INTO `f_soin`(`id_membre`, `nom`, `espece`, `poids`, `datePoids`, `neLe`, `genre`, `observation`, `photo`, `medicament`, `proprietaire`, `prochainRDV`, `etat`) VALUES (" + this.id_membre + ",'" + this.nom + "','" + this.espece + "'," + this.poids + ",'" + datepoid + "','" + datNai + "','" + this.genre + "','" + this.observation + "','" + this.photo + "','" + this.medicament + "','" + this.proprietaire + "','" + dateRDV + "'," + this.etat + ");";
        try {
            /**
             * execution de la requette**
             */
            stmt.executeUpdate(req);
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
    public int modifierFicheDeSoin() {
        /**
         * Creation de Statement**
         */
        try {

            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        /**
         * Creation de la Requette**
         */
        String req = "UPDATE `f_soin` "
        + "SET `nom`='" + this.nom
        + "',`espece`='" + this.espece
        + "',`poids`=" + this.poids
        + ",`datePoids`='" + this.datePoids
        + "',`neLe`='" + this.neLe
        + "',`genre`='" + this.genre
        + "',`observation`='" + this.observation
        + "',`photo`='" + this.photo
        + "',`medicament`='" + this.medicament
        + "',`proprietaire`='" + this.proprietaire
        + "',`prochainRDV`='" + this.prochainRDV
        + "' WHERE `id_f_Soin`=" + this.id_f_Soin + ";";
        try {
            /*
             * execution de la requette**
             */
            stmt.executeUpdate(req);
            System.out.println("Updaaaaate Bieeeen");
            return 1;
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            System.out.println("Ereeeeeeeeer update");
        }
        return 0;

    }

    /*
* *** Recherche ****
     */
    @Override
    public int rechercheFicheDeSoin(int id_f_Soin) {

        FicheDeSoin fs = new FicheDeSoin();

        String req = "Select *From f_soin where id_f_soin=?";
        try {
            ps = conn.prepareStatement(req);
            ps.setInt(1, this.id_f_Soin);
            rs = ps.executeQuery();
            if (rs.next()) {
                fs.id_f_Soin = rs.getInt(1);
                fs.id_membre = rs.getInt(2);
                fs.nom = rs.getString(3);
                fs.espece = rs.getString(4);
                fs.poids = rs.getInt(5);
                fs.datePoids = rs.getDate(6);
                fs.neLe = rs.getDate(7);
                fs.genre = rs.getString(8);
                fs.observation = rs.getString(9);
                fs.photo = rs.getString(10);
                fs.medicament = rs.getString(11);
                fs.proprietaire = rs.getString(12);
                fs.prochainRDV = rs.getDate(13);

            }
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;

    }

    /*
* *** Consultation ****
     */
    @Override
    public ArrayList<FicheDeSoin> displayFicheDeSoin() {
        ArrayList<FicheDeSoin> ficheDeSoins;
        ficheDeSoins = new ArrayList<>();
        String req = "Select * From f_soin where etat=1";
        try {
            ps = conn.prepareStatement(req);
            rs = ps.executeQuery();
            while (rs.next()) {
                FicheDeSoin fs = new FicheDeSoin();
                fs.id_f_Soin = rs.getInt(1);
                fs.id_membre = rs.getInt(2);
                fs.nom = rs.getString(3);
                fs.espece = rs.getString(4);
                fs.poids = rs.getInt(5);
                fs.datePoids = rs.getDate(6);
                fs.neLe = rs.getDate(7);
                fs.genre = rs.getString(8);
                fs.observation = rs.getString(9);
                fs.photo = rs.getString(10);
                fs.medicament = rs.getString(11);
                fs.proprietaire = rs.getString(12);
                fs.prochainRDV = rs.getDate(13);
                fs.etat = rs.getInt(14);
                fs.modButton = new Button("Modifier");
                fs.supButton = new Button("Supprimer");
                ficheDeSoins.add(fs);
            }
            return ficheDeSoins;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erreuuur d'execution req");
        }
        return ficheDeSoins;

    }

    /*
* *** Supprission ****
     */
    @Override
    public int supprimerFicheDeSoin() {
        try {
            String req = "update f_soin set etat= 0 where id_f_soin =? ";
            ps = conn.prepareStatement(req);
            ps.setInt(1, this.id_f_Soin);
            ps.execute();

            return 1;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;

    }

}
