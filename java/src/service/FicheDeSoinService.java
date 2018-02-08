/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Iservice.IficheDeSoin;
import entites.ficheDeSoin;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import singleton.DataSource;
import entites.ficheDeSoin;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author makni
 */
public class FicheDeSoinService implements IficheDeSoin {

    private Statement ste;
    Connection conn = DataSource.getInstance().getConnection();

    public FicheDeSoinService() {

        try {
            ste = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(FicheDeSoinService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur creation de Statement");
        }
    }

    @Override
    public void ajouterFicheDeSoin(ficheDeSoin fsDeSoin) {

        String req = "INSERT INTO `fiche_soin`(`description`, `etat`, `medicament`, `id_a`, `id_m`) VALUES ('" + fsDeSoin.getDescription() + "','" + fsDeSoin.getEtat() + "','" + fsDeSoin.getMedicament() + "'," + fsDeSoin.getId_animal() + "," + fsDeSoin.getId_membre() + ")";
        try {
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(FicheDeSoinService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreeur d'ajout ");
        }

    }

    @Override
    public void supprimerFicheDeSoin(ficheDeSoin fsDeSoin) {
    }

    @Override
    public boolean rechercherEnseignant(ficheDeSoin fsDeSoin) {
        return false;

    }

    @Override
    public boolean rechercherFicheDeSoin(int id) {

        return false;

    }

    @Override
    public List<ficheDeSoin> selectFicheDeSoin() {
        List<ficheDeSoin> ficheDeSoins = new ArrayList<>();
        try {

            ResultSet res = ste.executeQuery("select * from fiche_soin");
            while (res.next()) {
                ficheDeSoin u = new ficheDeSoin();
                u.setId_f_soin(res.getInt("id_f_soin"));
                u.setDescription(res.getString("description"));
                ficheDeSoins.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FicheDeSoinService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ficheDeSoins;

    }
}
