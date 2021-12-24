package service;

import database.BusinessNews;
import database.User;
import repository.BusinessRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import java.util.List;

@Stateless
public class BusinessService {

    @EJB
    private BusinessRepository repo;

    public List<BusinessNews> getBusinessNews() {
        return repo.getBusinessNews();
    }

    public List<BusinessNews> getNewsByAuthorId(int id) {
        return repo.getNewsByAuthorId(id);
    }

    public User getAuthorByNewsId(int id) {
        return repo.getAuthorByNewsId(id);
    }

    public BusinessNews getNewsById(int id) {
        return repo.getNewsById(id);
    }



}
