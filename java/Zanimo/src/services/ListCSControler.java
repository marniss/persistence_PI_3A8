/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.CentreSoins;
import java.util.ArrayList;

/**
 *
 * @author mossa
 */
public class ListCSControler {

    private CentreSoins cs;
    //selectall pour l'affichage
    public ArrayList<CentreSoins> selectAll()
    {cs=new CentreSoins();
        return cs.selectAll();
    }
     //selectall pour la recherche
    public ArrayList<CentreSoins> selectAll(String word)
    {cs=new CentreSoins();
        return cs.selectAll(word);
    }
}
