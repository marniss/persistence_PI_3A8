/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Animal;
import entites.Concour;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author angham
 */
public class ControlleurConcour {

    public int ajouterConcour(String titreConcour, String typeConcour, String race, Date dateDebut, Date dateFin, int etat, String lieu, int capacite, int nbparticipant) {
        Concour concour = new Concour(titreConcour, typeConcour, race, dateDebut, dateFin, etat, lieu, capacite, nbparticipant);
        return concour.ajouterConcour();

    }

    public int supprimerConcour(Concour concour) {
        int id = concour.getIdConcour();
        concour.supprimerConcour(id);
        return 1;
    }

    public Concour getConcour(int m) throws SQLException {
        Concour x = new Concour();
        return x.getConcour(m);
    }

    public Concour getConcour2(int m) throws SQLException {
        Concour x = new Concour();
        return x.getConcour2(m);
    }

    public ArrayList<Concour> selectAll() {
        Concour x = new Concour();

        return x.selectAll();
    }

    public int modifierConcour(int idConcour, String titreConcour, String typeConcour, String race, String lieu, int capacite) {
        System.out.println("Controlleeur");
        Concour temp = new Concour(idConcour, titreConcour, typeConcour, race, lieu, capacite);
        return temp.modifierConcour();
    }

    public ArrayList<Animal> displayAnimal(int idpro) {
        Animal temp = new Animal();
        return temp.selectAllFromMembre(idpro);
    }

    public void incrementParticpant(String str) {
        Concour temp = new Concour();
        temp.incrementParticpant(str);
    }

}
