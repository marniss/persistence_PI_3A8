/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.ControlleurParticipation;

/**
 * FXML Controller class
 *
 * @author angham
 */
public class IHM_Ajouter_ParticipationController implements Initializable {

    @FXML
    private TextField ida;
    @FXML
    private Button Ajouter;
    @FXML
    private TextField idc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
     private void Ajouter(ActionEvent event) {
        ControlleurParticipation test = new ControlleurParticipation();
        test.ajouterParticipation(Integer.valueOf( ida.getText()), Integer.valueOf(idc.getText()));
    }
}
