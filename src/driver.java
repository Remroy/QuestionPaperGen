
import gui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class driver extends Application {

    //public Stage stage;
    //Parent root;

    @Override
    public void start(Stage primaryStage) {
        try {

            //stage = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("gui/jPick_s1.fxml"));
            primaryStage.setTitle("SRMIST Question Paper Generator");
            primaryStage.getIcons().add(new Image("res/icon.png"));
            primaryStage.setScene(new Scene(root, 700, 500));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
