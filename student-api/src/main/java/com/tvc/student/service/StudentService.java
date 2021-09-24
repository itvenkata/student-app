package com.tvc.student.service;

import com.tvc.student.entity.Student;


public interface StudentService {

    public Student createStudent(Student studuent);


    public Student getStudent(Integer studentId);


    public Student updateStudent(Integer studentId, Student student);


    public String deleteStudent(Integer studentId);


}
