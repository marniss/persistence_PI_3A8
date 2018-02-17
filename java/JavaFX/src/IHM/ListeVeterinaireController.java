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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ControlleurListeVeterinaire;

/**
 * FXML Controller class
 *
 * @author pc asus
 */
public class ListeVeterinaireController implements Initializable {

    @FXML
    private TableView<ListeDesVetirinaires> listevet;
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

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ControlleurListeVeterinaire clv = new ControlleurListeVeterinaire();
        ArrayList<ListeDesVetirinaires> listeDesVetirinaireses = clv.displayList();

        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        photo.setCellValueFactory(new PropertyValueFactory<>("photo"));
        for (ListeDesVetirinaires vet : listeDesVetirinaireses) {
            System.out.println(vet);
            listevet.getItems().addAll(vet);

        }
    }

}
