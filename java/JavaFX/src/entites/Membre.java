/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author Ahmed
 */
public class Membre {
    // les attribuyts

    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private int num;
    private String type;

    // getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Membre() {
    }

    public Membre(int id, String nom, String prenom, String adresse, String email, int num, String type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.num = num;
        this.type = type;
    }

    // nos methodes
    public void ajouterMembre() {

    }

    /* ...
    public int noterVetirinaire() {
        private PreparedStatement ps = null;
     try {
            String req = "update membre set note=? where id_membre=? and type=vetirinaire";
            ps = conn.prepareStatement(req);
            ps.setInt(1, this.note);
            ps.setInt(2, this.id_membre);
            ps.execute();
            return 1;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


        return 0;
    }

        public int consulterNoteVetirinaire() {
        membre vet=new membre();
        private PreparedStatement ps = null;
        private ResultSet rs = null;
     try {
            String req = "select note from membre  where id_membre=? and type=vetirinaire";
            ps = conn.prepareStatement(req);
            ps.setInt(1, this.note);
            ps.setInt(2, this.id_membre);
            ps.setString(3, this.type);
            ps.execute();
    if(rs.next())
    {
        vet.note=rs.getFloat(x);

    }
            return 1;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     

        return 0;
    }
     */
}
