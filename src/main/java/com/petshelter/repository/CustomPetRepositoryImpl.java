package com.petshelter.repository;

import com.petshelter.entity.Pet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomPetRepositoryImpl implements CustomPetRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Pet> getAllPetByType(String type) {

        return null;
    }
}
