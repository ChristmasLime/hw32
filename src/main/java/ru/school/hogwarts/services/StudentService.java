package ru.school.hogwarts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.school.hogwarts.model.Faculty;
import ru.school.hogwarts.model.Student;
import ru.school.hogwarts.repository.StudentRepository;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student createStud(Student student) {
        return repository.save(student);
    }

    public Student findStud(long id) {
        return repository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public Student editStud(Student student) {
        return repository.save(student);
    }

    public void deleteStud(long id) {
        repository.deleteById(id);

    }
    public Collection<Student>getAllStud() {
        return repository.findAll();
    }

    public Collection<Student> getStudByAge(int age) {
        return repository.getStudentsByAge(age);

    }

    public Collection<Student> getStudByAgeBetween(int minAge, int maxAge) {
        return repository.findByAgeBetween(minAge, maxAge);
    }

    public Faculty getStudById(long id) {
        Student student = repository.findStudentById(id);
        if (student==null) {
            throw new NoSuchElementException("Студент с данным ID не существует");
        }
        return student.getFaculty();
    }
}

