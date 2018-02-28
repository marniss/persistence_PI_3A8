/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Participation;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.ControlleurParticipation;

/**
 * FXML Controller class
 *
 * @author angham
 */
public class IHM_Liste_ParticipationController implements Initializable {

    private TableView<Participation> table1;
    private TableColumn<Participation, String> idParticipation;
    private TableColumn<Participation, String> idAnimal;
    private TableColumn<Participation, String> idConcours;
    @FXML
    private Button annuler;
    private TextField modifieranimal;
    private TextField modifierconcour;
    @FXML
    private Button btntest;
    @FXML
    private Button btnApprouver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

     /*   ControlleurParticipation cp = new ControlleurParticipation();
        for (Participation p : cp.selectAll()) {
            idParticipation.setCellValueFactory(new PropertyValueFactory<>("idParticipation"));
            idAnimal.setCellValueFactory(new PropertyValueFactory<>("idAnimal"));
            idConcours.setCellValueFactory(new PropertyValueFactory<>("idConcour"));
            table1.getItems().add(p);
        }
        Participation p = table1.getSelectionModel().getSelectedItem();*/

    }

    private void supprimer(ActionEvent event) {
        Participation p = table1.getSelectionModel().getSelectedItem();
        ControlleurParticipation cp = new ControlleurParticipation();
        int a = cp.supprimerParticipation(p);
    }

    private void modifier(ActionEvent event) {
        Participation p = table1.getSelectionModel().getSelectedItem();
        int idd = Integer.parseInt(modifieranimal.getText());
        int idd2 = Integer.parseInt(modifierconcour.getText());
        p.setIdConcour(idd);
        p.setIdAnimal(idd2);
        ControlleurParticipation cp = new ControlleurParticipation();

        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("selectionner un participant");
        } else {
            cp.modifierParticipation(p, p.getIdParticipation());
        }
    }

    private void ajouter(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("IHM_Ajouter_Participation.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void annuler(ActionEvent event) {
    }

    @FXML
    private void testeraaaaaaaaaaa(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("IHM_Liste_Concour_Parti.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(IHM_Liste_ParticipationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void onClickApprouver(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("IHM_Gerer_Participation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(IHM_Liste_ParticipationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
