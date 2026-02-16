package ru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.models.Reception;


@Repository
public interface ReceptionRepository extends JpaRepository<Reception, Integer> {
}
