package com.tvc.student.client;

import com.tvc.student.entity.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "${course.service.name}", url = "${course.service.url}")
public interface CourseClient {

    @GetMapping("/courses/courseCode/{courseCode}")
    Course findByCourseCode(@PathVariable("courseCode") String courseCode);

}
