package ru.school.hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.school.hogwarts.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Collection<Student> getStudentsByAge(int age);

    Collection<Student> findByAgeBetween(int min, int max);

    Student findStudentById(Long id);
}
