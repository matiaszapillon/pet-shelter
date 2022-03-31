package com.petshelter.controller;

import com.petshelter.entity.Pet;
import com.petshelter.entity.TransitShelterPerson;
import com.petshelter.repository.TransitShelterPersonRepository;
import com.petshelter.service.TransitShelterPersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransitShelterPersonController {

    private final TransitShelterPersonRepository transitShelterPersonRepository;
    private final TransitShelterPersonService transitShelterPersonService;
    //private final TransitShelterPersonModelAssembler transitShelterPersonModelAssembler;

    public TransitShelterPersonController(TransitShelterPersonRepository transitShelterPersonRepository, TransitShelterPersonService transitShelterPersonService){
        this.transitShelterPersonRepository = transitShelterPersonRepository;
        this.transitShelterPersonService = transitShelterPersonService;
    }

    @PostMapping("/transitShelterPerson")
    public ResponseEntity<?> savePet(@RequestBody TransitShelterPerson transitShelterPerson){
        transitShelterPersonService.save(transitShelterPerson);
        return new ResponseEntity<>(transitShelterPerson, HttpStatus.OK);
    }

    @GetMapping("/getAllPetsById/{id}")
    public ResponseEntity<?> getAllPetsByPersonId(@PathVariable Long id){
        return new ResponseEntity<>(transitShelterPersonService.getAllTransitPet(id), HttpStatus.OK);
    }
}
