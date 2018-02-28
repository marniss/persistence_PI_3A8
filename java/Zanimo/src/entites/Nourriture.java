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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import services.DataSource;

/**
 *
 * @author Ahmed
 */
public class Nourriture extends Produit {

    //les attributs
    Date dateFabricationNourriture;
    Date dateLimiteNourriture;

    // getters + setters
    public Date getDateFabricationNourriture() {
        return dateFabricationNourriture;
    }

    public void setDateFabricationNourriture(Date dateFabricationNourriture) {
        this.dateFabricationNourriture = dateFabricationNourriture;
    }

    public Date getDateLimiteNourriture() {
        return dateLimiteNourriture;
    }

    public void setDateLimiteNourriture(Date dateLimiteNourriture) {
        this.dateLimiteNourriture = dateLimiteNourriture;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    // constructeurs
    /**
     * 1*
     */
    public Nourriture() {
    }

    /**
     * 2*
     */
    public Nourriture(int id, String nom, String description, float prix, int qteStock, String type, String photo, int validitePublication, int etat, Date dateFabricationNourriture, Date dateLimiteNourriture, int IdMembre) {
        super(id, nom, description, prix, qteStock, type, photo, validitePublication, etat, IdMembre);
        this.dateFabricationNourriture = dateFabricationNourriture;
        this.dateLimiteNourriture = dateLimiteNourriture;
    }

    /**
     * 3*
     */
    public Nourriture(int id, String nom, String description, float prix, int quan, String type) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.qteStock = quan;
        this.type = type;
        this.prix = prix;
    }

    /**
     * 4*
     */
    public Nourriture(int id) {
        this.id = id;
    }

    //nos methodes
    // les attributs relatifs au methodes CRUD
    Connection conn = DataSource.getInstance().getConnection();
    private Statement stmt;

    /**
     * l'ajout*
     */
    public int ajouterNourriture() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("Class Nourriture  erreur  statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "INSERT INTO `nourriture`("
                + "`Nom_Nourriture`, "
                + "`Description_Nourriture`, "
                + "`Prix_Nourriture`, "
                + "`Qte_Stock_Nourriture`, "
                + "`Type_Nourriture`, "
                + "`Photo_Nourriture`, "
                + "`Date_Publication_Nourriture`, "
                + "`Validite_Publication_Nourriture`, "
                + "`Etat_Nourriture`, "
                + "`Date_Fabrication_Nourriture`, "
                + "`Date_Limite_Nourriture`, "
                + "`Id_Membre`) "
                + "VALUES ( '"
                + this.nom + "' , '"
                + this.description + "' , "
                + this.prix + " , "
                + this.qteStock + " , '"
                + this.type + "' , '"
                + this.photo + "' , '"
                + new SimpleDateFormat("dd/MM/yyyy").format(this.datePublication) + "' ,"
                + this.validitePublication + ","
                + this.etat + ",'"
                + new SimpleDateFormat("dd/MM/yyyy").format(this.dateFabricationNourriture) + "','"
                + new SimpleDateFormat("dd/MM/yyyy").format(this.dateLimiteNourriture) + "',"
                + this.IdMembre
                + ");";
        // execution de la requette
        try {
            stmt.executeUpdate(maRequette);
            return 1;
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'exxecution de la requete d'ajout d'une nourriture \n");
            System.out.println(ex.getMessage());

        }
        return 0;

    }

    //supprission d'un acc
    public int supprimerNourriture() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "UPDATE `nourriture` "
                + "SET `Etat_Nourriture`= 0"
                + " WHERE Id_Nourriture = "
                + this.id
                + ";";

        // execution de la requette
        try {
            stmt.executeUpdate(maRequette);
            System.out.println(" la suppression est effectue");
            return 1;
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'exxecution de la requete de la supprission \n");
            System.out.println(ex.getMessage());

        }
        return 0;

    }

    //la methode modifier
    public int modifierNourriture() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "UPDATE `nourriture` SET "
                + "`Nom_Nourriture`= '" + this.nom + "' ,"
                + "`Description_Nourriture`='" + this.description + "',"
                + "`Prix_Nourriture`= " + this.prix + ","
                + "`Qte_Stock_Nourriture`= '" + this.qteStock + "' ,"
                + "`Type_Nourriture`='" + this.type + "'"
                + " WHERE Id_Nourriture = " + this.id
                + ";";

        // execution de la requette
        try {
            stmt.executeUpdate(maRequette);
            return 1;
        } catch (SQLException ex) {
            System.out.println("Classe Nourriture erreur req modifiation");
            System.out.println(ex.getMessage());

        }
        System.out.println("7");
        return 0;
    }

    //methode consultation
    public Nourriture getNourriture(int id) {
        Nourriture leResultat = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM nourriture WHERE Id_Nourriture = " + id + ";";

        // execution de la requette
        try {
            ResultSet res = stmt.executeQuery(maRequette);
            while (res.next()) {
                leResultat = new Nourriture();
                leResultat.id = res.getInt("Id_Nourriture");
                leResultat.nom = res.getString("Nom_Nourriture");
                leResultat.description = res.getString("Description_Nourriture");
                leResultat.prix = res.getInt("Prix_Nourriture");
                leResultat.qteStock = res.getInt("Qte_Stock_Nourriture");
                leResultat.type = res.getString("Type_Nourriture");
                leResultat.photo = res.getString("Photo_Nourriture");
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    leResultat.datePublication = df.parse(res.getString("Date_Publication_Nourriture"));
                    leResultat.dateFabricationNourriture = df.parse(res.getString("Date_Fabrication_Nourriture"));
                    leResultat.dateLimiteNourriture = df.parse(res.getString("Date_Limite_Nourriture"));
                } catch (ParseException ex) {
                    System.out.println("eror dans la covertion du type date Class Nourriture " + ex.getMessage());
                }
                leResultat.validitePublication = res.getInt("Validite_Publication_Nourriture");
                leResultat.etat = res.getInt("Etat_Nourriture");
                leResultat.IdMembre = res.getInt("Id_Membre");

            }

        } catch (SQLException ex) {
            System.out.println("Class Nourriture execution getnourriture \n");
            System.out.println(ex.getMessage());

        }

        return leResultat;
    }

    public ArrayList<Nourriture> listingNourriture() {
        ArrayList<Nourriture> laListe = new ArrayList<>();
        Nourriture leResultat;

        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM `nourriture` WHERE Etat_Nourriture = 1 ;";

        // execution de la requette
        try {
            ResultSet res = stmt.executeQuery(maRequette);
            while (res.next()) {
                //recuperation des champs
                leResultat = new Nourriture();
                leResultat.id = res.getInt("Id_Nourriture");
                leResultat.nom = res.getString("Nom_Nourriture");
                leResultat.description = res.getString("Description_Nourriture");
                leResultat.prix = res.getInt("Prix_Nourriture");
                leResultat.qteStock = res.getInt("Qte_Stock_Nourriture");
                leResultat.type = res.getString("Type_Nourriture");
                leResultat.photo = res.getString("Photo_Nourriture");
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    leResultat.datePublication = df.parse(res.getString("Date_Publication_Nourriture"));
                    leResultat.dateFabricationNourriture = df.parse(res.getString("Date_Fabrication_Nourriture"));
                    leResultat.dateLimiteNourriture = df.parse(res.getString("Date_Limite_Nourriture"));
                } catch (ParseException ex) {
                    System.out.println("eror dans la covertion du type date Class Nourriture " + ex.getMessage());
                }

                leResultat.validitePublication = res.getInt("Validite_Publication_Nourriture");
                leResultat.etat = res.getInt("Etat_Nourriture");
                leResultat.IdMembre = res.getInt("Id_Membre");
                //ajout de l'element a la liste
                laListe.add(leResultat);
            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de l'exxecution de la requete de selection\n");
            System.out.println(ex.getMessage());

        }

        return laListe;
    }

}
