package ru.school.hogwarts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.school.hogwarts.model.Faculty;
import ru.school.hogwarts.model.Student;
import ru.school.hogwarts.services.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(service.createStud(student));
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> findStudent(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.findStud(id));
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        if (student == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(service.editStud(student));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        service.deleteStud(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudents() {
        return ResponseEntity.ok(service.getAllStud());

    }

    @GetMapping("age/{age}")
    public ResponseEntity<Collection<Student>> getAllStudentsByAge(@PathVariable int age) {
        if (age < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(service.getStudByAge(age));
    }

    @GetMapping("age")
    public ResponseEntity<Collection<Student>> getAllStudentByBetweenAge(@RequestParam int minAge, @RequestParam int maxAge) {
        if (minAge >= maxAge) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(service.getStudByAgeBetween(minAge, maxAge));
    }

    @GetMapping("{id}/faculty")
    public ResponseEntity<Faculty> getStudentByFaculty(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudById(id));
    }

}
