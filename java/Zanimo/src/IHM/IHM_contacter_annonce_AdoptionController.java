/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Adoption;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.ControlleurChamps;
import services.ControlleurMembre;
import services.ServiceEmail;

/**
 * FXML Controller class
 *
 * @author houssem
 */
public class IHM_contacter_annonce_AdoptionController implements Initializable {

    @FXML
    private Label tel;
    @FXML
    private TextField email;
    @FXML
    private TextArea message;
    @FXML
    private Label erroremail;
    @FXML
    private Label erormessage;
Adoption ad = IHM_Adoption_afficherController.adop;
            ControlleurMembre cm = new ControlleurMembre();
            Membre m = cm.getMembre(ad.getIdMembre());
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      tel.setText(""+m.getNum());
    }    

    @FXML
    private void Retour(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IHM_afiche_Annonce_Adoption.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(new Scene(root1));  
                stage.show();
        
       
    }

    @FXML
    private void Annuler(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void envoyerMail(ActionEvent event) {
        int i = 1;
        ControlleurChamps cc=new ControlleurChamps();
        if(email.getText().isEmpty()){
            erroremail.setText("il faut ajouter votre email");
            i=0;
        }
        if(!cc.isEmail(email.getText())){
            erroremail.setText("il faut ajouter une email valide");
            i=0;
        }
        if(message.getText().isEmpty()){
            erormessage.setText("il faut ajouter votre message");
             i =0;
        }
        if (i==1){
            
            ServiceEmail se = new ServiceEmail();
            se.sendEmail(m.getEmail(),"l'email du contacteur : "+email.getText()+" \n  \n le message est :"+message.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("votre email a ete envoyer avec succes");
            alert.show();
        }
    }
    
}
