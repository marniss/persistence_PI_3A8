/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.ControlleurMembre;

/**
 * FXML Controller class
 *
 * @author houssem
 */
public class IHM_loginController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private Label erreur;
    @FXML
    private TextField pasword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void inscription(MouseEvent event) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IHM_MembreIHM.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
    }

    @FXML
    private void annuler(ActionEvent event) {
        
        System.exit(0);
    }


    @FXML
    private void connecter(ActionEvent event) throws IOException {
        ControlleurMembre cm = new ControlleurMembre();
        
        if(cm.login(email.getText(), pasword.getText())==0){
            System.out.println(email.getText());
            erreur.setText("login ou mot de passe incorrecte");
            
        }else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IHM_liste_membre.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(new Scene(root1));  
                stage.show();
            
        }
    }

   
    
}
