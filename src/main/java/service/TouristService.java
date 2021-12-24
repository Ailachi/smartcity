package service;

import database.Place;
import database.TouristSight;
import repository.TouristRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class TouristService {

    @EJB
    private TouristRepository repo;

    public List<TouristSight> getAllSights() {
        return repo.getSights();
    }

    public TouristSight getSightById(int id) {
        return repo.getSightById(id);
    }

    public Place getPlaceBySightId(int id) {
        return repo.getPlaceBySightId(id);
    }

    public List<TouristSight> getSightsByPlaceId(int id) {
        return repo.getSightsByPlaceId(id);
    }
}
