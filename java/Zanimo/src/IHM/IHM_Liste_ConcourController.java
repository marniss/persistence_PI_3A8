/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Concour;
import entites.Participation;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.ControlleurConcour;
import services.ControlleurParticipation;

/**
 * FXML Controller class
 *
 * @author angham
 */
public class IHM_Liste_ConcourController implements Initializable {
    
     

    @FXML
    private TableView<Concour> table;
    @FXML
    private TableColumn<Concour, Integer> id;
    @FXML
    private TableColumn<Concour,String> titre;
    @FXML
    private TableColumn<Concour, String> type;
    @FXML
    private TableColumn<Concour, String> race;
    @FXML
    private TableColumn<Concour,Date> datedebut;
    @FXML
    private TableColumn<Concour,Date> datefin;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    public static Concour con;
    @FXML
    private Button ajouter;
    @FXML
    private TableColumn<Concour,Integer> capacite;
    @FXML
    private TableColumn<Concour, String> lieu;
    @FXML
    private TableColumn<Concour, Integer> nbr;
    
    
    public static Concour concourSelectionner;
    
     ControlleurConcour cp = new ControlleurConcour();
       ArrayList<Concour> concour=cp.selectAll();
        ObservableList<Concour> sss = FXCollections.observableArrayList();
    
    
    
     
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        for (Concour en : cp.selectAll()) {
        table.getItems().add(en);
        id.setCellValueFactory(new PropertyValueFactory<>("idConcour"));
        type.setCellValueFactory(new PropertyValueFactory<>("typeConcour"));
        race.setCellValueFactory(new PropertyValueFactory<>("race"));
        datedebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        datefin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        titre.setCellValueFactory(new PropertyValueFactory<>("titreConcour")); 
        capacite.setCellValueFactory(new PropertyValueFactory<>("capacite")); 
        lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        nbr.setCellValueFactory(new PropertyValueFactory<>("nbparticipant")); 

       }  
    }
    
    
    private void refresh() throws IOException{
        sss.clear();
        sss.addAll(cp.selectAll());
        table.setItems(sss);
         Parent root = FXMLLoader.load(getClass().getResource("IHM_Liste_Concour.fxml"));
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.hide();
        stage.show();        
    }
    
    @FXML
    private void supprimer(ActionEvent event) throws IOException {
        
        Concour con = table.getSelectionModel().getSelectedItem();
         
      if(con==null)
      {
           Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("choisir un membre pour supprimer");
            alert.show(); 
      }
      else{  ControlleurConcour sm= new ControlleurConcour();
        
      int a;
      a=sm.supprimerConcour(con);
      
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
      refresh();
    }       
        
        
   

     private void ajouter(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("IHM_Ajouter_Concour.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();     
    }
    
     
    @FXML
    private void modifier(ActionEvent event)
    {
        concourSelectionner = table.getSelectionModel().getSelectedItem();

        if(concourSelectionner==null)
      {
           Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("choisir un concours pour modifier");
            alert.show(); 
      }
        else
        {try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IHM_Modifier_Concour.fxml"));
       
        Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(IOException e) {
            
            
          }
            
        }
    }

    @FXML
    private void ajouterConcour(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IHM_Ajouter_Concour.fxml"));
        
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1)); 
        stage.show();
    }
     }
    

