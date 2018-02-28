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
public class ReponseQuiz {

    private int idr;
    private String reponse;

    public ReponseQuiz() {
    }

    public ReponseQuiz(int idr, String reponse) {
        this.idr = idr;
        this.reponse = reponse;
    }

    public ReponseQuiz(int idr) {
        this.idr = idr;
    }

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    // les methodes "CRUD"
    Connection conn = DataSource.getInstance().getConnection();
    private Statement stmt;

    public ArrayList<ReponseQuiz> listingReponse() {
        ArrayList<ReponseQuiz> laListe = new ArrayList<>();
        ReponseQuiz leResultat;

        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM `reponsequiz`";
        ResultSet res = null;
        // execution de la requette
        try {
            res = stmt.executeQuery(maRequette);
            while (res.next()) {
                //recuperation des champs
                leResultat = new ReponseQuiz();
                leResultat.idr = res.getInt("idR");
                leResultat.reponse = res.getString("reponse");
                laListe.add(leResultat);
            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de l'exxecution de la requete de selection\n");
            System.out.println(ex.getMessage());

        }

        return laListe;
    }

    public ReponseQuiz getBonneReponse() {
        ReponseQuiz leResultat = null;

        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM `reponsequiz` where idR = " + this.idr;
        ResultSet res = null;
        // execution de la requette
        try {
            res = stmt.executeQuery(maRequette);
            while (res.next()) {
                //recuperation des champs
                leResultat = new ReponseQuiz();
                leResultat.idr = res.getInt("idR");
                leResultat.reponse = res.getString("reponse");
            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de l'exxecution de la requete de selection\n");
            System.out.println(ex.getMessage());

        }

        return leResultat;
    }
}
