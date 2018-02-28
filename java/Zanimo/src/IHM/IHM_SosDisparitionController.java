package IHM;

import entites.sosDisparition;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.ControlleurChamp;

/**
 * FXML Controller class
 *
 * @author salah
 */

//    *************************************************************************************************************
//    *          IHM_Sos_Disparition                                                                              *
//    *************************************************************************************************************
public class IHM_SosDisparitionController implements Initializable {

    @FXML private TextField membre;
    @FXML private Button afficher;
    @FXML private Label error;
    @FXML private TextField nom;    
    @FXML private TextField num_tel;
    @FXML  private TextArea description;
    @FXML
    private Label errornum;
    @FXML
    private Label errornom;
    private ImageView img;
    @FXML
    private Label errordes;
    @FXML
    private TextField email;
    @FXML
    private TextField adresse;
    
    
//*************************************************************************************************************
//*                                              INITIALIZE                                                                                   *
//*************************************************************************************************************
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    

    
 // *************************************************************************************************************
//  *              AJOUTER Sos_Disparition                                                                      *
//  *************************************************************************************************************
    @FXML
    private void ajouterSosDisparition(ActionEvent event) {
        
         ControlleurChamp cc = new ControlleurChamp();
        
          if (!cc.isNum(num_tel.getText())) {
               
            errornum.setText("il faut un numero valide");
          }else if (!cc.isName(nom.getText())) {
            errornom.setText("il faut un nom valide");
          }else if (cc.isEmpty(description.getText())) {
            errordes.setText("il faut une description non vide ");}
          else{
      
     
        sosDisparition sos =new sosDisparition(this.nom.getText(),Integer.valueOf(this.num_tel.getText()),this.description.getText(),this.email.getText(),this.adresse.getText());
        sos.ajouterSosDisparition();
           Alert al =new Alert (Alert.AlertType.INFORMATION);
           al.setTitle("INFORMATION");
           al.setHeaderText(null);
           al.setContentText("Sos Ajouter");
           al.showAndWait();   } 
    }

    
    
// *************************************************************************************************************
//  *                                   AFFICHER                                                                                     *
//  *************************************************************************************************************
    
    @FXML
    private void afficher(ActionEvent event) {
         try {
            Parent parent = FXMLLoader.load(getClass().getResource("/IHM/IHM_List_Sos.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
          } catch (IOException ex) {
                 Logger.getLogger(MainPanelController.class.getName()).log(Level.SEVERE, null, ex);
              }
          }      
      }

    
    

