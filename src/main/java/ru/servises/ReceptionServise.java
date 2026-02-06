package ru.servises;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.models.Reception;
import ru.repositories.ReceptionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)

public class ReceptionServise {

    private final ReceptionRepository receptionRepository;

    public ReceptionServise(ReceptionRepository receptionRepository) {
        this.receptionRepository = receptionRepository;
    }


    public Reception createReception(Reception reception) {
        receptionRepository.save(reception);
        return reception;
    }

    public Reception getReception(int id) {
        Optional<Reception>reception= receptionRepository.findById(id);
        return reception.orElse(null);
    }

    public List<Reception> getAllReception() {
       return receptionRepository.findAll();
    }

    public Reception updedeReception(Reception reception, int id) {
        reception.setId(id);
        receptionRepository.save(reception);
        return reception;
    }

    public void receptionServise(int id) {
        receptionRepository.deleteById(id);

    }
}
