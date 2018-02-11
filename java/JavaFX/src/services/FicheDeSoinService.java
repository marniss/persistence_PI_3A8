/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.FicheDeSoin;
import iServices.FicheDeSoinInterface;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author makni
 */
public class FicheDeSoinService implements FicheDeSoinInterface {

    DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    private Statement ste;
    Connection conn = DataSource.getInstance().getConnection();
    private PreparedStatement ps;

    public FicheDeSoinService() {
        try {
            ste = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("Erreur de Creation De Statement");
        }
    }

    @Override
    public void ajouterFicheDeSoin(FicheDeSoin ficheDeSoin) {
        //String req = "INSERT INTO `f_soin` (`id_membre`, `nom`, `espece`, `poids`, `datePoids`, `neLe`, `genre`, `observation`, `photo`, `medicament`, `proprietaire`, `prochainRDV`) VALUES ('" + ficheDeSoin.getId_membre() + "', '" + ficheDeSoin.getNom() + "', '" + ficheDeSoin.getEspece() + "', '" + ficheDeSoin.getPoids() + "', '" + ficheDeSoin.getDatePoids() + "', '" + ficheDeSoin.getNeLe() + "', '" + ficheDeSoin.getGenre() + "', '" + ficheDeSoin.getObservation() + "', '" + ficheDeSoin.getPhoto() + "', '" + ficheDeSoin.getMedicament() + "', '" + ficheDeSoin.getProprietaire() + "', '" + ficheDeSoin.getProchainRDV() + "');";
        /* String req2 = "INSERT INTO `f_soin` (`id_membre`, `nom`) VALUES ('" + ficheDeSoin.getId_membre() + " ','" + ficheDeSoin.getNom() + "')";
        try {
            ste.executeUpdate(req2);
        } catch (SQLException ex) {
            Logger.getLogger(FicheDeSoinService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur Requette");
        }
         */

        String req1 = "INSERT INTO `f_soin` (`id_membre`, `nom`, `espece`, `poids`, `datePoids`, `neLe`, `genre`, `observation`, `photo`, `medicament`, `proprietaire`, `prochainRDV`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            ps = conn.prepareStatement(req1);
            ps.setInt(1, ficheDeSoin.getId_membre());
            ps.setString(2, ficheDeSoin.getNom());
            ps.setString(3, ficheDeSoin.getEspece());
            ps.setFloat(4, ficheDeSoin.getPoids());
            ps.setString(5, ficheDeSoin.getDatePoids());
            ps.setString(6, ficheDeSoin.getNeLe());
            ps.setString(7, ficheDeSoin.getGenre());
            ps.setString(8, ficheDeSoin.getObservation());
            ps.setString(9, ficheDeSoin.getPhoto());
            ps.setString(10, ficheDeSoin.getMedicament());
            ps.setString(11, ficheDeSoin.getProprietaire());
            ps.setString(12, ficheDeSoin.getProchainRDV());

            ps.execute();

            System.out.println("Insertion Ok");
        } catch (SQLException ex) {
            Logger.getLogger(FicheDeSoinService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void modifierFicheDeSoin(FicheDeSoin ficheDeSoin) {

        String req = "update  f_soin SET id_membre=?,nom=?,espece=?,poids=?,datePoids=?,neLe=?,genre=?,observation=?,photo=?,medicament=?,proprietaire=?,prochainRDV=? Where id_f_soin =? ";

        try {
            ps = conn.prepareStatement(req);
            ps.setInt(1, ficheDeSoin.getId_membre());
            ps.setString(2, ficheDeSoin.getNom());
            ps.setString(3, ficheDeSoin.getEspece());
            ps.setFloat(4, ficheDeSoin.getPoids());
            ps.setString(5, ficheDeSoin.getDatePoids());
            ps.setString(6, ficheDeSoin.getNeLe());
            ps.setString(7, ficheDeSoin.getGenre());
            ps.setString(8, ficheDeSoin.getObservation());
            ps.setString(9, ficheDeSoin.getPhoto());
            ps.setString(10, ficheDeSoin.getMedicament());
            ps.setString(11, ficheDeSoin.getProprietaire());
            ps.setString(12, ficheDeSoin.getProchainRDV());
            ps.setInt(13, ficheDeSoin.getId_f_Soin());
            ps.execute();
            System.out.println("Modifier Ok");
        } catch (SQLException ex) {
            Logger.getLogger(FicheDeSoinService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Non Update");
        }
    }

    @Override
    public boolean rechercheFicheDeSoin(int id_f_Soin) {

        FicheDeSoin ficheDeSoin = new FicheDeSoin();
        int id = ficheDeSoin.getId_f_Soin();
        String req = "select *  f_soin Where id_f_Soin=?";

        try {
            ps = conn.prepareStatement(req);
            ps.setInt(1, ficheDeSoin.getId_f_Soin());
        } catch (SQLException ex) {
            Logger.getLogger(FicheDeSoinService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public List<FicheDeSoin> displayFicheDeSoin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
