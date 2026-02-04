package ru.VeterinaryPriem.veterinaryPriemDAO;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import ru.Veterinary.modelsVeterinary.Veterinary;
import ru.VeterinaryPriem.modelsVeterinaryPriem.VeterinaryReception;

import java.util.List;

@Controller
public class VeterenaryReceptionDAO {
    JdbcTemplate jdbcTemplate;

    public VeterenaryReceptionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createVeterinaryReception(VeterinaryReception veterinaryReception) {
        jdbcTemplate.update("INSERT INTO veterinary_reception (veterinary_id, start_of_reception, end_of_reception, reason_for_request) VALUES (?,?,?,?)"
                ,veterinaryReception.getVeterinaryId(),veterinaryReception.getStartOfReception(),veterinaryReception.getEndOfReception(),veterinaryReception.getReasonForRequest()
                );
    }

    public VeterinaryReception getVeterinaryReceptionForId(int id) {
        return    jdbcTemplate.query("SELECT * FROM veterinary_reception WHERE id = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(VeterinaryReception.class)).stream().findAny().orElse(null) ;
    }

    public List<VeterinaryReception> getAllVeterenaryReception() {
        return jdbcTemplate.query("SELECT * FROM veterinary_reception",new BeanPropertyRowMapper<>(VeterinaryReception.class));
    }


    public void updateVeterenaryReception(VeterinaryReception veterinaryReception, int id) {
        jdbcTemplate.update("UPDATE veterinary_reception SET veterinary_id=?, start_of_reception=?, end_of_reception=?, reason_for_request=? WHERE id =?"
        ,veterinaryReception.getVeterinaryId(),veterinaryReception.getStartOfReception(),veterinaryReception.getEndOfReception(),
                veterinaryReception.getReasonForRequest(),id);
    }


    public void deleteVeterenaryReception(int id) {
        jdbcTemplate.update("DELETE FROM veterinary_reception WHERE d =? ",id);
    }
}
