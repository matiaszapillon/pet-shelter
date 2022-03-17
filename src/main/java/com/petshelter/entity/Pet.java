package com.petshelter.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String location;
    private String type;
    @Column(name = "stamp_created")
    private Timestamp stampCreated;
    @Column(name = "stamp_updated")
    private Timestamp stampUpdated;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
}
