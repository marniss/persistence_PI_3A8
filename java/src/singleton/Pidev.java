/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;
import service.membreService;
import entites.membre;
import java.sql.SQLException;

/**
 *
 * @author houssem
 */
public class Pidev {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        
membre a = new membre("houssem", "marnissi", 0, "hassan nousri", "h", 0, 1);
membreService s = new membreService();
        System.out.println(a.toString());
s.ajouterMembre(a);

s.supprimerMembre(1);
        
        
    }
    
}
