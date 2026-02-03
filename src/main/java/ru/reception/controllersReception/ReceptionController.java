package ru.reception.controllersReception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.reception.modelsReception.Reception;
import ru.reception.receptionDAO.ReceptionDAO;

import java.util.List;

@RestController
@RequestMapping("/Reception")
public class ReceptionController {

    ReceptionDAO receptionDAO;

@Autowired
    public ReceptionController(ReceptionDAO receptionDAO) {
        this.receptionDAO = receptionDAO;
    }

    @PostMapping
    public void createReception(@RequestBody Reception reception){
    receptionDAO.createReception(reception);
    }

    @GetMapping("/{id}")
    public Reception getReception(@PathVariable("id") int id){
    return receptionDAO.getReception(id);
    }

    @GetMapping
    public List<Reception>getAllReception(){
    return receptionDAO.getAllReception();
    }

    @PutMapping("/{id}")
    public void updedeReception(@RequestBody Reception reception,@PathVariable("id") int id){
    receptionDAO.updedeReception(reception, id);
    }

    @DeleteMapping("/{id}")
    public void deleteReception(@PathVariable("id")int id){
    receptionDAO.deleteReception(id);

    }
}
