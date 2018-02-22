/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Participation;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author houssem
 */
public class ControlleurParticipation {
    public int supprimerMembre(Participation a){
        return a.supprimerParticipation();
        
    }
    public int modifierMembre(Participation m1,int x)
    {
      return  m1.modifierParticipation(x);
    }
    
    public Participation getMembre(int m) throws SQLException
    {
        Participation x=new Participation();
        return x.getParticipation(m);
    }
    
    public ArrayList<Participation> selectAll(){
                Participation x=new Participation();
return x.selectAll();
    }
    
}
