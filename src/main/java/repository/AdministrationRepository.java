package repository;

import database.Role;
import database.User;


import javax.ejb.Stateless;
import javax.transaction.Transaction;
import java.util.List;

@Stateless
public class AdministrationRepository extends Repository{
    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u").getResultList();
    }

    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    public int createUser(User user) {
        try {
            em.getTransaction().begin();
            Role defRole = (Role)em.createQuery("SELECT r from Role r WHERE r.name = :rolename")
                    .setParameter("rolename", "TOURIST")
                    .getSingleResult();
            user.setRole(defRole);
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return 0;
        }

        return 1;
    }

    public int updateRole(int userId, int roleId) {
        try {
            em.getTransaction().begin();
            Role role = em.find(Role.class, roleId);
            User user = em.find(User.class, userId);

            user.setRole(role);
            em.persist(user);
            em.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteUser(int userID) {
        try {
            em.getTransaction().begin();
            int res = em.createQuery("DELETE FROM User u " +
                            "WHERE u.userID = :userId")
                    .setParameter("userId", userID)
                    .executeUpdate();
            em.getTransaction().commit();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public User getUserByCredentials(String email, String password) {
        User user = null;
        try {
            user = (User)em.createQuery("SELECT u from User u WHERE " +
                            "u.email =:email " +
                            "AND u.password =:password")
                    .setParameter("email", email)
                    .setParameter("password", password).getSingleResult();
        } catch (Exception e) {
            System.out.println("No user with such credentials");
            e.printStackTrace();
        }
        return user;
    }
}
