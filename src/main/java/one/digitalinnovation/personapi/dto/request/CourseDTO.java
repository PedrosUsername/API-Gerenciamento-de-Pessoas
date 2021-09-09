package one.digitalinnovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;


    private String imgUrl;

    @NotNull
    private Float price;

    @NotEmpty
    private String code;

    @NotNull
    private Float duration ;

    @NotNull
    private Float rating;


    private String description;

    @NotEmpty
    private String releaseDate;
}
