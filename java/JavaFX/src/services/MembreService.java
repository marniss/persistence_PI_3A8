/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import entites.Membre;
import iServices.MembreInterface;

/**
 *
 * @author houssem
 */
public class MembreService implements MembreInterface {

    private Statement ste;
    Connection conn = DataSource.getInstance().getConnection();

    public MembreService() {
        try {
            ste = conn.createStatement();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
@Override
    public void ajouterMembre(Membre m) throws SQLException {
        String req = "insert into membre(nom,prenom,age,adresse,sexe, num_tel,type)values('" + m.getNom() + "','" + m.getPrenom() + "'," + m.getAge() + ",'" + m.getAdresse() + "','" + m.getSexe() + "'," + m.getTel() + ",'" + m.getType() + "') ";

        ste.executeUpdate(req);

    }
@Override
    public void supprimerMembre(int id) throws SQLException {

        String req = "delete from membre where id_membre=" + id;
        ste.executeUpdate(req);
    }
@Override
    public void modifierMembre(int id, Membre m) throws SQLException {

        String req = "UPDATE table SET nom = '" + m.getNom() + "',prenom='" + m.getPrenom() + "',age=" + m.getAge() + ",adresse='" + m.getAdresse() + "',sexe='" + m.getSexe() + "',num_tel=" + m.getTel() + ",type=" + m.getPrenom() + " WHERE id_membre=" + id;
        ste.executeUpdate(req);
    }

}
