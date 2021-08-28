package dev.patika.quixotic95.thirdhomework.service;

import dev.patika.quixotic95.thirdhomework.entity.Instructor;
import dev.patika.quixotic95.thirdhomework.entity.PermanentInstructor;
import dev.patika.quixotic95.thirdhomework.entity.VisitingResearcher;
import dev.patika.quixotic95.thirdhomework.repository.InstructorRepository;
import dev.patika.quixotic95.thirdhomework.repository.PermanentInstructorRepository;
import dev.patika.quixotic95.thirdhomework.repository.VisitingResearcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class InstructorService {

    private final InstructorRepository<?> instructorRepository;
    private final PermanentInstructorRepository permanentInstructorRepository;
    private final VisitingResearcherRepository visitingResearcherRepository;

    @Autowired
    public InstructorService(InstructorRepository<Instructor> instructorRepository, PermanentInstructorRepository permanentInstructorRepository, VisitingResearcherRepository visitingResearcherRepository) {
        this.instructorRepository = instructorRepository;
        this.permanentInstructorRepository = permanentInstructorRepository;
        this.visitingResearcherRepository = visitingResearcherRepository;
    }

    public boolean existsById(int instructorId) {
        return instructorRepository.existsById(instructorId);
    }

    public List<Instructor> findAllInstructors() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    public Optional<Instructor> findInstructorById(int instructorId) {
        return instructorRepository.findById(instructorId);
    }

    /*

    @Transactional
    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    */

    @Transactional
    public Instructor savePermanentInstructor(PermanentInstructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Transactional
    public Instructor saveVisitingResearcher(VisitingResearcher instructor) {
        return instructorRepository.save(instructor);
    }

    @Transactional
    public void deletePermanentInstructor(PermanentInstructor instructor) {
        instructorRepository.delete(instructor);
    }

    @Transactional
    public void deleteVisitingResearcher(VisitingResearcher instructor) {
        instructorRepository.delete(instructor);
    }

    /*
        @Transactional
        public void deleteInstructor(Instructor instructor) {
            instructorRepository.delete(instructor);
        }
    */

    @Transactional
    public void deleteInstructorById(int instructorId) {
        instructorRepository.deleteById(instructorId);
    }

    public List<Instructor> findInstructorsByFirstNameAndLastName(String firstName, String lastName) {
        return instructorRepository.findInstructorsByFirstNameAndLastName(firstName, lastName);
    }

    @Transactional
    public void deleteInstructorByFirstNameAndLastName(String firstName, String lastName) {
        instructorRepository.deleteInstructorByFirstNameAndLastName(firstName, lastName);
    }

    public List<PermanentInstructor> findFirst3PermanentInstructorsByOrderByFixedSalaryDesc() {
        return permanentInstructorRepository.findFirst3PermanentInstructorsByOrderByFixedSalaryDesc();
    }

    public List<PermanentInstructor> findFirst3PermanentInstructorsByOrderByFixedSalaryAsc() {
        return permanentInstructorRepository.findFirst3PermanentInstructorsByOrderByFixedSalaryAsc();
    }

    public List<VisitingResearcher> findFirst3VisitingResearchersByOrderByHourlySalaryDesc() {
        return visitingResearcherRepository.findFirst3VisitingResearchersByOrderByHourlySalaryDesc();
    }

    public List<VisitingResearcher> findFirst3VisitingResearchersByOrderByHourlySalaryAsc() {
        return visitingResearcherRepository.findFirst3VisitingResearchersByOrderByHourlySalaryAsc();
    }

}
