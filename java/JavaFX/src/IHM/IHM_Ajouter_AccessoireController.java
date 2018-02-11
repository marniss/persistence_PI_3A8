/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.ControlleurAjoutAccessoire;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class IHM_Ajouter_AccessoireController implements Initializable {

    @FXML
    private Button actionEvent;
    @FXML
    private TextField nom;
    @FXML
    private TextField prix;
    @FXML
    private TextField qte;
    @FXML
    private TextField validite;
    @FXML
    private TextField etat;
    @FXML
    private TextField categorie;
    @FXML
    private TextField idMembre;
    @FXML
    private TextField photo;
    @FXML
    private TextField type;
    @FXML
    private TextField date;
    @FXML
    private Button supprimer;
    @FXML
    private TextArea description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionEvent(ActionEvent event) {
        ControlleurAjoutAccessoire test = new ControlleurAjoutAccessoire();
        test.ajouterAccessoire(0, nom.getText(), description.getText(), 0, 0, type.getText(), photo.getText(), new Date(), 0, 0, 0);
    }

    @FXML
    private void supprimer(ActionEvent event) {
    }
    
    
}
