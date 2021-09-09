package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
