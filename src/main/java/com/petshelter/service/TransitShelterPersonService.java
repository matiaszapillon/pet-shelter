package com.petshelter.service;

import com.petshelter.entity.Pet;
import com.petshelter.entity.TransitShelterPerson;

import java.util.List;

public interface TransitShelterPersonService {
    void save(TransitShelterPerson transitShelterPerson);

    List<Pet> getAllTransitPet(Long id);
}
