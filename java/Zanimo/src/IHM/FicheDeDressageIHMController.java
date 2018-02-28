/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entites.Animal;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.ControlleurAnimal;
import services.ControlleurChamps;
import services.ControlleurFicheDeDressage;

/**
 * FXML Controller class
 *
 * @author makni
 */
public class FicheDeDressageIHMController implements Initializable {

    @FXML
    private Text id_membre;
    @FXML
    private Label prop;
    private Label nom;
    @FXML
    private Label espece;
    @FXML
    private RadioButton male;
    @FXML
    private ToggleGroup genre;
    @FXML
    private RadioButton female;
    @FXML
    private Button ajouter;
    @FXML
    private Button annuler;
    private TextField photo;
    @FXML
    private DatePicker dated;
    @FXML
    private DatePicker dateF;
    @FXML
    private TextField id_dres;
    @FXML
    private TextField specialite;

    private TextField poids;
    @FXML
    private TextField despline;
    @FXML
    private TextField obeissance;
    @FXML
    private TextField accompagnement;
    @FXML
    private TextField interception;
    private final Label jobStatus = new Label();
    float note = 0;

    ControlleurFicheDeDressage cfdd = new ControlleurFicheDeDressage();
    @FXML
    private TableView<Animal> listeanimal;
    @FXML
    private TableColumn<Animal, Integer> id_anim;
    @FXML
    private TableColumn<Animal, String> nom_anim;
    @FXML
    private Button ajouteranim;
    ControlleurAnimal ca = new ControlleurAnimal();
    ArrayList<Animal> animals = ca.afficherAnimal();
    int id;
    @FXML
    private Button imprimer;
    @FXML
    private Label erreursp;
    @FXML
    private Label erreurdes;
    @FXML
    private Label erreurinterc;
    @FXML
    private Label erreuraco;
    @FXML
    private Label erreurobe;
    @FXML
    private Label erreurdeb;
    @FXML
    private Label erreurfin;
    @FXML
    private Label racelab;
    @FXML
    private Label nomlab;
    @FXML
    private Label poidslab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ajouter.setDisable(true);
        id_anim.setCellValueFactory(new PropertyValueFactory("id"));
        nom_anim.setCellValueFactory(new PropertyValueFactory("nom"));

        listeanimal.getItems().addAll(animals);
        listeanimal.setOnMouseClicked((event) -> {
            if (event.getClickCount() == 2) {
                Animal fs = listeanimal.getItems().get(listeanimal.getSelectionModel().getSelectedIndex());
                id = fs.getId();
                nomlab.setText("Nom : " + fs.getAnimal(id).getNom());
                prop.setText("Propritére : " + fs.getAnimal(id).getProprietaire());
                poidslab.setText("Poids : " + String.valueOf(fs.getAnimal(id).getPoids()));
                racelab.setText("Race : " + fs.getAnimal(id).getEspece());
                ajouter.setDisable(false);
            }
        });
        imprimer.setOnAction((ActionEvent event) -> {
            //printSetup(textArea, );
        });

    }

    private boolean verif() {
        ControlleurChamps cc = new ControlleurChamps();
        if (specialite.getText().isEmpty()) {
            erreursp.setText("* Specialité Vide");
        } else if (interception.getText().isEmpty()) {
            erreursp.setText("");
            erreurinterc.setText("Interception Vide");
        } else if (!cc.isNumber(interception.getText())) {
            erreursp.setText("");
            erreurinterc.setText("interception non Valide");
        } else if (despline.getText().isEmpty()) {
            erreursp.setText("");
            erreurinterc.setText("");
            erreurdes.setText("despline Vide");
        } else if (!cc.isNumber(despline.getText())) {
            erreursp.setText("");
            erreurinterc.setText("");
            erreurdes.setText("despline non Valide");
        } else if (accompagnement.getText().isEmpty()) {
            erreursp.setText("");
            erreurinterc.setText("");
            erreurdes.setText("");
            erreuraco.setText("accompagnement Vide");
        } else if (!cc.isNumber(accompagnement.getText())) {
            erreursp.setText("");
            erreurinterc.setText("");
            erreurdes.setText("");
            erreuraco.setText("accompagnement non Valide");
        } else if (obeissance.getText().isEmpty()) {
            erreursp.setText("");
            erreurinterc.setText("");
            erreurdes.setText("");
            erreuraco.setText("");
            erreurobe.setText("obeissance Vide");
        } else if (!cc.isNumber(obeissance.getText())) {
            erreursp.setText("");
            erreurinterc.setText("");
            erreurdes.setText("");
            erreuraco.setText("");
            erreurobe.setText("obeissance non Valide");
        } else if (dated.getValue().toString().isEmpty()) {
            erreursp.setText("");
            erreurinterc.setText("");
            erreurdes.setText("");
            erreuraco.setText("");
            erreurobe.setText("");
            erreurdeb.setText("Date debut vide");
        } else if (dateF.getValue().toString().isEmpty()) {
            erreursp.setText("");
            erreurinterc.setText("");
            erreurdes.setText("");
            erreuraco.setText("");
            erreurobe.setText("");
            erreurdeb.setText("");
            erreurfin.setText("Date fin vide");
        } else {
            erreursp.setText("");
            erreurinterc.setText("");
            erreurdes.setText("");
            erreuraco.setText("");
            erreurobe.setText("");
            erreurdeb.setText("");
            erreurfin.setText("");
            return true;
        }
        return false;

    }

    @FXML
    private void ajouter(ActionEvent event) throws ParseException {
        String gen;
        if (female.isSelected()) {
            gen = "Female";
        } else {
            gen = "Male";
        }
        if (verif()) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date datedeb = format.parse(dated.getValue().toString());
            Date datFin = format.parse(dateF.getValue().toString());
            if (datFin.before(datedeb)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setContentText("klhjkl");
                alert.showAndWait();

            } else {
                float ntotal = Float.parseFloat(despline.getText()) + Float.parseFloat(obeissance.getText()) + Float.parseFloat(accompagnement.getText()) + Float.parseFloat(interception.getText()) / 4;

                cfdd.ajouterFicheDeDressage(2, specialite.getText(), Float.parseFloat(despline.getText()), Float.parseFloat(obeissance.getText()), Float.parseFloat(accompagnement.getText()), Float.parseFloat(interception.getText()), ntotal, datedeb, datFin, id, 1);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("fiche de soin créer");
                alert.showAndWait();
            }
        }

    }

    @FXML
    private void annuler(ActionEvent event) {
    }

    private void printSetup(Node node, Stage owner) {
        // Create the PrinterJob
        PrinterJob job = PrinterJob.createPrinterJob();

        if (job == null) {
            return;
        }

        // Show the print setup dialog
        boolean proceed = job.showPrintDialog(owner);

        if (proceed) {
            print(job, node);
        }
    }

    private void print(PrinterJob job, Node node) {
        // Set the Job Status Message
        jobStatus.textProperty().bind(job.jobStatusProperty().asString());

        // Print the node
        boolean printed = job.printPage(node);

        if (printed) {
            job.endJob();
        }

    }

    @FXML
    private void imprimer(ActionEvent event) throws FileNotFoundException, DocumentException {

        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream("fiche de dressage.pdf"));
        doc.open();
        doc.add(new Paragraph("                             Fiche de Dressage:"));
        doc.add(new Paragraph("proprietére :" + prop.getText()));
        doc.add(new Paragraph("despline" + String.valueOf(despline.getText())));
        doc.add(new Paragraph("obeissance" + String.valueOf(obeissance.getText())));
        doc.add(new Paragraph("accompagnement" + String.valueOf(accompagnement.getText())));
        doc.add(new Paragraph("interception" + String.valueOf(interception.getText())));
        doc.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Fiche créer");
        alert.showAndWait();
        doc.close();
    }

}
