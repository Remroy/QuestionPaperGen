package gui;


//import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class s2controller {

String fileName;
    @FXML
    private ResourceBundle resources;
    int n;
    @FXML
    private URL location;

    @FXML
    private Slider sliderDiff;


    @FXML
    private Label sliderListen;

    @FXML
    private Label lblFileName;

    @FXML
    public ComboBox<String> test_name;
    @FXML
    private ComboBox<Integer> num_sets;

    ObservableList<String> testName = FXCollections.observableArrayList("CT 1","CT 2","CT 3","Univ");
    ObservableList<Integer> sets = FXCollections.observableArrayList(1,2,3,4,5,6,7,8);

    public void loadFName(String s, String s1) {
        lblFileName.setText(s);
        fileName=s1;
    }

    @FXML
    void onClickNext(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("head_s3.fxml"));
        Parent root= fxmlLoader.load();
        s3controller s3= fxmlLoader.getController();
        s3.countWorksheetPass(fileName, test_name.getValue(), num_sets.getValue(), n);

        Scene scene=new Scene(root, 700, 500);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onClickPrev(ActionEvent event) throws IOException{
        Parent root= FXMLLoader.load(getClass().getResource("jPick_s1.fxml"));
        Scene scene=new Scene(root, 700, 500);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }





    @FXML
    public void initialize() {
        test_name.setItems(testName);
        num_sets.setItems(sets);

        // The minimum value.
        sliderDiff.setMin(0);

        // The maximum value.
        sliderDiff.setMax(100);

        // Current value
        sliderDiff.setValue(25);

        sliderDiff.setShowTickLabels(true);
        sliderDiff.setShowTickMarks(true);

        sliderDiff.setBlockIncrement(10);

        // Adding Listener to value property.
        //
        sliderDiff.valueProperty().addListener((observable, oldValue, newValue) -> {

            sliderListen.setText("Paper Difficulty: " + (int)(Math.floor((Double) newValue)) + "%");
            n=(int)(Math.floor((Double) newValue));
        });



    }
}
