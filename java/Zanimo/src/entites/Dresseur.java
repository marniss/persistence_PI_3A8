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
import java.util.Date;
import services.DataSource;

/**
 *
 * @author houssem
 */
public class Dresseur extends Membre{
    private int note ;
    
    //les getters et setters

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
    
    
    // les constructeurs

    public Dresseur() {
    }

    public Dresseur(int note, String nom, String prenom, String adresse, String email, int num, String photo, String DateInscription) {
        super( nom, prenom, adresse, email, num, photo, DateInscription);
        this.note = note;
    }
    
    
    
     
    //les methodes 
    
    
     // les attributs relatifs au methodes CRUD
    Connection conn = DataSource.getInstance().getConnection();
    private Statement stmt;
    
    /** l'ajou
     * @return t**/
    public int ajouterDresseur (){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "INSERT INTO `membre`("
              
                + "`nom`, "
                + "`prenom`, "
                + "`DateInscription`, "
                + "`adresse`, "
                + "`email`, "
                + "`photo`, "
                + "num,"
                +"type,"
                +"pasword,"
                +"etat"
                + ") "
                
                + "VALUES ( '"
                + this.getNom()+"','"
                + this.getPrenom()+"',"
               +" now(),'"
                + this.getAdresse()+"','"
                + this.getEmail()+"','"
                + this.getPhoto()+"',"
                + this.getNum()+","
                + "'dresseur',"
                + "'"+this.getPasword()+"',"
                +"1);";
        // execution de la requette
        try{
            stmt.executeUpdate(maRequette);
            System.out.println(" l'ajout est effectue");
            return 1;
        }catch(SQLException ahmed_makni){
            System.out.println("erreur lors de l'execution de la requete d'ajout d'un dresseur \n");
            System.out.println(ahmed_makni.getMessage());
            
        }
        return 0;
        
    }
    
    //supprission d'un acc
    public int supprimerDresseur(){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "UPDATE `membre` "
                + "SET `etat`= 0"
                + " WHERE id_Membre = "
                + this.getIdMembre()+
                ";";
        
        // execution de la requette
        try{
            stmt.executeUpdate(maRequette);
            System.out.println(" l'ajout est effectue");
            return 1;
        }catch(SQLException ahmed_makni){
            System.out.println("erreur lors de l'exxecution de la requete de la supprission \n");
            System.out.println(ahmed_makni.getMessage());
            
        }
        return 0;
        
    }
    
    
    //la methode modifier 
    public int modifierDresseur(){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "UPDATE `membre` SET "
                + "`nom`="+this.getNom()+","
                + "`prenom`="+this.getPrenom()+","
         
                + "`DateInscription`="+this.getDateInscription()+","
                + "`adresse`="+this.getAdresse()+","
                + "`email`="+this.getEmail()
                + "`num`="+this.getNum()
                + "`photo`="+this.getPhoto()
                + "WHERE 1 "
                + ";";
        
        // execution de la requette
        try{
            stmt.executeUpdate(maRequette);
            System.out.println(" l'ajout est effectue");
            return 1;
        }catch(SQLException ahmed_makni){
            System.out.println("erreur lors de l'exxecution de la requete de la supprission \n");
            System.out.println(ahmed_makni.getMessage());
            
        }
        return 0;
    }
    
    
    
   //methode consultation
    public Dresseur getDresseur(int id){
        Dresseur leResultat = new Dresseur();
         try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM membre WHERE Id_membre = "+ id +";";
        
        // execution de la requette
        try{
            ResultSet res = stmt.executeQuery(maRequette);
            System.out.println(" la recuperation des donnees est effectue");
            while(res.next()){
                leResultat.setIdMembre(res.getInt(1));
                leResultat.setNom(res.getString(2));
                leResultat.setPrenom(res.getString(3));
                leResultat.setAdresse(res.getString(4));
                leResultat.setEmail(res.getString(5));
                leResultat.setPhoto(res.getString(6));
                leResultat.setNum(res.getInt(7));
                /*et la suite ***/
                
            } 
        
           
        }catch(SQLException houssem_marnissi){
            System.out.println("erreur lors de l'exxecution de la requete de la supprission \n");
            System.out.println(houssem_marnissi.getMessage());
            
        }
        
        
        return leResultat;
    }
    
    
    
    
    
}
