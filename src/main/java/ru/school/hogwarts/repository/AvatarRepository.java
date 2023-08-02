package ru.school.hogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.school.hogwarts.model.Avatar;
import ru.school.hogwarts.model.Student;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar,Long> {

    Optional<Avatar> findByStudentId(Long studId);
}
