package repository;

import database.Place;
import database.TouristSight;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class TouristRepository extends Repository{
    public List<TouristSight> getSights() {
        return em.createQuery("SELECT s from TouristSight s").getResultList();
    }

    public TouristSight getSightById(int id) {
        return em.find(TouristSight.class, id);
    }

    public Place getPlaceBySightId(int id) {
        TouristSight sight = em.find(TouristSight.class, id);
        return sight.getPlace();
    }

    public List<TouristSight> getSightsByPlaceId(int id) {
        Place place = em.find(Place.class, id);
        return place.getSights();
    }


}
