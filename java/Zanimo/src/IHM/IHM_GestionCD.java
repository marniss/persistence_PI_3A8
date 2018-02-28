/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import com.lynden.gmapsfx.GoogleMapView;
import entites.CentreDressage;
import services.CDController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Rating;
import services.ListCDControler;

/**
 * FXML Controller class
 *
 * @author mossa
 */
public class IHM_GestionCD implements Initializable {
       CDController centre=new CDController();
    @FXML
    private Button ajout;
    @FXML
    private TextField adress;
    @FXML
    private TextField type;
    @FXML
    private TextField nom;
    @FXML
    private TextField numero;
    @FXML
    private Rating note;
    @FXML
    private TableView<CentreDressage> listCD;
    @FXML
    private TableColumn<CentreDressage, Integer> listmat;
    @FXML
    private TableColumn<CentreDressage, String> listnom;
    @FXML
    private TableColumn<CentreDressage, String> listtype;
    @FXML
    private TableColumn<CentreDressage, String> listeadr;
    @FXML
    private TableColumn<CentreDressage, Integer> listetel;
    @FXML
    private TableColumn<CentreDressage, Double> listenote;
    @FXML
    private TextField word;
    CDController cdc;
    @FXML
    private GoogleMapView map;
    @FXML
    private TextField longtitude;
    @FXML
    private TextField latitude;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affiche();
        // TODO
    }    

    @FXML
    private void ajouterCD(ActionEvent event) {
        CDController cd = new CDController(nom.getText(), type.getText(), adress.getText(),Integer.parseInt(numero.getText()) ,note.getRating());
        cd.ajouter();
       affiche();
    }

    @FXML
    private void modifierCD(ActionEvent event) {
     int id_cd= Integer.parseInt(nom.getAccessibleRoleDescription().toString());
     String nom_cd= nom.getText();
     String type_cd=type.getText();
     String adresse_cd=adress.getText();
     int numero_cd=Integer.parseInt(numero.getText());
     double note_cd=note.getRating();
        CDController cd1=new CDController(id_cd,nom_cd,type_cd,adresse_cd,numero_cd,note_cd);
      cd1.modifier();
       affiche();
    }

    @FXML
    private void supprimerCD(ActionEvent event) {
        
           CDController cd = new CDController();
           int id =listCD.getSelectionModel().getSelectedItem().getId();
           cd.supprimer(id);
           listCD.getSelectionModel().clearSelection();
           listCD.getItems().remove(cd);
           Alert al =new Alert (Alert.AlertType.INFORMATION);
           al.setTitle("INFORMATION");
           al.setHeaderText(null);
           al.setContentText("Centre supprimée");
           al.showAndWait();
           affiche();

    }

    private void affiche()
    {
     CDController cdc= new CDController();
        listCD.getItems().clear();
        for (CentreDressage ce : cdc.selectAll()){
            
                listmat.setCellValueFactory(new PropertyValueFactory<>("id"));
                listnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                listtype.setCellValueFactory(new PropertyValueFactory<>("type"));
                listeadr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                listetel.setCellValueFactory(new PropertyValueFactory<>("numero"));
                listenote.setCellValueFactory(new PropertyValueFactory<>("note"));
                listCD.getItems().add(ce);
            }
    }

    @FXML
    private void fillToUpdate(MouseEvent event) {
        nom.setAccessibleRoleDescription(Integer.toString(listCD.getSelectionModel().getSelectedItem().getId()));
        nom.setText(String.valueOf( listCD.getSelectionModel().getSelectedItem().getNom()));
        type.setText(String.valueOf( listCD.getSelectionModel().getSelectedItem().getType()));
        adress.setText(String.valueOf( listCD.getSelectionModel().getSelectedItem().getAdresse()));
        numero.setText(String.valueOf( listCD.getSelectionModel().getSelectedItem().getNumero()));
        note.setRating(listCD.getSelectionModel().getSelectedItem().getNote());
    }

//    private void recherche(InputMethodEvent event) {
////        String keyword ;
////       keyword=word.getText();
////        cdc= new CDController();
////        listCD.getItems().clear();
////        for (CentreDressage ce : cdc.selectAll(keyword)){
////                listmat.setCellValueFactory(new PropertyValueFactory<>("id"));
////                listnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
////                listtype.setCellValueFactory(new PropertyValueFactory<>("type"));
////                listeadr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
////                listetel.setCellValueFactory(new PropertyValueFactory<>("numero"));
////                listenote.setCellValueFactory(new PropertyValueFactory<>("note"));
////                listCD.getItems().add(ce);
////            }
//    }

       @FXML
    private void recherche(KeyEvent event) {
        String keyword ;
       keyword=word.getText();
        cdc= new CDController();
        listCD.getItems().clear();
        for (CentreDressage ce : cdc.selectAll(keyword)){
                listmat.setCellValueFactory(new PropertyValueFactory<>("id"));
                listnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                listtype.setCellValueFactory(new PropertyValueFactory<>("type"));
                listeadr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                listetel.setCellValueFactory(new PropertyValueFactory<>("numero"));
                listenote.setCellValueFactory(new PropertyValueFactory<>("note"));
                listCD.getItems().add(ce);
            }
    }
    
}
