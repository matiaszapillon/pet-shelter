package com.petshelter.controller;

import com.petshelter.entity.Pet;
import com.petshelter.entity.TransitShelterPerson;
import com.petshelter.helper.TransitShelterPersonModelAssembler;
import com.petshelter.repository.TransitShelterPersonRepository;
import com.petshelter.service.TransitShelterPersonService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class TransitShelterPersonController {

    private final TransitShelterPersonRepository transitShelterPersonRepository;
    private final TransitShelterPersonService transitShelterPersonService;
    private final TransitShelterPersonModelAssembler transitShelterPersonModelAssembler;

    public TransitShelterPersonController(TransitShelterPersonRepository transitShelterPersonRepository,
                                          TransitShelterPersonService transitShelterPersonService,
                                          TransitShelterPersonModelAssembler transitShelterPersonModelAssembler){
        this.transitShelterPersonRepository = transitShelterPersonRepository;
        this.transitShelterPersonService = transitShelterPersonService;
        this.transitShelterPersonModelAssembler = transitShelterPersonModelAssembler;
    }

    @GetMapping("/petshelter/{id}")
    public ResponseEntity<?> getTransitShelterPersonById(@PathVariable Long id){
        Optional<TransitShelterPerson> transitShelterPerson = transitShelterPersonRepository.findById(id);
        if(transitShelterPerson.isPresent()){
            return new ResponseEntity<>(transitShelterPerson.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Not found", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/petShelter")
    public CollectionModel<EntityModel<TransitShelterPerson>> getAll(){
        //I cannot return CollectionModel.of(transitShelterPersonRepository.findAll()); as it is a CollectionModel of TransitShelterPerson
        //instead of EntityModel<TransitShelterPerson>
        List<EntityModel<TransitShelterPerson>> transitShelterPersonList = transitShelterPersonRepository.findAll().stream()
                .map(transitShelterPersonModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(transitShelterPersonList, linkTo(methodOn(TransitShelterPersonController.class).getAll()).withSelfRel());
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
