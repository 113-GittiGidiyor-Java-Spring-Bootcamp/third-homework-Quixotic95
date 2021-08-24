package dev.patika.quixotic95.thirdhomework.repository;

import dev.patika.quixotic95.thirdhomework.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

}
