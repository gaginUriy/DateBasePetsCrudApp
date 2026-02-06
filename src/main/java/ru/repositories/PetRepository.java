package ru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.models.Pets;

@Repository
public interface PetRepository extends JpaRepository<Pets, Integer> {
}
