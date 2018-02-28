package entites;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.DataSource;

/**
 *
 * @author salah
 */

//*************************************************************************************************************
//                                    CLASS Sos Disparition
//*************************************************************************************************************
public class sosDisparition {
    private int idSosDisparition;
  
    private String nom;
    private int num_tel;
    private String description;
    private String email;
    private String adresse;


    public sosDisparition( String nom, int num_tel, String description, String email,String adresse) {
   
        this.nom =nom ;
        this.num_tel=num_tel ;
        this.description=description;
        this.email=email;
        this.adresse=adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public sosDisparition(String text, Integer valueOf) {
        throw new UnsupportedOperationException("Not supported yet.");    
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public sosDisparition() {} 
    
    public String getDescription() {return description;}
    public void setDescription(String description) { this.description = description;}
    public int getNum_tel() {return num_tel;}
    public void setNum_tel(int num_tel) {this.num_tel = num_tel;}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
   
    public int getIdSosDisparition() {return idSosDisparition;}
   
    public void setIdSosDisparition(int idSosDisparition) {this.idSosDisparition = idSosDisparition;}
          
    Connection conn = DataSource.getInstance().getConnection();
    private Statement stmt;

    
    
//*************************************************************************************************************
//                                       AJOUTER SOS Disparition
//*************************************************************************************************************
    public int ajouterSosDisparition() {
        try {
            stmt = conn.createStatement();
            } catch (SQLException ex) {
                System.out.println("erreur lors de la creation du statment \n");
                System.out.println(ex.getMessage());
                                       }
         
        String sql = "INSERT INTO `sos_disparition`("
               
                + "`nom`,"
                + "`num_tel` ,"
                + "description ,"
                + "`email` ,"
                + "`adresse` "
                + ") "
                + " VALUES ( '" +this.nom+ "'," + this.num_tel + ",'"+this.description+"','"+this.email+"','"+this.adresse+"');";

        
        try {
            stmt.executeUpdate(sql);
            System.out.println(" l'ajout est effectue");
            return 1;
            } catch (SQLException e) {
            System.out.println("erreur lors de l'exxecution de la requete d'ajout d'un SosDisparition\n");
            System.out.println(e.getMessage());
                                     }
        return 0;
    }

    
 //***************************************************************************************************************
 //                                        SUPPRIMER SosDisparition
 //***************************************************************************************************************
    public void supprimer (int id){
      try {
            stmt = conn.createStatement();
          } catch (SQLException ex) {
                System.out.println("erreur lors de la creation du statment \n");
                System.out.println(ex.getMessage());
                                    }
            
        String sql = "DELETE FROM `sos_disparition` WHERE id_sos_disparition="+id;
        
        try {
            stmt.executeUpdate(sql);
            System.out.println(" supp est effectue");

            } catch (SQLException e) {
            System.out.println("erreur lors de l'exxecution de la requete d'ajout d'un SosDisparition\n");
            System.out.println(e.getMessage());
                                     }
    }
  
    
 

    
    
 //***************************************************************************************************************
 //                                     SELECT ALL
 //***************************************************************************************************************
       public  ArrayList<sosDisparition> selectAll(){
 
             ArrayList<sosDisparition> sos = new ArrayList<>();
             PreparedStatement  pr;
             
              try {
                       pr = conn.prepareStatement("SELECT * FROM sos_disparition");
                       ResultSet res =pr.executeQuery();
                 while (res.next()){
                       sosDisparition a = new sosDisparition();
    
                       a.setIdSosDisparition(res.getInt("id_sos_disparition"));
                       a.setNom(res.getString("nom"));
                       a.setNum_tel(res.getInt("num_tel"));
                       a.setDescription(res.getString("description"));
                       a.setEmail(res.getString("email"));
                       a.setAdresse(res.getString("adresse"));
                       sos.add(a);
                    }                  
                } catch (SQLException ex) {
                       Logger.getLogger(sosDisparition.class.getName()).log(Level.SEVERE, null, ex);
                    }
              return sos;
 
                    }
        }
