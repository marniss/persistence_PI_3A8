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
import services.DataSource;

/**
 *
 * @author salah
 */
public class sosDisparition {
    
    	
private int idSosDisparition;
 private int idMembre;

    public sosDisparition() {
    }

    public int getIdSosDisparition() {
        return idSosDisparition;
    }

    public int getIdMembre() {
        return idMembre;
    }

    @Override
    public String toString() {
        return "sosDisparition{" + "idSosDisparition=" + idSosDisparition + ", idMembre=" + idMembre + '}';
    }

    public void setIdSosDisparition(int idSosDisparition) {
        this.idSosDisparition = idSosDisparition;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }
    
 // les attributs relatifs au methodes CRUD
    Connection conn = DataSource.getInstance().getConnection();
    private Statement stmt;
    
    
     public int ajouterSosDisparition (){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
    
      
        
        
        
        String sql ="";//to do
      
      
      
      
        // execution de la requette
        try{
            stmt.executeUpdate(sql);
            System.out.println(" l'ajout est effectue");
            return 1;
        }catch(SQLException e){
            System.out.println("erreur lors de l'exxecution de la requete d'ajout d'un SosDisparition\n");
            System.out.println(e.getMessage());
            
        }
        return 0;
        
    }
     
     public int supprimerSosDisparition(){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = ""; // to do
        
        // execution de la requette
        try{
            stmt.executeUpdate(maRequette);
            System.out.println(" l'ajout est effectue");
            return 1;
        }catch(SQLException e){
            System.out.println("erreur lors de l'exxecution de la requete de la supprission \n");
            System.out.println(e.getMessage());
            
        }
        return 0;
        
    }
    
    
    //la methode modifier 
    public int modifierSosDisparition(){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = ""; //to do
        
        // execution de la requette
        try{
            stmt.executeUpdate(maRequette);
            System.out.println(" l'ajout est effectue");
            return 1;
        }catch(SQLException e){
            System.out.println("erreur lors de l'exxecution de la requete de la supprission \n");
            System.out.println(e.getMessage());
            
        }
        return 0;
    }
    
    
    
     public sosDisparition getSosDisparition(int id){
        sosDisparition leResultat = new sosDisparition();
         try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM animal WHERE id_sos_disparition= "+ id +";";
        
        // execution de la requette
        try{
            ResultSet res = stmt.executeQuery(maRequette);
            System.out.println(" la recuperation des donnees est effectue");
            while(res.next()){
                leResultat.idSosDisparition=res.getInt(1);
                leResultat.idMembre=res.getInt(2);
                
                
            }
           
        }catch(SQLException e){
            System.out.println("erreur lors de l'exxecution de la requete de la supprission \n");
            System.out.println(e.getMessage());
            
        }
        
        
        return leResultat;
    }
    
 
 
    
}
