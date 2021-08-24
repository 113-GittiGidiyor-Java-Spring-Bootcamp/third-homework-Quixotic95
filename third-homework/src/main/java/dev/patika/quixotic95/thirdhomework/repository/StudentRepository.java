package dev.patika.quixotic95.thirdhomework.repository;

import dev.patika.quixotic95.thirdhomework.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
