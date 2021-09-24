package com.tvc.student.service;

import com.tvc.student.client.CourseClient;
import com.tvc.student.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseClient courseClient;


    public Course getCourse(String courseCode) {
        return courseClient.findByCourseCode(courseCode);
    }


}
