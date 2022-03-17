package com.petshelter.service;

import com.petshelter.entity.Pet;

public interface PetService {
     void save(Pet pet);

     Pet getPetById(Long id);
}
