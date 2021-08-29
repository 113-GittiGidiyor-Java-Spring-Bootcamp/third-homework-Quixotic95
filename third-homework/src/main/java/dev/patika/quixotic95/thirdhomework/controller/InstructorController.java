package dev.patika.quixotic95.thirdhomework.controller;

import dev.patika.quixotic95.thirdhomework.entity.Instructor;
import dev.patika.quixotic95.thirdhomework.entity.PermanentInstructor;
import dev.patika.quixotic95.thirdhomework.entity.VisitingResearcher;
import dev.patika.quixotic95.thirdhomework.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class InstructorController {

    private final InstructorService instructorService;

    // dependency injection with @Autowired annotation (not necessary to write, injects automatically; but placed for better-reading)
    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    // expose "/instructors" and return list of instructors
    @GetMapping("/instructors")
    public ResponseEntity<?> findAllInstructors() {
        return new ResponseEntity<>(instructorService.findAllInstructors(), HttpStatus.OK);
    }

    // mapping for GET /instructors/{instructorId} to get an instructor by id
    @GetMapping("/instructors/{instructorId}")
    public ResponseEntity<?> findInstructorById(@PathVariable int instructorId) {
        Optional<Instructor> foundInstructor = instructorService.findInstructorById(instructorId);
        if (foundInstructor.isPresent()) {
            return new ResponseEntity<>(foundInstructor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Instructor with id: " + instructorId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // mapping for POST /instructors/permanentInstructor - add new permanent instructor
    @PostMapping("/instructors/permanentInstructor")
    public ResponseEntity<?> savePermanentInstructor(@RequestBody PermanentInstructor instructor) {
        int instructorId = instructor.getId();
        if (instructorService.existsById(instructorId)) {
            return new ResponseEntity<>("Instructor with id: " + instructorId + " already exists.", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(instructorService.savePermanentInstructor(instructor), HttpStatus.OK);
        }
    }

    // mapping for POST /instructors/visitingResearcher - add new visiting researcher
    @PostMapping("/instructors/visitingResearcher")
    public ResponseEntity<?> saveVisitingResearcher(@RequestBody VisitingResearcher instructor) {
        int instructorId = instructor.getId();
        if (instructorService.existsById(instructorId)) {
            return new ResponseEntity<>("Instructor with id: " + instructorId + " already exists.", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(instructorService.saveVisitingResearcher(instructor), HttpStatus.OK);
        }
    }

    // mapping for PUT /instructors/permanentInstructor - update existing permanent instructor
    @PutMapping("/instructors/permanentInstructor")
    public ResponseEntity<?> updatePermanentInstructor(@RequestBody PermanentInstructor instructor) {
        if (instructorService.existsById(instructor.getId())) {
            return new ResponseEntity<>(instructorService.savePermanentInstructor(instructor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Instructor with id: " + instructor.getId() + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // mapping for PUT /instructors/visitingResearcher - update existing visiting researcher
    @PutMapping("/instructors/visitingResearcher")
    public ResponseEntity<?> updateVisitingResearcher(@RequestBody VisitingResearcher instructor) {
        if (instructorService.existsById(instructor.getId())) {
            return new ResponseEntity<>(instructorService.saveVisitingResearcher(instructor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Instructor with id: " + instructor.getId() + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    /*

    // mapping for PUT /instructors - update existing instructor
    @PutMapping("/instructors")
    public ResponseEntity<?> updateInstructor(@RequestBody Instructor instructor) {
        if (instructorService.existsById(instructor.getId())) {
            return new ResponseEntity<>(instructorService.saveInstructor(instructor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Instructor with id: " + instructor.getId() + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // mapping for DELETE /instructors - delete instructor
    @DeleteMapping("/instructors")
    public ResponseEntity<String> deleteInstructor(@RequestBody Instructor instructor) {
        int instructorId = instructor.getId();
        if (instructorService.existsById(instructorId)) {
            instructorService.deleteInstructor(instructor);
            return new ResponseEntity<>("Instructor with id: " + instructorId + " deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Instructor with id: " + instructorId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    */

    // mapping for DELETE /instructors - delete instructor
    @DeleteMapping("/instructors/permanentInstructor")
    public ResponseEntity<String> deletePermanentInstructor(@RequestBody PermanentInstructor instructor) {
        int instructorId = instructor.getId();
        if (instructorService.existsById(instructorId)) {
            instructorService.deletePermanentInstructor(instructor);
            return new ResponseEntity<>("Instructor with id: " + instructorId + " deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Instructor with id: " + instructorId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // mapping for DELETE /instructors - delete instructor
    @DeleteMapping("/instructors/visitingResearcher")
    public ResponseEntity<String> deleteVisitingResearcher(@RequestBody VisitingResearcher instructor) {
        int instructorId = instructor.getId();
        if (instructorService.existsById(instructorId)) {
            instructorService.deleteVisitingResearcher(instructor);
            return new ResponseEntity<>("Instructor with id: " + instructorId + " deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Instructor with id: " + instructorId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // mapping for DELETE /instructors/{instructorId} - delete instructor by id
    @DeleteMapping("/instructors/{instructorId}")
    public ResponseEntity<String> deleteInstructorById(@PathVariable int instructorId) {
        if (instructorService.existsById(instructorId)) {
            instructorService.deleteInstructorById(instructorId);
            return new ResponseEntity<>("Instructor with id: " + instructorId + " deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Instructor with id: " + instructorId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // mapping for GET instructor(s) by their name
    @GetMapping("/instructors/byName")
    public ResponseEntity<?> findInstructorsByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return new ResponseEntity<>(instructorService.findInstructorsByFirstNameAndLastName(firstName, lastName), HttpStatus.OK);
    }

    // mapping for DELETE instructor by name
    @DeleteMapping("/instructors/byName")
    public ResponseEntity<String> deleteInstructorByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        if (instructorService.findInstructorsByFirstNameAndLastName(firstName, lastName).isEmpty()) {
            return new ResponseEntity<>("Instructor with name: " + firstName + " " + lastName + " not found.", HttpStatus.BAD_REQUEST);
        } else {
            instructorService.deleteInstructorByFirstNameAndLastName(firstName, lastName);
            return new ResponseEntity<>("Instructor with name: " + firstName + " " + lastName + " deleted.", HttpStatus.OK);
        }
    }

    // mapping for GET top 3 permanent instructors with the highest salary.
    @GetMapping("/instructors/permanentInstructor/top3")
    public ResponseEntity<?> findFirst3PermanentInstructorsByOrderByFixedSalaryDesc() {
        return new ResponseEntity<>(instructorService.findFirst3PermanentInstructorsByOrderByFixedSalaryDesc(), HttpStatus.OK);
    }

    // mapping for GET top 3 permanent instructors with the lowest salary.
    @GetMapping("/instructors/permanentInstructor/last3")
    public ResponseEntity<?> findFirst3PermanentInstructorsByOrderByFixedSalaryAsc() {
        return new ResponseEntity<>(instructorService.findFirst3PermanentInstructorsByOrderByFixedSalaryAsc(), HttpStatus.OK);
    }

    // mapping for GET top 3 visiting researchers with the highest salary.
    @GetMapping("/instructors/visitingResearcher/top3")
    public ResponseEntity<?> findFirst3VisitingResearchersByOrderByHourlySalaryDesc() {
        return new ResponseEntity<>(instructorService.findFirst3VisitingResearchersByOrderByHourlySalaryDesc(), HttpStatus.OK);
    }

    // mapping for GET top 3 visiting researchers with the lowest salary.
    @GetMapping("/instructors/visitingResearcher/last3")
    public ResponseEntity<?> findFirst3VisitingResearchersByOrderByHourlySalaryAsc() {
        return new ResponseEntity<>(instructorService.findFirst3VisitingResearchersByOrderByHourlySalaryAsc(), HttpStatus.OK);
    }

}

