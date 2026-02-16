package ru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.DTO.ToNotificationPostDTO;
import ru.models.Reception;


@Repository
public interface ReceptionRepository extends JpaRepository<Reception, Integer> {



}
