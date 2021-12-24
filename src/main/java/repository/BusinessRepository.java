package repository;

import database.BusinessNews;
import database.User;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class BusinessRepository extends Repository{
    public List<BusinessNews> getBusinessNews() {
        return em.createQuery("SELECT bn FROM BusinessNews bn").getResultList();
    }

    public User getAuthorByNewsId(int id) {
        try {
            User user = (User)em.createQuery("SELECT n.author FROM BusinessNews n WHERE n.newsID = :id")
                    .setParameter("id", id)
                    .getSingleResult();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    public List<BusinessNews> getNewsByAuthorId(int id) {
        return em.createQuery("SELECT u.news FROM User u WHERE u.userID = :id")
                .setParameter("id", id)
                .getResultList();
    }

    public BusinessNews getNewsById(int id) {
        return em.find(BusinessNews.class, id);
    }

}
