/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author houssem
 */
public class IHM_AdoptionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void donner(ActionEvent event) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IHM_Animal_Donner.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(IOException e) {
            
            
          }
        
    }

    @FXML
    private void deleger(ActionEvent event) {
         try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IHM_Animal_Deleger.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.hide();
              
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(IOException e) {
            
            
          }
    }

    @FXML
    private void adopter(ActionEvent event) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IHM_Adoption_afficher.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.hide();
                
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(IOException e) {
            
            
          }
        
    }

    @FXML
    private void annuler(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IHM_Accueil.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(new Scene(root1));  
                stage.show();
    }
    
}
