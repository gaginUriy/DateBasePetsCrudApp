package ru.pets.PesDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.pets.models.Pets;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetsDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PetsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public void postPets(Pets pet) {
                jdbcTemplate.update("insert into Pets (type, name, vaccination,vaccination_end, color) VALUES (?,?,?,?,?)",
           pet.getType().name(),pet.getName(),pet.getVaccination(),pet.getEndVaccination(),pet.getColor().name());
    }

    public Pets getPets(int id) {
        return jdbcTemplate.query("SELECT * FROM Pets WHERE id = ?",new Object[]{id},new BeanPropertyRowMapper<>(Pets.class))
                .stream().findAny().orElse(null);
    }

    public List<Pets> getAllPets() {
        return jdbcTemplate.query("SELECT * FROM Pets",new BeanPropertyRowMapper<>(Pets.class));
    }

    public Pets updatePetsId(Pets pet, int id) {
        jdbcTemplate.update("UPDATE Pets SET type=?, name=?, vaccination=?,vaccination_end =?, color=? WHERE id=?",
                pet.getType().name(),pet.getName(),pet.getVaccination(), pet.getEndVaccination() ,pet.getColor().name(),id);
        return pet;
    }

    public int DeletePets(int id) {
            int ids = id;
       jdbcTemplate.update("delete from Pets where id=?",id);
        return ids;
    }
}
