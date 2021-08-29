package dev.patika.quixotic95.thirdhomework.service;

import dev.patika.quixotic95.thirdhomework.entity.Course;
import dev.patika.quixotic95.thirdhomework.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public boolean existsById(int courseId) {
        return courseRepository.existsById(courseId);
    }

    public List<Course> findAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    public Optional<Course> findCourseById(int courseId) {
        return courseRepository.findById(courseId);
    }

    @Transactional
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Transactional
    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }

    @Transactional
    public void deleteCourseById(int courseId) {
        courseRepository.deleteById(courseId);
    }

    public List<Course> findCoursesByCourseName(String courseName) {
        return courseRepository.findCoursesByCourseName(courseName);
    }

    @Transactional
    public void deleteCoursesByCourseName(String courseName) {
        courseRepository.deleteCoursesByCourseName(courseName);
    }
}
