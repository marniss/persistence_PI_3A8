/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Membre;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.ControlleurMembre;

/**
 * FXML Controller class
 *
 * @author houssem
 */
public class IHM_ConfirmationCodeController implements Initializable {

    @FXML
    private TextField code;
    @FXML
    private Label Ereur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmer(ActionEvent event) throws IOException {
        int codeV =IHM_inscriptionController.code;
        Membre m =IHM_inscriptionController.m;
        String type =IHM_inscriptionController.types;
            
          if (Integer.parseInt(code.getText())==codeV)  
          {       ControlleurMembre ca = new ControlleurMembre();

                int a = ca.ajoutMembre(m.getNom(), m.getPrenom(), m.getAdresse(), m.getEmail(), m.getNum()  , m.getPhoto(),ca.encrypt(m.getPasword()) );
                if (a==1)
                {
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("Ajout effectuer avec succés");
                    alert.show();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IHM_login.fxml"));
       
        Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(new Scene(root1));  
                stage.show();
                }else
                {
                  Alert alert;
                alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("verifier vos donner");
                    alert.show();  
                }
            }else{
              Alert alert;
                alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("code incorrecte");
                    alert.show();
          }
              
    }

    @FXML
    private void annuler(ActionEvent event) {
         Stage stage = new Stage();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.hide();
    }
    
}
