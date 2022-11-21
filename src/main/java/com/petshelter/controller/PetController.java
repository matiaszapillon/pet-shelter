package com.petshelter.controller;

import com.petshelter.entity.Pet;
import com.petshelter.helper.PetType;
import com.petshelter.repository.PetRepository;
import com.petshelter.helper.PetModelAssembler;
import com.petshelter.service.PetService;
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
public class PetController {

    private final PetRepository petRepository;
    private final PetModelAssembler petModelAssembler;
    private final PetService petService;

    PetController(PetRepository petRepository, PetModelAssembler petModelAssembler, PetService petService) {
        this.petRepository = petRepository;
        this.petModelAssembler = petModelAssembler;
        this.petService = petService;
    }

    @GetMapping("/pet")
    public CollectionModel<EntityModel<Pet>> getAll(){
        List<EntityModel<Pet>> pets = petRepository.findAll().stream()
                .map( pet -> petModelAssembler.toModel(pet))
                .collect(Collectors.toList());

        return CollectionModel.of(pets, linkTo(methodOn(PetController.class).getAll()).withSelfRel());
    }

    //Copy of /pet using ResponseEntity as a response. it seems the same. The only difference is that using ResponseEntity I can return Headers / HttpStatus, etc
    @GetMapping("/petCopy")
    public ResponseEntity<CollectionModel<EntityModel<Pet>>> getAllCopy(){
        List<EntityModel<Pet>> pets = petRepository.findAll().stream()
                .map(petModelAssembler::toModel)
                .collect(Collectors.toList());

        return new ResponseEntity<>(CollectionModel.of(pets, linkTo(methodOn(PetController.class).getAll()).withSelfRel()),HttpStatus.MULTIPLE_CHOICES);
    }

    @GetMapping("/pet/{id}")
    public ResponseEntity<?> getPetById(@PathVariable Long id){
        Optional<Pet> pet = petRepository.findById(id);
        if(pet.isPresent()){
            return new ResponseEntity<>(pet.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/pet")
    public ResponseEntity<?> createPet(@RequestBody Pet pet){
        petService.save(pet);
        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

    @GetMapping("/petByType")
    public ResponseEntity<CollectionModel<EntityModel<Pet>>> getAllByType(){
        List<EntityModel<Pet>> pets = petRepository.getAllPetByType(PetType.DOG).stream()//petService.getAllByType(("Dog")).stream()
                .map(petModelAssembler::toModel)
                .collect(Collectors.toList());

        return new ResponseEntity<>(CollectionModel.of(pets, linkTo(methodOn(PetController.class).getAll()).withSelfRel()),HttpStatus.OK);
    }

    @DeleteMapping("/pet/{id}")
    public ResponseEntity<?> deletePet(@PathVariable Long id){
        petRepository.deleteById(id);
        return new ResponseEntity<>("Delete successfully", HttpStatus.OK);
    }

    @PutMapping("/pet")
    public ResponseEntity<?> updateSave(@RequestBody Pet pet){
        petService.save(pet);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }
    //Should i Use ResponseEntity Or EntityModel to return object in REST Api? -> with ResponseEntity you can manage Headers, HttpCode, etc.

    @GetMapping("/petByIdTransitShelterPerson/" + "{id}")
    public ResponseEntity<?> getTransitPetsByIdTransitShelterPerson(@PathVariable Long id){

        List<EntityModel<Pet>> pets = petService.getAllTransitPetByIdTransitShelterPerson(id).stream()
                .map(petModelAssembler::toModel)
                .collect(Collectors.toList());

        return new ResponseEntity<>(CollectionModel.of(pets, linkTo(methodOn(PetController.class).getAll()).withSelfRel()),HttpStatus.MULTIPLE_CHOICES);
    }
}
