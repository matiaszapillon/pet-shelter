package com.petshelter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pet {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String location;
    private String type;
}
