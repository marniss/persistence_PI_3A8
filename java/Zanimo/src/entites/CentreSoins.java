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
 * @author mossab
 */
public class CentreSoins {
    private int id;
    private String nom;
    private String type;
    private String adresse;
    private int numero;
    private double note;
    private double somenote;
    private int nbrenote;
    private double longtitude;
    private double laltitude;
//constructeur non parametré
    public CentreSoins() {
    }

//*************
//constructeur parametré sans id
    public CentreSoins(String nom, String type, String adresse, int numero, double note) {
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.numero = numero;
        this.note = note;
    }

//*************
//constructeur parametré avec id
    public CentreSoins(int id, String nom, String type, String adresse, int numero, double note) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.numero = numero;
        this.note = note;
    }

//*************
//connection a la base et preparation d'un statement
     Connection conn = DataSource.getInstance().getConnection();
    private Statement stmt;

//*************
//ajouter dans la base
 public int ajouter() {
        try {
            stmt = conn.createStatement();
            } catch (SQLException ex) {
               
                System.out.println("erreur lors de la creation du statment \n");
                System.out.println(ex.getMessage());
                                      }

        String sql = "INSERT INTO `centre_de_soin`("
                + "`nom`, "
                + "`type`, "
                + "`adresse`, "
                + "`numero` ,"
                + "`note`,"
                + "`visible`) "
                + " VALUES ( '" + this.nom + "','" + this.type + "','" + this.adresse + "','" + this.numero + "',"+ this.note+ ",1);";

     
        try {
            stmt.executeUpdate(sql);
            System.out.println(" l'ajout est effectue");
            return 1;
             } catch (SQLException e) {
                  System.out.println("erreur lors de l'exxecution de la requete d'ajout d'un Centre de Dressage \n");
                  System.out.println(e.getMessage());

                                      }
        return 0;

    }
//*************
//supprimer de la base
public void supprimer(int id)
  {
      try {
            stmt = conn.createStatement();
          } catch (SQLException ex) {
                System.out.println("erreur lors de la creation du statment \n");
                System.out.println(ex.getMessage());
                                    }
            
        String sql = "UPDATE `centre_de_soin` SET `visible`=0 WHERE id_centre="+id;
        
        try {
            stmt.executeUpdate(sql);
            System.out.println(" Suppression est effectue");

            } catch (SQLException e) {
            System.out.println("erreur lors de l'exxecution de la requete d'ajout d'un Centre de Soins\n");
            System.out.println(e.getMessage());
                                     }
  }
//*************
 //select all
 public  ArrayList<CentreSoins> selectAll(){
         
            ArrayList<CentreSoins> CS = new ArrayList<>();
            PreparedStatement  pr;
            
                  try {
                         pr = conn.prepareStatement("SELECT * FROM centre_de_soin where visible=1");
                         ResultSet res =pr.executeQuery();
                         while (res.next()){
                            CentreSoins centre = new CentreSoins();
                            centre.setId(res.getInt("id_centre"));
                            centre.setNom(res.getString("nom"));
                            centre.setType(res.getString("type"));
                            centre.setAdresse(res.getString("adresse"));
                            centre.setNumero(res.getInt("numero"));
                            centre.setNote(res.getDouble("note"));
                            CS.add(centre);
                   }
                      } catch (SQLException ex) {
                                                     Logger.getLogger(CentreSoins.class.getName()).log(Level.SEVERE, null, ex);
                                                }
   
   
                        return CS;
 
           }
 //************
 //recherche
 public  ArrayList<CentreSoins> selectAll(String word){
         
            ArrayList<CentreSoins> CS = new ArrayList<>();
            PreparedStatement  pr;
            
                  try {
                         pr = conn.prepareStatement("SELECT * FROM centre_de_soin  where visible=1 AND ( `nom`LIKE'%"+word+"%' OR `adresse`LIKE'%"+word+"%' OR `type`LIKE'%"+word+"%' )"); /*OR `note`="+Integer.parseInt(word)+" OR `numero`="+Integer.parseInt(word)*/
                         ResultSet res =pr.executeQuery();
                         while (res.next()){
                              CentreSoins centre = new CentreSoins();
                            centre.setId(res.getInt("id_centre"));
                            centre.setNom(res.getString("nom"));
                            centre.setType(res.getString("type"));
                            centre.setAdresse(res.getString("adresse"));
                            centre.setNumero(res.getInt("numero"));
                            centre.setNote(res.getDouble("note"));
                            CS.add(centre);
                   }
                      } catch (SQLException ex) {
                                                     Logger.getLogger(CentreDressage.class.getName()).log(Level.SEVERE, null, ex);
                                                }
   
   
                        return CS;
 
           }
//modifier dans la base
 public int modifier() {
        try {
            stmt = conn.createStatement();
            } catch (SQLException ex) {
                   System.out.println("erreur lors de la creation du statment \n");
                   System.out.println(ex.getMessage());
                                      }
        
        String maRequette = "UPDATE `centre_de_soin` SET "
                + "`nom`='" + this.nom + "',"
                + "`type`='" + this.type + "',"
                + "`adresse`='" + this.adresse + "',"
                + "`numero`='" + this.numero + "',"
                +"`note`='"+ this.note+"' "
                + "WHERE `id_centre`= "+this.id
                + ";";

        try {
            stmt.executeUpdate(maRequette);
            System.out.println(" la modification est effectuer");
            return 1;
            } catch (SQLException e) {
                   System.out.println("erreur lors de l'exxecution de la requete de la modification \n");
                   System.out.println(e.getMessage());

                                     }
        return 0;
    }
//*************
//tout les setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNote(double note) {
        this.note = note;
    }
    
//*************************
//tout les getters
    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getNumero() {
        return numero;
    }

    public double getNote() {
        return note;
    }

    public int getId() {
        return id;
    }
    
}

//*************************