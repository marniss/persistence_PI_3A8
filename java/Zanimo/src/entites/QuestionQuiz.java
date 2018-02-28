/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import services.DataSource;

/**
 *
 * @author Ahmed
 */
public class QuestionQuiz {

    // atribut
    private int id;
    private int idR;
    private String question;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    //1
    public QuestionQuiz() {
    }

    //2
    public QuestionQuiz(int id, int idR, String question) {
        this.id = id;
        this.idR = idR;
        this.question = question;
    }

    //3
    public QuestionQuiz(int id) {
        this.id = id;
    }
    // les methodes "CRUD"
    Connection conn = DataSource.getInstance().getConnection();
    private Statement stmt;

    /*ajout*/
    //averifier
    public int ajouterQuestion() {

        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("Class Question  erreur  statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "INSERT INTO `question`(`question`, `etat`) VALUES ( '"
                + this.question
                + "' , 0 );";
        // execution de la requette
        try {
            stmt.executeUpdate(maRequette);
            return 1;
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'exxecution de la requete d'ajout d'une question");
            System.out.println(ex.getMessage());
        }
        return 0;

    }

    /*supprissin*/
    public int supprimerQuestion() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "DELETE FROM `question`"
                + " WHERE id_question = " + this.id
                + ";";

        // execution de la requette
        try {
            stmt.executeUpdate(maRequette);
            System.out.println(" la suppression est effectue");
            return 1;
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'exxecution de la requete de la supprission \n");
            System.out.println(ex.getMessage());

        }
        return 0;
    }

    /*Get Une Quetion a l'aide de son ID */
    public QuestionQuiz getQuestionQuiz() {
        QuestionQuiz leresultat = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM questionquiz WHERE idq = " + this.id + ";";

        // execution de la requette
        try {
            ResultSet res = stmt.executeQuery(maRequette);
            while (res.next()) {
                leresultat = new QuestionQuiz();
                leresultat.id = res.getInt("idq");
                leresultat.question = res.getString("question");
                leresultat.idR = res.getInt("idr");
            }

        } catch (SQLException ex) {
            System.out.println("Class Accessoire execution getaccessoire \n");
            System.out.println(ex.getMessage());

        }

        return leresultat;
    }

    //listing de tt les quetions
    public ArrayList<QuestionQuiz> listingQuestion() {
        ArrayList<QuestionQuiz> laListe = new ArrayList<>();
        QuestionQuiz leResultat;

        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM `questionquiz` ";
        ResultSet res = null;
        // execution de la requette
        try {
            res = stmt.executeQuery(maRequette);
            while (res.next()) {
                //recuperation des champs
                leResultat = new QuestionQuiz();
                leResultat.id = res.getInt("idQ");
                leResultat.question = res.getString("question");
                leResultat.idR = res.getInt("idR");
                //ajout de l'element a la liste
                laListe.add(leResultat);
            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de l'exxecution de la requete de selection\n");
            System.out.println(ex.getMessage());

        }

        return laListe;
    }

}
