/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import singleton.DataSource;
import entites.animal;

/**
 *
 * @author houssem
 */
public class animalService {
    private Statement ste ;
    Connection conn = DataSource.getInstance().getConnection();
   
    
    public animalService()
    {
         try {
            ste = conn.createStatement();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
     public void  ajouterAnimal(animal a) throws SQLException{
        String req = "insert into membre(nom,type,race,date_m,id_m , id_f_dressage,id_f_soin)values('"+a.getNom()+"','"+a.getType()+ "',"+a.getRace()+",'"+a.getDate_n()+"',"+a.getId_m()+","+a.getId_f_dressage()+","+a.getId_f_soin()+ ") ";
    
    ste.executeUpdate(req);
       
    }
    public  void  supprimerAnimal(int id) throws SQLException{
            
String req ="delete from animal where id_m="+id;    
    ste.executeUpdate(req);
    }
    public  void  modifierAnimal(int id ,animal m) throws SQLException{
            
String req ="UPDATE table SET nom = '"+m.getNom()+"',type='"+m.getType()+"',race='"+m.getRace()+"',date_m='"+m.getDate_n()+"',id_m='"+m.getId_m()+"',id_f_dressage="+m.getId_f_dressage()+",id_f_soin="+m.getId_f_soin()+" WHERE id_m="+id;    
    ste.executeUpdate(req);
    }
    
}
