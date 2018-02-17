/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.ListeDesVetirinaires;
import java.net.URL;
import java.util.ArrayList;
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
import services.ControlleurListeVeterinaire;

/**
 * FXML Controller class
 *
 * @author pc asus
 */
public class ListeDesVeterinaireAdminController implements Initializable {

    @FXML
    private TableView<ListeDesVetirinaires> listedvet;
    @FXML
    private TableColumn<ListeDesVetirinaires, String> nom;
    @FXML
    private TableColumn<ListeDesVetirinaires, String> prenom;
    @FXML
    private TableColumn<ListeDesVetirinaires, String> tel;
    @FXML
    private TableColumn<ListeDesVetirinaires, String> adresse;
    @FXML
    private TableColumn<ListeDesVetirinaires, String> mail;
    @FXML
    private TableColumn<ListeDesVetirinaires, String> photo;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private Button ajouter;
    @FXML
    private Button Annuler;
    @FXML
    private TextField nomtext;
    @FXML
    private TextField prenomtext;
    @FXML
    private TextField teltext;
    @FXML
    private TextField adressetext;
    @FXML
    private TextField mailtext;
    @FXML
    private TextField phototext;
    @FXML
    private Button brouse;
    ControlleurListeVeterinaire clv = new ControlleurListeVeterinaire();
    private int id;

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<ListeDesVetirinaires> listedesvetArrayList = clv.displayList();
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        photo.setCellValueFactory(new PropertyValueFactory<>("photo"));
        for (ListeDesVetirinaires vet : listedesvetArrayList) {
            listedvet.getItems().addAll(vet);

        }
        listedvet.setOnMouseClicked((event) -> {
            if (event.getClickCount() == 2) {
                ListeDesVetirinaires vetirinaire = listedvet.getItems().get(listedvet.getSelectionModel().getSelectedIndex());
                nomtext.setText(vetirinaire.getNom());
                prenomtext.setText(vetirinaire.getPrenom());
                teltext.setText(vetirinaire.getTel());
                adressetext.setText(vetirinaire.getAdresse());
                mailtext.setText(vetirinaire.getMail());
                phototext.setText(vetirinaire.getPhoto());
                id = vetirinaire.getId();
            }

        });
    }

    @FXML
    private void supprimer(ActionEvent event) {

        clv.supprimerVeterinaire(listedvet.getItems().get(listedvet.getSelectionModel().getSelectedIndex()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Veterinaire Supprimer");
        alert.showAndWait();
    }

    @FXML
    private void modifier(ActionEvent event) {
        clv.modifierVeterinaire(id, nomtext.getText(), prenomtext.getText(), teltext.getText(), adressetext.getText(), mailtext.getText(), phototext.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Veterinaire Modifier");
        alert.showAndWait();
    }

    @FXML
    private void ajouter(ActionEvent event) {
        clv.ajouterVeteriniare(nomtext.getText(), prenomtext.getText(), teltext.getText(), adressetext.getText(), mailtext.getText(), phototext.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Veterinaire Ajouter");
        alert.showAndWait();
    }

    @FXML
    private void Annuler(ActionEvent event) {
    }

    @FXML
    private void brouse(ActionEvent event) {
    }

}
