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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import services.ControlleurConcour;

/**
 * FXML Controller class
 *
 * @author angham
 */
public class IHM_Modifier_ConcourController implements Initializable {

    @FXML
    private Button modifier;
    @FXML
    private TextField new_type;
    @FXML
    private TextField new_race;
    @FXML
    private TextField new_titre;
    @FXML
    private DatePicker dd;
    @FXML
    private DatePicker df;
    @FXML
    private TextField capacite;
    @FXML
    private TextField lieu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //IHM_Liste_ConcourController.
        System.out.println("*************"+IHM_Liste_ConcourController.concourSelectionner.getTypeConcour());
                new_type.setText(IHM_Liste_ConcourController.concourSelectionner.getTypeConcour());
                new_race.setText(IHM_Liste_ConcourController.concourSelectionner.getRace());
                new_titre.setText(IHM_Liste_ConcourController.concourSelectionner.getTitreConcour());
                /*new_capacite.setText(IHM_Liste_ConcourController.concourSelectionner.getCapacite());
                new_lieu.setText(IHM_Liste_ConcourController.concourSelectionner.getLieu());*/


    }    

    @FXML
    private void modifier(ActionEvent event) {
        ControlleurConcour temp = new ControlleurConcour();
       // temp.modifierConcour(IHM_Liste_ConcourController.concourSelectionner.getIdConcour(),new_type.getText(),new_race.getText(),new_titre.getText(),capacite.getText(),lieu.getText());
        System.out.println("Vue");
        temp.modifierConcour(IHM_Liste_ConcourController.concourSelectionner.getIdConcour(),new_type.getText(),new_race.getText(),new_titre.getText(),lieu.getText(),Integer.parseInt(capacite.getText()));
    }
    
}
