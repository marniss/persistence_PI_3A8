/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Animal;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import services.ControlleurAnimal;
import services.ControlleurChamps;
import services.ControlleurFicheDeSoin;

/**
 * FXML Controller class
 *
 * @author pc makni
 */
public class FicheDeSoinIHMController implements Initializable {

    @FXML
    private Text id_membre;

    @FXML
    private TextField nom;
    @FXML
    private TextField espece;
    @FXML
    private TextArea observation;
    @FXML
    private TextField poids;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private Text id_f_Soin;
    @FXML
    private TextField medi;
    @FXML
    private Button annuler;
    @FXML
    private TextField photo;

    @FXML
    private DatePicker nele;
    @FXML
    private DatePicker datep;
    @FXML
    private DatePicker revoirerdv;

    @FXML
    private Button brouse;

    @FXML
    ToggleGroup genre;
    @FXML
    private TextField id_vete;
    @FXML
    private Button ajouterFiche;
    @FXML
    private TextField prop;
    @FXML
    private TableView<Animal> listeanimal;
    @FXML
    private TableColumn<Animal, Integer> id_anim;
    @FXML
    private TableColumn<Animal, String> nom_anim;
    ControlleurAnimal ca = new ControlleurAnimal();
    ArrayList<Animal> animals = ca.afficherAnimal();
    int id;
    @FXML
    private Button ajouteranim;
    @FXML
    private Label erreurobserv;
    @FXML
    private Label erreurdaterdv;
    @FXML
    private Label erreurMedi;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        id_anim.setCellValueFactory(new PropertyValueFactory("id"));
        nom_anim.setCellValueFactory(new PropertyValueFactory("nom"));
        for (Animal anim : animals) {
            listeanimal.getItems().addAll(anim);
            System.out.println(anim);
            System.out.println("animal Vue");
        }
        listeanimal.setOnMouseClicked((event) -> {
            if (event.getClickCount() == 2) {

                Animal fs = listeanimal.getItems().get(listeanimal.getSelectionModel().getSelectedIndex());
                id = fs.getId();
                nom.setText(fs.getAnimal(id).getNom());
                prop.setText(fs.getAnimal(id).getProprietaire());
                poids.setText(String.valueOf(fs.getAnimal(id).getPoids()));
                photo.setText(fs.getAnimal(id).getPhoto());
                espece.setText(fs.getAnimal(id).getEspece());
                System.out.println("Noooooom +" + fs.getAnimal(id).getNom());
                System.out.println("Noooooom +" + fs.getAnimal(id).getProprietaire());

            }
        });

    }

    private boolean verif() {
        ControlleurChamps cc = new ControlleurChamps();
        if (medi.getText().isEmpty()) {
            erreurMedi.setText("* Medicament Vide");
        } else if (observation.getText().isEmpty()) {
            erreurMedi.setText("");
            erreurobserv.setText("* Observation Vide");
        } else if (revoirerdv.getValue().toString().isEmpty()) {
            erreurMedi.setText("");
            erreurobserv.setText("");
            erreurdaterdv.setText("*Date vide");
        } else {
            erreurMedi.setText("");
            erreurobserv.setText("");
            erreurdaterdv.setText("");
            return true;
        }
        return false;

    }

    @FXML
    private void medi(MouseEvent event) {
    }

    @FXML
    private void annuler(ActionEvent event) {
    }

    @FXML
    private void brouse(ActionEvent event) {
    }

    @FXML
    private void ajouterFicheSoin(ActionEvent event) throws ParseException {
        ControlleurFicheDeSoin cfds = new ControlleurFicheDeSoin();
        String gen;
        if (female.isSelected()) {
            gen = "Female";
        } else {
            gen = "Male";
        }
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Date dateRDV = formater.parse(revoirerdv.getValue().toString());
        System.out.println("3*******" + revoirerdv.getValue() + dateRDV/*dateRDV*/);
        if (verif()) {
            cfds.ajouterFicheDeSoin(1, observation.getText(), medi.getText(), dateRDV, id, 1);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("fiche de dressage créer");
            alert.showAndWait();
        }

    }

    @FXML
    private void ajouteranim(ActionEvent event) {
    }

}
