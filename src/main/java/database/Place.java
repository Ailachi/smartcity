package database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "place")
public class Place {
    @Id
    @Column(name = "placeID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int placeID;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "place")
    List<University> universities;

    @JsonIgnore
    @OneToMany(mappedBy = "place")
    List<TouristSight> sights;

    @JsonIgnore
    @OneToMany(mappedBy = "placeType")
    List<Vacancy> vacancies;

    public Place() {

    }

    public Place(String name) {
        this.name = name;
    }
}
