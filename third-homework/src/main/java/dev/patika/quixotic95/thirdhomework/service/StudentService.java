package dev.patika.quixotic95.thirdhomework.service;

import dev.patika.quixotic95.thirdhomework.entity.Student;
import dev.patika.quixotic95.thirdhomework.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public boolean existsById(int studentId) {
        return studentRepository.existsById(studentId);
    }

    @Transactional
    public List<Student> findAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Transactional
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

    @Transactional
    public List<Student> findStudentsByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.findStudentsByFirstNameAndLastName(firstName, lastName);
    }

    @Transactional
    public List<?> getStudentsGendersWithGrouping() {
        return studentRepository.getStudentsGendersWithGrouping();
    }

    @Transactional
    public void deleteStudentByFirstNameAndLastName(String firstName, String lastName) {
        studentRepository.deleteStudentByFirstNameAndLastName(firstName, lastName);
    }
}
