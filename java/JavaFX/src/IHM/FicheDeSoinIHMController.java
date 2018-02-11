/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author pc makni
 */
public class FicheDeSoinIHMController implements Initializable {

    @FXML
    private Button ajouter;
    @FXML
    private Button annuler;
    @FXML
    private Text id_membre;
    @FXML
    private TextField prop;
    @FXML
    private TextField nom;
    @FXML
    private TextField espece;
    @FXML
    private TextField poids;
    @FXML
    private TextField race;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton femmel;
    @FXML
    private DatePicker neLe;
    @FXML
    private DatePicker datePoids;
    @FXML
    private DatePicker revoireLe;
    @FXML
    private ListView<String> medicament;
    @FXML
    private Text id_f_Soin;
    @FXML
    private Button btn;
    @FXML
    private TextField medi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajouter(ActionEvent event) {
    }

    @FXML
    private void annuler(ActionEvent event) {
    }

    @FXML
    private void btn(ActionEvent event) {

        btn.setOnAction(e -> {
            String ahmed = medi.getText();
            medicament.getItems().add(ahmed);
        });
    }

    @FXML
    private void medi(ActionEvent event) {
    }

    @FXML
    private void ajouter(MouseEvent event) {

    }

}
