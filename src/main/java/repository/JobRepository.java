package repository;

import database.Role;
import database.Vacancy;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class JobRepository extends Repository{
    public List<Vacancy> getAllVacancies() {
        return em.createQuery("SELECT v FROM Vacancy v")
                .getResultList();
    }

    public int createVacancy(Vacancy vacancy) {
        try {
            em.getTransaction().begin();
            em.persist(vacancy);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return 0;
        }

        return 1;
    }

}
