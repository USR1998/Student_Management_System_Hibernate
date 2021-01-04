package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button btnCourses;

    @FXML
    private Button btnDetails;

    @FXML
    private Button btnStudents;

    @FXML
    private BorderPane border;

    public void ClickCourses(ActionEvent actionEvent) {
        try {
            Parent load = FXMLLoader.load(this.getClass().getResource("/view/Courses.fxml"));
            border.setCenter(load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ClickDetails(ActionEvent actionEvent) {
        try {
            Parent load = FXMLLoader.load(this.getClass().getResource("/view/Details.fxml"));
            border.setCenter(load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void ClickStudents(ActionEvent actionEvent) {
        try {
            Parent load = FXMLLoader.load(this.getClass().getResource("/view/Students.fxml"));
            border.setCenter(load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
