/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.DataSource;
import java.util.List;
import services.FicheDeSoinService;
import ientites.ificheDeSoinInterface;

/**
 *
 * @author makni
 */
public class FicheDeSoin implements ificheDeSoinInterface {

    private int id_f_Soin;
    private int id_membre;
    private String nom;
    private String espece;
    private float poids;
    private String datePoids;
    private String neLe;
    private String genre;
    private String observation;

    private String photo;
    private String medicament;
    private String proprietaire;
    private String prochainRDV;

    private Statement ste;
    Connection conn = DataSource.getInstance().getConnection();
    private PreparedStatement ps;

    public FicheDeSoin() {
        try {
            ste = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(FicheDeSoin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FicheDeSoin(int id_membre, String nom, String espece, float poids, String datePoids, String neLe, String genre, String observation, String photo, String medicament, String proprietaire, String prochainRDV) {

        this.id_membre = id_membre;
        this.nom = nom;
        this.espece = espece;
        this.poids = poids;
        this.datePoids = datePoids;
        this.neLe = neLe;
        this.genre = genre;
        this.observation = observation;
        this.photo = photo;
        this.medicament = medicament;
        this.proprietaire = proprietaire;
        this.prochainRDV = prochainRDV;
        try {
            ste = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(FicheDeSoin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return "FicheDeSoin{" + "id_f_Soin=" + id_f_Soin + ", id_membre=" + id_membre + ", nom=" + nom + ", espece=" + espece + ", poids=" + poids + ", datePoids=" + datePoids + ", neLe=" + neLe + ", genre=" + genre + ", observation=" + observation + ", photo=" + photo + ", medicament=" + medicament + ", proprietaire=" + proprietaire + ", prochainRDV=" + prochainRDV + '}';
    }

    public int getId_f_Soin() {
        return id_f_Soin;
    }

    public void setId_f_Soin(int id_f_Soin) {
        this.id_f_Soin = id_f_Soin;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public String getDatePoids() {
        return datePoids;
    }

    public void setDatePoids(String datePoids) {
        this.datePoids = datePoids;
    }

    public String getNeLe() {
        return neLe;
    }

    public void setNeLe(String neLe) {
        this.neLe = neLe;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getProchainRDV() {
        return prochainRDV;
    }

    public void setProchainRDV(String prochainRDV) {
        this.prochainRDV = prochainRDV;
    }

    @Override
    public void ajouterFicheDeSoin() {
        String req1 = "INSERT INTO `f_soin` (`id_membre`, `nom`, `espece`, `poids`, `datePoids`, `neLe`, `genre`, `observation`, `photo`, `medicament`, `proprietaire`, `prochainRDV`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            ps = conn.prepareStatement(req1);
            ps.setInt(1, this.id_membre);
            ps.setString(2, this.nom);
            ps.setString(3, this.espece);
            ps.setFloat(4, this.poids);
            ps.setString(5, this.datePoids);
            ps.setString(6, this.neLe);
            ps.setString(7, this.genre);
            ps.setString(8, this.observation);
            ps.setString(9, this.photo);
            ps.setString(10, this.medicament);
            ps.setString(11, this.proprietaire);
            ps.setString(12, this.prochainRDV);

            ps.execute();

            System.out.println("Insertion Ok");
        } catch (SQLException ex) {
            Logger.getLogger(FicheDeSoinService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierFicheDeSoin() {
        try {
            String req = "update  f_soin SET id_membre=?,nom=?,espece=?,poids=?,datePoids=?,neLe=?,genre=?,observation=?,photo=?,medicament=?,proprietaire=?,prochainRDV=? Where id_f_soin =? ";
            ps = conn.prepareStatement(req);
            ps.setInt(1, this.id_membre);
            ps.setString(2, this.nom);
            ps.setString(3, this.espece);
            ps.setFloat(4, this.poids);
            ps.setString(5, this.datePoids);
            ps.setString(6, this.neLe);
            ps.setString(7, this.genre);
            ps.setString(8, this.observation);
            ps.setString(9, this.photo);
            ps.setString(10, this.medicament);
            ps.setString(11, this.proprietaire);
            ps.setString(12, this.prochainRDV);
            ps.setInt(13, this.id_f_Soin);

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(FicheDeSoin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public FicheDeSoin rechercheFicheDeSoin(int id_f_Soin) {

        String req = "Select *From f_soin where id_f_soin=?";
        try {
            ps = conn.prepareStatement(req);
            ps.setInt(1, this.id_f_Soin);
        } catch (SQLException ex) {
            Logger.getLogger(FicheDeSoin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public List<FicheDeSoin> displayFicheDeSoin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
