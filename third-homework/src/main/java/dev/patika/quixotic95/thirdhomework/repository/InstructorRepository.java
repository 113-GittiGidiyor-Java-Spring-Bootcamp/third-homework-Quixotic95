package dev.patika.quixotic95.thirdhomework.repository;

import dev.patika.quixotic95.thirdhomework.entity.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository<T extends Instructor> extends CrudRepository<T, Integer> {

}
