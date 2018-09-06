package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class s5controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void onClickPrev(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("head_s3.fxml"));
        Scene scene=new Scene(root, 700, 500);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private WebView confi;
    private WebEngine engine;
    @FXML
    void initialize() {
    engine=confi.getEngine();
    engine.load("https://www.google.co.in");

    }
}