/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import services.CSController;
import entites.CentreSoins;
import java.net.URL;
import java.util.ResourceBundle;
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
import services.ListCSControler;

/**
 * FXML Controller class
 *
 * @author mossa
 */
public class IHM_GestionCS implements Initializable {

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
    private TableView<CentreSoins> listCS;
    @FXML
    private TableColumn<CentreSoins, Integer> listmat;
    @FXML
    private TableColumn<CentreSoins, String> listnom;
    @FXML
    private TableColumn<CentreSoins, String> listtype;
    @FXML
    private TableColumn<CentreSoins, String> listeadr;
    @FXML
    private TableColumn<CentreSoins, Integer> listetel;
    @FXML
    private TableColumn<CentreSoins, Double> listenote;
    @FXML
    private Button modif;
    @FXML
    private TextField word;

     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affiche();
        // TODO
    }    
CSController CSC;
    @FXML
    private void ajouterCS(ActionEvent event) {
        
        CSC = new CSController(nom.getText(), type.getText(), adress.getText(),Integer.parseInt(numero.getText()) ,note.getRating());
        CSC.ajouter();
        affiche();
    }

    @FXML
    private void modifierCS(ActionEvent event) {
     int id_CS= Integer.parseInt(nom.getAccessibleRoleDescription().toString());
     String nom_CS= nom.getText();
     String type_CS=type.getText();
     String adresse_CS=adress.getText();
     int numero_CS=Integer.parseInt(numero.getText());
     double note_CS=note.getRating();
        CSC = new CSController(id_CS,nom_CS,type_CS,adresse_CS,numero_CS,note_CS);
        CSC.modifier();
       affiche();
    }

    @FXML
    private void supprimerCS(ActionEvent event) {
        
           CentreSoins cs = new CentreSoins();
           CSC=new CSController();
           int id =listCS.getSelectionModel().getSelectedItem().getId();
           CSC.supprimer(id);
           listCS.getSelectionModel().clearSelection();
           listCS.getItems().remove(cs);
           Alert al =new Alert (Alert.AlertType.INFORMATION);
           al.setTitle("INFORMATION");
           al.setHeaderText(null);
           al.setContentText("Centre supprimée");
           al.showAndWait();
           affiche();

    }

    private void affiche()
    {
     CSController CS= new CSController();
        listCS.getItems().clear();
        for (CentreSoins ce : CS.selectAll()){
            
                listmat.setCellValueFactory(new PropertyValueFactory<>("id"));
                listnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                listtype.setCellValueFactory(new PropertyValueFactory<>("type"));
                listeadr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                listetel.setCellValueFactory(new PropertyValueFactory<>("numero"));
                listenote.setCellValueFactory(new PropertyValueFactory<>("note"));
                listCS.getItems().add(ce);
            }
    }

    @FXML
    private void fillToUpdate(MouseEvent event) {
        nom.setAccessibleRoleDescription(Integer.toString(listCS.getSelectionModel().getSelectedItem().getId()));
        nom.setText(String.valueOf( listCS.getSelectionModel().getSelectedItem().getNom()));
        type.setText(String.valueOf( listCS.getSelectionModel().getSelectedItem().getType()));
        adress.setText(String.valueOf( listCS.getSelectionModel().getSelectedItem().getAdresse()));
        numero.setText(String.valueOf( listCS.getSelectionModel().getSelectedItem().getNumero()));
        note.setRating(listCS.getSelectionModel().getSelectedItem().getNote());
    }

    private void recherche(InputMethodEvent event) {
//           String keyword ;
//       keyword=word.getText();
//        CSC= new CSController();
//        listCS.getItems().clear();
//        for (CentreSoins ce : CSC.selectAll(keyword)){
//                listmat.setCellValueFactory(new PropertyValueFactory<>("id"));
//                listnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
//                listtype.setCellValueFactory(new PropertyValueFactory<>("type"));
//                listeadr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
//                listetel.setCellValueFactory(new PropertyValueFactory<>("numero"));
//                listenote.setCellValueFactory(new PropertyValueFactory<>("note"));
//                listCS.getItems().add(ce);
//            }
    }

    @FXML
    private void recherche(KeyEvent event) {
         String keyword ;
       keyword=word.getText();
        CSC= new CSController();
        listCS.getItems().clear();
        for (CentreSoins ce : CSC.selectAll(keyword)){
                listmat.setCellValueFactory(new PropertyValueFactory<>("id"));
                listnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                listtype.setCellValueFactory(new PropertyValueFactory<>("type"));
                listeadr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                listetel.setCellValueFactory(new PropertyValueFactory<>("numero"));
                listenote.setCellValueFactory(new PropertyValueFactory<>("note"));
                listCS.getItems().add(ce);
            }
    }
    
}

