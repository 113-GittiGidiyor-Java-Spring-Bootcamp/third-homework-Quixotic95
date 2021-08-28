package dev.patika.quixotic95.thirdhomework.repository;

import dev.patika.quixotic95.thirdhomework.entity.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository<T extends Instructor> extends CrudRepository<Instructor, Integer> {

    List<Instructor> findInstructorsByFirstNameAndLastName(String firstName, String lastName);

    void deleteInstructorByFirstNameAndLastName(String firstName, String lastName);

}
