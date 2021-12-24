package service;

import database.User;
import repository.AdministrationRepository;
import view.UserView;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;


@Stateless
public class AdministrationService {
    @EJB
    private AdministrationRepository repo;

    public List<User> getAllUsers() {
        return repo.getAllUsers();
    }

    public UserView getUserById(int id) {
        User user = repo.getUserById(id);
        UserView userView = new UserView(user);
        return userView;
    }

    public int createUser(User user) {
        return repo.createUser(user);
    }

    public int updateRole(int userId, int roleId) {
        return repo.updateRole(userId, roleId);
    }

    public int deleteUser(int userID) {
        return repo.deleteUser(userID);
    }

    public User getUserByCredentials(String email, String password) {
        return repo.getUserByCredentials(email, password);
    }

}
