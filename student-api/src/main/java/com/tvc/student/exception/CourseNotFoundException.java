package com.tvc.student.exception;

public class CourseNotFoundException extends RuntimeException {


    public CourseNotFoundException(String message) {
        super(message);
    }
}
