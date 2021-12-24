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
@Table(name = "specialty")
public class Specialty {
    @Id
    @Column(name = "specialtyID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int specialtyID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "hasScholarship", nullable = false)
    private Boolean hasScholarship;

    @JsonIgnore
    @ManyToMany(mappedBy = "specialties")
    List<Subject> specialtySubjects;

    @OneToMany(mappedBy = "specialty")
    @JsonIgnore
    List<University> universities;


    public Specialty() {

    }

    public Specialty(String name, Boolean hasScholarship, List<Subject> subjects) {
        this.name = name;
        this.hasScholarship = hasScholarship;
        this.specialtySubjects = subjects;
    }

    @Override
    public String toString() {return "Speciality: " + this.name; }
}
