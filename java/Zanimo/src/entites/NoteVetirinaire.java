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
import services.ControlleurListeVeterinaire;
import services.DataSource;

/**
 *
 * @author makni
 */
public class NoteVetirinaire {

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
//1
    public NoteVetirinaire() {
    }
//2

    public NoteVetirinaire(int id) {
        this.id_note = id;
    }
//2

    public NoteVetirinaire(int id_note, int id_membre, float note, String observation) {
        this.id_note = id_note;
        this.id_membre = id_membre;
        this.note = note;
        this.observation = observation;

    }
//3

    public NoteVetirinaire(int id_membre, float note, String observation) {

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

            String req = "INSERT INTO `notevetirinaire`(`idmembre`, `note`, `observation`) VALUES (?,?,?);";

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

    public float getNote() {
        return note;
    }

    public String moyNotee() {
        String st = null;
        //Connexion à La DB
        conn = DataSource.getInstance().getConnection();
        System.out.println("Modele");

        /**
         * Creation Du Req
         */
        String req = "select AVG(note) from notevetirinaire ";

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
            /**
             * Execution de La Requette*
             */
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

    public NoteVetirinaire getlanote() {
        NoteVetirinaire temp = new NoteVetirinaire(this.id_note);
        Statement sttt = null;
        try {

            /**
             * Creation du req*
             */
            String req = "select note from notevetirinaire  where idnoteVet =" + this.id_note;

            try {
                /*
                *Creation Du Statememnt
                 */
                sttt = conn.createStatement();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            /**
             * Execution de La Requette*
             */
            ResultSet rzs = sttt.executeQuery(req);

            while (rzs.next()) {
                temp.note = rzs.getFloat("note");

            }
            return temp;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return temp;
    }

    public void setLaNote(float f) {
        Statement sttt = null;
        try {

            /**
             * Creation du req*
             */
            String req = "UPDATE `notevetirinaire` SET "
            + "`note`= " + f
            + " WHERE idnoteVet = " + ControlleurListeVeterinaire.tempo.getId_note();
            System.out.println(req);

            try {
                /*
                *Creation Du Statememnt
                 */
                sttt = conn.createStatement();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            sttt.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getLastidNote() {
        ArrayList<NoteVetirinaire> nvsList = new ArrayList<>();
        try {
            try {

                Statement sttt = null;
                String req = "select * from notevetirinaire ";
                System.out.println(req);
                try {

                    sttt = conn.createStatement();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Erreur de creation de statement");
                }
                rs = sttt.executeQuery(req);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());

            }
            while (rs.next()) {
                NoteVetirinaire nv = new NoteVetirinaire();
                nv.id_note = rs.getInt("idnoteVet");
                System.out.println(nv.id_note);
                nvsList.add(nv);
            }

        } catch (SQLException ex) {
            System.out.println("ssss");
        }

        return nvsList.get(nvsList.size() - 1).id_note;

    }

}
