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
import entites.membre;


/**
 *
 * @author houssem
 */

public class membreService {
    private Statement ste ;
    Connection conn = DataSource.getInstance().getConnection();
   
    public membreService()
    {
        try {
            ste = conn.createStatement();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void  ajouterMembre(membre m) throws SQLException{
        String req = "insert into membre(nom,prenom,age,adresse,sexe, num_tel,type)values('"+m.getNom()+"','"+m.getPrenom()+ "',"+m.getAge()+",'"+m.getAdresse()+"','"+m.getSexe()+"',"+m.getTel()+",'"+m.getType()+ "') ";
    
    ste.executeUpdate(req);
       
    }
    public  void  supprimerMembre(int id) throws SQLException{
            
String req ="delete from membre where id_m="+id;    
    ste.executeUpdate(req);
    }
    public  void  modifierMembre(int id ,membre m) throws SQLException{
            
String req ="UPDATE table SET nom = '"+m.getNom()+"',prenom='"+m.getPrenom()+"',age="+m.getAge()+",adresse='"+m.getAdresse()+"',sexe='"+m.getSexe()+"',num_tel="+m.getTel()+",type="+m.getPrenom()+" WHERE id_m="+id;    
    ste.executeUpdate(req);
    }
    
}
