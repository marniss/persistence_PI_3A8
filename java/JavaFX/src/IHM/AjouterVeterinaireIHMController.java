/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.ControlleurListeVeterinaire;

/**
 * FXML Controller class
 *
 * @author pc asus
 */
public class AjouterVeterinaireIHMController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField tel;
    @FXML
    private TextField mail;
    @FXML
    private TextField prenom;
    @FXML
    private TextField adresse;
    @FXML
    private TextField pht;
    @FXML
    private Button ajouter;
    @FXML
    private Button annuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void brouse(ActionEvent event) {
    }

    @FXML
    private void add(ActionEvent event) {
        ControlleurListeVeterinaire clv = new ControlleurListeVeterinaire();
        clv.ajouterVeteriniare(nom.getText(), prenom.getText(), tel.getText(), adresse.getText(), mail.getText(), pht.getText());
        System.out.println("Ok");
    }

    @FXML
    private void annuler(ActionEvent event) {
    }

}
