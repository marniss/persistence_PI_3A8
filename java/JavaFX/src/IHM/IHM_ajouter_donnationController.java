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
import java.io.IOException;
import java.util.Date;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
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
    @FXML
    private Label ErrorLieu;
    @FXML
    private Label errorDesc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        int i=1;
        if (lieu.getText().isEmpty()){
          ErrorLieu.setText("il faut ajouter votre adresse");
          i=0;
            
        }
        if (desc.getText().isEmpty()){
            errorDesc.setText("il faut ajouter une description");
          i=0; 
        }
        if( i==1){
            
        
        ControlleurAdoption ca = new ControlleurAdoption();
        ca.ajoutDonnation(IHM_loginController.membre.getIdMembre(), lieu.getText(), desc.getText(), "Donner", IHM_Animal_DonnerController.idAnimal);
         Alert alert;
        alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Ajout effectuer avec succés");
            alert.show();
        }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IHM_Animal_Donner.fxml"));
       
        Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(new Scene(root1));  
                stage.show();
    }
    
}
