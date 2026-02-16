package ru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.DTO.IntegrationReceptionDTO;
import ru.models.Reception;

import java.util.List;


@Repository
public interface ReceptionRepository extends JpaRepository<Reception, Integer> {


    @Query(value = "SELECT new ru.DTO.IntegrationReceptionDTO( po.firstName as pets_owner_first_name, p.name as pet_name, v.firstName as veterinary_first_name, vr.startOfReception, po.email, po.telegram ) from Reception r  join VeterinaryReception vr  on r.veterinaryReceptionId =vr.id join Veterinary v on vr.veterinaryId = v.Id join OwnerPets po on r.petsOwnerId = po.id join Pets p on po.petsId =p.id  WHERE r.id =?1")
    List<IntegrationReceptionDTO> findIntegrationReception(int param);



}
