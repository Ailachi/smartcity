package database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "university")
public class University {
    @Id
    @Column(name = "universityID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int universityID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "avgGpa", nullable = false)
    private BigDecimal avgGpa;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "specialtyID")
    Specialty specialty;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "placeID")
    Place place;


    public University() {}

    public University(String name, String phone, String address,
                      BigDecimal avgGpa, Specialty specialty, Place place) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.avgGpa = avgGpa;
        this.specialty = specialty;
        this.place = place;
    }

    @Override
    public String toString() {
        return "University: " + this.name + ", GPA: " + this.avgGpa.toString();
    }
}
