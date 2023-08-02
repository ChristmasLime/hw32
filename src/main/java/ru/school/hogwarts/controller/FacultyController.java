package ru.school.hogwarts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.school.hogwarts.model.Faculty;
import ru.school.hogwarts.model.Student;
import ru.school.hogwarts.services.FacultyService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    private final FacultyService service;

    public FacultyController(FacultyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(service.createFacul(faculty));
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> findFaculty(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.findFacul(id));
    }

    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        if (faculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(service.editFacul(faculty));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteFaculty(@PathVariable Long id) {
        service.deleteFacul(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> getAllFaculty() {
        return ResponseEntity.ok(service.getAllFacul());
    }

    @GetMapping("color/{color}")
    public ResponseEntity<Collection<Faculty>> getFacultyByColor(@PathVariable String color) {
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(service.getFaculByColor(color));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("search")
    public ResponseEntity<Collection<Faculty>> getFacultyByNameOrColor(
            @RequestParam String searchString) {
        if (searchString != null && !searchString.isBlank()) {
            return ResponseEntity.ok(service.getFaculByNameAndByColor(searchString));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("{id}/student")
    public ResponseEntity<Collection<Student>> getFacultyByStudents(@PathVariable Long id) {
        return ResponseEntity.ok(service.getFacultyInStudent(id));
    }
}
