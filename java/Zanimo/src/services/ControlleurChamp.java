/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author salah
 */
public class ControlleurChamp {
   
    public boolean isName(String s){
        return s.matches("([A-Z]|[a-z])*");
        
    }
    public boolean isRace(String s){
       return s.matches("([A-Z]|[a-z])*");
    }
    
     public boolean isNum(String s){
       return s.matches("([0-9])*");
    }
     
     public boolean isEmpty(String s){
         return (s.length()==0);
     }
    
    
    
    
    
}
