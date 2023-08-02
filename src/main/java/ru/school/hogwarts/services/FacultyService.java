package ru.school.hogwarts.services;

import org.springframework.stereotype.Service;
import ru.school.hogwarts.model.Faculty;
import ru.school.hogwarts.model.Student;
import ru.school.hogwarts.repository.FacultyRepository;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class FacultyService {

    private final FacultyRepository repository;

    public FacultyService(FacultyRepository repository) {
        this.repository = repository;
    }

    public Faculty createFacul(Faculty faculty) {
        return repository.save(faculty);
    }

    public Faculty findFacul(long id) {
        return repository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public Faculty editFacul(Faculty faculty) {
        return repository.save(faculty);
    }

    public void deleteFacul(long id) {
        repository.deleteById(id);

    }

    public Collection< Faculty> getAllFacul() {
        return repository.findAll();
    }

    public Collection<Faculty> getFaculByColor(String color) {
        return repository.getFacultiesByColor(color);
    }

    public Collection<Faculty> getFaculByNameAndByColor(String searchString) {
        return repository.getFacultiesByNameOrColorIgnoreCase(searchString, searchString);
    }

    public Collection<Student> getFacultyInStudent(Long id) {
        Faculty faculty = repository.findFacultiesById(id);
        if (faculty==null) {

            throw new NoSuchElementException("Факультета с данный ID не сущестует");
        }
        return faculty.getStudents();
    }
}
