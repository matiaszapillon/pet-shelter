package com.petshelter.repository;

import com.petshelter.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository => Not need it since it extends by JpaRepository and it is solved with that.
//Besides, It should be define it in a class instead of an interface. If we don't extends from JpaRepository or Repository, we should put in our interface @RepositoryDefinition
// Or in the implementation @Repository.
//@Repository and @RepositoryDefinition behave in the same way. @Repository for class, @RepositoryDefinition for interface.
public interface PetRepository extends JpaRepository<Pet,Long>, CustomPetRepository {

}
