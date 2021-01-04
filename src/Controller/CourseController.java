package Controller;

import Model.Courses;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CourseController {
        @FXML
        private JFXTextField txtCode;
        @FXML
        private JFXTextField txtCourseName;
        @FXML
        private JFXTextField txtDuration;
        @FXML
        private JFXTextField txtCourseType;
        @FXML
        private Button btnAddCourse;

        public void TextCode (ActionEvent actionEvent){}
        public void TextCourseName (ActionEvent actionEvent){}
        public void TestDuration (ActionEvent actionEvent){}
        public void TextTType (ActionEvent actionEvent){}

        public void ClickCourse (ActionEvent actionEvent){

            String code = txtCode.getText();
            String name = txtCourseName.getText();
            String duration = txtDuration.getText();
            String type = txtCourseType.getText();

            Courses courses = new Courses(code,name,duration,type);
             ControllerController.saveCourses(courses);
        }

}
