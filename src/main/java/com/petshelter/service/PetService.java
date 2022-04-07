package com.petshelter.service;

import com.petshelter.entity.Pet;
import com.petshelter.helper.PetType;

import java.util.List;

public interface PetService {
     void save(Pet pet);

     Pet getPetById(Long id);

     List<Pet> getAllByType(PetType type);

     List<Pet> getAllTransitPetByIdTransitShelterPerson(Long id);
}
