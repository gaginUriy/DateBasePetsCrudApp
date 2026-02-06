package ru.controllers;

import org.springframework.web.bind.annotation.*;
import ru.models.Pets;
import ru.servises.PetServise;
import java.util.List;

@RestController
@RequestMapping("/Pets")
public class PetControllers {

    //<editor-fold desc="конструктор">
private final PetServise petServise;

    public PetControllers(PetServise petServise) {
        this.petServise = petServise;
    }

    //</editor-fold>


    @PostMapping(consumes = "application/json")
    public Pets AddPets(@RequestBody Pets pet){
        System.out.println("Post Method");
        return  petServise.postPets(pet);
    }

    @GetMapping("/{id}")
    public Pets GetPets(@PathVariable("id")int id){
        return petServise.getPets(id);
    }

    @GetMapping()
    public List <Pets> GetAllPets(){
        return petServise.getAllPets();
    }

    @PutMapping("/{id}")
    public Pets UpdatePets(@RequestBody Pets pet, @PathVariable("id")int id){
        return petServise.updatePetsId(pet,id);

    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable("id")int id){
        petServise.DeletePets(id);
    }

}
