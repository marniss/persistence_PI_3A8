/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.ListeDesVetirinaires;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import services.ControlleurChamps;
import services.ControlleurListeVeterinaire;

/**
 * FXML Controller class
 *
 * @author makni
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
    ArrayList<ListeDesVetirinaires> listedesvetArrayList = clv.displayList();
    private int id;
    @FXML
    private Label erreurnom;
    @FXML
    private Label erreurpre;
    @FXML
    private Label erreurtel;
    @FXML
    private Label erreurmail;
    @FXML
    private Label erreuradres;
    @FXML
    private TextField find;

    private boolean verif() {
        ControlleurChamps cc = new ControlleurChamps();
        if (nomtext.getText().isEmpty()) {
            erreurnom.setText("* Nom Vide");
        } else if (!cc.isName(nomtext.getText())) {
            erreurnom.setText("* il faut un Nom valide");
        } else if (prenomtext.getText().isEmpty()) {
            erreurnom.setText("");
            erreurpre.setText("* Prenom Vide");
        } else if (!cc.isName(prenomtext.getText())) {
            erreurnom.setText("");
            erreurpre.setText("* il faut un Prenom valide");
        } else if (teltext.getText().isEmpty()) {
            erreurnom.setText("");
            erreurpre.setText("");
            erreurtel.setText("* Tel Vide");
        } else if (!cc.isNumber(teltext.getText())) {
            erreurnom.setText("");
            erreurpre.setText("");
            erreurtel.setText("* il faut un tel valide");
        } else if (adressetext.getText().isEmpty()) {
            erreurnom.setText("");
            erreurpre.setText("");
            erreurtel.setText("");
            erreuradres.setText("* Adresse Vide");
        } else if (mailtext.getText().isEmpty()) {
            erreurnom.setText("");
            erreurpre.setText("");
            erreurtel.setText("");
            erreuradres.setText("");
            erreurmail.setText("* Mail Vide");
        } else if (!cc.isEmail(mailtext.getText())) {
            erreurnom.setText("");
            erreurpre.setText("");
            erreurtel.setText("");
            erreuradres.setText("");
            erreurmail.setText("* il faut un Email valide");
        } else {
            erreurnom.setText("");
            erreurpre.setText("");
            erreurtel.setText("");
            erreuradres.setText("");
            erreurmail.setText("");
            return true;
        }
        return false;
    }

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        photo.setCellValueFactory(new PropertyValueFactory<>("photo"));

        listedvet.getItems().addAll(listedesvetArrayList);

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
                ajouter.setDisable(true);
            }

        });
    }

    public ArrayList<ListeDesVetirinaires> recherche(String x) {
        List<ListeDesVetirinaires> vet = listedvet.getItems().stream().filter(
        t -> t.getNom().startsWith(x)
        || t.getPrenom().startsWith(x)
        || t.getTel().startsWith(x)
        || t.getAdresse().startsWith(x)
        || t.getMail().startsWith(x)
        ).collect(Collectors.toList());

        return (ArrayList<ListeDesVetirinaires>) vet;

    }

    @FXML
    private void supprimer(ActionEvent event) {

        clv.supprimerVeterinaire(listedvet.getItems().get(listedvet.getSelectionModel().getSelectedIndex()));
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Voulez-vous supprimer ?");
        alert.showAndWait();
        ref();
    }

    @FXML
    private void modifier(ActionEvent event) {
        if (verif()) {
            clv.modifierVeterinaire(id, nomtext.getText(), prenomtext.getText(), teltext.getText(), adressetext.getText(), mailtext.getText(), phototext.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Veterinaire Modifier");
            alert.showAndWait();
            ref();

        }

    }

    @FXML
    private void ajouter(ActionEvent event) {
        if (verif()) {
            clv.ajouterVeteriniare(nomtext.getText(), prenomtext.getText(), teltext.getText(), adressetext.getText(), mailtext.getText(), phototext.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Veterinaire Ajouter");
            alert.showAndWait();
            ref();
        }

    }

    public void ref() {
        listedvet.getItems().clear();
        listedvet.getItems().addAll(clv.displayList());

    }

    @FXML
    private void Annuler(ActionEvent event) {
        nomtext.setText("");
        prenomtext.setText("");
        teltext.setText("");
        adressetext.setText("");
        mailtext.setText("");
        phototext.setText("");
        ajouter.setDisable(false);
    }

    @FXML
    private void brouse(ActionEvent event
    ) {
    }

    @FXML
    private void findAc(KeyEvent event) {
        String mot = find.getText();
        if (mot.length() > 0) {
            List<ListeDesVetirinaires> vet = recherche(mot);
            listedvet.getItems().clear();
            listedvet.getItems().addAll(vet);
        } else {
            listedvet.getItems().clear();
            listedvet.getItems().addAll(clv.displayList());
        }
    }

}
