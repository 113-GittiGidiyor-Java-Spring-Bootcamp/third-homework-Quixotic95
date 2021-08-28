package dev.patika.quixotic95.thirdhomework.repository;

import dev.patika.quixotic95.thirdhomework.entity.VisitingResearcher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitingResearcherRepository extends InstructorRepository<VisitingResearcher> {

    // get 3 instructors with the greatest salary
    List<VisitingResearcher> findFirst3VisitingResearchersByOrderByHourlySalaryDesc();

    //get 3 instructors with the lowest salary
    List<VisitingResearcher> findFirst3VisitingResearchersByOrderByHourlySalaryAsc();

}
