/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import services.ControlleurListeDresseur;
import services.DataSource;

/**
 *
 * @author makni
 */
public class NoteDresseur {

    /**
     * Les Attributs *
     */
    private int id_note;
    private int id_membre;
    private float note;
    private String observation;

    /**
     * Les Constructeurs*
     */
    public NoteDresseur() {
    }

    public NoteDresseur(int id) {
        this.id_note = id;
    }

    public NoteDresseur(int id_note, int id_membre, float note, String observation) {
        this.id_note = id_note;
        this.id_membre = id_membre;
        this.note = note;
        this.observation = observation;
    }

    public NoteDresseur(int id_membre, float note, String observation) {

        this.id_membre = id_membre;
        this.note = note;
        this.observation = observation;
    }

    /*
     * Getters*
     */
    public int getId_note() {
        return id_note;
    }

    /*
      Les Setters
     */
    public void setId_note(int id_note) {
        this.id_note = id_note;
    }
    /**
     * Attributs Relative à DB
     */
    Connection conn = DataSource.getInstance().getConnection();
    private PreparedStatement ps;
    private Statement stm;
    private ResultSet rs;

    /*
     * Nos Methode *
     */
    public int ajouterNote() {
        System.out.println("Modele");

        try {
            /**
             * Creation du Requette**
             */

            String req = "INSERT INTO `notedresseur`(`idmembre`, `note`, `observation`) VALUES (?,?,?);";

            try {
                /**
                 * Creation Statement
                 */
                ps = (PreparedStatement) conn.prepareStatement(req);
                ps.setInt(1, this.id_membre);
                ps.setFloat(2, this.note);
                ps.setString(3, this.observation);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Erreur Creation de Statement");
            }
            /**
             * Execution de La Requette*
             */
            ps.executeUpdate();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erreur d'execution du req");
        }
        return 0;
    }

    public String moyNotee() {
        String st = null;
        //Connexion à La DB
        conn = DataSource.getInstance().getConnection();
        System.out.println("Modele");

        /**
         * Creation Du Req
         */
        String req = "select AVG(note) from notedresseur ";

        try {
            /*
            * Creation Du Statement **
             */
            stm = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erreur de creation de Statement");
        }
        try {
            ResultSet executeQuery = stm.executeQuery(req);
            while (executeQuery.next()) {
                System.out.println("Ahmado " + executeQuery.getString(1));

                return executeQuery.getString(1);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Erreur de l'Execution");
        }
        return "";

    }

    public NoteDresseur getlanote() {
        NoteDresseur temp = new NoteDresseur(this.id_note);

        try {

            /**
             * Creation du req*
             */
            String req = "select note from notedresseur  where idnote = " + this.id_note;

            try {
                /*
                *Creation Du Statememnt
                 */
                stm = conn.createStatement();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            ResultSet rzs = stm.executeQuery(req);

            while (rzs.next()) {
                System.out.println("dans la boucle");
                temp.note = rzs.getFloat("note");

            }
            return temp;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return temp;
    }

    public float getNote() {
        return note;
    }

    public void setLaNote(float f) {
        Statement sttt = null;
        try {

            /**
             * Creation du req*
             */
            String req = "UPDATE `notedresseur` SET "
            + "`note`= " + f
            + " WHERE idnote = " + ControlleurListeDresseur.tempo.getId_note();
            System.out.println(req);

            try {
                /*
                *Creation Du Statememnt
                 */
                System.out.println("1");
                sttt = conn.createStatement();
                System.out.println("2");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("3");
            sttt.executeUpdate(req);
            System.out.println("4");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getLastidNote() {
        ArrayList<NoteDresseur> nvsList = new ArrayList<>();
        System.out.println("dsfsfsfsecfefs");
        try {
            try {
                Statement sttt = null;
                String req = "select * from notedresseur ";
                System.out.println(req);
                try {
                    System.out.println("staaaateeement");
                    sttt = conn.createStatement();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Erreur de creation de statement");
                }
                rs = sttt.executeQuery(req);
                System.out.println("eeeeeeeeexxx");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Erreur Execution");
            }
            while (rs.next()) {
                System.out.println("eeeeeeeeexxx");
                NoteDresseur nd = new NoteDresseur();
                nd.id_note = rs.getInt("idnote");
                System.out.println(nd.id_note);
                nvsList.add(nd);
            }
        } catch (SQLException ex) {
            System.out.println("ssss");
        }
        System.out.println("Ahmeeed" + nvsList.get(nvsList.size() - 1).id_note);
        return nvsList.get(nvsList.size() - 1).id_note;

    }
}
