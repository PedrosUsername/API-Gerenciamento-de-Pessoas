package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.dto.request.CourseDTO;
import one.digitalinnovation.personapi.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Mapping(target = "releaseDate", source = "releaseDate")
    Course toModel(CourseDTO courseDTO);

    CourseDTO toDTO(Course course);
}