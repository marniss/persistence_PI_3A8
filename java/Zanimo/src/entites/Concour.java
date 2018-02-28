package entites;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.DataSource;

/**
 *
 * @author angham
 */
public class Concour {

    private int idConcour;
    private String titreConcour;
    private String typeConcour;
    private String race;
    private Date dateDebut;
    private Date dateFin;
    private int etat;
    private String lieu;
    private int capacite;
    private int nbparticipant;

    private String nomConcourStat;
    private float Pourcentagestats;

    // les constructeuur
    public Concour(int idConcour, String titreConcour, String typeConcour, String race, String lieu, int capacite) {
        this.idConcour = idConcour;
        this.titreConcour = titreConcour;
        this.typeConcour = typeConcour;
        this.race = race;
        this.lieu = lieu;
        this.capacite = capacite;
    }

    /**
     * constructeur af
     */
    public Concour(int id, String a, String b, String c) {
        this.idConcour = id;
        this.typeConcour = a;
        this.race = b;
        this.titreConcour = c;
    }

    public Concour(String titreConcour, String typeConcour, String race, Date dateDebut, Date dateFin, int etat, String lieu, int capacite, int nbparticipant) {
        this.titreConcour = titreConcour;
        this.typeConcour = typeConcour;
        this.race = race;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.etat = etat;
        this.lieu = lieu;
        this.capacite = capacite;
        this.nbparticipant = nbparticipant;
    }

    public Concour() {

    }

    public Concour(int idConcour, String text, String text0, String text1, String text2, String text3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdConcour() {
        return idConcour;
    }

    public void setIdConcour(int idConcour) {
        this.idConcour = idConcour;

    }

    public String getTitreConcour() {
        return titreConcour;
    }

    public void setTitreConcour(String titre) {
        this.titreConcour = titre;
    }

    public String getNomConcourStat() {
        return nomConcourStat;
    }

    public void setNomConcourStat(String nomConcourStat) {
        this.nomConcourStat = nomConcourStat;
    }

    public float getPourcentagestats() {
        return Pourcentagestats;
    }

    public void setPourcentagestats(float Pourcentagestats) {
        this.Pourcentagestats = Pourcentagestats;
    }

    public String getTypeConcour() {
        return typeConcour;
    }

    public void setTypeConcour(String typeConcour) {
        this.typeConcour = typeConcour;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getNbparticipant() {
        return nbparticipant;
    }

    public void setNbparticipant(int nbparticipant) {
        this.nbparticipant = nbparticipant;
    }

    @Override
    public String toString() {
        return "Concour{" + "id=" + idConcour + "," + "titreConcour=" + titreConcour + ", type=" + typeConcour + ", race=" + race + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + '}';
    }

    //la methode ajouter:
    Connection conn = DataSource.getInstance().getConnection();
    private Statement stmt;

    public int ajouterConcour() {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }

        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String date = formater.format(this.dateDebut);
        String datef = formater.format(this.dateFin);
        // preparation de la requette
        String maRequette = "INSERT INTO concour("
                + "typeConcour, "
                + "titreConcour, "
                + "race, "
                + "dateDebut,"
                + "dateFin,"
                + "capacite,"
                + "lieu,"
                + "nbparticipant"
                + ") "
                + "VALUES ( '"
                + this.typeConcour + "','"
                + this.titreConcour + "','"
                + this.race + "','"
                + date + "','"
                + datef + "',"
                + capacite + ",'"
                + lieu + "',"
                + nbparticipant + ")";
        System.out.println(maRequette);

        // execution de la requette
        try {
            stmt.executeUpdate(maRequette);
            System.out.println(" l'ajout est effectue");
            return 1;
        } catch (SQLException xxxx) {
            System.out.println("erreur lors de l'exxecution de la requete d'ajout d'un councours \n");
            System.out.println(xxxx.getMessage());

        }
        return 0;

    }

    //la methode modifier
    public int modifierConcour() {

        System.out.println("Modeeel");
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette
                = "UPDATE `concour` SET `typeConcour`='" + this.typeConcour + "',`race`='" + this.race + "',`titreConcour`='" + this.titreConcour + "',`capacite`=" + this.capacite + ",`lieu`='" + this.lieu + "' WHERE `idConcour`=" + this.idConcour + ";";
        try {
            stmt.executeUpdate(maRequette);
            System.out.println(" la modification est effectuee");
            return 1;
        } catch (SQLException xxxx) {
            System.out.println("erreur lors de l'exxecution de la requete de la modification \n");
            System.out.println(xxxx.getMessage());

        }
        return 0;
    }

    //la methode supprimer
    public int supprimerConcour(int id) {
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "DELETE FROM `concour` WHERE idConcour=" + id;

        // execution de la requette
        try {
            stmt.executeUpdate(maRequette);
            System.out.println(" la supp est effectue");
            return 1;
        } catch (SQLException xxxx) {
            System.out.println("erreur lors de l'execution de la requete de la supprission \n");
            System.out.println(xxxx.getMessage());

        }
        return 0;

    }

    //methode consultation
    public Concour getConcour(int id) throws SQLException {
        Concour leResultat = new Concour();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM Concour WHERE idConcour = " + idConcour + ";";

        // execution de la requette
        try {
            ResultSet res = stmt.executeQuery(maRequette);
            System.out.println(" la recuperation des donnees est effectue");
            while (res.next()) {
                leResultat.idConcour = res.getInt(1);
                leResultat.titreConcour = res.getString(2);
                leResultat.typeConcour = res.getString(3);
                leResultat.race = res.getString(4);
                leResultat.dateDebut = res.getDate(5);
                leResultat.dateFin = res.getDate(6);
                leResultat.capacite = res.getInt(7);
                leResultat.lieu = res.getString(8);
                leResultat.nbparticipant = res.getInt(9);

            }

        } catch (SQLException aaaaa) {
            System.out.println("erreur lors de l'exxecution de la requete de l'affichage \n");
            System.out.println(aaaaa.getMessage());

        }

        return leResultat;
    }

    public Concour getConcour2(int id) throws SQLException {
        Concour leResultat = new Concour();
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT * FROM Concour WHERE idConcour = " + id + ";";

        // execution de la requette
        try {
            ResultSet res = stmt.executeQuery(maRequette);
            System.out.println(" la recuperation des donnees est effectue");
            while (res.next()) {
                leResultat.idConcour = res.getInt("idConcour");
                leResultat.titreConcour = res.getString("titreConcour");
                leResultat.typeConcour = res.getString("typeConcour");
                leResultat.race = res.getString("race");
                leResultat.dateDebut = res.getDate("dateDebut");
                leResultat.dateFin = res.getDate("dateFin");
                leResultat.capacite = res.getInt("capacite");
                leResultat.lieu = res.getString("lieu");
                leResultat.nbparticipant = res.getInt("nbparticipant");

            }

        } catch (SQLException aaaaa) {
            System.out.println("erreur lors de l'exxecution de la requete de l'affichage \n");
            System.out.println(aaaaa.getMessage());

        }

        return leResultat;
    }

    public ArrayList<Concour> selectAll() {
        ArrayList<Concour> le = new ArrayList();
        try {
            PreparedStatement st = conn.prepareStatement(
                    "SELECT * FROM `concour`");
            ResultSet res = st.executeQuery();
            while (res.next()) {
                Concour concour = new Concour();
                concour.setIdConcour(res.getInt("idConcour"));
                concour.setTypeConcour(res.getString("typeConcour"));
                concour.setRace(res.getString("race"));
                concour.setDateDebut(res.getDate("dateDebut"));
                concour.setDateFin(res.getDate("dateFin"));
                concour.setTitreConcour(res.getString("titreConcour"));
                concour.setCapacite(res.getInt("capacite"));
                concour.setLieu(res.getString("lieu"));
                concour.setNbparticipant(res.getInt("nbparticipant"));

                le.add(concour);
            }
            return le;
        } catch (SQLException ex) {
            System.out.println("ereuur dans l'aafichage");
            return null;
        }
    }

    public void incrementParticpant(String str) {
        Concour leResultat = new Concour();
        try {
            stmt = conn.createStatement();

            // preparation de la requette
            String maRequette = "SELECT * FROM Concour WHERE typeConcour like '" + str + "' ;";

            ResultSet res = stmt.executeQuery(maRequette);
            System.out.println(" nb participation la recuperation des donnees est effectue");
            while (res.next()) {
                leResultat.idConcour = res.getInt("idConcour");
                leResultat.nbparticipant = res.getInt("nbparticipant");
            }
            int newnb = leResultat.getNbparticipant() + 1;
            maRequette = "UPDATE `concour` SET "
                    + "`nbparticipant`= " + newnb
                    + " WHERE idConcour = " + leResultat.getIdConcour();
            stmt.executeUpdate(maRequette);
        } catch (SQLException aaaaa) {
            System.out.println("erreur lors de l'exxecution de la requete de l'affichage \n");
            System.out.println(aaaaa.getMessage());

        }
    }

    // select titreConcour, (nbparticipant*100)/capacite from concour where (CURRENT_DATE-dateDebut)>365
    public List<Concour> selectStatistiques() {
        List<Concour> le = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(
                    "select titreConcour, (nbparticipant*100)/capacite from concour where (CURRENT_DATE-dateDebut)<365");
            ResultSet res = st.executeQuery();
            while (res.next()) {
                Concour concour = new Concour();
                concour.setNomConcourStat(res.getString(1));
                concour.setPourcentagestats(res.getFloat(2));

                le.add(concour);
            }
            //return le;
        } catch (SQLException ex) {
            System.out.println("ereuur dans l'aafichage");

        }
        return le;
    }
}
