/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.security.Key;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import services.ControlleurMembre;
import services.DataSource;

/**
 *
 * @author Ahmed
 */
public class Membre {
    // les attribuyts
    
    private int idMembre;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private int num;
    private String photo;
    private Date DateInscription;
    private String pasword;
    private String type;
    private int note;
    private int etat;
    private int tel;
    private int connecte;
    // getters

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

   

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
    
    

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

   

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getDateInscription() {
        return DateInscription;
    }
 
    public void setDateInscription(Date DateInscription) {
        this.DateInscription = DateInscription;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getConnecte() {
        return connecte;
    }

    public void setConnecte(int connecte) {
        this.connecte = connecte;
    }
    


    public Membre() {
    }

    public Membre( String nom, String prenom, String adresse, String email, int num, String photo, String pasword) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.num = num;
        this.photo = photo;
        this.pasword = pasword;
    }

    @Override
    public String toString() {
        return "Membre{" + "idMembre=" + idMembre + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email=" + email + ", num=" + num + ", photo=" + photo + ", DateInscription=" + DateInscription + ", pasword=" + pasword + ", type=" + type + ", note=" + note + ", etat=" + etat + ", tel=" + tel + ", conn=" + conn + ", stmt=" + stmt + '}';
    }

   
    
    // les methodes
    
     // les attributs relatifs au methodes CRUD
    Connection conn = DataSource.getInstance().getConnection();
    private Statement stmt;
    
    /** l'ajou
     * @return t**/
    public int ajouterMembre (){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "INSERT INTO `membre`("
              
                + "`nom`, "
                + "`prenom`, "
                + "`DateInscription`, "
                + "`adresse`, "
                + "`email`, "
                + "`photo`, "
                + "num,"
                +"type,"
                +"pasword,"
                +"etat"
                + ") "
                
                + "VALUES ( '"
                + this.nom+"','"
                + this.prenom+"',"
               +" now(),'"
                + this.adresse+"','"
                + this.email+"','"
                + this.photo+"',"
                + this.num+","
                + "'membre',"
                + "'"+this.pasword+"',"
                +"1);";
        // execution de la requette
        try{
            stmt.executeUpdate(maRequette);
            System.out.println(" l'ajout est effectue");
            return 1;
        }catch(SQLException houssem_marnissi){
            System.out.println("erreur lors de l'execution de la requete d'ajout d'un membre \n");
            System.out.println(houssem_marnissi.getMessage());
            
        }
        return 0;
        
    }
    
    //supprission d'un acc
    public int supprimerMembre(){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "UPDATE `membre` "
                + "SET `etat`= 0"
                + " WHERE id_membre = "
                + this.idMembre+
                ";";
        
        // execution de la requette
        try{
            stmt.executeUpdate(maRequette);
            System.out.println(" l'ajout est effectue");
            return 1;
        }catch(SQLException ahmed_makni){
            System.out.println("erreur lors de l'exxecution de la requete de la supprission \n");
            System.out.println(ahmed_makni.getMessage());
            
        }
        return 0;
        
    }
    
    
    //la methode modifier 
    public int modifierMembre(int id){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "UPDATE `membre` SET "
                + "`nom`='"+this.nom+"',"
                + "`prenom`='"+this.prenom+"',"
         
                + "`adresse`='"+this.adresse+"',"
                + "`email`='"+this.email+"',"
                + "`num`="+this.num+","
                + "`photo`='"+this.photo
                + "' WHERE id_membre= "+id
                + ";";
        
        // execution de la requette
        try{
            stmt.executeUpdate(maRequette);
            System.out.println("la modification est ffectuer");
            return 1;
        }catch(SQLException ahmed_makni){
            System.out.println("erreur lors de l'exxecution de la requete de la modification \n");
            System.out.println(ahmed_makni.getMessage());
            
        }
        return 0;
    }
    public int modifierasword(int id){
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        
        ControlleurMembre cm = new ControlleurMembre();
        String maRequette = "UPDATE `membre` SET "
                + "`pasword`='"+cm.encrypt(this.pasword)  +
                
                 "' WHERE id_membre= "+id
                + ";";
        
        // execution de la requette
        try{
            stmt.executeUpdate(maRequette);
            System.out.println("la modification est ffectuer");
            return 1;
        }catch(SQLException ahmed_makni){
            System.out.println("erreur lors de l'exxecution de la requete de la modification \n");
            System.out.println(ahmed_makni.getMessage());
            
        }
        return 0;
    }
    
    
    
   //methode consultation by id
    public Membre getMembre(int id){
        Membre leResultat = new Membre();
         try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
        // preparation de la requette
        String maRequette = "SELECT `id_membre`, `type`, `photo`, `nom`, `prenom`, `adresse`, `num`, `DateInscription`, `email`, `note`, `pasword`, `etat` FROM `membre` WHERE id_membre="+id+";";
        
        // execution de la requette
        try{
            ResultSet res = stmt.executeQuery(maRequette);
            System.out.println(" la recuperation des donnees est effectue");
            while(res.next()){
                leResultat.nom=res.getString("nom");
                leResultat.prenom=res.getString("prenom");
                leResultat.adresse=res.getString("adresse");
                leResultat.email=res.getString("email");
                leResultat.photo=res.getString("photo");
                leResultat.type=res.getString("type");
                leResultat.pasword=res.getString("pasword");
                leResultat.num=res.getInt("num");
                leResultat.idMembre=res.getInt("id_membre");
                leResultat.DateInscription=res.getDate("DateInscription");
                leResultat.connecte=res.getInt("connecter");

                
                /*et la suite ***/
            }
           
        }catch(SQLException houssem_marnissi){
            System.out.println("erreur lors de l'exxecution de la requete de la getmembre \n");
            System.out.println(houssem_marnissi.getMessage());
            
        }
        
        
        return leResultat;
    }
     //methode consultation by email
    public Membre getMembreByEmail(String emails){
        Membre leResultat = new Membre();
         try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
         System.out.println("'chest lemail"+emails+"aa");
        
        // execution de la requette
        try{
            // preparation de la requette
        String maRequette = "SELECT `id_membre`, `type`, `photo`, `nom`, `prenom`, `num`, `DateInscription`, `email`, `note`, `pasword`, `etat`, `adresse` FROM `membre` WHERE `email`='"+emails+"'";
        
            ResultSet res = stmt.executeQuery(maRequette);
            System.out.println(" la recuperation des donnees est effectue dans getmembrby email");
            while(res.next()){
                leResultat.setNom(res.getString("nom"));
                
                leResultat.prenom=res.getString("prenom");
                System.out.println("le prenom estt"+leResultat.getPrenom());

                leResultat.adresse=res.getString("adresse");
                leResultat.photo=res.getString("photo");
                leResultat.type=res.getString("type");
                leResultat.pasword=res.getString("pasword");
                leResultat.num=res.getInt("num");
                leResultat.setIdMembre(res.getInt("id_membre"));
                System.out.println("le id est "+leResultat.getIdMembre());
                leResultat.DateInscription=res.getDate("DateInscription");
                leResultat.email=res.getString("email");
                leResultat.connecte=res.getInt("connecter");
                
                /*et la suite ***/
                
            
            }
        }catch(SQLException houssem_marnissi){
            System.out.println("erreur lors de l'exxecution de la requete de la getmembreby email \n");
            System.out.println(houssem_marnissi.getMessage());
            
        }
        
        
        return leResultat;
    }
    
    public ArrayList<Membre> selectAll(int id) {
         ArrayList<Membre> le = new ArrayList();
        try {
            PreparedStatement st = conn.prepareStatement(
            "SELECT id_membre,type,photo,nom"
                    + ",prenom,num,DateInscription,email ,adresse ,note,etat FROM membre  WHERE `etat`=1 AND `id_membre`<> "+id);
            ResultSet res = st.executeQuery();
            while (res.next()) {
                Membre e = new Membre();
                e.setIdMembre(res.getInt(1));
                e.setType(res.getString(2));
                e.setPhoto(res.getString(3));
                e.setNom(res.getString(4));
                e.setPrenom(res.getString(5));
                e.setNum(res.getInt(6));
                e.setDateInscription(res.getDate(7));
                e.setEmail(res.getString(8));
                e.setAdresse(res.getString(9));
                e.setNote(res.getInt(10));
                e.setEtat(res.getInt(11));
                
                le.add(e);
            }
            return le;
        } catch (SQLException ex) {
            System.out.println("ereuur dans l'aafichage");
        return null;
        }
    }
     public int login(String emails , String paswords)
    {
         Membre leResultat1 = new Membre();
         if (leResultat1.emailExiste(emails)==1)
         {
          Membre  leResultat2 = leResultat1.getMembreByEmail(emails);
        if(leResultat2.decrypt(leResultat2.pasword) .equals(paswords))
        {
            return 1;
        }
         }
         
        return 0;
    }
    public int emailExiste(String email)
    {
        Membre m1 = new Membre();
        System.out.println("aaaaaaaaaaa");
        System.out.println(m1);
      Membre m2= m1.getMembreByEmail(email);
        System.out.println("bbbbbbbbb");
        System.out.println(m2);
        if (m2.idMembre!=0){
            System.out.println("nuuullllll");
            return 1;
        }
        return 0;
    }
    
    
    public String encrypt(String password){

        String crypte= "";
        for (int i=0; i<password.length();i++)  {
            int c=password.charAt(i)^48;  
            crypte=crypte+(char)c; 
        }
        return crypte;
    }
        public String decrypt(String password){
    String aCrypter="";
        for (int i=0; i<password.length();i++)  {
            int c=password.charAt(i)^48;  
            aCrypter=aCrypter+(char)c; 
        }
        return aCrypter;
    }
        public void setConnected() {
     String request = "UPDATE membre SET connect=? WHERE id=?";
    try {
      
        PreparedStatement st = conn.prepareStatement(request);
        st.setObject(1, 1);
        st.setObject(2, this.idMembre);
  
        st.executeUpdate();
        
        
    } catch (SQLException ex) {
        System.out.println("error dans la requete de setConnected");    }
        
    }
       public void setDeconnected() {
     String request = "UPDATE membre SET connect=? WHERE id=?";
    try {
      
        PreparedStatement st = conn.prepareStatement(request);
        st.setObject(1, null);
        st.setObject(2, this.idMembre);
  
        st.executeUpdate();
        
        
    } catch (SQLException ex) {
        System.out.println("error dans la requete de setDeConnected");    }
        
    }
    public String getForgetPasword(String emails){
         Membre leResultat = new Membre();
         try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la creation du statment \n");
            System.out.println(ex.getMessage());
        }
         System.out.println("'chest lemail"+emails+"aa");
        
        // execution de la requette
        try{
            // preparation de la requette
        String maRequette = "SELECT `pasword` FROM `membre` WHERE `email`='"+emails+"'";
        
            ResultSet res = stmt.executeQuery(maRequette);
            System.out.println(" la recuperation des donnees est effectue dans getmembrby email");
            while(res.next()){
                leResultat.setNom(res.getString("nom"));
                
                leResultat.prenom=res.getString("prenom");
                System.out.println("le prenom estt"+leResultat.getPrenom());

                leResultat.adresse=res.getString("adresse");
                leResultat.photo=res.getString("photo");
                leResultat.type=res.getString("type");
                leResultat.pasword=res.getString("pasword");
                leResultat.num=res.getInt("num");
                leResultat.setIdMembre(res.getInt("id_membre"));
                System.out.println("le id est "+leResultat.getIdMembre());
                leResultat.DateInscription=res.getDate("DateInscription");
                leResultat.email=res.getString("email");
                leResultat.connecte=res.getInt("connecter");
                
                /*et la suite ***/
                
            return leResultat.getPasword();
            }
        }catch(SQLException houssem_marnissi){
            System.out.println("erreur lors de l'exxecution de la requete de la getmembreby email \n");
            System.out.println(houssem_marnissi.getMessage());
           
        }
                    return null;

        
    }
    
    
    
}
