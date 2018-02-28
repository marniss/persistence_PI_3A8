/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Animal;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import services.DataSource;

/**
 * FXML Controller class
 *
 * @author salah
 */
//*************************************************************************************************************
//CLASS Animal
//*************************************************************************************************************
public class IHM_List_AnimalController implements Initializable {

    Animal ani = new Animal();
    ArrayList<Animal> animals = ani.selectAll();
    ObservableList<Animal> animal = FXCollections.observableArrayList(animals);

    @FXML
    private TableView<Animal> tab;
    @FXML
    private TableColumn<Animal, String> type;
    @FXML
    private Button supprimee;
    @FXML
    private TableColumn<Animal, String> nom;
    @FXML
    private TableColumn<Animal, String> race;
    @FXML
    private TableColumn<Animal, String> date;
    @FXML
    private TableColumn<Animal, String> description;
    private TextField new_date;
    @FXML
    private TextField new_race;
    @FXML
    private TextField new_name;
    @FXML
    private TextField new_type;
    private TextField new_id_sos;
    private TextField new_id_adoption;
    private TextField desc;
    @FXML
    private TextField chercheField;
    @FXML
    private TextArea new_description;
    @FXML
    private TableColumn<Animal, Integer> id;
    @FXML
    private TableColumn<Animal, Double> poid;
    @FXML
    private TextField new_poid;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
//*************************************************************************************************************
//*              INITIALIZE                                                                                   *
//*************************************************************************************************************
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* ImageView image;
        int i=0;
        
                for (Animal a : ani.selectAll()){
                    i++;
                    image = new ImageView("Image/"+i+".jpg");
                    System.out.println(image);
                    image.setFitHeight(60.0);
                    image.setFitWidth(50.0);
                    animal.add(new Animal(a.getType(),a.getNom(),a.getRace(),a.getDate_naissance(),a.getDescription()));

                }
     
         */
        for (Animal a : animals) {

            id.setCellValueFactory(new PropertyValueFactory<>("idAnimal"));
            type.setCellValueFactory(new PropertyValueFactory<>("type"));
            nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            race.setCellValueFactory(new PropertyValueFactory<>("race"));
            date.setCellValueFactory(new PropertyValueFactory<>("date_naissance"));
            description.setCellValueFactory(new PropertyValueFactory<>("description"));
            poid.setCellValueFactory(new PropertyValueFactory<>("poid"));
            // photo.setCellValueFactory(new PropertyValueFactory<>("image"));
            tab.getItems().addAll(a);
            //tab.getItems().add(a);

        }
        initial();

    }

    //*************************************************************************************************************
//*              RECHERCHER                                                                                   *
//*************************************************************************************************************
    private void initial() {
        FilteredList<Animal> filteredData = new FilteredList<>(animal, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        chercheField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(ev -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                try {
                    if (ev.getNom().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches first name.
                    } else if (ev.getNom().contains(lowerCaseFilter))/*.toLowerCase().contains(lowerCaseFilter)) */ {
                        return true; // Filter matches last name.
                    }
                       if (Double.toString(ev.getPoid()).contains(lowerCaseFilter)) {
                            return true;
                         } 
                       if (ev.getDate_naissance().toString().contains(lowerCaseFilter)) {
                            return true;}
                        
                    return false; // Does not match.
                } catch (NullPointerException ex) {
                    System.out.println(ex.toString());
                }
                return false;
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Animal> sortedData = new SortedList<>(filteredData);
        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(tab.comparatorProperty());
        // 5. Add sorted (and filtered) data to the table.
        tab.setItems(sortedData);
    }

//    *************************************************************************************************************
//    *          ACTUALISER                                                                                       *
//    *************************************************************************************************************
    private void ref() {
        animal.clear();
        animal.addAll(ani.selectAll());
        tab.setItems(animal);
    }

//    **************************************************************************************************************
//    *             SUPPRIMER                                                                                      *
//    **************************************************************************************************************
    @FXML
    private void supprimee(ActionEvent event) {
        Animal a = new Animal();
        int id = tab.getSelectionModel().getSelectedItem().getIdAnimal();

        a.supprimer(id);
        tab.getSelectionModel().clearSelection();
        tab.getItems().remove(animal);
        Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setTitle("INFORMATION");
        al.setHeaderText(null);
        al.setContentText("Publication supprimée");
        al.showAndWait();
        ref();
    }

    @FXML
    private void modifier(ActionEvent event) {

        DataSource conn = DataSource.getInstance();
        Animal a = new Animal();

        String race = new_race.getText();
        String type = new_type.getText();
        String name = new_name.getText();
        String descrip = new_description.getText();
        String poid =new_poid.getText();
        int id = tab.getSelectionModel().getSelectedItem().getIdAnimal();
        try {
            Statement prep = conn.getConnection().createStatement();

            String resi = "UPDATE `animal` SET  `type`='" + type + "',`nom`='" + name + "',`race`='" + race + "',`description`='" + descrip + "',`poid`= '"+poid+"' WHERE `id_animal`=" + id;
            System.out.println(resi);
            prep.executeUpdate(resi);
            ref();
            System.out.println("update done");
            System.out.println(resi);
        } catch (SQLException ex) {

            System.out.println("update error   " + ex.getCause());
        }

    }

    @FXML
    private void fill(MouseEvent event) {

        String t = tab.getSelectionModel().getSelectedItem().getType();
        String n = tab.getSelectionModel().getSelectedItem().getNom();
        String r = tab.getSelectionModel().getSelectedItem().getRace();
        String d = tab.getSelectionModel().getSelectedItem().getDescription();
        Double p = tab.getSelectionModel().getSelectedItem().getPoid();
        
        new_poid.setText("" + p);
        new_type.setText(t);
        new_name.setText(n);
        new_race.setText(r);
        new_description.setText(d);

    }

}
