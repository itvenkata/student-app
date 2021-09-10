package com.tvc.course.api.service;

import java.util.List;
import java.util.Optional;

import com.tvc.course.api.exception.CourseNotFoundException;
import com.tvc.course.api.model.Course;
import com.tvc.course.api.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    /**
     * create course
     *
     * @param course
     */
    public void storeCourse(Course course) {
        courseRepository.save(course);
    }

    /**
     *
     * @return
     */
    public List<Course> getAllCourse() {
        List<Course> courses = courseRepository.findAll();
        if (courses.isEmpty()) {
            throw new CourseNotFoundException("no courses found");
        }
        return courses;
    }

    /**
     * get course
     *
     * @param id
     * @return
     */
    public Course getCourseInfo(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (!course.isPresent()) {
            throw new CourseNotFoundException("no course found with id " + id);
        }
        return course.get();
    }

    /**
     * update course info
     *
     * @param course
     * @param id
     */
    public void updateCourseInfo(Course course, Long id) {
        Optional<Course> updatedCourse = courseRepository.findById(id);
        if (!updatedCourse.isPresent()) {
            throw new CourseNotFoundException("No course found with id " + id);
        }
        updatedCourse.get().setTitle(course.getTitle());
        updatedCourse.get().setCourseCode(course.getCourseCode());
        updatedCourse.get().setCreditValue(course.getCreditValue());
        courseRepository.save(updatedCourse.get());
    }

    /**
     * delete course
     *
     * @param id
     */
    public void deleteCourse(Long id) {
        Optional<Course> updatedCourse = courseRepository.findById(id);
        if (!updatedCourse.isPresent()) {
            throw new CourseNotFoundException("No course found with id " + id);
        }
        courseRepository.delete(updatedCourse.get());
    }

}