package ru.controllers;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.DTO.VeterinaryDTO;
import ru.models.Veterinary;
import ru.servises.VeterinaryServise;
import ru.util.Excepion.ExceptionMethods;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/veterinary")
public class VeterinaryControllers {


    private static final Logger log = LoggerFactory.getLogger(VeterinaryControllers.class);
    private final VeterinaryServise veterinaryServise;
    private final ExceptionMethods exceptionMethods;
    private final ModelMapper modelMapper;

    public VeterinaryControllers(VeterinaryServise veterinaryServise, ExceptionMethods exceptionMethods, ModelMapper modelMapper) {
        this.veterinaryServise = veterinaryServise;
        this.exceptionMethods = exceptionMethods;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<Veterinary> createVeterinary(@RequestBody @Valid VeterinaryDTO veterinaryDTO, BindingResult bindingResult){
        log.info("The POST method was called for the method: createVeterinary");

        exceptionMethods.validationModelField(bindingResult);
        Veterinary veterinary = veterinaryServise.createVeterinary(convertToVeterinary( veterinaryDTO));
        return ResponseEntity.ok(veterinary);
    }

    @GetMapping("/{id}")
    public ResponseEntity< VeterinaryDTO> getVeterinaryId(@PathVariable("id")int id){
        log.info("The GET method was called for the method: getVeterinaryId");
        VeterinaryDTO veterinaryDTO = convertToVeterinaryDTO( veterinaryServise.findoneVeterinary(id));
        exceptionMethods.validationId(veterinaryDTO,id);
        return ResponseEntity.ok(veterinaryDTO);
    }

    @GetMapping
    public List<Veterinary> getAllVeterinary(){
        log.info("The GET method was called for the method: getAllVeterinary");
        return veterinaryServise.findAllVeterinary();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veterinary> updateVeterinary(@RequestBody @Valid VeterinaryDTO veterinaryDTO,BindingResult bindingResult ,@PathVariable("id")int id){
        log.info("The PUT method was called for the method: updateVeterinary");
        exceptionMethods.existByID(id);
        exceptionMethods.validationModelField(bindingResult);
        return ResponseEntity.ok( veterinaryServise.updateVeterinary(  convertToVeterinary(veterinaryDTO), id));
    }

    @DeleteMapping("/{id}")
    public void deleteVeterinary(@PathVariable("id")int id){
        exceptionMethods.existByID(id);
        veterinaryServise.deleteVeterinary(id);
        log.info("The DELETE method was called for the method: deleteVeterinary");
    }

    private Veterinary convertToVeterinary(VeterinaryDTO veterinaryDTO){
        log.info("convertToVeterinary Return");
        return modelMapper.map(veterinaryDTO,Veterinary.class);
    }

    private VeterinaryDTO convertToVeterinaryDTO(Veterinary veterinary){
        log.info("convertToVeterinaryDTO Return");
        return modelMapper.map(veterinary,VeterinaryDTO.class);
    }


}
