package com.petshelter.service;

import com.petshelter.entity.Pet;
import com.petshelter.entity.TransitShelterPerson;
import com.petshelter.repository.PetRepository;
import com.petshelter.repository.TransitShelterPersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PetServiceImplTest {

    private PetRepository petRepository;
    private PetService petService;
    private TransitShelterPersonRepository transitShelterPersonRepository;

    @BeforeEach
    void setUp() {
        petRepository = Mockito.mock(PetRepository.class);
        petService = new PetServiceImpl(petRepository,transitShelterPersonRepository);
    }


    @Test
    void save() {
        Pet pet = new Pet();

        Mockito.doNothing().when(petRepository.save(pet)); //Why I get errors here? How can I mock a void method?
        petService.save(pet);
        Assertions.assertNotNull(pet.getId());
    }

    @Test
    void getPetbyId(){
        Pet mockedPet = new Pet();
        mockedPet.setId(2L);
        mockedPet.setName("PetMocked");
        Mockito.when(petRepository.getById(2L)).thenReturn(mockedPet);
        Pet pet = petService.getPetById(2L);
        Assertions.assertEquals(mockedPet.getId(),pet.getId());
    }
}