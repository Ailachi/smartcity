package view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import database.BusinessNews;
import database.Role;
import database.User;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UserView {

    private int id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private String rolename;

    public UserView() {

    }

    public UserView(User user) {
        this.id = user.getUserID();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.rolename = user.getRole().getName();
    }

    public static List<UserView> getListOfViews(List<User> users) {
        List<UserView> views = new ArrayList<>();
        for(User user:users) {
            views.add(new UserView(user));
        }
        return views;
    }
}
