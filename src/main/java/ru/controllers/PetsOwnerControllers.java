package ru.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.models.OwnerPets;
import ru.servises.PetsOwnerServise;


import java.util.List;

@Controller
@RequestMapping("/petsOwner")

public class PetsOwnerControllers {

private final PetsOwnerServise petsOwnerServise;

    public PetsOwnerControllers(PetsOwnerServise petsOwnerServise) {
        this.petsOwnerServise = petsOwnerServise;
    }

    @PostMapping(consumes = "application/json")
  public OwnerPets createOwnerPets(@RequestBody OwnerPets ownerPets){
        petsOwnerServise.saveOwnerPets(ownerPets);
        return ownerPets;
    }

    @GetMapping("/{id}")
    public OwnerPets gitOwnerPetsForId(@PathVariable ("id") int id){
       return petsOwnerServise.getOwnerPets(id);
    }
    @GetMapping
    public List<OwnerPets> getAllOwnerPets(){

        return petsOwnerServise.getAllOwnerPets();
    }


    @PutMapping("/{id}")
    public OwnerPets updteOwnerPets(@PathVariable("id") int id,@RequestBody OwnerPets ownerPets){
        return petsOwnerServise.updatePetsOwner(id, ownerPets);

    }


    @DeleteMapping("/{id}")
    public void deleteOwnerPets(@PathVariable("id") int id){
        petsOwnerServise.deleteOwnerPet(id);
    }

}
