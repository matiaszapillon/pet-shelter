package com.petshelter.repository;

import com.petshelter.entity.Pet;
import com.petshelter.repository.PetRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository should i use it here or in interface
public class PetRepositoryImpl {

    public void save(Pet pet){
        //petRepository.save(pet);
        //Initialize session objetc:
        //Using Configuration object and SessionFactory
        Session session = null;

        session.save(pet);
    }
}
