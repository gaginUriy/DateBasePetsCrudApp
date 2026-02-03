package ru.pets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pets.PesDAO.PetsDAO;
import ru.pets.models.Pets;

import java.util.List;

@RestController
@RequestMapping("/Pets")
public class PetControllers {

    //<editor-fold desc="конструктор">
    private final PetsDAO petsDAO;

    @Autowired
    public PetControllers(PetsDAO petsDAO) {
        this.petsDAO = petsDAO;
    }
    //</editor-fold>


    @PostMapping(consumes = "application/json")
    public Pets AddPets(@RequestBody Pets pet){
        System.out.println("Post Method");
        petsDAO.postPets(pet);

        return pet;


    }

    @GetMapping("/{id}")
    public Pets GetPets(@PathVariable("id")int id){
        return petsDAO.getPets(id);
    }

    @GetMapping()
    public List <Pets> GetAllPets(){
        return petsDAO.getAllPets();
    }

    @PutMapping("/{id}")
    public Pets UpdatePets(@RequestBody Pets pet, @PathVariable("id")int id){
        return petsDAO.updatePetsId(pet,id);

    }

    @DeleteMapping("/{id}")
    public int Delete(@PathVariable("id")int id){
        return petsDAO.DeletePets(id);
    }

}
