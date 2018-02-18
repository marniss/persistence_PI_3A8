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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.ControlleurAdoption;
import entites.Adoption;
import java.util.Date;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
/**
 * FXML Controller class
 *
 * @author houssem
 */
public class IHM_ajouter_donnationController implements Initializable {

    @FXML
    private Button ajouter;
    @FXML
    private TextField lieu;
    @FXML
    private TextArea desc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        ControlleurAdoption ca = new ControlleurAdoption();
        ca.ajoutDonnation(1, new Date(), lieu.getText(), 0, desc.getText());
         Alert alert;
        alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Ajout effectuer avec succés");
            alert.show();
    }
    
}
