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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.DataSource;

/**
 *
 * @author Ahmed
 */
public class Accessoire {
    //les attributs 
    private int idAccessoire;
    private String nomAccessoire;
    private String descriptionAccessoire;
    private float prixAccessoire;
    private int qteStockAccessoire;
    private String typeAccessoire;
    private String photoAccessoire;
    private Date datePublicationAccessoire;
    private int validitePublicationAccessoire;
    private int etatAccessoire;
    private Categorie categorieAccessoire;
    private int IdMembre;
    
    // getters

    public int getIdAccessoire() {
        return idAccessoire;
    }

    public String getNomAccessoire() {
        return nomAccessoire;
    }

    public String getDescriptionAccessoire() {
        return descriptionAccessoire;
    }

    public float getPrixAccessoire() {
        return prixAccessoire;
    }

    public int getQteStockAccessoire() {
        return qteStockAccessoire;
    }

    public String getTypeAccessoire() {
        return typeAccessoire;
    }

    public String getPhotoAccessoire() {
        return photoAccessoire;
    }

    public Date getDatePublicationAccessoire() {
        return datePublicationAccessoire;
    }

    public int getValiditePublicationAccessoire() {
        return validitePublicationAccessoire;
    }

    public int getEtatAccessoire() {
        return etatAccessoire;
    }

    public Categorie getCategorieAccessoire() {
        return categorieAccessoire;
    }

    public int getIdMembre() {
        return IdMembre;
    }
    
    //setters

    public void setIdAccessoire(int idAccessoire) {
        this.idAccessoire = idAccessoire;
    }

    public void setNomAccessoire(String nomAccessoire) {
        this.nomAccessoire = nomAccessoire;
    }

    public void setDescriptionAccessoire(String descriptionAccessoire) {
        this.descriptionAccessoire = descriptionAccessoire;
    }

    public void setPrixAccessoire(float prixAccessoire) {
        this.prixAccessoire = prixAccessoire;
    }

    public void setQteStockAccessoire(int qteStockAccessoire) {
        this.qteStockAccessoire = qteStockAccessoire;
    }

    public void setTypeAccessoire(String typeAccessoire) {
        this.typeAccessoire = typeAccessoire;
    }

    public void setPhotoAccessoire(String photoAccessoire) {
        this.photoAccessoire = photoAccessoire;
    }

    public void setDatePublicationAccessoire(Date datePublicationAccessoire) {
        this.datePublicationAccessoire = datePublicationAccessoire;
    }

    public void setValiditePublicationAccessoire(int validitePublicationAccessoire) {
        this.validitePublicationAccessoire = validitePublicationAccessoire;
    }

    public void setEtatAccessoire(int etatAccessoire) {
        this.etatAccessoire = etatAccessoire;
    }

    public void setCategorieAccessoire(Categorie categorieAccessoire) {
        this.categorieAccessoire = categorieAccessoire;
    }

    public void setIdMembre(int IdMembre) {
        this.IdMembre = IdMembre;
    }
     // constructeurs
    /**1**/
    public Accessoire() {}
    /**2**/
    public Accessoire(int idAccessoire, String nomAccessoire, String descriptionAccessoire, float prixAccessoire, int qteStockAccessoire, String typeAccessoire, String photoAccessoire, Date datePublicationAccessoire, int validitePublicationAccessoire, int etatAccessoire, Categorie categorieAccessoire, int IdMembre) {
        this.idAccessoire = idAccessoire;
        this.nomAccessoire = nomAccessoire;
        this.descriptionAccessoire = descriptionAccessoire;
        this.prixAccessoire = prixAccessoire;
        this.qteStockAccessoire = qteStockAccessoire;
        this.typeAccessoire = typeAccessoire;
        this.photoAccessoire = photoAccessoire;
        this.datePublicationAccessoire = datePublicationAccessoire;
        this.validitePublicationAccessoire = validitePublicationAccessoire;
        this.etatAccessoire = etatAccessoire;
        this.categorieAccessoire = categorieAccessoire;
        this.IdMembre = IdMembre;
    }
    
    
    //nos methodes
    
    // les attributs relatifs au methodes CRUD
    Connection conn = DataSource.getInstance().getConnection();
    private Statement stmt;
    
    /** l'ajout**/
    public int ajouterAccessoire (){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "INSERT INTO `accessoire`("
                + "`Nom_Accessoire`, "
                + "`Description_Accessoire`, "
                + "`Prix_Accessoire`, "
                + "`Qte_Stock_Accessoire`, "
                + "`Type_Accessoire`, "
                + "`Photo_Accessoire`, "
                + "`Date_Publication_Accessoire`, "
                + "`Validite_Publication_Accessoire`, "
                + "`Etat_Accessoire`, "
                + "`categorie_Accessoire`, "
                + "`Id_Membre`"
                + ") "
                + "VALUES ( '"
                + this.nomAccessoire+"','"
                + this.descriptionAccessoire+"',"
                + this.prixAccessoire+","
                + this.qteStockAccessoire+",'"
                + this.typeAccessoire+"','"
                + this.photoAccessoire+"',"
                + this.datePublicationAccessoire+","
                + this.validitePublicationAccessoire+",'"
                + this.etatAccessoire+"',"
                + this.categorieAccessoire.getIdCategorie()+","
                + this.IdMembre
                + ");";
        // execution de la requette
        try{
            stmt.executeUpdate(maRequette);
            System.out.println(" l'ajout est effectue");
            return 1;
        }catch(SQLException ahmed_makni){
            System.out.println("erreur lors de l'exxecution de la requete d'ajout d'un accessoire \n");
            System.out.println(ahmed_makni.getMessage());
            
        }
        return 0;
        
    }
    
    //supprission d'un acc
    public int supprimerAccessoire(){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "UPDATE `accessoire` "
                + "SET `Etat_Accessoire`= 0"
                + " WHERE Id_Accessoire = "
                + this.idAccessoire+
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
    public int modifierAccessoi(){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "UPDATE `accessoire` SET "
                + "`Nom_Accessoire`="+this.nomAccessoire+","
                + "`Description_Accessoire`="+this.descriptionAccessoire+","
                + "`Prix_Accessoire`="+this.nomAccessoire+","
                + "`Qte_Stock_Accessoire`=[value-5],"
                + "`Type_Accessoire`=[value-6],"
                + "`Photo_Accessoire`=[value-7],"
                + "`Date_Publication_Accessoire`=[value-8],"
                + "`Validite_Publication_Accessoire`=[value-9],"
                + "`Etat_Accessoire`=[value-10],"
                + "`categorie_Accessoire`=[value-11],"
                + "`Id_Membre`=[value-12] "
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
    public Accessoire getAccessoire(int id){
        Accessoire leResultat = new Accessoire();
         try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM Accessoire WHERE Id_Accessoire = "+ id +";";
        
        // execution de la requette
        try{
            ResultSet res = stmt.executeQuery(maRequette);
            System.out.println(" la recuperation des donnees est effectue");
            while(res.next()){
                leResultat.idAccessoire=res.getInt(1);
                leResultat.nomAccessoire=res.getString(2);
                leResultat.descriptionAccessoire=res.getString(3);
                /*et la suite ***/
            }
           
        }catch(SQLException ahmed_makni){
            System.out.println("erreur lors de l'exxecution de la requete de la supprission \n");
            System.out.println(ahmed_makni.getMessage());
            
        }
        
        
        return leResultat;
    }
    
}
