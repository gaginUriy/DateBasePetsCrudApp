package ru.controllers;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.DTO.IntegrationReceptionDTO;
import ru.DTO.ReceptionDTO;
import ru.models.Reception;

import ru.servises.ReceptionServise;
import ru.util.Excepion.ExceptionMethods;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Reception")
public class ReceptionController {

    private static final Logger log = LoggerFactory.getLogger(ReceptionController.class);

    private final ReceptionServise receptionServise;
    private final ExceptionMethods exceptionMethods;
    private final ModelMapper modelMapper;

    public ReceptionController( ReceptionServise receptionServise, ExceptionMethods exceptionMethods, ModelMapper modelMapper) {
        this.receptionServise = receptionServise;
        this.exceptionMethods = exceptionMethods;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<Reception>  createReception(@RequestBody @Valid ReceptionDTO receptionDTO, BindingResult bindingResult){
        log.info("The POST method was called for the method:GetPets");
        exceptionMethods.validationModelField(bindingResult);
       Reception reception = receptionServise.createReception(convertToReception(receptionDTO) );
       return ResponseEntity.ok(reception);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceptionDTO> getReception(@PathVariable("id") int id){
        log.info("The GET method was called for the method:GetPets");
        ReceptionDTO get= convertToReceptionDTO( receptionServise.getReception(id));
        exceptionMethods.validationId(get, id);
        return ResponseEntity.ok(get);
    }


    @GetMapping
    public List<Reception>getAllReception(){
        log.info("The GET method was called for the method:GetPets");
        return receptionServise.getAllReception();
    }

    @PutMapping("/{id}")
    public ResponseEntity< Reception> updedeReception(@RequestBody @Valid ReceptionDTO receptionDTO,BindingResult bindingResult,@PathVariable("id") int id){
        log.info("The PUT  method was called for the method:GetPets");
        exceptionMethods.existByID(id);
        exceptionMethods.validationModelField(bindingResult);
        Reception reception= receptionServise.updedeReception(convertToReception(receptionDTO), id);

        return ResponseEntity.ok(reception);
    }

    @DeleteMapping("/{id}")
    public void deleteReception(@PathVariable("id")int id){
        log.info("The DELETE  method was called for the method:GetPets");
        exceptionMethods.existByID(id);
        receptionServise.receptionServise(id);
    }


    @PutMapping("/Aprove/{id}")
    public String integration(@PathVariable("id")int id){
      return   receptionServise.postNotification(id);
    }




    private Reception convertToReception(ReceptionDTO receptionDTO ) {
        log.info("convertToReception Return");
        return modelMapper.map(receptionDTO, Reception.class);

    }

    private ReceptionDTO convertToReceptionDTO(Reception reception){

        log.info("Return convertToReceptionDTO");
        return modelMapper.map(reception,ReceptionDTO.class);
    }


}
