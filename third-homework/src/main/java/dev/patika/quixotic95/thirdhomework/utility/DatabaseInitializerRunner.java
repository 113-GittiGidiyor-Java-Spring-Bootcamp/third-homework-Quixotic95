package dev.patika.quixotic95.thirdhomework.utility;

import dev.patika.quixotic95.thirdhomework.entity.*;
import dev.patika.quixotic95.thirdhomework.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class DatabaseInitializerRunner implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    InstructorRepository<Instructor> instructorRepository;
    @Autowired
    PermanentInstructorRepository permanentInstructorRepository;
    @Autowired
    VisitingResearcherRepository visitingResearcherRepository;

    @Override
    public void run(String... args) {

        studentRepository.deleteAll();
        courseRepository.deleteAll();
        instructorRepository.deleteAll();

        /*

        // Builder template for Student
        studentRepository.save(Student.builder()
                .firstName("Ahmet Emre")
                .lastName("Oğuz")
                .address("İstanbul, Turkey")
                .birthDate(LocalDate.of(1995, Month.JULY, 26))
                .gender(Gender.MALE)
                .build());


        // Builder template for Course
        courseRepository.save(Course.builder()
                .courseName("")
                .courseCode("")
                .creditScore()
                .build());

        // Builder template for PermanentInstructor
        permanentInstructorRepository.save(PermanentInstructor.builder()
                .firstName("")
                .lastName("")
                .address("")
                .phoneNumber("")
                .fixedSalary()
                .build());


        // Builder template for VisitingResearcher
        visitingResearcherRepository.save(VisitingResearcher.builder()
                .firstName("")
                .lastName("")
                .address("")
                .phoneNumber("")
                .hourlySalary()
                .build());

         */

        studentRepository.save(Student.builder()
                .firstName("Ahmet Emre")
                .lastName("Oğuz")
                .address("İstanbul, Turkey")
                .birthDate(LocalDate.of(1995, Month.JULY, 26))
                .gender(Gender.MALE)
                .build());

        studentRepository.save(Student.builder()
                .firstName("Edwin")
                .lastName("Bailey")
                .address("Ottawa, Canada")
                .birthDate(LocalDate.of(1991, Month.MAY, 5))
                .gender(Gender.OTHER)
                .build());

        studentRepository.save(Student.builder()
                .firstName("Henry")
                .lastName("Elliott")
                .address("San Juan, Puerto Rico")
                .birthDate(LocalDate.of(2002, Month.AUGUST, 19))
                .gender(Gender.MALE)
                .build());

        studentRepository.save(Student.builder()
                .firstName("Brad")
                .lastName("Johnson")
                .address("Yokohama, Japan")
                .birthDate(LocalDate.of(1998, Month.AUGUST, 4))
                .gender(Gender.MALE)
                .build());

        studentRepository.save(Student.builder()
                .firstName("Ada")
                .lastName("Richards")
                .address("Yerevan, Armenia")
                .birthDate(LocalDate.of(1995, Month.DECEMBER, 13))
                .gender(Gender.FEMALE)
                .build());

        studentRepository.save(Student.builder()
                .firstName("Olivia")
                .lastName("Parker")
                .address("Gaborone, Botswana")
                .birthDate(LocalDate.of(2001, Month.APRIL, 22))
                .gender(Gender.FEMALE)
                .build());

        courseRepository.save(Course.builder()
                .courseName("Turkish Language - 1")
                .courseCode("TDL1001")
                .creditScore(2)
                .courseInstructor(permanentInstructorRepository.save(PermanentInstructor.builder()
                        .firstName("Koray")
                        .lastName("Güney")
                        .address("İstanbul, Turkey")
                        .phoneNumber("05555855995")
                        .fixedSalary(12000)
                        .build()))
                .build());

        permanentInstructorRepository.save(PermanentInstructor.builder()
                .firstName("Bruis")
                .lastName("Champley")
                .address("18258 Doe Crossing Junction")
                .phoneNumber("564-999-0444")
                .fixedSalary(8176)
                .build());

        permanentInstructorRepository.save(PermanentInstructor.builder()
                .firstName("Archaimbaud")
                .lastName("Blandamore")
                .address("833 Orin Point")
                .phoneNumber("902-672-7973")
                .fixedSalary(10333)
                .build());

        permanentInstructorRepository.save(PermanentInstructor.builder()
                .firstName("Felita")
                .lastName("Jelkes")
                .address("405 Morningstar Way")
                .phoneNumber("758-365-5543")
                .fixedSalary(8531)
                .build());

        permanentInstructorRepository.save(PermanentInstructor.builder()
                .firstName("Katrine")
                .lastName("Kik")
                .address("3195 4th Hill")
                .phoneNumber("527-933-1282")
                .fixedSalary(9332)
                .build());

        permanentInstructorRepository.save(PermanentInstructor.builder()
                .firstName("Jemmie")
                .lastName("Sennett")
                .address("12958 Rutledge Crossing")
                .phoneNumber("121-775-1574")
                .fixedSalary(4229)
                .build());

        permanentInstructorRepository.save(PermanentInstructor.builder()
                .firstName("Maddie")
                .lastName("Johnston")
                .address("Kuwait City, Kuwait")
                .phoneNumber("356-1742-16")
                .fixedSalary(5500)
                .build());

        permanentInstructorRepository.save(PermanentInstructor.builder()
                .firstName("Belinda")
                .lastName("Riley")
                .address("Bordeaux, France")
                .phoneNumber("207-2627-45")
                .fixedSalary(6000)
                .build());

        visitingResearcherRepository.save(VisitingResearcher.builder()
                .firstName("William")
                .lastName("Ross")
                .address("Kigali, Rwanda")
                .phoneNumber("820-9900-18")
                .hourlySalary(200)
                .build());

        visitingResearcherRepository.save(VisitingResearcher.builder()
                .firstName("Quillan")
                .lastName("Haberfield")
                .address("06 Grim Street")
                .phoneNumber("812-833-9928")
                .hourlySalary(366)
                .build());

        visitingResearcherRepository.save(VisitingResearcher.builder()
                .firstName("Temp")
                .lastName("Pratten")
                .address("279 Wayridge Parkway")
                .phoneNumber("329-314-8626")
                .hourlySalary(232)
                .build());

        visitingResearcherRepository.save(VisitingResearcher.builder()
                .firstName("Hercules")
                .lastName("Sparrowe")
                .address("5789 Derek Place")
                .phoneNumber("873-414-1030")
                .hourlySalary(360)
                .build());

        visitingResearcherRepository.save(VisitingResearcher.builder()
                .firstName("Sherlock")
                .lastName("Girodon")
                .address("09 Carey Drive")
                .phoneNumber("738-699-9631")
                .hourlySalary(195)
                .build());

    }

}
