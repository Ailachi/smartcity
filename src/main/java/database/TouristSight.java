package database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "sight")
public class TouristSight {
    @Id
    @Column(name = "sightID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sightID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "childrenfree", nullable = false)
    private Boolean childrenFree;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "placeID")
    private Place place;

    @Override
    public String toString() {
        return "SIGHT ID: " + this.sightID + ", NAME: " + this.name + ", PHONE: " + this.phone + ", ADDRESS: " +
                this.address + ", CHILDREN FREE TICKETS: " + this.childrenFree + "PLACE ID: " + this.place.getPlaceID();
    }

    public int getSightID() {
        return sightID;
    }

    public void setSightID(int sightID) {
        this.sightID = sightID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getChildrenFree() {
        return childrenFree;
    }

    public void setChildrenFree(Boolean childrenFree) {
        this.childrenFree = childrenFree;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
