/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.ListeDesDresseurs;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import services.ControlleurChamps;
import services.ControlleurListeDresseur;

/**
 * FXML Controller class
 *
 * @author makni
 */
public class ListeDresseurAdminController implements Initializable {

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
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private Button ajouter;
    @FXML
    private Button Annuler;
    @FXML
    private Button brouse;
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
    URL url;
    ResourceBundle rb;
    private static int id;
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
    ArrayList<ListeDesDresseurs> listedesdreArrayList = cld.displayList();
    @FXML
    private TextField find;

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

        listedress.getItems().addAll(listedesdreArrayList);

        listedress.setOnMouseClicked((event) -> {
            if ((event.getClickCount() == 2)) {
                ListeDesDresseurs dresseur = listedress.getItems().get(listedress.getSelectionModel().getSelectedIndex());
                nomtext.setText(dresseur.getNom());
                prenomtext.setText(dresseur.getPrenom());
                teltext.setText(dresseur.getTel());
                adressetext.setText(dresseur.getAdresse());
                mailtext.setText(dresseur.getMail());
                phototext.setText(dresseur.getPhoto());
                id = dresseur.getId();
                ajouter.setDisable(true);

            }
        });
    }

    @FXML
    private void supprimer(ActionEvent event) {
        cld.supprimerDresseur(listedress.getItems().get(listedress.getSelectionModel().getSelectedIndex()));
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

            System.out.println("modifier" + id);
            cld.modifierDresseur(id, nomtext.getText(), prenomtext.getText(), teltext.getText(), adressetext.getText(), mailtext.getText(), phototext.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Dresseur Modifier");
            alert.showAndWait();
            ref();
            ajouter.setDisable(false);

        }

    }

    @FXML
    private void ajouter(ActionEvent event) {
        if (verif()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            cld.ajouterDresseur(nomtext.getText(), prenomtext.getText(), teltext.getText(), adressetext.getText(), mailtext.getText(), phototext.getText());
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Dresseur Ajouter");
            alert.showAndWait();
            ref();

        }

    }

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

    @FXML
    private void Annuler(ActionEvent event
    ) {
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

    public void ref() {
        listedress.getItems().clear();
        listedress.getItems().addAll(cld.displayList());

    }

    public ArrayList<ListeDesDresseurs> recherche(String x) {
        return (ArrayList<ListeDesDresseurs>) listedress.getItems().stream().filter(
        t -> t.getNom().startsWith(x)
        || t.getPrenom().startsWith(x)
        || t.getTel().startsWith(x)
        || t.getAdresse().startsWith(x)
        || t.getMail().startsWith(x)
        ).collect(Collectors.toList());

    }

    @FXML
    private void findAc(KeyEvent event) {
        String mot = find.getText();
        if (mot.length() > 0) {
            List<ListeDesDresseurs> vet = recherche(mot);
            listedress.getItems().clear();
            listedress.getItems().addAll(vet);
        } else {
            listedress.getItems().clear();
            listedress.getItems().addAll(cld.displayList());
        }
    }

}
