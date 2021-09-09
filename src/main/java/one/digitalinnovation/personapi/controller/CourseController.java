package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.request.CourseDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import one.digitalinnovation.personapi.exception.CourseNotFoundException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createCourse(@RequestBody @Valid CourseDTO courseDTO) {
        return courseService.createCourse(courseDTO);
    }

    @GetMapping
    public List<CourseDTO> listAll() {
        return courseService.listAll();
    }

    @GetMapping("/{id}")
    public CourseDTO findById(@PathVariable Long id) throws CourseNotFoundException {
        return courseService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws CourseNotFoundException {
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid CourseDTO courseDTO) throws CourseNotFoundException {
        return courseService.updateById(id, courseDTO);
    }

}
