package gui;

import algorithms.DocGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class s1controller implements Initializable{

    public String fname;
    public  String fileName;

    @FXML
    private ResourceBundle resources;

    @FXML
    public Label lbl;

    @FXML
    private URL location;

    @FXML
    private Button button1;

    @FXML
    void fileSelector() {

        FileChooser chooser=new FileChooser();
        //FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files Only", "xlsx", "xls");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel","*.xlsx","*.xlx"));
        File f =chooser.showOpenDialog(new Stage());
        String filename= f.getAbsolutePath();
        fileName=filename;
        fname=f.getName();
        lbl.setText(filename);
    }


@FXML
public FXMLLoader fxmlLoader;
    @FXML
    void onClickNext(ActionEvent event) throws Exception{
        if (fname!= null) {
            //DocGenerator docGenerator = new DocGenerator();
            //docGenerator.createDoc();
            fxmlLoader = new FXMLLoader(getClass().getResource("diff_s2.fxml"));
            Parent root = fxmlLoader.load();
            s2controller s2 = fxmlLoader.getController();
            s2.loadFName(fname, fileName);

            Scene scene = new Scene(root, 700, 500);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        else {
            lbl.setText("Please Select an Excel File");
        }
    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
