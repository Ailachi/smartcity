package database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @Column(name = "subjectID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "credits", nullable = false)
    private int credits;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "SpecialtySubject",
            joinColumns = @JoinColumn(name = "subjectID"),
            inverseJoinColumns = @JoinColumn(name = "specialtyID")
    )
    List<Specialty> specialties;

    public Subject() {

    }
    public Subject(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }
}
