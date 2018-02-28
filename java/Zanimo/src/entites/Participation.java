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
 * @author angham
 */
public class Participation {

    private int idParticipation;
    private int idAnimal;
    private int idConcour;
    private int etat;

    public Participation() {
    }

    public Participation(int idAnimal, int idConcour) {
        this.idAnimal = idAnimal;
        this.idConcour = idConcour;

    }

    public int getIdConcour() {
        return idConcour;
    }

    public void setIdConcour(int idConcour) {
        this.idConcour = idConcour;
    }

    public int getIdParticipation() {
        return idParticipation;
    }

    public void setIdParticipation(int idParticipation) {
        this.idParticipation = idParticipation;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    @Override
    public String toString() {
        return "Participation{" + "idParticipation=" + idParticipation + ", idAnimal=" + idAnimal + ", idConcour=" + idConcour + '}';
    }

    //nos methodes
    // les attributs relatifs au methodes CRUD
    Connection conn = DataSource.getInstance().getConnection();
    private Statement stmt;

    public int ajouterParticipation() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }

        String sql = "INSERT INTO `participation`("
                + "`idAnimal`, "
                + "`idConcour`, "
                + "etat"
                + ") "
                + " VALUES ( " + this.idAnimal + "," + this.idConcour + ",0);";

        // execution de la requette
        try {
            stmt.executeUpdate(sql);
            System.out.println(" l'ajout est effectue");
            return 1;
        } catch (SQLException e) {
            System.out.println("erreur lors de l'exxecution de la requete d'ajout d'une Participation \n");
            System.out.println(e.getMessage());

        }
        return 0;

    }

    public Participation getParticipation(int id) throws SQLException {
        Participation leResultat = new Participation();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT `idConcour`, `idAnimal` ,`idParticipation` WHERE idParticipation=" + id + ";";

        // execution de la requette
        try {
            ResultSet res = stmt.executeQuery(maRequette);
            System.out.println(" la recuperation des donnees est effectue");
            while (res.next()) {

                leResultat.idAnimal = res.getInt("idAnimal");
                leResultat.idConcour = res.getInt("idConcour");
                leResultat.idParticipation = res.getInt("idParticipation");

                /*et la suite ***/
            }

        } catch (SQLException angham) {
            System.out.println("erreur lors de l'exxecution de la requete de la getmembre \n");
            System.out.println(angham.getMessage());

        }

        return leResultat;
    }

    public ArrayList<Participation> selectAll() {
        ArrayList<Participation> le = new ArrayList();
        try {
            PreparedStatement st = conn.prepareStatement(
                    "SELECT idParticipation,idAnimal,idConcour"
                    + " FROM participation where etat=1");
            ResultSet res = st.executeQuery();
            while (res.next()) {
                Participation e = new Participation();
                e.setIdAnimal(res.getInt("idAnimal"));
                e.setIdParticipation(res.getInt("idParticipation"));
                e.setIdConcour(res.getInt("idConcour"));

                le.add(e);
            }
            return le;
        } catch (SQLException ex) {
            System.out.println("ereuur dans l'aafichage");
            return null;
        }
    }

    //la methode supprimer
    public int supprimerParticipation() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "UPDATE `participation` "
                + "SET `etat`= 0"
                + " WHERE idParticipation = "
                + this.idParticipation
                + ";";

        // execution de la requette
        try {
            stmt.executeUpdate(maRequette);
            System.out.println(" la suppression est effectuee");
            return 1;
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'exxecution de la requete de la supprission \n");
            System.out.println(ex.getMessage());

        }
        return 0;

    }
    //la methode modifier

    public int modifierParticipation(int id) {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette

        String maRequette = "UPDATE `participation` SET "
                + "`idAnimal`=" + this.idAnimal + ","
                + "`idConcour`= '" + this.idConcour + "'"
                + "WHERE idParticipation = " + id;
        // execution de la requette

        try {
            stmt.executeUpdate(maRequette);
            System.out.println("la modification est ffectuer");
            return 1;
        } catch (SQLException ahmed_makni) {
            System.out.println("erreur lors de l'exxecution de la requete de la modification \n");
            System.out.println(ahmed_makni.getMessage());

        }
        return 0;
    }

    /* ********************** Angham le 25-02-2017**************************** */
    public ArrayList<Participation> getList() {
        ArrayList<Participation> le = new ArrayList();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM participation where etat=0");
            ResultSet res = st.executeQuery();
            while (res.next()) {
                Participation e = new Participation();
                e.setIdAnimal(res.getInt("idAnimal"));
                e.setIdParticipation(res.getInt("idParticipation"));
                e.setIdConcour(res.getInt("idConcour"));
                le.add(e);
            }
            return le;
        } catch (SQLException ex) {
            System.out.println("ereuur dans l'aafichage");
            return null;
        }
    }

    public void confirm(int idd) {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "UPDATE `participation` "
                + "SET `etat`= 1"
                + " WHERE idParticipation = "
                + idd
                + ";";

        // execution de la requette
        try {
            stmt.executeUpdate(maRequette);
        } catch (SQLException a) {
            System.out.println("erreur lors de l'exxecution de la requete");
            System.out.println(a.getMessage());

        }

    }

    public void rejeter(int idd) {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "DELETE FROM `participation` WHERE idParticipation = " + idd;

        // execution de la requette
        try {
            stmt.executeUpdate(maRequette);
        } catch (SQLException a) {
            System.out.println("erreur lors de l'exxecution de la requete");
            System.out.println(a.getMessage());

        }
    }

}
