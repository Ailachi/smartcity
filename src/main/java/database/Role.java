package database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "roleID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleID;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    List<User> users;

    @Override
    public String toString() {
        return "ROLE ID: " + this.roleID + ", ROLE NAME: " + this.name;
    }

    public Role() {}

    public Role(String name) {
        this.name = name;
    }
}
