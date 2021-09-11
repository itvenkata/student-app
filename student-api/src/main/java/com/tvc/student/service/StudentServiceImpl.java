package com.tvc.student.service;

import com.tvc.student.client.CourseClient;
import com.tvc.student.entity.Course;
import com.tvc.student.entity.Student;
import com.tvc.student.exception.CourseNotFoundException;
import com.tvc.student.repository.AddressRepository;
import com.tvc.student.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CourseClient courseClient;


    @Override
    public Student createStudent(Student studuent) {
        try {
            Set<Course> coureSet = new HashSet<>();
            for (Course c : studuent.getCourses()) {
                log.info(c.toString());
                Course clientCourse = courseClient.findByCourseCode(c.getCourseCode());
                coureSet.add(clientCourse);
            }
            studuent.setCourses(coureSet);

        } catch (Exception e) {
            throw new CourseNotFoundException(e.getMessage());
        }

        return studentRepository.save(studuent);
    }

    @Override
    public Student getStudent(Integer studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Student updateStudent(Integer studentId, Student student) {
        return studentRepository.save(student);
    }

    @Override
    public String deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
        return "deleted successfully";
    }
}
