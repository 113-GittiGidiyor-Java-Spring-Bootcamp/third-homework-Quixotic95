package dev.patika.quixotic95.thirdhomework.controller;

import dev.patika.quixotic95.thirdhomework.entity.Student;
import dev.patika.quixotic95.thirdhomework.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    // dependency injection with @Autowired annotation (not necessary to write, injects automatically; but placed for better-reading)
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // expose "/students" and return list of students
    @GetMapping("/students")
    public ResponseEntity<?> findAllStudents() {
        return new ResponseEntity<>(studentService.findAllStudents(), HttpStatus.OK);
    }

    // add mapping for GET /students/{studentId} to get a student by id
    @GetMapping("/students/{studentId}")
    public ResponseEntity<?> findStudentById(@PathVariable int studentId) {
        Optional<Student> foundStudent = studentService.findStudentById(studentId);
        if (foundStudent.isPresent()) {
            return new ResponseEntity<>(foundStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student with id: " + studentId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // add mapping for POST /students - add new student
    @PostMapping("/students")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        int studentId = student.getId();
        if (studentService.existsById(studentId)) {
            return new ResponseEntity<>("Student with id: " + studentId + " already exists.", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.OK);
        }
    }

    // add mapping for PUT /students - update existing student
    @PutMapping("/students")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        if (studentService.existsById(student.getId())) {
            return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student with id: " + student.getId() + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // add mapping for DELETE /students - delete student
    @DeleteMapping("/students")
    public ResponseEntity<String> deleteStudent(@RequestBody Student student) {
        int studentId = student.getId();
        if (studentService.existsById(studentId)) {
            studentService.deleteStudent(student);
            return new ResponseEntity<>("Student with id: " + studentId + " deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student with id: " + studentId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // add mapping for DELETE /students/{studentId} - delete student by id
    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int studentId) {
        if (studentService.existsById(studentId)) {
            studentService.deleteStudentById(studentId);
            return new ResponseEntity<>("Student with id: " + studentId + " deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student with id: " + studentId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // add mapping for GET student(s) by their name
    @GetMapping("/students/byName")
    public ResponseEntity<?> findStudentsByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return new ResponseEntity<>(studentService.findStudentsByFirstNameAndLastName(firstName, lastName), HttpStatus.OK);
    }

    @GetMapping("/students/groupByGender")
    public ResponseEntity<?> getStudentsGendersWithGrouping() {
        return new ResponseEntity<>(studentService.getStudentsGendersWithGrouping(), HttpStatus.OK);
    }

    @DeleteMapping("/students/byName")
    public ResponseEntity<String> deleteStudentByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        if (studentService.findStudentsByFirstNameAndLastName(firstName, lastName).isEmpty()) {
            return new ResponseEntity<>("Student with name: " + firstName + " " + lastName + " not found.", HttpStatus.BAD_REQUEST);
        } else {
            studentService.deleteStudentByFirstNameAndLastName(firstName, lastName);
            return new ResponseEntity<>("Student with name: " + firstName + " " + lastName + " deleted.", HttpStatus.OK);
        }
    }

}
