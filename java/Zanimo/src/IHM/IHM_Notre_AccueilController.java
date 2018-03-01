/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import entites.Accessoire;
import entites.Nourriture;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.ServiceAccessoire;
import services.ServiceNourriture;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class IHM_Notre_AccueilController implements Initializable {

    @FXML
    private VBox vbListingAccessoire;
    @FXML
    private VBox vbListingNourriture;
    @FXML
    private Button btnsonne;
    @FXML
    private JFXDrawer drawer;
    private JFXHamburger jfxdrawing;
    public static JFXHamburger houha;
    @FXML
    private Pane menu;
    @FXML
    private Button btngestion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        menu.setTranslateX(-190);
        TranslateTransition menuTranslation = new TranslateTransition(Duration.millis(500), menu);

        menuTranslation.setFromX(-190);
        menuTranslation.setToX(0);

        menu.setOnMouseEntered(evt -> {
            menuTranslation.setRate(1);
            menuTranslation.play();
        });
        menu.setOnMouseExited(evt -> {
            menuTranslation.setRate(-1);
            menuTranslation.play();
        });
        /*try {
        // TODO

        AnchorPane jfxdrawing = FXMLLoader.load(getClass().getResource("ACC.fxml"));
        //  jfxdrawing.getStylesheets().add(getClass().getResource("/Asset/Style.css").toExternalForm());

        drawer.setSidePane(jfxdrawing);
        } catch (IOException ex) {
        System.out.println(ex.getMessage());
        }*/
 /*
        //        HamburgerSlideCloseTransition task = new HamburgerSlideCloseTransition(jfxdrawing);
        task.setRate(-1);
        jfxdrawing.addEventHandler(MouseEvent.MOUSE_CLICKED, (Event event) -> {
        task.setRate(task.getRate() * -1);
        task.play();
        if (drawer.isHidden()) {
        drawer.open();
        } else {
        drawer.close();
        }
        });*/
        affichageintial();
    }

    @FXML
    private void onClickAffichLogIn(ActionEvent event) throws IOException {
        /*Button siscri = new Button("s'inscrire");
        Button fbc = new Button("se connecter avec FaceBook");
        TextField adresseE = new TextField();
        Label eror = new Label("veuiller saisir un login et mdb ");*/
        Parent root = FXMLLoader.load(getClass().getResource("IHM_login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();

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
            vbListingAccessoire.getChildren().add(vbtemp1);
            System.out.println("11111111111111");
        }
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
            vbListingNourriture.getChildren().add(vbtemp2);
        }
    }

    private void accueil(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("IHM_Notre_Accueil.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onClickSoin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("VIEW_Soin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onClickCommercial(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ModuleCommercial.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onClickAnimal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("VIEW_ANIMAL.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onClickWIKI(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("VIEW_WIKI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onClickConcours(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("IHM_Notre_Accueil.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onClickDressage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("VIEW_DRESSAGE.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onClickGestionItilisateur(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("IHM_Notre_Accueil.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onClickProfil(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("IHM_Notre_Accueil.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

}
