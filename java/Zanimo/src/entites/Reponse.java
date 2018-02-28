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
public class Reponse {
    //attribut
    private int id;
    private String lareponse;
    //methodes
    //getters

    public int getId() {
        return id;
    }

    public String getLareponse() {
        return lareponse;
    }

    //setters

    public void setId(int id) {
        this.id = id;
    }

    public void setLareponse(String lareponse) {
        this.lareponse = lareponse;
    }

    //constructeurs
    /**1**/
    public Reponse() {}
    /**2**/
    public Reponse(int id, String lareponse) {
        this.id = id;
        this.lareponse = lareponse;
    }
    /**3**/
    public Reponse(int id) {
        this.id = id;
    }
    /**4**/
    public Reponse(String rep){
        this.lareponse=rep;
    }
// les methodes "CRUD"
    Connection conn = DataSource.getInstance().getConnection();
    private Statement stmt;
    
    /*ajout*/
    public int ajouterReponse(){
        
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("Class Question  erreur  statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "INSERT INTO `reponse`(`reponse`) VALUES ( '"
                + this.lareponse
                + "' );";
        // execution de la requette
        try{
            stmt.executeUpdate(maRequette);
            System.out.println("lajour de la reponse est effectué");
            return 1;
        }catch(SQLException ex){
            System.out.println("erreur lors de l'exxecution de la requete d'ajout d'une repose");
            System.out.println(ex.getMessage());
        }
        return 0;

    }
    /*supprissin*/
    public int supprimerReponse (){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "DELETE FROM `reponse`"
                + " WHERE id_reponse = " + this.id
                +" ;";
        
        // execution de la requette
        try{
            stmt.executeUpdate(maRequette);
            System.out.println(" la suppression est effectue");
            return 1;
        }catch(SQLException ex){
            System.out.println("erreur lors de l'exxecution de la requete de la supprission \n");
            System.out.println(ex.getMessage());
            
        }
        return 0;
    }
    
    /*modificcation*/
    public int modifierReponse(){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        
        // preparation de la requette
        String maRequette = "UPDATE `reponse` SET `reponse`= '"
                + this.lareponse
                + " ' WHERE id_reponse = "
                + this.id
                + ";";
        
        // execution de la requette
        try{
            stmt.executeUpdate(maRequette);
            return 1;
        }catch(SQLException ex){
            System.out.println("Classe Reponse erreur req modifiation");
            System.out.println(ex.getMessage());
            
        }
        return 0;
    }
   /*Get Une Quetion a l'aide de son ID */
    public Reponse getReponse(){
        Reponse leresultat = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT `reponse` FROM `reponse`"
                + " WHERE id_reponse = " + this.id
                + ";";
        // execution de la requette
        try{
            ResultSet res = stmt.executeQuery(maRequette);
            while(res.next()){
                leresultat  = new Reponse();
                leresultat.lareponse=res.getString("reponse");
            }
           
        }catch(SQLException ex){
            System.out.println("Class Reponse get reponse");
            System.out.println(ex.getMessage());
            
        }

        return leresultat;
    }
    
    //listing de tt les quetions
    public ArrayList<Reponse> listingReponse(){
        ArrayList<Reponse> laListe = new ArrayList<>();
        Reponse leResultat;
        
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM `reponse`";
        ResultSet res = null;
        // execution de la requette
        try{
            res = stmt.executeQuery(maRequette);
            while(res.next()){
                //recuperation des champs
                leResultat  = new Reponse();
                leResultat.id=res.getInt("id_reponse");
                leResultat.lareponse=res.getString("reponse");
                //ajout de l'element a la liste
                laListe.add(leResultat);
            }
            
            
        }catch(SQLException ex){
            System.out.println("erreur lors de l'exxecution de la requete de selection\n");
            System.out.println(ex.getMessage());
            
        }

        return laListe;
    }
    
    public Reponse getReponseviaREP(){
        Reponse leresultat = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM `reponse`"
                + " WHERE reponse like '" + this.lareponse
                + "' ;";
        // execution de la requette
        try{
            ResultSet res = stmt.executeQuery(maRequette);
            while(res.next()){
                leresultat  = new Reponse();
                leresultat.id=res.getInt("id_reponse");
                leresultat.lareponse=res.getString("reponse");
            }
           
        }catch(SQLException ex){
            System.out.println("Class Reponse get reponse");
            System.out.println(ex.getMessage());
            
        }
        return leresultat;
    }
    

}
