package dev.patika.quixotic95.thirdhomework.controller;

import dev.patika.quixotic95.thirdhomework.entity.Course;
import dev.patika.quixotic95.thirdhomework.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {

    private final CourseService courseService;

    // dependency injection with @Autowired annotation (not necessary to write, injects automatically; but placed for better-reading)
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // expose "/courses" and return list of courses
    @GetMapping("/courses")
    public ResponseEntity<?> findAllCourses() {
        return new ResponseEntity<>(courseService.findAllCourses(), HttpStatus.OK);
    }

    // mapping for GET /courses/{courseId} to get a course by id
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<?> findCourseById(@PathVariable int courseId) {
        Optional<Course> foundCourse = courseService.findCourseById(courseId);
        if (foundCourse.isPresent()) {
            return new ResponseEntity<>(foundCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course with id: " + courseId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // mapping for POST /courses - add new course
    @PostMapping("/courses")
    public ResponseEntity<?> saveCourse(@RequestBody Course course) {
        int courseId = course.getId();
        if (courseService.existsById(courseId)) {
            return new ResponseEntity<>("Course with id: " + courseId + " already exists.", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.OK);
        }
    }

    // mapping for PUT /courses - update existing course
    @PutMapping("/courses")
    public ResponseEntity<?> updateCourse(@RequestBody Course course) {
        if (courseService.existsById(course.getId())) {
            return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course with id: " + course.getId() + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // mapping for DELETE /courses - delete course
    @DeleteMapping("/courses")
    public ResponseEntity<String> deleteCourse(@RequestBody Course course) {
        int courseId = course.getId();
        if (courseService.existsById(courseId)) {
            courseService.deleteCourse(course);
            return new ResponseEntity<>("Course with id: " + courseId + " deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course with id: " + courseId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // mapping for DELETE /courses/{courseId} - delete course by id
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<String> deleteCourseById(@PathVariable int courseId) {
        if (courseService.existsById(courseId)) {
            courseService.deleteCourseById(courseId);
            return new ResponseEntity<>("Course with id: " + courseId + " deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course with id: " + courseId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // mapping for GET course(s) by their name
    @GetMapping("/courses/byName")
    public ResponseEntity<?> findCoursesByCourseName(@RequestParam String courseName) {
        return new ResponseEntity<>(courseService.findCoursesByCourseName(courseName), HttpStatus.OK);
    }

    // mapping for DELETE course(s) by name
    @DeleteMapping("/courses/byName")
    public ResponseEntity<String> deleteCoursesCourseName(@RequestParam String courseName) {
        if (courseService.findCoursesByCourseName(courseName).isEmpty()) {
            return new ResponseEntity<>("Course: " + courseName + " not found.", HttpStatus.BAD_REQUEST);
        } else {
            courseService.deleteCoursesByCourseName(courseName);
            return new ResponseEntity<>("Course(s): " + courseName + " deleted.", HttpStatus.OK);
        }
    }

}

