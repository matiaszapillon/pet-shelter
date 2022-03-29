package com.petshelter.repository;

import com.petshelter.entity.Pet;
import com.petshelter.helper.PetType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

//@Repository check if it is needed
public class CustomPetRepositoryImpl implements CustomPetRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Get All pet by a Type.
     * Using Criteria API without Spring Data (With Specifications (implementing JpaRepositoryExecutor) is easier. take a look to findAllByTpe method
     * in petServiceImpl
     */
    @Override
    public List<Pet> getAllPetByType(PetType type) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pet> criteriaQuery = criteriaBuilder.createQuery(Pet.class);
        Root<Pet> petRoot = criteriaQuery.from(Pet.class);
        Predicate typePredicate = criteriaBuilder.equal(petRoot.get("type"), type);
        criteriaQuery.where(typePredicate);
        Order order = criteriaBuilder.desc(petRoot.get("stampCreated"));
        criteriaQuery.orderBy(order);
        TypedQuery<Pet> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }


}
