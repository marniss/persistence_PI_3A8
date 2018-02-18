/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Membre;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.ImageIcon;
import services.ControlleurMembre;

/**
 * FXML Controller class
 *
 * @author houssem
 */
public class IHM_membre_afficherController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField tel;
    @FXML
    private Button modifier;
    @FXML
    private TextField adresse;
    @FXML
    private TextField email;
    @FXML
    private Label date;
    @FXML
    private Label type;
    @FXML
    private ImageView image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                ControlleurMembre x = new ControlleurMembre();

              Membre m=x.getMembre(IHM_liste_membreController.idZbotrech);
                      
                      nom.setText(m.getNom());
                      adresse.setText(m.getAdresse());
                      tel.setText(""+m.getNum());
                      prenom.setText(m.getPrenom());
                      email.setText(m.getEmail());
                      type.setText(m.getType());
                      date.setText(""+m.getDateInscription());
                     System.out.println("ZZZZZZ"+m.getPhoto());
URL imageURL = getClass().getResource("/image/maphoto.jpg");
 Image i = new Image(imageURL.toExternalForm());
 
image.setImage(i);

    }    
    
}
