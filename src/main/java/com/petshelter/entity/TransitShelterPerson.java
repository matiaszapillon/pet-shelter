package com.petshelter.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class TransitShelterPerson extends Person {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transitShelterPerson") //to make it bidirectional
    //If we use this object in rest call then we will have a recursive reference between both properties and we should use an jackson annotation to ignore it
    //'For Jackson to work well, one of the two sides of the relationship should not be serialized, in order to avoid the infite loop that causes your stackoverflo error.'
    private List<Pet> petList;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }
}
