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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.ControlleurNoteVeterinaire;

/**
 * FXML Controller class
 *
 * @author makni
 */
public class NoteVetIHMController implements Initializable {

    @FXML
    private TextField id_membre;
    @FXML
    private TextArea observation;
    @FXML
    private TextField note;
    @FXML
    private Label moyenne;
    @FXML
    private Button valider;
    @FXML
    private Button annuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Vue Initial");
        ControlleurNoteVeterinaire cnv = new ControlleurNoteVeterinaire();
        // moyenne.setText("Notes est  " + cnv.moyenneNote());
        System.out.println("La Moyenne des Notes est  *******************" + cnv.moyenneNote());
        System.out.println("IHM   [" + cnv.moyenneNote().length() + "]");
        moyenne.setText(cnv.moyenneNote());
    }

    @FXML
    private void valider(ActionEvent event) {
        ControlleurNoteVeterinaire cnv = new ControlleurNoteVeterinaire();
        cnv.ajouterNote(Integer.parseInt(id_membre.getText()), Float.parseFloat(note.getText()), observation.getText());
        System.out.println("Vue");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Note Ajouter");
        alert.showAndWait();
    }

    @FXML
    private void annuler(ActionEvent event) {
    }

}
