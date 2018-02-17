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
    Connection conn;
    private PreparedStatement ps;
    private Statement stm;
    private ResultSet rs;

    /*
     * Nos Methode *
     */
    public int ajouterNote() {
        System.out.println("Modele");
        conn = DataSource.getInstance().getConnection();
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

    public float moyNoteee() {
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
            ResultSet executeQuery = stm.executeQuery(req);
            while (executeQuery.next()) {
                System.out.println("Ahmado " + executeQuery.getString(1));
                System.out.println(executeQuery.getObject(1));

            }
            System.out.println("Ahmeeeeed");
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erreur de l'Execution");
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
            ResultSet executeQuery = stm.executeQuery(req);
            while (executeQuery.next()) {
                System.out.println("Ahmado " + executeQuery.getString(1));
                //System.out.println("entit   [" + executeQuery.getString(1).length() + "]");
                // System.out.println(executeQuery.getObject(1));
                return executeQuery.getString(1);
            }
            //System.out.println("Ahmeeeeed");
            //return executeQuery.getString(1);
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Erreur de l'Execution");
        }
        return "";

    }

}
