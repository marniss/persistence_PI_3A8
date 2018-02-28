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
public class Question {
    //attributs
    private int id;
    private String laquestion;
    private String lesreponse;
    //getters

    public int getId() {
        return id;
    }

    public String getLaquestion() {
        return laquestion;
    }

    public String getLesreponse() {
        return lesreponse;
    }
    
    //setters

    public void setId(int id) {
        this.id = id;
    }

    public void setLaquestion(String laquestion) {
        this.laquestion = laquestion;
    }

    public void setLesreponse(String lesreponse) {
        this.lesreponse = lesreponse;
    }
    
    // les constructeurs
    /**1**/
    public Question() {}
    /**2**/ 
    public Question(int id, String laquestion, String lesreponse) {
        this.id = id;
        this.laquestion = laquestion;
        this.lesreponse = lesreponse;
    }
    /**3**/
    public Question(int id, String laquestion) {
        this.id = id;
        this.laquestion = laquestion;
    }
    /**4**/
    public Question(int id){
        this.id = id;
    }
    /**5**/
    public Question(String uneQuestion){
        this.laquestion=uneQuestion;
    }
    // les methodes "CRUD"
    Connection conn = DataSource.getInstance().getConnection();
    private Statement stmt;
    
    /*ajout*/
    public int ajouterQuestion(){
        
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("Class Question  erreur  statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "INSERT INTO `question`(`question`, `etat`) VALUES ( '"
                + this.laquestion
                +"' , 0 );";
        // execution de la requette
        try{
            stmt.executeUpdate(maRequette);
            return 1;
        }catch(SQLException ex){
            System.out.println("erreur lors de l'exxecution de la requete d'ajout d'une question");
            System.out.println(ex.getMessage());
        }
        return 0;

    }
    /*supprissin*/
    public int supprimerQuestion (){
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
    public int modifierQuestion(int idrep){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "UPDATE `question` SET "
                + "`id_reponse`= '"+idrep+",' ,"
                +"`etat`= 1"
                + " WHERE id_question = " + this.id
                + ";";
        // execution de la requette
        try{
            stmt.executeUpdate(maRequette);
            return 1;
        }catch(SQLException ex){
            System.out.println("Classe Question erreur req modifiation");
            System.out.println(ex.getMessage());
            
        }
        return 0;
    }
   /*Get Une Quetion a l'aide de son ID */
    public Question getQuestion(){
        Question leresultat = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM question WHERE id_question = "+ this.id +";";
        
        // execution de la requette
        try{
            ResultSet res = stmt.executeQuery(maRequette);
            while(res.next()){
                leresultat  = new Question();
                leresultat.id=res.getInt("id_question");
                leresultat.laquestion=res.getString("question");
                leresultat.lesreponse=res.getString("id_reponse");
            }
           
        }catch(SQLException ex){
            System.out.println("Class Accessoire execution getaccessoire \n");
            System.out.println(ex.getMessage());
            
        }

        return leresultat;
    }
    
    //listing de tt les quetions
    public ArrayList<Question> listingQuestion(){
        ArrayList<Question> laListe = new ArrayList<>();
        Question leResultat;
        
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM `question` Where etat = 1";
        ResultSet res = null;
        // execution de la requette
        try{
            res = stmt.executeQuery(maRequette);
            while(res.next()){
                //recuperation des champs
                leResultat  = new Question();
                leResultat.id=res.getInt("id_question");
                leResultat.laquestion=""+res.getString("question");
                leResultat.lesreponse=""+res.getString("id_reponse");
                //ajout de l'element a la liste
                laListe.add(leResultat);
            }
            
            
        }catch(SQLException ex){
            System.out.println("erreur lors de l'exxecution de la requete de selection\n");
            System.out.println(ex.getMessage());
            
        }

        return laListe;
    }
    
    public ArrayList<Question> listingQuestionPourAdmin(){
        ArrayList<Question> laListe = new ArrayList<>();
        Question leResultat;
        
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM `question` Where etat = 0";
        ResultSet res = null;
        // execution de la requette
        try{
            res = stmt.executeQuery(maRequette);
            while(res.next()){
                //recuperation des champs
                leResultat  = new Question();
                leResultat.id=res.getInt("id_question");
                leResultat.laquestion=""+res.getString("question");
                leResultat.lesreponse=""+res.getString("id_reponse");
                //ajout de l'element a la liste
                laListe.add(leResultat);
            }
            
            
        }catch(SQLException ex){
            System.out.println("erreur lors de l'exxecution de la requete de selection\n");
            System.out.println(ex.getMessage());
            
        }

        return laListe;
    }
}
