package dev.patika.quixotic95.thirdhomework.repository;

import dev.patika.quixotic95.thirdhomework.entity.PermanentInstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermanentInstructorRepository extends InstructorRepository<PermanentInstructor> {

    // get 3 instructors with the greatest salary
    List<PermanentInstructor> findFirst3PermanentInstructorsByOrderByFixedSalaryDesc();

    //get 3 instructors with the lowest salary
    List<PermanentInstructor> findFirst3PermanentInstructorsByOrderByFixedSalaryAsc();

}
