package dev.patika.quixotic95.thirdhomework.service;

import dev.patika.quixotic95.thirdhomework.entity.Student;
import dev.patika.quixotic95.thirdhomework.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public boolean existsById(int studentId) {
        return studentRepository.existsById(studentId);
    }

    public List<Student> findAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public Optional<Student> findStudentById(int studentId) {
        return studentRepository.findById(studentId);
    }

    @Transactional
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    @Transactional
    public void deleteStudentById(int studentId) {
        studentRepository.deleteById(studentId);
    }

    public List<Student> findStudentsByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.findStudentsByFirstNameAndLastName(firstName, lastName);
    }

    public List<?> getStudentsGendersWithGrouping() {
        return studentRepository.getStudentsGendersWithGrouping();
    }

    @Transactional
    public void deleteStudentsByFirstNameAndLastName(String firstName, String lastName) {
        studentRepository.deleteStudentsByFirstNameAndLastName(firstName, lastName);
    }

}
