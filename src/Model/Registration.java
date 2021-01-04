package Model;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Registration {
    @Id
    private int regNO;
    private Date regDate;
    private double regFee;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Student_Id",referencedColumnName = "SID",nullable = false)
    private Students students;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Course_Code",referencedColumnName = "Code",nullable = false)
    private Courses courses;

    public Registration() {
    }

    public Registration(int regNO, Date regDate, double regFee, Students students, Courses courses) {
        this.regNO = regNO;
        this.regDate = regDate;
        this.regFee = regFee;
        this.students = students;
        this.courses = courses;
    }

    public int getRegNO() {
        return regNO;
    }

    public void setRegNO(int regNO) {
        this.regNO = regNO;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public double getRegFee() {
        return regFee;
    }

    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "regNO=" + regNO +
                ", regDate=" + regDate +
                ", regFee=" + regFee +
                ", students=" + students +
                ", courses=" + courses +
                '}';
    }
}
