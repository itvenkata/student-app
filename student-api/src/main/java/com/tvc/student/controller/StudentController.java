package com.tvc.student.controller;

import com.tvc.student.entity.Student;
import com.tvc.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student studuent) {
        return studentService.createStudent(studuent);
    }


    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {

        return studentService.getStudent(studentId);
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {

        return studentService.updateStudent(studentId, student);
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable Integer studentId) {

        return studentService.deleteStudent(studentId);
    }

}
