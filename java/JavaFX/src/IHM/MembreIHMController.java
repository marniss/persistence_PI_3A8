/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import entites.Membre;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import services.MembreService;

/**
 * FXML Controller class
 *
 * @author houssem
 */
public class MembreIHMController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField tel;
    @FXML
    private Button ajouter;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
        Membre m = new Membre(nom.getText(), prenom.getText(), 0, "", "", 0, 0);
        
        MembreService aService;
        aService = new MembreService();
        aService.ajouterMembre(m);
    }
    
     
}
