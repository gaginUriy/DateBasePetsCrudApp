package ru.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.models.Pets;
import ru.servises.PetServise;
import ru.util.ExceptionMethods;
import ru.util.NotIdException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Pets")
public class PetControllers {

    //<editor-fold desc="конструктор">
private final PetServise petServise;
private final ExceptionMethods exceptionMethods;

    public PetControllers(PetServise petServise, ExceptionMethods exceptionMethods) {
        this.petServise = petServise;
        this.exceptionMethods = exceptionMethods;
    }

    //</editor-fold>


    @PostMapping(consumes = "application/json")
    public ResponseEntity<Pets> AddPets(@RequestBody @Valid Pets pet,  BindingResult bindingResult){

        System.out.println("Post Method");
        exceptionMethods.validationModelField(bindingResult);
         petServise.postPets(pet);

        return ResponseEntity.ok(pet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pets> GetPets(@PathVariable("id") int id){
       Pets pet= petServise.getPets(id);
       exceptionMethods.validationId(pet, id);

       return ResponseEntity.ok(pet);
    }

    @GetMapping()
    public List <Pets> GetAllPets(){
        return petServise.getAllPets();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pets> UpdatePets(@RequestBody @Valid Pets pet , BindingResult bindingResult, @PathVariable("id")int id){
        exceptionMethods.validationModelField(bindingResult);
        petServise.updatePetsId(pet,id);

        return ResponseEntity.ok(pet);

    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable("id")int id){
        petServise.DeletePets(id);
    }

}
