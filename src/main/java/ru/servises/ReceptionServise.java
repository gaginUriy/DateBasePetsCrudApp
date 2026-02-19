package ru.servises;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.models.Reception;
import ru.repositories.ReceptionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)

public class ReceptionServise {

    private final RestTemplate restTemplate;
    private final ReceptionRepository receptionRepository;

    public ReceptionServise(RestTemplate restTemplate, ReceptionRepository receptionRepository) {
        this.restTemplate = restTemplate;
        this.receptionRepository = receptionRepository;
    }


    @Transactional
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
    @Transactional
    public Reception updedeReception(Reception reception, int id) {
        reception.setId(id);
        receptionRepository.save(reception);
        return reception;
    }
    @Transactional
    public void receptionServise(int id) {
        receptionRepository.deleteById(id);

    }

    public String postNotification(int id){
        return  restTemplate.postForObject("https://postman-echo.com/post",new HttpEntity<>(receptionRepository.findIntegrationReception(id).stream().findAny().orElse(null)),String.class);
    }
}
