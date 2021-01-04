package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent load = FXMLLoader.load(this.getClass().getResource("/view/MainForm.fxml"));
        Scene scene = new Scene(load);
        primaryStage.setTitle("Main");
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
