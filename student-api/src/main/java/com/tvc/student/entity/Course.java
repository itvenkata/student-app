package com.tvc.student.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Course {
    @Column(name = "course_code")
    String courseCode;
    String title;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    //https://www.netsurfingzone.com/jpa/elementcollection-example-in-hibernate-jpa-using-spring-boot/
}
