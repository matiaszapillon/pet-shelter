package com.petshelter.repository;

import com.petshelter.entity.Pet;
import com.petshelter.entity.TransitShelterPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransitShelterPersonRepository extends JpaRepository<TransitShelterPerson,Long> {
}
