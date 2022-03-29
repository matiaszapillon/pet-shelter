package com.petshelter.repository;

import com.petshelter.entity.Pet;
import com.petshelter.helper.PetType;

import java.util.List;

public interface CustomPetRepository {
    List<Pet> getAllPetByType(PetType type);
}
