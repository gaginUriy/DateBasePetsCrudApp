package ru.petsOwner.ownerPetsDAO;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.petsOwner.modelsOwnerPets.OwnerPets;

import java.util.List;
import java.util.Map;

@Component

public class PetsOwnerDAO {

    private final JdbcTemplate jdbcTemplate;


    public PetsOwnerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    public OwnerPets  createPetsOwner(OwnerPets ownerPets) {

     jdbcTemplate.update("INSERT INTO pets_owner (first_name, last_name,phone, pets_id, birthday, telegram, email) VALUES (?,?,?,?,?,?,?)",
                 ownerPets.getFirstName(), ownerPets.getLastName(), ownerPets.getPhone(), ownerPets.getPetsId(),
                ownerPets.getBirthDay(), ownerPets.getTelegram(), ownerPets.getEmail());
        return ownerPets;
    }

    public OwnerPets getPetsOwnerFofId(int id) {
        return jdbcTemplate.query("SELECT * FROM pets_owner WHERE id = ?",new Object[]{id}, new BeanPropertyRowMapper<>(OwnerPets.class))
                .stream().findAny().orElse(null);



    }

    public List<OwnerPets> getAllPetsOwner() {
        return jdbcTemplate.query("SELECT * FROM pets_owner", new BeanPropertyRowMapper<>(OwnerPets.class));
    }

    public void updatePetsOwner(OwnerPets ownerPets, int id) {

      jdbcTemplate.update("UPDATE pets_owner SET first_name = ?, last_name = ?,phone = ?, pets_id = ?, birthday = ?, telegram = ?, email = ? WHERE id = ?",
                ownerPets.getFirstName(), ownerPets.getLastName(), ownerPets.getPhone(), ownerPets.getPetsId(),
                ownerPets.getBirthDay(), ownerPets.getTelegram(), ownerPets.getEmail(), id);


    }

    public OwnerPets deletePetsOwner(int id) {
        jdbcTemplate.update("DELETE FROM pets_owner WHERE id = ?",id);
        return null;
    }
}
