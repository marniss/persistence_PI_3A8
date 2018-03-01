/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Animal;
import entites.Concour;
import entites.Participation;
import entites.ParticipationAffectation;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class IHM_Gerer_ParticipationController implements Initializable {

    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnSupp;
    @FXML
    private Button btnRetour;
    @FXML
    private TableView<ParticipationAffectation> tvGestionParticipation;
    @FXML
    private TableColumn<ParticipationAffectation, String> idparticipation;
    @FXML
    private TableColumn<ParticipationAffectation, String> typeConcour;
    @FXML
    private TableColumn<ParticipationAffectation, String> nbPlaceDispo;
    @FXML
    private TableColumn<ParticipationAffectation, String> typeAnimal;
    @FXML
    private TableColumn<ParticipationAffectation, String> idAnimal;
    @FXML
    private TableColumn<ParticipationAffectation, String> adresseMembre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inittab();

    }

    @FXML
    private void onClickConfirm(ActionEvent event) {
        if (tvGestionParticipation.getSelectionModel().getSelectedItem() != null) {
            ControlleurParticipation temp = new ControlleurParticipation();
            //iici modification de l'etat de particiapation 0->1
            temp.confirm(Integer.parseInt(tvGestionParticipation.getSelectionModel().getSelectedItem().getIdparticipation()));
            //incrementer le nb participant dans concours
            ControlleurConcour crtConcours = new ControlleurConcour();
            crtConcours.incrementParticpant(tvGestionParticipation.getSelectionModel().getSelectedItem().getTypeConcour());
            inittab();
            /**
             * ici mette l'API mail
             */

        } else {
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("il faut selectionner un element de votre liste");
            alert.show();
        }
    }

    @FXML
    private void onClickDele(ActionEvent event) {
        if (tvGestionParticipation.getSelectionModel().getSelectedItem() != null) {
            ControlleurParticipation temp = new ControlleurParticipation();
            //iici modification de l'etat de particiapation 0->1
            temp.rejeter(Integer.parseInt(tvGestionParticipation.getSelectionModel().getSelectedItem().getIdparticipation()));
            inittab();
            /**
             * ici mette l'API mail
             */

        } else {
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("il faut selectionner un element de votre liste");
            alert.show();
        }
    }

    @FXML
    private void annuler(ActionEvent event) {
        Stage stage = (Stage) btnRetour.getScene().getWindow();
        stage.close();
    }

    public void inittab() {
        //initialisation de notre table view
        idparticipation.setCellValueFactory(new PropertyValueFactory("idparticipation"));
        typeConcour.setCellValueFactory(new PropertyValueFactory("typeConcour"));
        nbPlaceDispo.setCellValueFactory(new PropertyValueFactory("nbPlaceDispo"));
        typeAnimal.setCellValueFactory(new PropertyValueFactory("typeAnimal"));
        idAnimal.setCellValueFactory(new PropertyValueFactory("idAnimal"));
        adresseMembre.setCellValueFactory(new PropertyValueFactory("adresseMembre"));
        tvGestionParticipation.getItems().clear();

        //atribut pr la selection des participations
        ControlleurParticipation crtParticipation = new ControlleurParticipation();
        ArrayList<Participation> listeParticipation = ControlleurParticipation.getList();

        //attributs pour la selection du concours
        ControlleurConcour crtConcours = new ControlleurConcour();

        for (Participation participation : listeParticipation) {
            try {
                //recuperation du concours relative a la participation

                Concour tempConcours = crtConcours.getConcour2(participation.getIdConcour());
                Animal tempAnimal = crtParticipation.getAnimalviaid(participation.getIdAnimal());
                //ajout dans notre tab Vie
                int angham = tempConcours.getCapacite() - tempConcours.getNbparticipant();
                ParticipationAffectation temp = new ParticipationAffectation("" + participation.getIdParticipation(), tempConcours.getTypeConcour(), "" + angham, tempAnimal.getRace(), "" + tempAnimal.getIdAnimal(), "eamail");
                tvGestionParticipation.getItems().addAll(temp);
            } catch (Exception ex) {
                System.out.println("error ihmGestionParticipation ** " + ex.getMessage());
            }
        }
    }
}
