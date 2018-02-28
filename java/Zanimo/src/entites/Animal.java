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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.ImageView;
import services.DataSource;

/**
 *
 * @author Angham
 */
public class Animal {

    //Angham
    private int id;
    private String nom;
    private String espece;
    private float poids;
    private Date datePoids;
    private Date neLe;
    private String genre;
    private String photo;
    private int proprietaire;
    private String sexe;
    //private String proprietaire;

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    //Les attributs DB
    Connection conn = DataSource.getInstance().getConnection();
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement stmt;
//

    public Animal(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Animal(int proprietaire) {
        this.proprietaire = proprietaire;
    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public void setEspece(String espece) {
//        this.espece = espece;
//    }
//
//    public void setPoids(float poids) {
//        this.poids = poids;
//    }
//
//    public void setDatePoids(Date datePoids) {
//        this.datePoids = datePoids;
//    }
//
//    public void setNeLe(Date neLe) {
//        this.neLe = neLe;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }
//
//    public void setPhoto(String photo) {
//        this.photo = photo;
//    }
//
//    public void setProprietaire(int proprietaire) {
//        this.proprietaire = proprietaire;
//    }
//

    public String getEspece() {
        return espece;
    }

    public float getPoids() {
        return poids;
    }
//
//    public Date getDatePoids() {
//        return datePoids;
//    }
//
//    public Date getNeLe() {
//        return neLe;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public String getPhoto() {
//        return photo;
//    }
//

    public int getProprietaire() {
        return proprietaire;
    }
//

    public int getId() {
        return id;
    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    public Animal() {
//    }
//
//    @Override
//    public String toString() {
//        return "Animal{" + "id=" + id + ", nom=" + nom + ", espece=" + espece + ", poids=" + poids + ", datePoids=" + datePoids + ", neLe=" + neLe + ", genre=" + genre + ", photo=" + photo + ", proprietaire=" + proprietaire + '}';
//    }
//
//    public Animal getAnimal(int id) {
//        Animal x = new Animal();
//        String req = "Select * From animal where  proprietaire =" + proprietaire + ";";
//        try {
//            ps = conn.prepareStatement(req);
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        try {
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                System.out.println("anghammm, dans classe Animal");
//                x.id = rs.getInt(1);
//                x.nom = rs.getString(5);
//                x.espece = rs.getString(2);
//                x.poids = rs.getFloat(7);
//                x.photo = rs.getString(8);
//                x.genre = rs.getString(5);
//                x.proprietaire = rs.getInt(6);
//                System.out.println(x);
//                System.out.println("animal iddddd model");
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        return x;
//
//    }
//

    public ArrayList<Animal> displayAnimal() {
        ArrayList<Animal> animals = new ArrayList<>();
        String req = "Select id,nom From animal where proprietaire = " + this.proprietaire;
        try {
            ps = conn.prepareStatement(req);
            rs = ps.executeQuery();
            while (rs.next()) {
                Animal fs = new Animal();
                fs.id = rs.getInt(1);
                fs.nom = rs.getString(2);
                animals.add(fs);
            }
            return animals;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erreuuur d'execution req");
        }
        return animals;

    }
//

    public Animal getAnimalviaid(int id) {
        Animal x = new Animal();
        String req = "Select * From animal where  id =" + id + ";";
        try {
            ps = conn.prepareStatement(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                x.id = rs.getInt("id");
                x.nom = rs.getString("nom");
                x.espece = rs.getString("espece");
                x.poids = rs.getFloat("poids");
                x.photo = rs.getString("photo");
                x.genre = rs.getString("genre");
                x.proprietaire = rs.getInt("proprietaire");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return x;

    }

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    /**
     *
     * @author salah
     */
//*************************************************************************************************************
//                                            CLASS Animal
//*************************************************************************************************************
//package entites;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.sql.Date;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.scene.image.ImageView;
//import services.DataSource;
    /**
     *
     * @author salah
     */
//*************************************************************************************************************
//                                            CLASS Animal
//*************************************************************************************************************
//public class Animal {
    public static void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void addAll(ArrayList<Animal> selectAll) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int idAnimal;
    private String type;
    // private String nom;
    private String race;
    private java.sql.Date date_naissance;
    private String description;
    //   private String photo;
    private ImageView image;
    private Double poid;

    public Animal() {
    }

    public Animal(String type, String nom, String race, java.sql.Date date_naissance, String description, Double poid) {

        this.type = type;
        this.nom = nom;
        this.race = race;
        this.date_naissance = date_naissance;
        this.description = description;
        this.poid = poid;
        // this.image = image;
    }

    public Double getPoid() {
        return poid;
    }

    public void setPoid(Double poid) {
        this.poid = poid;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public java.sql.Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(java.sql.Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

//    Connection conn = DataSource.getInstance().getConnection();
//    private Statement stmt;
//*************************************************************************************************************
//                                    AJOUTER Animal
//*************************************************************************************************************
    public int ajouterAnimal() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {

            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }

        String sql = "INSERT INTO `animal`("
                + "type, "
                + "nom ,"
                + "race ,"
                + "date_naissance,"
                + "description ,"
                + "`poid`"
                + ") "
                + " VALUES ( '" + this.type + "','" + this.nom + "','" + this.race + "','" + this.date_naissance + "','" + this.description + "'," + this.poid + ");";

        try {
            stmt.executeUpdate(sql);
            System.out.println(" l'ajout est effectue");
            return 1;
        } catch (SQLException e) {
            System.out.println("erreur lors de l'exxecution de la requete d'ajout d'un animal \n");
            System.out.println(e.getMessage());

        }
        return 0;

    }
//*************************************************************************************************************
//SELECTALL
//*************************************************************************************************************

    public ArrayList<Animal> selectAll() {

        ArrayList<Animal> ani = new ArrayList<>();
        PreparedStatement pr;

        try {
            pr = conn.prepareStatement("SELECT * FROM animal ");
            ResultSet res = pr.executeQuery();
            while (res.next()) {
                Animal animal = new Animal();
                animal.setIdAnimal(res.getInt("id_animal"));
                animal.setType(res.getString("type"));
                animal.setNom(res.getString("nom"));
                animal.setRace(res.getString("race"));
                animal.setDescription(res.getString("description"));
                animal.setDate_naissance(res.getDate("date_naissance"));
                animal.setPoid(res.getDouble("poid"));
                ani.add(animal);

            }
        } catch (SQLException ex) {
            Logger.getLogger(sosDisparition.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ani;

    }

//*************************************************************************************************************
//SUPPRIMER Animal
//*************************************************************************************************************
    public void supprimer(int id) {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }

        String sql = "DELETE FROM `animal` WHERE id_animal=" + id;

        try {
            stmt.executeUpdate(sql);
            System.out.println(" supp est effectue");

        } catch (SQLException e) {
            System.out.println("erreur lors de l'exxecution de la requete d'ajout d'un SosDisparition\n");
            System.out.println(e.getMessage());
        }
    }

//*************************************************************************************************************
//                                            MODIFIER Animal
//*************************************************************************************************************
    public int modifierAnimal() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }

        String maRequette = "UPDATE `animal` SET "
                + "`id_animal`=" + this.idAnimal + ","
                + "`type`=" + this.type + ","
                + "`nom`=" + this.nom + ","
                + "`race`=" + this.race + ","
                + "`date_naissance`=" + this.date_naissance + ","
                + "`description`=" + this.description + ","
                + "`poid`=" + this.poid + ""
                + "WHERE id_animal=" + idAnimal
                + ";";

        try {
            stmt.executeUpdate(maRequette);
            System.out.println(" l'ajout est effectue");
            return 1;
        } catch (SQLException e) {
            System.out.println("erreur lors de l'exxecution de la requete de la supprission \n");
            System.out.println(e.getMessage());

        }
        return 0;
    }

//*************************************************************************************************************
//GET Animal
//*************************************************************************************************************
    public Animal getAnimal(int id) {

        Animal leResultat = new Animal();

        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }

        String maRequette = "SELECT * FROM animal WHERE id_animal = " + id + ";";

        try {
            ResultSet res = stmt.executeQuery(maRequette);
            System.out.println(" la recuperation des donnees est effectue");
            while (res.next()) {
                leResultat.idAnimal = res.getInt(1);

                leResultat.type = res.getString(2);
                leResultat.nom = res.getString(3);
                leResultat.race = res.getString(4);

                leResultat.date_naissance = res.getDate(5);
                leResultat.photo = res.getString(6);
                leResultat.description = res.getString(7);
                leResultat.poid = res.getDouble(8);

            }

        } catch (SQLException e) {
            System.out.println("erreur lors de l'exxecution de la requete de la supprission \n");
            System.out.println(e.getMessage());
        }

        return leResultat;
    }

    public ArrayList<Animal> selectAllhh(int id) {
        ArrayList<Animal> le = new ArrayList();
        try {
            PreparedStatement st = conn.prepareStatement(
                    "SELECT `id_animal`, `race`, `photo`, `sexe`, `nom`, `etat`, `id_membre`"
                    + " FROM `animal` WHERE `etat`=1 "
                    + "AND `id_membre` = " + id);

            ResultSet res = st.executeQuery();
            while (res.next()) {
                Animal e = new Animal();
                e.setIdAnimal(res.getInt(1));
                e.setSexe(res.getString(4));
                e.setRace(res.getString(2));
                e.setPhoto(res.getString(3));
                e.setNom(res.getString(5));

                le.add(e);
            }
            return le;
        } catch (SQLException ex) {
            System.out.println("ereuur dans l'aafichage");
            return null;
        }
    }

}
