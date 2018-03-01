/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Animal;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
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
public class IHM_ParticipationController implements Initializable {

    @FXML
    private TableView<Animal> tvListinAnimal;
    @FXML
    private TableColumn<Animal, Integer> id_anim;
    @FXML
    private TableColumn<Animal, String> nom_anim;
    ControlleurConcour controlleur = new ControlleurConcour();
    @FXML
    private Label typeconcour;
    @FXML
    private Label idMembre;
    @FXML
    private Button btnConfirmer;
    int idmembrebd = /*ici on doit mettre l'id du membre*/ 1;
    ArrayList<Animal> animals = controlleur.displayAnimal(idmembrebd);

    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id_anim.setCellValueFactory(new PropertyValueFactory("id"));
        nom_anim.setCellValueFactory(new PropertyValueFactory("nom"));
        for (Animal anim : animals) {
            tvListinAnimal.getItems().addAll(anim);
        }
        typeconcour.setText(IHM_Liste_Concour_PartiController.concourSelectionner.getTypeConcour());
        idMembre.setText("votre identifiant = " + 1);
    }

    @FXML
    private void onClickConfirmer(ActionEvent event) {
        if (tvListinAnimal.getSelectionModel().getSelectedItem() != null) {
            ControlleurParticipation temp = new ControlleurParticipation();
            int idAnimalSelectionne = tvListinAnimal.getSelectionModel().getSelectedItem().getIdAnimal();
            temp.ajouterParticipation(idAnimalSelectionne, IHM_Liste_Concour_PartiController.concourSelectionner.getIdConcour());
            Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("votre demande est transmise a notre commité :*");
            alert.show();
            Stage stage = (Stage) btnConfirmer.getScene().getWindow();
            stage.close();

        } else {
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("il faut selectionner un animal de votre liste");
            alert.show();
        }
    }

}
