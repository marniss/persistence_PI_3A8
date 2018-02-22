/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.io.File;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import services.ControlleurChamps;
import services.ControlleurMembre;

/**
 * FXML Controller class
 *
 * @author houssem
 */
public class MembreIHMController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField tel;
    @FXML
    private Button ajouter;
    @FXML
    private TextField motdepasse;
    @FXML
    private TextField adresse;
    @FXML
    private TextField email;
    @FXML
    private Button brows;
    @FXML
    private TextField doc;
    @FXML
    private ChoiceBox<String> type;
    @FXML
    private Label Erornom;
    @FXML
    private Label ErorEmail;
    @FXML
    private Label Errorprenom;
    @FXML
    private Label errorMotPAsse;
    @FXML
    private Label errorConfirmerMotdePass;
    @FXML
    private Label erroreTel;
    @FXML
    private Label ErorAdresse;
    @FXML
    private Label ErrorePhoto;
    @FXML
    private Label Erortype;
    @FXML
    private TextField conf;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        type.getItems().add("simple utilisateur");
         type.getItems().add("veterinere");
        type.getItems().add("dresseur");
        
    }

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
     
            ControlleurMembre ca = new ControlleurMembre();
            ControlleurChamps cc = new ControlleurChamps();
            int c=1 ;

                        if (nom.getText().isEmpty()||!cc.isName(nom.getText())){
                             c=0;
                             if(nom.getText().isEmpty()){
                                Erornom.setText("il faut ajouter un nom");

                            }else          
                             {  Erornom.setText("il faut ajouter un nom  valide");}


                        }
                        if (prenom.getText().isEmpty()||!cc.isName(prenom.getText())){
                             c=0;
                             if(prenom.getText().isEmpty()){
                                Errorprenom.setText("il faut ajouter un prénom");

                            }else          
                             {  Errorprenom.setText("il faut ajouter un prenom  valide");}


                        }
                        if (tel.getText().isEmpty()||!cc.isNum(tel.getText())){
                             c=0;
                             if(tel.getText().isEmpty()){
                                erroreTel.setText("il faut ajouter un numero de téléphone");

                            }else          
                             {  erroreTel.setText("il faut ajouter un numero  valide");}


                        }
                        if (email.getText().isEmpty()||!cc.isEmail(email.getText())||ca.emailExiste(email.getText())==1){
                             c=0;
                             if(email.getText().isEmpty()){
                                ErorEmail.setText("il faut ajouter un email");

                            }else if   (!cc.isEmail(email.getText()))       
                             {  ErorEmail.setText("il faut ajouter un email valide");}
                            else
                            {  ErorEmail.setText("email existe déja");}
                        }
                        if (motdepasse.getText().isEmpty()||!conf.getText().equals(motdepasse.getText())||motdepasse.getText().length()<8){
                                         c=0;
                             if (motdepasse.getText().isEmpty())
                             { errorMotPAsse.setText("il faut ajouter un mot de passe");}
                              else  if (motdepasse.getText().length()<8)
                              { errorMotPAsse.setText("il faut plus de 8 caractére");}

                                 else  if (!conf.getText().equals(motdepasse.getText())){
            
                              errorConfirmerMotdePass.setText("il faut confirmer le mot de passe");
            
                                        }
                        }
                        else  
        if(type.getValue()=="simple utilisateur"&&c==1)
        {
            int a = ca.ajoutMembre(nom.getText(), prenom.getText(), adresse.getText(), email.getText(), Integer.parseInt(tel.getText()), doc.getText(),ca.encrypt(motdepasse.getText()) );
        if (a==1)
        {
        Alert alert;
        alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Ajout effectuer avec succés");
            alert.show();
        }else
        {
          Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("verifier vos donner");
            alert.show();  
        }
        }
        else if(type.getValue()=="veterinere"&&c==1)
        {int a = ca.ajoutVeterinaire(nom.getText(), prenom.getText(), adresse.getText(), email.getText(), Integer.parseInt(tel.getText()), doc.getText(), motdepasse.getText());

        if (a==1)
        {
        Alert alert;
        alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Ajout effectuer avec succés");
            alert.show();
        }else
        {
          Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("verifier vos donner");
            alert.show();  
        }
                
                }
        else if(type.getValue()=="dresseur"&&c==1){
          int  a = ca.ajoutDresseur(nom.getText(), prenom.getText(), adresse.getText(), email.getText(), Integer.parseInt(tel.getText()), doc.getText(), motdepasse.getText());
            if (a==1)
        {
        Alert alert;
        alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Ajout effectuer avec succés");
            alert.show();
            
        }else
        {
          Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("verifier vos donner");
            alert.show();  
        }
        }
        
        else{
                        Erortype.setText("il faut choisir un type d'utilisation");

        }
    }

    @FXML
    private void brows(ActionEvent event) {
        
        
        JFileChooser file = new JFileChooser();
        
        file.showOpenDialog(null);
        File f = file.getSelectedFile();
        doc.setText(f.getAbsolutePath());
        
    }

    @FXML
    private void annuler(ActionEvent event) {
        Stage stage = new Stage();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.hide();
    }

}
