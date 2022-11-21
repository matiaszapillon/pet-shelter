package com.petshelter.helper;

import com.petshelter.controller.TransitShelterPersonController;
import com.petshelter.entity.TransitShelterPerson;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TransitShelterPersonModelAssembler implements RepresentationModelAssembler<TransitShelterPerson, EntityModel<TransitShelterPerson>> {

    @Override
    public EntityModel<TransitShelterPerson> toModel(TransitShelterPerson transitShelterPerson) {

        return EntityModel.of(transitShelterPerson,
                linkTo(methodOn(TransitShelterPersonController.class).getTransitShelterPersonById(transitShelterPerson.getId())).withSelfRel(),
                linkTo(methodOn(TransitShelterPersonController.class).getAll()).withRel("transitShelterPersonList"));
    }
}
