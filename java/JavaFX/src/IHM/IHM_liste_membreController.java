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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.ControlleurMembre;

/**
 * FXML Controller class
 *
 * @author houssem
 */
public class IHM_liste_membreController implements Initializable {

    @FXML
    private TableView<Membre> table;
    @FXML
    private TableColumn<Membre, String> id;
    @FXML
    private TableColumn<Membre, String> typr;
    @FXML
    private TableColumn<Membre, String> nom;
    @FXML
    private TableColumn<Membre, String> prenom;
    @FXML
    private TableColumn<Membre, String> adresse;
    @FXML
    private TableColumn<Membre, String> num;
    @FXML
    private TableColumn<Membre, String> email;
    @FXML
    private TableColumn<Membre, String> note;
    @FXML
    private TableColumn<Membre, String> etat;
    
    public static int idZbotrech ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Membre m = new Membre();
        
        for (Membre mem : m.selectAll())
            
        {            table.getItems().add(mem);
      		id.setCellValueFactory(new PropertyValueFactory<>("idMembre"));
      		typr.setCellValueFactory(new PropertyValueFactory<>("type"));
      		nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
      		prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
      		adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
      		num.setCellValueFactory(new PropertyValueFactory<>("num"));
      		email.setCellValueFactory(new PropertyValueFactory<>("email"));
      		note.setCellValueFactory(new PropertyValueFactory<>("note"));
      		etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
                
                
                
                // suprimer
                
                

        }
        
        
    }    

    @FXML
    private void ajouter(ActionEvent event) {
         try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MembreIHM.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(IOException e) {
            
             System.out.println("erreur dans la redirection a membreIHM pour l'ajout d'un membre");
          }
         
    }

    @FXML
    private void modifier(ActionEvent event) {
        Membre m = table.getSelectionModel().getSelectedItem();

        if(m==null)
      {
           Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("choisir un membre pour modifier");
            alert.show(); 
      }
        else
        {try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IHM_membre_modifier.fxml"));
                       this.idZbotrech = m.getIdMembre();
       
        Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.setX(m.getIdMembre());       
                stage.show();
                    System.out.println(idZbotrech);
        } catch(IOException e) {
            
            
          }
            
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
        
        Membre m = table.getSelectionModel().getSelectedItem();
         
      if(m==null)
      {
           Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("choisir un membre pour supprimer");
            alert.show(); 
      }
      else{  ControlleurMembre sm= new ControlleurMembre();
        
      int a=sm.supprimerMembre(m);
      
      if (a==1)
        {
 
        Alert alert;
        alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("suppréssion effectuer avec succés refléchir la page pour voir les modifications");
            alert.show();
        }else
        {
          Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("echec de suppression");
            alert.show();  
        }}
               
        
    }

    @FXML
    private void annuler(ActionEvent event) {
        System.exit(0);
    }

  

    @FXML
    private void reflechir(ActionEvent event) {
    }

    @FXML
    private void ajouter(MouseEvent event) {
    }

    @FXML
    private void afficher(ActionEvent event) throws IOException {
          Membre m = table.getSelectionModel().getSelectedItem();

        if(m==null)
      {
           Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("choisir un membre pour l'afficher");
            alert.show(); 
      }
        else
        {
            try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IHM_membre_afficher.fxml"));
                       this.idZbotrech = m.getIdMembre();
       
        Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.setX(m.getIdMembre());       
                stage.show();
                    System.out.println(idZbotrech);
    } catch(IOException e)
    {
        
    }
    
        }
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Parent parent125 = FXMLLoader.load(getClass().getResource("IHM_login.fxml"));
       Scene scene1116 = new Scene(parent125 );
       Stage stage1116  = (Stage)((Node)event.getSource()).getScene().getWindow();
       stage1116 .hide();
       stage1116 .setScene(scene1116 );
       stage1116.show();
    }
}
