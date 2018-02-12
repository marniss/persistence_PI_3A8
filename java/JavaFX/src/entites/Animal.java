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
public class Animal {
    
    private int idAnimal;
    private int idAdoption;
    private int idSosDisparition;
    private String type ;

    public Animal() {
    }

    public Animal(int idAnimal, int idAdoption, int idSosDisparition, String type) {
        this.idAnimal = idAnimal;
        this.idAdoption = idAdoption;
        this.idSosDisparition = idSosDisparition;
        this.type = type;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdAdoption() {
        return idAdoption;
    }

    public void setIdAdoption(int idAdoption) {
        this.idAdoption = idAdoption;
    }

    public int getIdSosDisparition() {
        return idSosDisparition;
    }

    public void setIdSosDisparition(int idSosDisparition) {
        this.idSosDisparition = idSosDisparition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Animal{" + "idAnimal=" + idAnimal + ", idAdoption=" + idAdoption + ", idSosDisparition=" + idSosDisparition + ", type=" + type + '}';
    }
    
    
      //nos methodes
    
    // les attributs relatifs au methodes CRUD
    Connection conn = DataSource.getInstance().getConnection();
    private Statement stmt;
    
    
     public int ajouterAnimal (){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        //	id_animal	id_adoption	id_sos_disparition	type
      
        
        
        
        String sql ="";//to do
      
      
      
      
        // execution de la requette
        try{
            stmt.executeUpdate(sql);
            System.out.println(" l'ajout est effectue");
            return 1;
        }catch(SQLException e){
            System.out.println("erreur lors de l'exxecution de la requete d'ajout d'un animal \n");
            System.out.println(e.getMessage());
            
        }
        return 0;
        
    }
     
     public int supprimerAccessoire(){
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
    public int modifierAnimal(){
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
    
    
    
     public Animal getAnimal(int id){
        Animal leResultat = new Animal();
         try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM animal WHERE id_animal = "+ id +";";
        
        // execution de la requette
        try{
            ResultSet res = stmt.executeQuery(maRequette);
            System.out.println(" la recuperation des donnees est effectue");
            while(res.next()){
                leResultat.idAnimal=res.getInt(1);
                leResultat.idAdoption=res.getInt(2);
                leResultat.idSosDisparition=res.getInt(3);
                leResultat.type=res.getString(3);
                /*et la suite ***/
            }
           
        }catch(SQLException e){
            System.out.println("erreur lors de l'exxecution de la requete de la supprission \n");
            System.out.println(e.getMessage());
            
        }
        
        
        return leResultat;
    }
    
}
