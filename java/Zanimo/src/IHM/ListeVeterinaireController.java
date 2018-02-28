/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.Rating;
import services.ControlleurListeVeterinaire;

/**
 * FXML Controller class
 *
 * @author makni
 */
public class ListeVeterinaireController implements Initializable, MapComponentInitializedListener {

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
    private Button valide;
    public static int iddd = 1;
    ControlleurListeVeterinaire clv = new ControlleurListeVeterinaire();
    ArrayList<ListeDesVetirinaires> listeDesVetirinaireses = clv.displayList();
    @FXML
    private Rating rateVet;
    float not;
    private int idnote;
    @FXML
    private AnchorPane mapGoogle;
    @FXML
    private GoogleMapView gmap;
    private GoogleMap map;
    @FXML
    private Button mapi;

    private GeocodingService G;

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        rateVet.setDisable(true);
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        photo.setCellValueFactory(new PropertyValueFactory<>("photo"));

        listevet.getItems().addAll(clv.displayList());

        listevet.setOnMouseClicked(
        (event) -> {
            if (event.getClickCount() == 2) {
                ListeVeterinaireController.iddd = listevet.getItems().get(listevet.getSelectionModel().getSelectedIndex()).getId();
                nomvet.setText(listevet.getItems().get(listevet.getSelectionModel().getSelectedIndex()).getNom());
                idnote = listevet.getItems().get(listevet.getSelectionModel().getSelectedIndex()).getId_note();
                note.setText("" + clv.getLaNote(iddd));
                rateVet.setDisable(false);
                rateVet.setRating(clv.getLaNote(iddd));
                mapGoogle.setVisible(true);
                mapInitialized();
            }
        }
        );
    }

    public ArrayList<ListeDesVetirinaires> recherche(String x) {
        return (ArrayList<ListeDesVetirinaires>) listevet.getItems().stream().filter(
        t -> t.getNom().startsWith(x)
        || t.getPrenom().startsWith(x)
        || t.getTel().startsWith(x)
        || t.getAdresse().startsWith(x)
        || t.getMail().startsWith(x)
        ).collect(Collectors.toList());

    }

    @FXML
    private void valider(ActionEvent event) {

        Float x = (clv.getLaNote(iddd) + not) / 2;
        System.out.println(x);
        clv.affecternote(x);
        rateVet.setDisable(true);
        ref();

    }

    @FXML
    private void evalvet(MouseEvent event) {
        not = (float) rateVet.getRating();
    }

    @Override
    public void mapInitialized() {
        try {

            createMap();
            ListeDesVetirinaires e = listevet.getSelectionModel().getSelectedItem();
            String L = e.getAdresse();
            System.out.println(L);

            G.geocode(L, (GeocodingResult[] results, GeocoderStatus status) -> {
                LatLong latLong = null;

                if (status == GeocoderStatus.ZERO_RESULTS) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
                    alert.show();
                    return;
                } else if (results.length > 1) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                    alert.show();
                    latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
                } else {
                    latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
                    MarkerOptions markerOptions = new MarkerOptions();
                    System.out.println("result LG " + latLong.getLongitude() + "   " + latLong.getLatitude());
                    markerOptions.position(latLong)
                    .visible(Boolean.TRUE)
                    .title("My Marker");

                    Marker marker = new Marker(markerOptions);
                    map.addMarker(marker);

                }

                map.setCenter(latLong);
            }
            );
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void createMap() {

        map = new GoogleMap();
        G = new GeocodingService();
        MapOptions mapOptions = new MapOptions();
        mapOptions.center(new LatLong(33.8869, 9.5375))
        .mapType(MapTypeIdEnum.ROADMAP)
        .overviewMapControl(true)
        .panControl(true)
        .rotateControl(true)
        .scaleControl(true)
        .streetViewControl(true)
        .zoomControl(true)
        .zoom(15);

        map = gmap.createMap(mapOptions);
    }

    @FXML
    private void mapi(ActionEvent event) {

    }

    public void ref() {
        listevet.getItems().clear();
        listevet.getItems().addAll(clv.displayList());

    }
}
