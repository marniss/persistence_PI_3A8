/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.CentreDressage;
import java.util.ArrayList;

/**
 *
 * @author mossa
 */
public class ListCDControler {
     private CentreDressage cd;
    //selectall pour l'affichage
    public ArrayList<CentreDressage> selectAll()
    {cd=new CentreDressage();
        return cd.selectAll();
    }
     //selectall pour la recherche
    public ArrayList<CentreDressage> selectAll(String word)
    {cd=new CentreDressage();
        return cd.selectAll(word);
    }
}
