package database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "userID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    List<BusinessNews> news;

    //    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "roleID")
    Role role;

    public User() {

    }

    public User(String name, String surname, String email, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "USER ID: " + this.userID + ", NAME: " + this.name + ", SURNAME: " + this.surname +
                ", EMAIL: " + this.email + ", PASSWORD: " + this.password + ", ROLE ID: " + this.role.getRoleID();
    }

}
