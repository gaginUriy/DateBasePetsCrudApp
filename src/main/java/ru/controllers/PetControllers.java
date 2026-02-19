package ru.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ru.DTO.PetsDTO;
import ru.models.Pets;
import ru.servises.PetServise;
import ru.util.Excepion.ExceptionMethods;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetControllers {
    //<editor-fold desc="конструктор">

  private static final Logger log = LoggerFactory.getLogger(PetControllers.class);
    private final PetServise petServise;
    private final ExceptionMethods exceptionMethods;
    private final ModelMapper modelMapper;

    public PetControllers(PetServise petServise, ExceptionMethods exceptionMethods, ModelMapper modelMapper) {
        this.petServise = petServise;
        this.exceptionMethods = exceptionMethods;
        this.modelMapper = modelMapper;
    }

    //</editor-fold>


    @PostMapping(consumes = "application/json")
    public ResponseEntity<Pets> AddPets(@RequestBody @Valid PetsDTO petsDTO, BindingResult bindingResult){
        log.info("The POST method was called for the method: AddPets");
        exceptionMethods.validationModelField(bindingResult);
        Pets pet = petServise.postPets(convertToPets( petsDTO));

        return ResponseEntity.ok(pet);
    }



    @GetMapping("/{id}")
    public ResponseEntity<PetsDTO> GetPets(@PathVariable("id") int id){
       PetsDTO pet= convertToPetsDTO( petServise.getPets(id));
       exceptionMethods.validationId(pet, id);
        log.info("The GET method was called for the method:GetPets");
       return ResponseEntity.ok(pet);
    }



    @GetMapping()
    public List <Pets> GetAllPets(){
        log.info("The GET method was called for the method:GetAllPets");
        return petServise.getAllPets();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pets> UpdatePets(@RequestBody @Valid PetsDTO petDTO , BindingResult bindingResult, @PathVariable("id")int id){
        exceptionMethods.existByID(id);
        exceptionMethods.validationModelField(bindingResult);
        Pets pet = petServise.updatePetsId(convertToPets(petDTO),id);
        log.info("The PUT method was called for the method: UpdatePets");
        return ResponseEntity.ok(pet);

    }

    @DeleteMapping("/{id}")
    public int deletePets(@PathVariable("id")int id){
        log.info("The DELETE method was called for the method:DeletePets");
        exceptionMethods.existByID(id);
        petServise.DeletePets(id);
        return id;

    }

    private Pets convertToPets(PetsDTO petsDTO ) {
        log.info("convertToPets Return");
       return modelMapper.map(petsDTO, Pets.class);

    }

    private PetsDTO convertToPetsDTO(Pets pets){

        log.info("Return convertToPetsDTO");
        return modelMapper.map(pets,PetsDTO.class);
    }


}
