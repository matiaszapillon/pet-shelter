package com.petshelter;

import com.petshelter.entity.Pet;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class PetRepositoryImpl {

    @Autowired
    private PetRepository petRepository;

    public void save(Pet pet){
        //petRepository.save(pet);
        //Initialize session objetc:
        //Using Configuration object and SessionFactory
        Session session = null;

        session.save(pet);
    }
}
