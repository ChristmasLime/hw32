package ru.school.hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.school.hogwarts.model.Faculty;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {

    Collection<Faculty> getFacultiesByColor(String color);

    Collection<Faculty> getFacultiesByNameOrColorIgnoreCase(String name, String color);

    Faculty findFacultiesById(Long id);

}