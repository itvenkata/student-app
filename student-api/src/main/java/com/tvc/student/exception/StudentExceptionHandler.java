package com.tvc.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class StudentExceptionHandler {

    /**
     * handle not found exceptions
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(CourseNotFoundException.class)
    public final ResponseEntity<ErrorResponse> courseNotFoundException(CourseNotFoundException ex) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse("Error", ex.getMessage()), HttpStatus.NOT_FOUND);

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
        StringBuilder message = new StringBuilder();
        if (!CollectionUtils.isEmpty(fieldErrors)) {
            for (FieldError fieldError : fieldErrors) {
                String defaultMessage = fieldError.getDefaultMessage();
                message.append(defaultMessage);
                message.append(";");
            }
        }
        return new ResponseEntity<ErrorResponse>(new ErrorResponse("Error", message.toString()), HttpStatus.BAD_REQUEST);
    }

    /**
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAnyOtherException(Exception ex) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse("Error", ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
