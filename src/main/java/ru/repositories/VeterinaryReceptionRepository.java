package ru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.models.VeterinaryReception;

@Repository
public interface VeterinaryReceptionRepository extends JpaRepository<VeterinaryReception, Integer> {
}
