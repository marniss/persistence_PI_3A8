/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Nourriture;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmed
 */
public class ServiceNourriture {

    //attributs
    //methodes
    public int ajouterNourriture(int id, String nom, String description, String prix, String qteStockparam, String type, String photo, String validitePublication, String datef, String datel, int IdMembre) {
        //manipulation des dates
        //LocalDate localDate = dateli.getValue();
        //Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        //Date date = Date.from(instant);
        float prixn = 0;
        int qteStock = 0;
        int test = 1;
        Date dateAujourdhui = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date datell = null;
        Date dateff = null;

        //nos tests 9345
        if (nom.length() == 0) {
            test = test * 10 + 9;
        }
        try {
            prixn = Float.parseFloat(prix);
        } catch (Exception e) {
            test = test * 10 + 3;
        }
        try {
            qteStock = Integer.parseInt(qteStockparam);
        } catch (Exception e) {
            test = test * 10 + 4;
        }
        if (validitePublication == null) {
            test = test * 10 + 5;
        }
        try {
            dateff = format.parse(datef);
            if (dateff.after(dateAujourdhui)) {
                test = test * 10 + 6;
            }
        } catch (ParseException ex) {
            test = test * 10 + 6;
        }
        try {
            datell = format.parse(datel);
            if (dateAujourdhui.after(datell)) {
                test = test * 10 + 7;
            }
        } catch (ParseException ex) {
            test = test * 10 + 7;
        }
        if (type.length() == 0) {
            test = test * 10 + 8;
        }
        if (test < 10) {
            int valval = getvalid(validitePublication);
            Nourriture temp = new Nourriture(id, nom, description, prixn, qteStock, type, photo, valval, 1, dateff, datell, IdMembre);
            return temp.ajouterNourriture();
        } else {
            return test;
        }
    }

    public ArrayList<Nourriture> listingNourriture() {
        Nourriture temp = new Nourriture();
        return temp.listingNourriture();
    }

    public Nourriture getNourriture(int id) {
        Nourriture temp = new Nourriture();
        return temp.getNourriture(id);
    }

    public int modifierNourriture(int id, String nom, String description, float prix, int quan, String type) {
        Nourriture temp = new Nourriture(id, nom, description, prix, quan, type);
        return temp.modifierNourriture();
    }

    public int supprimerNourriture(int id) {
        Nourriture temp = new Nourriture(id);
        return temp.supprimerNourriture();
    }

    private int getvalid(String x) {
        if (x == "1 semaine") {
            return 1;
        }
        if (x == "1 mois") {
            return 4;
        }
        if (x == "2 mois") {
            return 8;
        }
        return 12;
    }

}
