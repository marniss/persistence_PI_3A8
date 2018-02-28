/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Concour;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class IHM_Liste_Concour_PartiController implements Initializable {

    @FXML
    private TableView<Concour> table;
    @FXML
    private TableColumn<Concour, Integer> id;
    @FXML
    private TableColumn<Concour, String> titre;
    @FXML
    private TableColumn<Concour, String> type;
    @FXML
    private TableColumn<Concour, String> race;
    @FXML
    private TableColumn<Concour, Date> datedebut;
    @FXML
    private TableColumn<Concour, Date> datefin;

    public static Concour con;
    @FXML
    private Button ajouter;
    @FXML
    private TableColumn<Concour, Integer> capacite;
    @FXML
    private TableColumn<Concour, String> lieu;
    @FXML
    private TableColumn<Concour, Integer> nbr;

    public static Concour concourSelectionner;

    ControlleurConcour cp = new ControlleurConcour();
    ArrayList<Concour> concour = cp.selectAll();
    ObservableList<Concour> sss = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for (Concour en : cp.selectAll()) {
            if (en.getCapacite() > en.getNbparticipant()) {
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
    }

    @FXML
    private void ajouterConcour(ActionEvent event) {

        if (table.getSelectionModel().getSelectedItem() != null) {
            //recuperation du concours selectionnee
            IHM_Liste_Concour_PartiController.concourSelectionner = table.getSelectionModel().getSelectedItem();
            //affichage de l'interface relative au choi de l'animal
            try {
                Parent root = FXMLLoader.load(getClass().getResource("IHM_Participation.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(IHM_Liste_Concour_PartiController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("il faut selectionner un concours");
            alert.show();
        }
    }

}
