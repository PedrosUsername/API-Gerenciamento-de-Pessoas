package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.request.CourseDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.model.Course;
import one.digitalinnovation.personapi.mapper.CourseMapper;
import one.digitalinnovation.personapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.digitalinnovation.personapi.exception.CourseNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    final private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    private final CourseMapper courseMapper = CourseMapper.INSTANCE;


    public MessageResponseDTO createCourse(CourseDTO courseDTO) {
        Course courseToSave = courseMapper.toModel(courseDTO);

        Course savedCourse = courseRepository.save(courseToSave);
        return MessageResponseDTO
                .builder()
                .message("creation success!")
                .build();
    }

    public List<CourseDTO> listAll() {
        List<Course> allPeople = courseRepository.findAll();
        return allPeople.stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO findById(Long id) throws CourseNotFoundException {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isEmpty())
            throw new CourseNotFoundException(id);

        return courseMapper.toDTO(optionalCourse.get());
    }

    public void delete(Long id) throws CourseNotFoundException{
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isEmpty())
            throw new CourseNotFoundException(id);

        courseRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, CourseDTO courseDTO) throws CourseNotFoundException {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isEmpty())
            throw new CourseNotFoundException(id);

        Course courseToUpdate = courseMapper.toModel(courseDTO);

        Course updatedCourse = courseRepository.save(courseToUpdate);
        return MessageResponseDTO
                .builder()
                .message("Updated course with ID " + updatedCourse.getId())
                .build();
    }
}
