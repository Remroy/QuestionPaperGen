package gui;

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

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class s1controller implements Initializable{

    public String fname;
    public  String fileName;
    Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    public Label lbl;

    @FXML
    private URL location;

    @FXML
    private Button button1;

    @FXML
    void onClickFileChose(ActionEvent event) {

        FileChooser chooser=new FileChooser();
        //FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files Only", "xlsx", "xls");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel","*.xlsx","*.xlx"));
        File f =chooser.showOpenDialog(root.getScene().getWindow());
        String filename= f.getAbsolutePath();
        fileName=filename;
        fname=f.getName();
        lbl.setText(filename);
    }


@FXML
public FXMLLoader fxmlLoader;
    @FXML
    void onClick(ActionEvent event) throws IOException{
        fxmlLoader= new FXMLLoader(getClass().getResource("diff_s2.fxml"));
        root= fxmlLoader.load();
        s2controller s2 = fxmlLoader.getController();
        s2.loadFName(fname, fileName);

        Scene scene=new Scene(root, 700, 500);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();


    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }
}
