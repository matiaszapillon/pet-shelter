package com.petshelter.entity;

import com.petshelter.helper.PetType;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String location;
    @Enumerated(value = EnumType.STRING)
    private PetType type;
    @Column(name = "stamp_created")
    private Timestamp stampCreated;
    @Column(name = "stamp_updated")
    private Timestamp stampUpdated;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_transit_shelter_person") //Join column to refer the FK. @MappedBy to make the relationship bidirectional in TransitShelterPerson class
    private TransitShelterPerson transitShelterPerson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public Timestamp getStampCreated() {
        return stampCreated;
    }

    public void setStampCreated(Timestamp stampCreated) {
        this.stampCreated = stampCreated;
    }

    public Timestamp getStampUpdated() {
        return stampUpdated;
    }

    public void setStampUpdated(Timestamp stampUpdated) {
        this.stampUpdated = stampUpdated;
    }

    public TransitShelterPerson getTransitShelterPerson() {
        return transitShelterPerson;
    }

    public void setTransitShelterPerson(TransitShelterPerson transitShelterPerson) {
        this.transitShelterPerson = transitShelterPerson;
    }
}
