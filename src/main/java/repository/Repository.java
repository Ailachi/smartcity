package repository;

import database.*;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Stateful
public class Repository {
    protected static String PERSISTENCE_UNIT_NAME = "default";
    protected static EntityManagerFactory factory = null;
    protected static EntityManager em = null;
    private static boolean isInitialized = false;

    public Repository() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        if(!isInitialized) {
            try {
//                dbSetup();
                System.out.println("DB HAS BEEN SUCCESSFULLY INITIALIZED");
                isInitialized = true;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("DB INITIALIZATION FAILED!");
            }
        }



    }

    public void dbSetup() {

        List<Role> roles = Arrays.asList(
                new Role("ADMIN"),
                new Role("STUDENT"),
                new Role("TOURIST"),
                new Role("BUSINESSPERSON"),
                new Role("JOBSEEKER")
        );
        for(Role role : roles) {
            em.getTransaction().begin();
            em.persist(role);
            em.getTransaction().commit();
        }

        List<User> users = Arrays.asList(
                new User("Elvira", "Nugmanova", "elvira@gmail.com", "123", roles.get(0)),
                new User("Anuar", "Borangaziyev", "anuar@gmail.com", "123", roles.get(1)),
                new User("Aldiyar", "Orazbek", "aldik@gmail.com", "123", roles.get(2)),
                new User("Raphael", "Turtle", "ninja@gmail.com", "123",  roles.get(3)),
                new User("Leonardo", "Di Caprio", "oscar@gmail.com", "123",  roles.get(4)),
                new User("Michael", "Grey", "michael@gmail.com", "123",  roles.get(3))
        );
        for(User user : users) {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }

        List<Subject> subjects = Arrays.asList(
                new Subject("Math", 3),
                new Subject("Physics", 2),
                new Subject("Psychology", 1),
                new Subject(".Net", 1)
        );
        for(Subject subj : subjects) {
            em.getTransaction().begin();
            em.persist(subj);
            em.getTransaction().commit();
        }

        List<Specialty> specialties = Arrays.asList(
                new Specialty("Software Engineer", true, Arrays.asList(subjects.get(0),subjects.get(1))),
                new Specialty("IS", false, Arrays.asList(subjects.get(0), subjects.get(2))),
                new Specialty("CSSE", true, Arrays.asList(subjects.get(0), subjects.get(1), subjects.get(3))),
                new Specialty("Computer Science", false, Arrays.asList(subjects.get(1)))
        );
        for(Specialty spec : specialties) {
            em.getTransaction().begin();
            em.persist(spec);
            em.getTransaction().commit();
        }



        List<Place> places = Arrays.asList(
                new Place("IITU main building"),
                new Place("Baizak Center"),
                new Place("Dostyk Plaza")
        );

        for(Place place : places) {
            em.getTransaction().begin();
            em.persist(place);
            em.getTransaction().commit();
        }

        List<University> universities = Arrays.asList(
                new University("IITU", "777","Jand Manas", new BigDecimal(3.25d), specialties.get(0), places.get(0)),
                new University("KBTU", "666","Tole Abyl", new BigDecimal(3.0d), specialties.get(1), places.get(1)),
                new University("Satbayev", "555","Bait Satb", new BigDecimal(2.4d), specialties.get(2), places.get(2))
        );

        for(University uni : universities) {
            em.getTransaction().begin();
            em.persist(uni);
            em.getTransaction().commit();
        }

        List<BusinessNews> news = Arrays.asList(
                new BusinessNews("Stocks", "Today's stock is good. Yesterday it was not good", users.get(3)),
                new BusinessNews("Book", "It is very important to read books, guys. So, do it.", users.get(5))
        );
        for(BusinessNews bn : news) {
            em.getTransaction().begin();
            em.persist(bn);
            em.getTransaction().commit();
        }

    }

}
