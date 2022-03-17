package com.petshelter.repository;

import com.petshelter.entity.Pet;

import java.util.List;

public interface CustomPetRepository {
    List<Pet> getAllPetByType(String type);
}
