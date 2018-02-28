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
import java.util.logging.Level;
import java.util.logging.Logger;
import services.*;

/**
 *
 * @author Ahmed
 */
public class Accessoire extends Produit {
    //les attributs

    private Categorie categorieAccessoire;

    // getters
    public Categorie getCategorieAccessoire() {
        return categorieAccessoire;
    }

    public String getNomCategorieAccessoire() {
        return categorieAccessoire.getNom();
    }

    //setters
    public void setCategorieAccessoire(Categorie categorieAccessoire) {
        this.categorieAccessoire = categorieAccessoire;
    }

    // constructeurs
    /**
     * 1*
     */
    public Accessoire() {
        this.categorieAccessoire = new Categorie();
    }

    /**
     * 2*
     */
    public Accessoire(int idAccessoire, String nomAccessoire, String descriptionAccessoire, float prixAccessoire, int qteStockAccessoire, String typeAccessoire, String photoAccessoire, int validitePublicationAccessoire, int etatAccessoire, Categorie categorieAccessoire, int IdMembre) {
        super(idAccessoire, nomAccessoire, descriptionAccessoire, prixAccessoire, qteStockAccessoire, typeAccessoire, photoAccessoire, validitePublicationAccessoire, etatAccessoire, IdMembre);
        this.categorieAccessoire = categorieAccessoire;
    }

    public Accessoire(String nomAccessoire, String descriptionAccessoire, float prixAccessoire, int qteStockAccessoire, String typeAccessoire, String photoAccessoire, int validitePublicationAccessoire, Categorie categorieAccessoire, int IdMembre) {
        super(nomAccessoire, descriptionAccessoire, prixAccessoire, qteStockAccessoire, typeAccessoire, photoAccessoire, validitePublicationAccessoire, IdMembre);
        this.categorieAccessoire = categorieAccessoire;
    }

    /**
     * 3*
     */
    public Accessoire(int id, String nom, String description, float prix, int quan, String type, int vali) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.qteStock = quan;
        this.type = type;
        this.prix = prix;
        this.validitePublication = vali;
    }

    /**
     * 4*
     */
    public Accessoire(int id) {
        this.id = id;
    }

    //nos methodes
    // les attributs relatifs au methodes CRUD
    Connection conn = DataSource.getInstance().getConnection();
    private Statement stmt;

    /**
     * l'ajout*
     */
    public int ajouterAccessoire() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("Class Accessoire  erreur  statment \n");
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
                + this.nom + "','"
                + this.description + "',"
                + (int) this.prix + ","
                + this.qteStock + ",'"
                + this.type + "','"
                + this.photo + "','"
                + new SimpleDateFormat("dd/MM/yyyy").format(this.datePublication) + "',"
                + this.validitePublication + ","
                + 1 + ","
                + this.categorieAccessoire.getIdCategorie() + ","
                + this.IdMembre
                + ");";
        // execution de la requette
        try {
            stmt.executeUpdate(maRequette);
            return 1;
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'exxecution de la requete d'ajout d'un accessoire \n");
            System.out.println(ex.getMessage());

        }
        return 0;

    }

    //supprission d'un acc
    public int supprimerAccessoire() {
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
    public int modifierAccessoi() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }

        // preparation de la requette
        String maRequette = "UPDATE `accessoire` SET "
                + "`Nom_Accessoire`= '" + this.nom + "' ,"
                + "`Description_Accessoire`='" + this.description + "',"
                + "`Prix_Accessoire`= " + this.prix + ","
                + "`Qte_Stock_Accessoire`= '" + this.qteStock + "' ,"
                + "`Type_Accessoire`='" + this.type + "'"
                + " WHERE Id_Accessoire = " + this.id
                + ";";

        // execution de la requette
        try {
            stmt.executeUpdate(maRequette);
            return 1;
        } catch (SQLException ex) {
            System.out.println("Classe Accessoir erreur req modifiation");
            System.out.println(ex.getMessage());

        }
        return 0;
    }

    //methode consultation
    public Accessoire getAccessoire(int id) {
        Accessoire leResultat = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM Accessoire WHERE Id_Accessoire = " + id + ";";

        // execution de la requette
        try {
            ResultSet res = stmt.executeQuery(maRequette);
            while (res.next()) {
                leResultat = new Accessoire();
                leResultat.id = res.getInt("Id_Accessoire");
                leResultat.nom = res.getString("Nom_Accessoire");
                leResultat.description = res.getString("Description_Accessoire");
                leResultat.prix = res.getInt("Prix_Accessoire");
                leResultat.qteStock = res.getInt("Qte_Stock_Accessoire");
                leResultat.type = res.getString("Type_Accessoire");
                leResultat.photo = res.getString("Photo_Accessoire");
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    leResultat.datePublication = df.parse(res.getString("Date_Publication_Accessoire"));
                } catch (ParseException ex) {
                    System.out.println("eror dans la covertion du type date Class Accessoire " + ex.getMessage());
                }
                leResultat.validitePublication = res.getInt("Validite_Publication_Accessoire");
                Categorie x = new Categorie(res.getInt("Etat_Accessoire"));
                leResultat.categorieAccessoire = x.getCategorieViaId();
                leResultat.IdMembre = res.getInt("Id_Membre");

            }

        } catch (SQLException ex) {
            System.out.println("Class Accessoire execution getaccessoire \n");
            System.out.println(ex.getMessage());

        }

        return leResultat;
    }

    public ArrayList<Accessoire> listingAccessoire() {
        ArrayList<Accessoire> laListe = new ArrayList<>();
        Accessoire leResultat;

        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM `accessoire` WHERE Etat_Accessoire = 1 ;";

        // execution de la requette
        try {
            DateFormat format;
            ResultSet res = stmt.executeQuery(maRequette);
            while (res.next()) {
                //recuperation des champs
                leResultat = new Accessoire();
                leResultat.id = res.getInt("Id_Accessoire");
                leResultat.nom = res.getString("Nom_Accessoire");
                leResultat.description = res.getString("Description_Accessoire");
                leResultat.prix = res.getInt("Prix_Accessoire");
                leResultat.qteStock = res.getInt("Qte_Stock_Accessoire");
                leResultat.type = res.getString("Type_Accessoire");
                leResultat.photo = res.getString("Photo_Accessoire");
                //format = new SimpleDateFormat("dd/MM/yyyy");
                format = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    leResultat.datePublication = format.parse(res.getString("Date_Publication_Accessoire"));
                } catch (ParseException ex) {
                    Logger.getLogger(Accessoire.class.getName()).log(Level.SEVERE, null, ex);
                }
                leResultat.validitePublication = res.getInt("Validite_Publication_Accessoire");
                leResultat.etat = res.getInt("Etat_Accessoire");
                leResultat.categorieAccessoire.setIdCategorie(res.getInt("categorie_Accessoire"));
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
