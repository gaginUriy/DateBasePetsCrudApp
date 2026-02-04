package ru.Veterinary.veterinaryDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.Veterinary.modelsVeterinary.Veterinary;

import java.util.List;

@Component
public class VeterinaryDAO {
    @Autowired
    public VeterinaryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    JdbcTemplate jdbcTemplate;


    public void createVeterinary(Veterinary veterinary) {
        jdbcTemplate.update("INSERT INTO veterinary (first_name, last_name,phone,birthday) VALUES (?,?,?,?)",
                veterinary.getFirstName(),veterinary.getLastName(),veterinary.getPhone(),veterinary.getBirthday());
    }

    public Veterinary getVeterinaryId(int id) {
       return jdbcTemplate.query("SELECT * FROM veterinary WHERE id = ?",new Object[]{id}, new BeanPropertyRowMapper<>(Veterinary.class))
               .stream().findAny().orElse(null);
    }

    public List<Veterinary> getAllVeterinary() {
        return jdbcTemplate.query("SELECT * FROM veterinary ", new BeanPropertyRowMapper<>(Veterinary.class));
    }

    public void updateVeterinary(Veterinary veterinary, int id) {
        jdbcTemplate.update("UPDATE veterinary SET first_name = ?, last_name = ?,phone = ?,birthday = ? WHERE id = ?",
                veterinary.getFirstName(), veterinary.getLastName(),veterinary.getPhone(),veterinary.getBirthday(),id);

    }

    public void deleteVeterinary(int id) {
        jdbcTemplate.update("DELETE FROM veterinary WHERE id = ?",id);
    }
}
