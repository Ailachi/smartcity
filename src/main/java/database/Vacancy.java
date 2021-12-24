package database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import converter.JpaConverter;
import converter.LocalDateDeserializer;
import converter.LocalDateSerializer;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "vacancy")
public class Vacancy {
    @Id
    @Column(name = "vacancyID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vacancyID;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "postdate", nullable = false, columnDefinition = "DATE")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate postDate;

    @Column(name = "salary", nullable = false)
    private int salary;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "placeType")
    private Place placeType;
}
