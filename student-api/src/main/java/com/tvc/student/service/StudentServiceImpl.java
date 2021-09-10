package com.tvc.student.service;

import com.tvc.student.entity.Student;
import com.tvc.student.repository.AddressRepository;
import com.tvc.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public Student createStudent(Student studuent) {

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
