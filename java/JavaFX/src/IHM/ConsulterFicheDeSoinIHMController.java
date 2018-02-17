/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.FicheDeSoin;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.ControlleurFicheDeSoin;

/**
 * FXML Controller class
 *
 * @author pc makni
 */
public class ConsulterFicheDeSoinIHMController implements Initializable {

    @FXML
    private TableView<FicheDeSoin> listFicheDeSoin;
    @FXML
    private TextField rech;
    @FXML
    private Button btn;

    @FXML
    private TableColumn<FicheDeSoin, Integer> id_f_soin;
    @FXML
    private TableColumn<FicheDeSoin, String> nom;
    @FXML
    private TableColumn<FicheDeSoin, String> espece;
    @FXML
    private TableColumn<FicheDeSoin, Float> poids;
    @FXML
    private TableColumn<FicheDeSoin, String> datepoids;
    @FXML
    private TableColumn<FicheDeSoin, String> neLe;
    @FXML
    private TableColumn<FicheDeSoin, String> genre;
    @FXML
    private TableColumn<FicheDeSoin, String> observation;
    @FXML
    private TableColumn<FicheDeSoin, String> photo;
    @FXML
    private TableColumn<FicheDeSoin, String> medicament;
    @FXML
    private TableColumn<FicheDeSoin, String> proprietaire;
    @FXML
    private TableColumn<FicheDeSoin, String> prochainRDV;
    private TableColumn<FicheDeSoin, Boolean> col_action;
    @FXML
    private Label idvet;
    @FXML
    private TableColumn<FicheDeSoin, Boolean> modifierCol;
    @FXML
    private TableColumn<FicheDeSoin, Boolean> supprimerCol;
    public static int id_f_soin_modifier;
    @FXML
    private Button add;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /**
         * Instanciation Du Controlleur*
         */
        ControlleurFicheDeSoin cfds = new ControlleurFicheDeSoin();
        ArrayList<FicheDeSoin> ficheDeSoins = cfds.ConsulterFicheDeSoin();
        /*
         *Deffinition des Colonnes
         */
        id_f_soin.setCellValueFactory(new PropertyValueFactory("id_f_Soin"));
        nom.setCellValueFactory(new PropertyValueFactory("Nom"));
        espece.setCellValueFactory(new PropertyValueFactory("espece"));
        poids.setCellValueFactory(new PropertyValueFactory("poids"));
        datepoids.setCellValueFactory(new PropertyValueFactory("datepoids"));
        neLe.setCellValueFactory(new PropertyValueFactory("neLe"));
        genre.setCellValueFactory(new PropertyValueFactory("genre"));
        observation.setCellValueFactory(new PropertyValueFactory("observation"));
        photo.setCellValueFactory(new PropertyValueFactory("photo"));
        medicament.setCellValueFactory(new PropertyValueFactory("medicament"));
        proprietaire.setCellValueFactory(new PropertyValueFactory("proprietaire"));
        prochainRDV.setCellValueFactory(new PropertyValueFactory("prochainRDV"));
        modifierCol.setCellValueFactory(new PropertyValueFactory("modButton"));
        supprimerCol.setCellValueFactory(new PropertyValueFactory("supButton"));
        ficheDeSoins.stream().filter(t -> t.getEtat() == 1).map((FicheDeSoin e) -> {
            listFicheDeSoin.getItems().addAll(e);
            return e;
        }).map((e) -> {
            e.getModButton().setOnAction((event) -> {
                try {
                    id_f_soin_modifier = e.getId_f_Soin();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/IHM/FicheDeSoinIHM.fxml"));
                    Parent root = (Parent) loader.load();
                    FicheDeSoinVueController control = loader.getController();
                    control.initFields(e);
                    // int id_f_Soin = listFicheDeSoin.getSelectionModel().getSelectedItem().getId_f_Soin();
                    Stage window;
                    window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(new Scene(root));
                    window.show();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            });
            return e;
        }).forEachOrdered((e) -> {
            e.getSupButton().setOnAction((event) -> {
                cfds.updateFicheDeSoin(e);
                listFicheDeSoin.getSelectionModel().clearSelection();
                listFicheDeSoin.getItems().remove(e);
            });
        });
        idvet.setText("Code Vetirinaire : " + String.valueOf(ficheDeSoins.get(0).getId_membre()));
        System.out.println("IHM");

    }

    @FXML
    private void btn(ActionEvent event) {
    }

    @FXML
    private void add(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/IHM/FicheDeSoinIHM.fxml"));
        try {

            Parent root = (Parent) loader.load();
            FicheDeSoinVueController control = loader.getController();

            Stage window;
            window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(new Scene(root));
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(ConsulterFicheDeSoinIHMController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FicheDeSoinVueController control = loader.getController();
    }

}
