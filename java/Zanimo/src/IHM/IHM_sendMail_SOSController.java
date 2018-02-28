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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.ServiceEmail;

/**
 * FXML Controller class
 *
 * @author salah
 */
public class IHM_sendMail_SOSController implements Initializable {

    @FXML
    private TextArea contenue;
    @FXML
    private TextField email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyer(ActionEvent event) {
        System.out.println(",hghghj"+IHM_List_SosController.mm);
        ServiceEmail se = new ServiceEmail();
        
        se.sendEmail(IHM_List_SosController.mm, "l'email :"+email.getText()+" le message :"+contenue.getText());
        
    }
    
}
