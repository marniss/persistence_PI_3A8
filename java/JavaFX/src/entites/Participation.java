/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import services.DataSource;


/**
 *
 * @author houssem
 */
public class Participation {
    
    //les attributs
    private int idMembre;
    private int idConcour;
    private Date dateconcour;
    
    
    public int getIdMembre() {
        return idMembre;
    }

    //les geters end setters
    public void setIdMembre(int idMembre) {    
        this.idMembre = idMembre;
    }

    public int getIdConcour() {
        return idConcour;
    }

    public void setIdConcour(int idConcour) {
        this.idConcour = idConcour;
    }

    public Date getDateconcour() {
        return dateconcour;
    }

    public void setDateconcour(Date dateconcour) {
        this.dateconcour = dateconcour;
    }

    public Participation() {
    }

    public Participation(int idMembre, int idConcour, Date dateconcour) {
        this.idMembre = idMembre;
        this.idConcour = idConcour;
        this.dateconcour = dateconcour;
    }

    
    
    
    //les methodes
     // les attributs relatifs au methodes CRUD
    Connection conn = DataSource.getInstance().getConnection();
    private Statement stmt;
    
    
    public int supprimerParticipation(){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "UPDATE `participation` "
                + "SET `etat`= 0"
                + " WHERE id_membre = "
                + this.idMembre+
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
    public int modifierParticipation(int id){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "UPDATE `participation` SET "
                + "`date_concour`="+this.dateconcour+","
                + "`id_concours`="+this.idConcour+","
                + "`id_membre`="+this.idMembre+","
                + ";";
        
        // execution de la requette
        try{
            stmt.executeUpdate(maRequette);
            System.out.println("la modification est ffectuer");
            return 1;
        }catch(SQLException ahmed_makni){
            System.out.println("erreur lors de l'exxecution de la requete de la modification \n");
            System.out.println(ahmed_makni.getMessage());
            
        }
        return 0;
    }
     //methode consultation by id
    public Participation getParticipation(int id) throws SQLException{
        Participation leResultat = new Participation();
         try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT `id_concours`, `date_concour`, `id_membre` WHERE id_membre="+id+";";
        
        // execution de la requette
        try{
            ResultSet res = stmt.executeQuery(maRequette);
            System.out.println(" la recuperation des donnees est effectue");
            while(res.next()){
               
                leResultat.idMembre=res.getInt("id_membre");
                leResultat.idConcour=res.getInt("id_concours");
                leResultat.dateconcour=res.getDate("date_concour");
                
                /*et la suite ***/
            }
        
        }catch(SQLException houssem_marnissi){
            System.out.println("erreur lors de l'exxecution de la requete de la getmembre \n");
            System.out.println(houssem_marnissi.getMessage());
            
        }
        
        
        return leResultat;
    }
            
             
    public ArrayList<Participation> selectAll() {
         ArrayList<Participation> le = new ArrayList();
        try {
            PreparedStatement st = conn.prepareStatement(
            "SELECT id_membre,id_concours,date_concour"
                    + " FROM participation where etat=1");
            ResultSet res = st.executeQuery();
            while (res.next()) {
                Participation e = new Participation();
                e.setIdMembre(res.getInt("id_membre"));
                e.setDateconcour(res.getDate("date_concour"));
                e.setIdConcour(res.getInt("id_concours"));
                
                
                le.add(e);
            }
            return le;
        } catch (SQLException ex) {
            System.out.println("ereuur dans l'aafichage");
        return null;
        }
    }
    
    
    
}
