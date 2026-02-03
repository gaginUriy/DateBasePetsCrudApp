package ru.reception.receptionDAO;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.reception.modelsReception.Reception;

import java.util.List;


@Component
public class ReceptionDAO {
    JdbcTemplate jdbcTemplate;

    public ReceptionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createReception(Reception reception) {
        jdbcTemplate.update("INSERT INTO reception (veterinary_reception_id, pets_owner_id, pets_id,vaccination)VALUES(?,?,?,?)",
               reception.getVeterinaryReceptionId(),reception.getPetsOwnerId(),reception.getPitsId(),reception.isVaccination() );
    }

    public Reception getReception(int id) {
        return jdbcTemplate.query("SELECT * FROM reception WHERE reception_id = ?",
                new Object[]{id},new BeanPropertyRowMapper<>(Reception.class)).stream().findAny().orElse(null);
    }

    public List<Reception> getAllReception() {
        return jdbcTemplate.query("SELECT * FROM reception", new BeanPropertyRowMapper<>(Reception.class));
    }


    public void updedeReception(Reception reception, int id) {
        jdbcTemplate.update("UPDATE reception SET veterinary_reception_id=?, pets_owner_id=?, pets_id=?,vaccination=? WHERE reception_id =?",
                reception.getVeterinaryReceptionId(),reception.getPetsOwnerId(),reception.getPitsId(),reception.isVaccination(), id);
    }

    public void deleteReception(int id) {
        jdbcTemplate.update("DELETE FROM reception WHERE reception_id =?", id);
    }
}
