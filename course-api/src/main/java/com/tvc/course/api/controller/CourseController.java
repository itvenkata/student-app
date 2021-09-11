package com.tvc.course.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.tvc.course.api.model.Course;
import com.tvc.course.api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    /**
     * store new course
     *
     * @param course
     * @return
     */
    @PostMapping
    public ResponseEntity<String> store(@Valid @RequestBody Course course) {
        courseService.storeCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created course");
    }

    /**
     * get all courses
     *
     * @return List Course
     */
    @GetMapping
    public List<Course> index() {
        List<Course> courses = courseService.getAllCourse();
        return courses;
    }

    /**
     * show details of course
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Course showCourseInfo(@PathVariable Long id) {
        return courseService.getCourseInfo(id);
    }

    /**
     * update course info
     *
     * @param course
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@Valid @RequestBody Course course, @PathVariable Long id) {
        courseService.updateCourseInfo(course, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully updated course");
    }

    /**
     * delete course
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.OK).body("successfully deleted course");
    }

    @GetMapping("/courseCode/{courseCode}")
    public Course getCourseByCode(@PathVariable String courseCode) {
        return courseService.getCourseByCode(courseCode);
    }

}