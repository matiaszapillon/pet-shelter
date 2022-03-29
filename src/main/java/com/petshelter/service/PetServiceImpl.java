package com.petshelter.service;

import com.petshelter.entity.Pet;
import com.petshelter.helper.PetType;
import com.petshelter.repository.PetRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PetServiceImpl implements PetService{

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    @Override
    public void save(Pet pet) {
        if(pet != null){
            java.util.Date date = new java.util.Date();
            Timestamp stampCreated = new Timestamp(date.getTime());
            pet.setStampCreated(stampCreated);
            pet.setStampUpdated(stampCreated);
            petRepository.save(pet);
        }
    }

    @Override
    public Pet getPetById(Long id) {
        if(id != null){
            return petRepository.getById(id);
        }else{
            throw new RuntimeException();
        }
    }

    @Override
    public List<Pet> getAllByType(PetType type) {
        return petRepository.findAll(isADog(type));
    }


    //Spring data Specifications.
    static Specification<Pet> isADog(PetType petType) {
        return (book, cq, cb) -> cb.equal(book.get("type"), petType);
    }
}
