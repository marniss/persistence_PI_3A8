/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import entites.Accessoire;
import entites.Nourriture;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.ServiceAccessoire;
import services.ServiceNourriture;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class ModuleCommercialController implements Initializable {

    @FXML
    private Button affAcc;
    @FXML
    private Button affNou;
    @FXML
    private Button btnAjouterAccessoire;
    @FXML
    private Button btnAjouterNourriture;
    @FXML
    private HBox hboxxx;
    @FXML
    private HBox hbox2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        affichageintial();
        if (IHM_loginController.membre == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ti connectiiii");
            // alert.setHeaderText(null);
            alert.setContentText("vous pouver s'inscrire pour plus de fonctionalités \n Merci ");
            alert.showAndWait();
            btnAjouterAccessoire.setVisible(false);
            btnAjouterNourriture.setVisible(false);
        } else {
            if (IHM_loginController.membre.getType().equals("membre") || IHM_loginController.membre.getType().equals("Admin")) {
                btnAjouterAccessoire.setVisible(true);
                btnAjouterNourriture.setVisible(true);
            }

        }
    }

    @FXML
    private void affAcc(ActionEvent event
    ) {

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("IHM_Listing_Accessoire.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException o) {
            o.getMessage();
        }

    }

    @FXML
    private void affNou(ActionEvent event
    ) {

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("IHM_Listing_Nourriture.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException o) {
            o.getMessage();
        }
    }

    @FXML
    private void ajouterAccessoire(ActionEvent event
    ) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("IHM_Ajouter_Accessoire.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException o) {
            o.getMessage();
        }
    }

    @FXML
    private void ajouterNourriture(ActionEvent event
    ) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Ihm_Ajouter_Nourriture.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException o) {
            o.getMessage();
        }
    }

    private void affichageintial() {
        ServiceAccessoire services = new ServiceAccessoire();
        ArrayList<Accessoire> temp = services.listingAccessoire();
        ArrayList<Accessoire> hahahouhou = temp.stream().skip(temp.size() - 5).collect(Collectors.toCollection(ArrayList::new));
        VBox vbtemp1 = null;
        for (Accessoire e : hahahouhou) {
            //modification du VBox fils

            //creation de la  imageview
            vbtemp1 = new VBox();
            vbtemp1.setPrefHeight(50);
            vbtemp1.setPrefWidth(1000);
            ImageView imgproduit = new ImageView();
            File file = new File(e.getPhoto());
            Image image = new Image(file.toURI().toString());
            imgproduit.setImage(image);
            imgproduit.setFitWidth(100);
            imgproduit.setFitHeight(100);
            vbtemp1.getChildren().add(imgproduit);
            vbtemp1.getChildren().add(new Label(e.getNom()));
            vbtemp1.getChildren().add(new Label(e.getDescription()));
            imgproduit.setVisible(true);
            Label sec = new Label("" + e.getId());
            sec.setVisible(false);
            Button visualiser = new Button("consulter");
            visualiser.setOnMouseClicked(new EventHandler<Event>() {
                @Override
                public void handle(Event event) {
                    IHM_Afficher_AccessoireController.ida = Integer.parseInt(sec.getText());
                    try {
                        Stage stage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("IHM_Afficher_Accessoire.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException o) {
                        o.getMessage();
                    }
                }
            });
            vbtemp1.getChildren().add(visualiser);
            hboxxx.getChildren().add(vbtemp1);
        }
        hboxxx.setSpacing(100);
        /**
         * ***************************************************************************************************
         */
        ServiceNourriture service = new ServiceNourriture();
        ArrayList<Nourriture> temp2 = service.listingNourriture();
        ArrayList<Nourriture> hahahihi = temp2.stream().skip(temp2.size() - 5).collect(Collectors.toCollection(ArrayList::new));
        VBox vbtemp2 = new VBox();
        for (Nourriture e : hahahihi) {
            //modification du VBox fils

            //creation de la  imageview
            vbtemp2 = new VBox();
            vbtemp2.setPrefHeight(50);
            vbtemp2.setPrefWidth(1000);
            ImageView imgproduit = new ImageView();
            File file = new File(e.getPhoto());
            Image image = new Image(file.toURI().toString());
            imgproduit.setImage(image);
            imgproduit.setFitWidth(100);
            imgproduit.setFitHeight(100);
            vbtemp2.getChildren().add(imgproduit);
            vbtemp2.getChildren().add(new Label(e.getNom()));
            vbtemp2.getChildren().add(new Label(e.getDescription()));
            imgproduit.setVisible(true);
            Label sec = new Label("" + e.getId());
            sec.setVisible(false);
            Button visualiser = new Button("consulter");
            visualiser.setOnMouseClicked(new EventHandler<Event>() {
                @Override
                public void handle(Event event) {
                    IHM_Afficher_NourritureController.idn = Integer.parseInt(sec.getText());
                    try {
                        Stage stage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("IHM_Afficher_Nourriture.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException o) {
                        o.getMessage();
                    }
                }
            });
            vbtemp2.getChildren().add(visualiser);
            hbox2.getChildren().add(vbtemp2);
            hbox2.setSpacing(100);
        }
    }

}
