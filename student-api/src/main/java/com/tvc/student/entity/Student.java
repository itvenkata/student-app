package com.tvc.student.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String studentName;
    private String emailId;


  /*  @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"))
    private List<Course> courseList = new ArrayList<>();*/

    @ElementCollection
    @Column(name = "courses", nullable = false)
    @CollectionTable(name = "student_courses", joinColumns = {@JoinColumn(name = "student_id")})
    private Set<Course> courses;


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Address> addresses = new HashSet<>();

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
        for (Address a : addresses) {
            a.setStudent(this);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
