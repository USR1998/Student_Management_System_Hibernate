package Controller;

import Model.Courses;
import Model.Registration;
import Model.Students;
import Util.HibernateUtil;
import javafx.fxml.Initializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerController implements Initializable {

    public static void saveCourses(Courses courses) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
            session.save(courses);
        session.getTransaction().commit();
        session.close();
    }

    public static void SaveStudent(Registration registration, String sid, String code) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Students students = session.get(Students.class, sid);
        Courses courses = session.get(Courses.class, code);
        registration.setCourses(courses);
        registration.setStudents(students);
        session.save(registration);

        session.getTransaction().commit();
        session.close();
    }

    public static List loadCouse(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list = session.createNativeQuery("SELECT Code FROM Courses").list();
        session.getTransaction().commit();
        session.close();
        return  list;

    }

    public static void addStudents(Students students) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(students);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCouse();
    }
}
