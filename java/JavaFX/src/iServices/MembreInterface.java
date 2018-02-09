/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iServices;

import entites.Membre;
import java.sql.SQLException;



/**
 *
 * @author houssem
 */
public interface MembreInterface {
    
    
   public void ajouterMembre(Membre m)throws SQLException ;
   
   
   public void supprimerMembre(int id)throws SQLException ;
   
   
   public void modifierMembre(int id, Membre m)throws SQLException ;

    
}
