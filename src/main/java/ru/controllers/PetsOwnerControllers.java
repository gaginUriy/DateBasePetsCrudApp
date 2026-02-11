package ru.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.models.OwnerPets;
import ru.servises.PetsOwnerServise;
import ru.util.ExceptionMethods;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/petsOwner")

public class PetsOwnerControllers {

private final PetsOwnerServise petsOwnerServise;
    private final ExceptionMethods exceptionMethods;

    public PetsOwnerControllers(PetsOwnerServise petsOwnerServise, ExceptionMethods exceptionMethods) {
        this.petsOwnerServise = petsOwnerServise;
        this.exceptionMethods = exceptionMethods;
    }

    @PostMapping(consumes = "application/json")
  public OwnerPets createOwnerPets(@RequestBody @Valid OwnerPets ownerPets, BindingResult bindingResult){
        exceptionMethods.validationModelField(bindingResult);
        petsOwnerServise.saveOwnerPets(ownerPets);
        return ownerPets;
    }

    @GetMapping("/{id}")
    public OwnerPets gitOwnerPetsForId(@PathVariable ("id") int id){
        OwnerPets ownerPets =  petsOwnerServise.getOwnerPets(id);
        exceptionMethods.validationId(ownerPets,id);
        return ownerPets;
    }
    @GetMapping
    public List<OwnerPets> getAllOwnerPets(){
        return petsOwnerServise.getAllOwnerPets();
    }


    @PutMapping("/{id}")
    public OwnerPets updteOwnerPets(@RequestBody @Valid OwnerPets ownerPets, BindingResult bindingResult,@PathVariable("id") int id){
        exceptionMethods.existByID(id);
        exceptionMethods.validationModelField(bindingResult);
        return petsOwnerServise.updatePetsOwner(id, ownerPets);

    }


    @DeleteMapping("/{id}")
    public void deleteOwnerPets(@PathVariable("id") int id){
        exceptionMethods.existByID(id);
        petsOwnerServise.deleteOwnerPet(id);
    }

}
