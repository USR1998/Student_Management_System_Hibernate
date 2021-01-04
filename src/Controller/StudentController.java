package Controller;
import Model.Courses;
import Model.Registration;
import Model.Students;
import Util.HibernateUtil;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.DataFormat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.text.DateFormatter;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.zip.DataFormatException;

public class StudentController implements Initializable {
    @FXML
    private JFXTextField txtStudentID;
    @FXML
    private JFXTextField txtStudentName;
    @FXML
    private JFXTextField txtStudentaAddress;
    @FXML
    private JFXTextField txtContact;
    @FXML
    private JFXTextField txtGender;
    @FXML
    private JFXTextField txtFee;
    @FXML
    private JFXComboBox txtSelectCode;

    @FXML
    private DatePicker txtDateOfBirth;
    @FXML
    private DatePicker txtDate;
    @FXML
    private Button btnSearchID;
    @FXML
    private Button btnRegister;
    @FXML
    private JFXTextField txtRegNo;
    @FXML
    private Button btnAdd;


    public void TextStudentID(ActionEvent actionEvent) {}
    public void TextStudentName(ActionEvent actionEvent) {}
    public void TextStudentAddress(ActionEvent actionEvent) {}
    public void TextContact(ActionEvent actionEvent) {}
    public void TextGender(ActionEvent actionEvent) {}
    public void TextFee(ActionEvent actionEvent) {}
    public void SelectCourse(ActionEvent actionEvent) {}
    public void TextDateOfBirth(ActionEvent actionEvent) {}
    public void TextDate(ActionEvent actionEvent) {}
    public void TextRegNO(ActionEvent actionEvent) {}
    public void SearchStudent(ActionEvent actionEvent) {}
    public void RegisterStudent(ActionEvent actionEvent) {
        try {
        LocalDate date = txtDateOfBirth.getValue();
        String s = DateTimeFormatter.ofPattern("YYYY-MM-dd").format(date);

        Date parseDate = null;

            parseDate = new SimpleDateFormat("YYYY-MM-dd").parse(s);

        String sid = txtStudentID.getText();
        String sname = txtStudentName.getText();
        String address = txtStudentaAddress.getText();
        String contact = txtContact.getText();
        String gender = txtGender.getText();
        Students students = new Students(sid,sname,address,contact,parseDate,gender);

        int regno = Integer.parseInt(txtRegNo.getText());
        double fee = Double.parseDouble(txtFee.getText());
        String code =(String) txtSelectCode.getSelectionModel().getSelectedItem();
        LocalDate date2 = txtDateOfBirth.getValue();
        String d = DateTimeFormatter.ofPattern("YYYY-MM-dd").format(date2);
        Date parseDate2 = new SimpleDateFormat("YYYY-MM-dd").parse(d);

        Courses courses = new Courses("C001","aa","bb","cc");
        Registration registration = new Registration(regno,parseDate2,fee,students,courses);
        ControllerController.SaveStudent(registration,sid,code);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public void Add(ActionEvent actionEvent) {
        try {
        LocalDate date = txtDateOfBirth.getValue();
        String s = DateTimeFormatter.ofPattern("YYYY-MM-dd").format(date);

            Date parseDate = new SimpleDateFormat("YYYY-MM-dd").parse(s);
            String sid = txtStudentID.getText();
            String sname = txtStudentName.getText();
            String address = txtStudentaAddress.getText();
            String contact = txtContact.getText();
            String gender = txtGender.getText();
            Students students = new Students(sid,sname,address,contact,parseDate,gender);
            ControllerController.addStudents(students);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private void loadAll(){
        List list = ControllerController.loadCouse();
        ObservableList objects = FXCollections.observableArrayList();
        for (Object o : list) {
            objects.add(o);
        }
        txtSelectCode.setItems(objects);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        loadAll();

    }
}
