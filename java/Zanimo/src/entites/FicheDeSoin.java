/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import IHM.IHM_loginController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import services.DataSource;
import ientites.ificheDeSoinInterface;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    private String observation;
    private String medicament;
    private Date prochainRDV;
    private int id_animal;
    private Date datecreation;
    private int etat;
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
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

    public FicheDeSoin(int id_f_Soin, int id_membre, String observation, String medicament, Date prochainRDV, int id_animal, int etat) {
        this.id_f_Soin = id_f_Soin;
        this.id_membre = id_membre;
        this.observation = observation;
        this.medicament = medicament;
        this.prochainRDV = prochainRDV;
        this.id_animal = id_animal;
        this.etat = etat;
    }

    public FicheDeSoin(int id_membre, String observation, String medicament, Date datecreation, Date prochainRDV, int id_animal, int etat) {

        this.id_membre = id_membre;
        this.observation = observation;
        this.medicament = medicament;
        this.datecreation = datecreation;
        this.prochainRDV = prochainRDV;
        this.id_animal = id_animal;
        this.etat = etat;
    }

    public Date getProchainRDV() {
        return prochainRDV;
    }

    public void setProchainRDV(Date prochainRDV) {
        this.prochainRDV = prochainRDV;
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

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
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
         *
         */

        String dateprrdv = formater.format(this.prochainRDV);
        String datepcre = formater.format(this.datecreation);

        String req = "INSERT INTO `f_soin`(`id_f_Soin`, `id_membre`, `observation`, `medicament`, `dateCreation`,`prochainRDV`, `id_animal`, `etat`) VALUES (" + this.id_f_Soin + "," + this.id_membre + ",'" + this.observation + "','" + this.medicament + "','" + datepcre + "','" + dateprrdv + "'," + this.id_animal + ",1)";
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

        String date = formater.format(prochainRDV);
        System.out.println("Ahmeeeed date" + date);
        String req = "UPDATE `f_soin` SET `id_membre`=" + this.id_membre + ",`observation`='" + this.observation + "',`medicament`='" + this.medicament + "',`prochainRDV`='" + date + "' WHERE `id_f_Soin`=" + this.id_f_Soin + ";";
        System.out.println(req);
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
                fs.observation = rs.getString(3);
                fs.medicament = rs.getString(4);
                fs.prochainRDV = rs.getDate(5);

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
        ArrayList<FicheDeSoin> ficheDeSoins = new ArrayList<>();
        String req = "Select * From f_soin "
        + "where etat=1"
        + " and  id_membre = " + IHM_loginController.membre.getIdMembre();
        try {
            ps = conn.prepareStatement(req);
            rs = ps.executeQuery();
            while (rs.next()) {
                FicheDeSoin fs = new FicheDeSoin();
                fs.id_f_Soin = rs.getInt(1);
                fs.id_membre = rs.getInt(2);
                fs.observation = rs.getString(3);
                fs.medicament = rs.getString("medicament");
                fs.datecreation = rs.getDate("dateCreation");
                fs.prochainRDV = rs.getDate("prochainRDV");
                fs.id_animal = rs.getInt("id_animal");
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
