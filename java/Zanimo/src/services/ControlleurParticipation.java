/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Animal;
import entites.Participation;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author houssem
 */
public class ControlleurParticipation {

    public int ajouterParticipation(int idAnimal, int idconcour) {
        Participation p = new Participation(idAnimal, idconcour);
        return p.ajouterParticipation();

    }

    public int supprimerParticipation(Participation a) {
        return a.supprimerParticipation();

    }

    public int modifierParticipation(Participation m1, int x) {
        return m1.modifierParticipation(x);
    }

    public Participation getParticipation(int m) throws SQLException {
        Participation x = new Participation();
        return x.getParticipation(m);
    }

    public ArrayList<Participation> selectAll() {
        Participation x = new Participation();
        return x.selectAll();
    }

    /* ********************** Angham le 25-02-2017**************************** */
    public static ArrayList<Participation> getList() {
        Participation tempParticipation = new Participation();
        return tempParticipation.getList();
    }

    public static Animal getAnimal(int id) {
        Animal x = new Animal();
        return x.getAnimal(id);
    }

    public static Animal getAnimalviaid(int id) {
        Animal x = new Animal();
        return x.getAnimal(id);
    }

    public void confirm(int id) {
        Participation temp = new Participation();
        temp.confirm(id);
    }

    public void rejeter(int id) {
        Participation temp = new Participation();
        temp.rejeter(id);
    }
}
