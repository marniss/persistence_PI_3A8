/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.FicheDeSoin;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.ControlleurChamps;
import services.ControlleurFicheDeSoin;

/**
 * FXML Controller class
 *
 * @author makni
 */
public class ConsulterFicheDeSoinIHMController implements Initializable {

    @FXML
    private TableView<FicheDeSoin> listeFicheDeSoin;
    @FXML
    private TableColumn<FicheDeSoin, Integer> id_f_soin;
    @FXML
    private TableColumn<FicheDeSoin, String> observation;

    @FXML
    private TableColumn<FicheDeSoin, String> medicament;

    @FXML
    private TableColumn<FicheDeSoin, String> prochainRDV;
    @FXML
    private TableColumn<FicheDeSoin, Integer> id_animal;
    public static int id_f_soin_modifier;

    @FXML
    private Button ajouter;
    @FXML
    private Button modifer;
    @FXML
    private Button annuler;
    @FXML
    private Button supprimer;
    @FXML
    private Label id_membre;
    @FXML
    private TextArea observ;
    @FXML
    private DatePicker prchRDV;
    @FXML
    private TextField medi;
    ControlleurFicheDeSoin cfds = new ControlleurFicheDeSoin();
    int id;
    int idanim;
    @FXML
    private Label erreurobserv;
    @FXML
    private Label erreurdaterdv;
    @FXML
    private Label erreurMedi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /**
         * Instanciation Du Controlleur*
         */
        ArrayList<FicheDeSoin> ficheDeSoins = cfds.ConsulterFicheDeSoin();
        /*
         *Deffinition des Colonnes
         */
        id_f_soin.setCellValueFactory(new PropertyValueFactory("id_f_Soin"));
        observation.setCellValueFactory(new PropertyValueFactory("observation"));
        medicament.setCellValueFactory(new PropertyValueFactory("medicament"));
        prochainRDV.setCellValueFactory(new PropertyValueFactory("prochainRDV"));
        id_animal.setCellValueFactory(new PropertyValueFactory("id_animal"));

        for (FicheDeSoin fs : ficheDeSoins) {
            listeFicheDeSoin.getItems().addAll(fs);

        }
        listeFicheDeSoin.setOnMouseClicked((event) -> {

            if (event.getClickCount() == 2) {
                FicheDeSoin fs = listeFicheDeSoin.getItems().get(listeFicheDeSoin.getSelectionModel().getSelectedIndex());
                observ.setText(fs.getObservation());
                LocalDate lc = LocalDate.parse(fs.getProchainRDV().toString());
                prchRDV.setValue(lc);
                medi.setText(fs.getMedicament());
                id = fs.getId_f_Soin();
                idanim = fs.getId_animal();

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
        } else if (prchRDV.getValue().toString().isEmpty()) {
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

    private void modifier(ActionEvent event) throws ParseException {
        if (verif()) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date prcv = format.parse(prchRDV.getValue().toString());
            cfds.modifierFicheDeSoin(id, 2, observ.getText(), medi.getText(), prcv, idanim);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("fiche de soin modifer");
            alert.showAndWait();

        }

    }

    @FXML
    private void annuler(ActionEvent event) {
    }

    @FXML
    private void supp(ActionEvent event) {
        cfds.updateFicheDeSoin(listeFicheDeSoin.getItems().get(listeFicheDeSoin.getSelectionModel().getSelectedIndex()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("fiche de soin supprimer");
        alert.showAndWait();
        listeFicheDeSoin.getItems().remove(listeFicheDeSoin.getSelectionModel().getSelectedIndex());
    }

    @FXML
    private void ajouter(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/IHM/FicheDeSoinIHM.fxml"));
        try {
            Parent root = (Parent) loader.load();
            FicheDeSoinIHMController control = loader.getController();
            Stage window;
            window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(new Scene(root));
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(ConsulterFicheDeSoinIHMController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
