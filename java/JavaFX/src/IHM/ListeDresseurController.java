/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.ListeDesDresseurs;
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
import services.ControlleurListeDresseur;

/**
 * FXML Controller class
 *
 * @author pc asus
 */
public class ListeDresseurController implements Initializable {

    @FXML
    private TableView<ListeDesDresseurs> listedress;
    @FXML
    private TableColumn<ListeDesDresseurs, String> nom;
    @FXML
    private TableColumn<ListeDesDresseurs, String> prenom;
    @FXML
    private TableColumn<ListeDesDresseurs, String> tel;
    @FXML
    private TableColumn<ListeDesDresseurs, String> adresse;
    @FXML
    private TableColumn<ListeDesDresseurs, String> mail;
    @FXML
    private TableColumn<ListeDesDresseurs, String> photo;
    ControlleurListeDresseur cld = new ControlleurListeDresseur();
    @FXML
    private Label nomvet;
    @FXML
    private Label note;
    @FXML
    private TextField lanote;
    @FXML
    private Button valide;
    public static int iddd = 1;
    @FXML
    private Rating rateDress;
    Float not;
    private int idnote;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rateDress.setDisable(true);
        ArrayList<ListeDesDresseurs> listedesdreArrayList = cld.displayList();
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        photo.setCellValueFactory(new PropertyValueFactory<>("photo"));

        for (ListeDesDresseurs dre : listedesdreArrayList) {
            System.out.println(dre);
            listedress.getItems().addAll(dre);
        }
        listedress.setOnMouseClicked(
        (event) -> {
            if (event.getClickCount() == 2) {
                ListeDresseurController.iddd = listedress.getItems().get(listedress.getSelectionModel().getSelectedIndex()).getId();
                nomvet.setText(listedress.getItems().get(listedress.getSelectionModel().getSelectedIndex()).getNom());
                idnote = listedress.getItems().get(listedress.getSelectionModel().getSelectedIndex()).getId_note();
                note.setText("" + cld.getLaNote(iddd));
                rateDress.setDisable(false);
                rateDress.setRating(cld.getLaNote(iddd));
            }
        }
        );
    }

    @FXML
    private void valider(ActionEvent event) {
        /* if (idnote != 0) {
            Float x = (Float.parseFloat(note.getText()) + not) / 2;
            System.out.println(x);
            cld.affecternote(x);
            rateDress.setDisable(true);
        } else {
            System.out.println("Vue");
            cld.ajouterNote(1, idnote, "");
            int numNote = cld.getLastidNote();
            listedress.getItems().get(listedress.getSelectionModel().getSelectedIndex()).setId_note(numNote);
            cld.affecteridnote(iddd, numNote);
            cld.affecternote(not);
            System.out.println(numNote);
            System.out.println("id note nuLL   " + idnote);

        }*/
        Float x = (cld.getLaNote(iddd) + not) / 2;
        System.out.println(x);
        cld.affecternote(x);
        rateDress.setDisable(true);

    }

    @FXML
    private void evaldress(MouseEvent event
    ) {
        not = (float) rateDress.getRating();
    }

}
