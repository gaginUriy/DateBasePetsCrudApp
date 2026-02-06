package ru.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.models.Reception;

import ru.servises.ReceptionServise;

import java.util.List;

@RestController
@RequestMapping("/Reception")
public class ReceptionController {

private final ReceptionServise receptionServise;

    public ReceptionController(ReceptionServise receptionServise) {
        this.receptionServise = receptionServise;
    }

    @PostMapping
    public Reception createReception(@RequestBody Reception reception){
       return receptionServise.createReception(reception);
    }

    @GetMapping("/{id}")
    public Reception getReception(@PathVariable("id") int id){
    return receptionServise.getReception(id);
    }

    @GetMapping
    public List<Reception>getAllReception(){
    return receptionServise.getAllReception();
    }

    @PutMapping("/{id}")
    public Reception updedeReception(@RequestBody Reception reception,@PathVariable("id") int id){
      return   receptionServise.updedeReception(reception, id);
    }

    @DeleteMapping("/{id}")
    public void deleteReception(@PathVariable("id")int id){
    receptionServise.receptionServise(id);

    }
}
