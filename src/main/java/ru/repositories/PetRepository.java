package ru.repositories;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.DTO.IntegrationReceptionDTO;
import ru.models.Pets;

import javax.persistence.criteria.From;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pets, Integer> {




}
