package com.petshelter.service;

import com.petshelter.entity.Pet;
import com.petshelter.entity.TransitShelterPerson;
import com.petshelter.repository.TransitShelterPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransitShelterPersonServiceImpl implements TransitShelterPersonService {
    private final TransitShelterPersonRepository transitShelterPersonRepository;

    public TransitShelterPersonServiceImpl(TransitShelterPersonRepository transitShelterPersonRepository){
        this.transitShelterPersonRepository = transitShelterPersonRepository;
    }

    @Override
    public void save(TransitShelterPerson transitShelterPerson) {
        this.transitShelterPersonRepository.save(transitShelterPerson);
    }

    @Override
    public List<Pet> getAllTransitPet(Long id) {
        TransitShelterPerson transitShelterPersonWithPets = this.transitShelterPersonRepository.getById(id);
        return transitShelterPersonWithPets.getPetList();
    }
}
