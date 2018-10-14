package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import algorithms.ExcelParser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class s3controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea textAreaHeader;

    @FXML
    private TextArea textAreaFooter;

    @FXML
    Parent root;
    FXMLLoader loader;
    s4controller s4;
    String fname;
    String test_Name;
    int set_Number;
    int diff_Percentage;

    @FXML
    void onClickNext(ActionEvent event) throws IOException {
        loader= FXMLLoader.load(getClass().getResource("load_s4.fxml"));
        root= loader.load();
        //AnchorPane anchorPane = (AnchorPane) FXMLLoader.load(getClass().getResource("load_s4.fxml"));
        Scene scene=new Scene(root, 700, 500);
        System.out.println("File Name:"+fname+"\n Test Name:" + test_Name  + "\nSet Number:" + set_Number +"\nDifficulty Percentage:"+diff_Percentage);
        s4=loader.getController();
        s4.countWorksheet(fname,test_Name,set_Number,diff_Percentage);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void onClickPrev(ActionEvent event) throws IOException{
        loader= new FXMLLoader(getClass().getResource("diff_s2.fxml"));
        root=loader.load();

        Scene scene=new Scene(root, 700, 500);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    public void countWorksheetPass(String fileName, String testName, Integer setNumber, int diffPercentage) {
      fname=fileName;
        test_Name=testName;
        set_Number=setNumber;
        diff_Percentage=diffPercentage;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
