package ru.controllers;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.DTO.OwnerPetsDTO;
import ru.models.OwnerPets;
import ru.servises.PetsOwnerServise;
import ru.util.Excepion.ExceptionMethods;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/petsOwner")

public class PetsOwnerControllers {
    private static final Logger log = LoggerFactory.getLogger(PetsOwnerControllers.class);
    //<editor-fold desc="конструктор">
private final PetsOwnerServise petsOwnerServise;
    private final ExceptionMethods exceptionMethods;
    private final ModelMapper modelMapper;


    public PetsOwnerControllers(PetsOwnerServise petsOwnerServise, ExceptionMethods exceptionMethods, ModelMapper modelMapper) {
        this.petsOwnerServise = petsOwnerServise;
        this.exceptionMethods = exceptionMethods;
        this.modelMapper = modelMapper;
    }
        //</editor-fold>


    @PostMapping(consumes = "application/json")
  public ResponseEntity<OwnerPets> createOwnerPets(@RequestBody @Valid OwnerPetsDTO ownerPetsDTO, BindingResult bindingResult){
        log.info("The POST method was called for the method: createOwnerPets");
        exceptionMethods.validationModelField(bindingResult);
       OwnerPets ownerPets = petsOwnerServise.saveOwnerPets(converterToOwnerPets(ownerPetsDTO));
        return ResponseEntity.ok(ownerPets);
    }



    @GetMapping("/{id}")
    public ResponseEntity<OwnerPetsDTO> getOwnerPetsForId(@PathVariable ("id") int id){
        log.info("The GET  method was called for the method: getOwnerPetsForId");
        OwnerPetsDTO ownerPets = converterToOwnerPetsDTO( petsOwnerServise.getOwnerPets(id));
        exceptionMethods.validationId(ownerPets,id);
        return ResponseEntity.ok(ownerPets);

    }

    @GetMapping
    public List<OwnerPets> getAllOwnerPets(){
        log.info("The GET  method was called for the method: getAllOwnerPets");
        return  petsOwnerServise.getAllOwnerPets();

    }


    @PutMapping("/{id}")
    public ResponseEntity<OwnerPets> updteOwnerPets(@RequestBody @Valid OwnerPetsDTO ownerPetsDTO, BindingResult bindingResult,@PathVariable("id") int id){
        log.info("The PUT method was called for the method: createOwnerPets");
        exceptionMethods.existByID(id);
        exceptionMethods.validationModelField(bindingResult);
        OwnerPets owner= petsOwnerServise.updatePetsOwner(converterToOwnerPets(ownerPetsDTO),  id);
        return ResponseEntity.ok(owner);
    }


    @DeleteMapping("/{id}")
    public void deleteOwnerPets(@PathVariable("id") int id){
        log.info("The DELETE method was called for the method: deleteOwnerPets");
        exceptionMethods.existByID(id);
        petsOwnerServise.deleteOwnerPet(id);
    }

    private OwnerPets converterToOwnerPets(OwnerPetsDTO ownerPetsDTO){
        log.info("converterToOwnerPets Return");

        return modelMapper.map(ownerPetsDTO,OwnerPets.class);

    }
    private OwnerPetsDTO converterToOwnerPetsDTO(OwnerPets ownerPets){
        log.info("converterToOwnerPetsDTO Return");

        return modelMapper.map(ownerPets,OwnerPetsDTO.class);

    }



}
