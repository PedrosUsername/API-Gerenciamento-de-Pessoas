package one.digitalinnovation.personapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    private String imgUrl;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private Float duration;

    @Column(nullable = false)
    private Float rating;


    private String description;

    @Column(nullable = false)
    private LocalDate uploadDate;
}
