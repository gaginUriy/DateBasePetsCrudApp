package ru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.models.OwnerPets;

@Repository
public interface PetsOwnerRepository extends JpaRepository<OwnerPets, Integer> {
}
