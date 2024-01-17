package com.petshelter.helper;

import com.petshelter.controller.PetController;
import com.petshelter.entity.Pet;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@Component
public class PetModelAssembler implements RepresentationModelAssembler<Pet, EntityModel<Pet>> {

    @Override
    public EntityModel<Pet> toModel(Pet pet) {

        return EntityModel.of(pet,
                linkTo(methodOn(PetController.class).getPetById(pet.getId())).withSelfRel(),
                linkTo(methodOn(PetController.class).getAll()).withRel("petList"));
    }
}