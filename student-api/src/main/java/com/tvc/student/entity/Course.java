package com.tvc.student.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//@Data
@Embeddable
public class Course {
    @Column(name = "course_id")
    Integer courseId;
    @Column(name = "course_name")
    String courseName;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    //https://www.netsurfingzone.com/jpa/elementcollection-example-in-hibernate-jpa-using-spring-boot/
}
