package Model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Courses {
    @Id
    private String Code;
    private String CourseName;
    private String Type;
    private String Duration;
    @OneToMany(mappedBy = "courses",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Registration> registrations  = new ArrayList<>();

    public Courses() {
    }

    public Courses(String code, String courseName, String type, String duration) {
        Code = code;
        CourseName = courseName;
        Type = type;
        Duration = duration;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "Code='" + Code + '\'' +
                ", CourseName='" + CourseName + '\'' +
                ", Type='" + Type + '\'' +
                ", Duration='" + Duration + '\'' +
                ", registrations=" + registrations +
                '}';
    }
}
