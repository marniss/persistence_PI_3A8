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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Rating;
import services.ControlleurListeVeterinaire;
import services.ControlleurNoteVeterinaire;

/**
 * FXML Controller class
 *
 * @author makni
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
    @FXML
    private Label nomvet;
    @FXML
    private Label note;
    @FXML
    private TextField lanote;
    @FXML
    private Button valide;
    public static int iddd = 1;
    ControlleurListeVeterinaire clv = new ControlleurListeVeterinaire();
    @FXML
    private Rating rateVet;
    float not;
    private int idnote;

    /*
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ArrayList<ListeDesVetirinaires> listeDesVetirinaireses = clv.displayList();
        rateVet.setDisable(true);
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
        listevet.setOnMouseClicked(
        (event) -> {
            if (event.getClickCount() == 2) {
                ListeVeterinaireController.iddd = listevet.getItems().get(listevet.getSelectionModel().getSelectedIndex()).getId();
                nomvet.setText(listevet.getItems().get(listevet.getSelectionModel().getSelectedIndex()).getNom());
                idnote = listevet.getItems().get(listevet.getSelectionModel().getSelectedIndex()).getId_note();
                note.setText("" + clv.getLaNote(iddd));
                rateVet.setDisable(false);
                rateVet.setRating(clv.getLaNote(iddd));
            }
        }
        );
    }

    @FXML
    private void valider(ActionEvent event) {
        /*
        if (idnote != 0) {
            Float x = (clv.getLaNote(iddd) + not) / 2;
            System.out.println(x);
            clv.affecternote(x);
            rateVet.setDisable(true);
        } else {
            clv.ajouterNote(1, idnote, "");
            int numNote = clv.getLastidNote();
            listevet.getItems().get(listevet.getSelectionModel().getSelectedIndex()).setId_note(numNote);
            clv.affecteridnote(iddd, numNote);
            clv.affecternote(not);
            System.out.println(numNote);
            System.out.println("id note nuLL   " + idnote);
        }*/
        Float x = (clv.getLaNote(iddd) + not) / 2;
        System.out.println(x);
        clv.affecternote(x);
        rateVet.setDisable(true);

    }

    @FXML
    private void evalvet(MouseEvent event) {
        not = (float) rateVet.getRating();
    }
}
