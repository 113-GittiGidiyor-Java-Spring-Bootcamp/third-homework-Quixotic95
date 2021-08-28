package dev.patika.quixotic95.thirdhomework.repository;

import dev.patika.quixotic95.thirdhomework.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    List<Student> findStudentsByFirstNameAndLastName(String firstName, String lastName);

    @Query("select s.gender, count(s.gender) from Student s GROUP BY s.gender")
    List<?> getStudentsGendersWithGrouping();

    void deleteStudentsByFirstNameAndLastName(String firstName, String lastName);

}
