package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Students {
    @Id
    private String SID;
    private String Name;
    private String Address;
    private String Contact;
    private Date DOB;
    private String Gender;
    @OneToMany(mappedBy = "students",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Registration> registrations = new ArrayList<>();

    public Students() {
    }

    public Students(String SID, String name, String address, String contact, Date DOB, String gender) {
        this.SID = SID;
        Name = name;
        Address = address;
        Contact = contact;
        this.DOB = DOB;
        Gender = gender;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    @Override
    public String toString() {
        return "Students{" +
                "SID='" + SID + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Contact='" + Contact + '\'' +
                ", DOB=" + DOB +
                ", Gender='" + Gender + '\'' +
                ", registrations=" + registrations +
                '}';
    }
}
