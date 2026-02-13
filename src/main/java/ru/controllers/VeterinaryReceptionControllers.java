package ru.controllers;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.DTO.VeterinaryReceptionDTO;
import ru.models.VeterinaryReception;
import ru.servises.VeterinaryReceptionServise;
import ru.util.Excepion.ExceptionMethods;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/VeterinaryReception")
public class VeterinaryReceptionControllers {


    private static final Logger log = LoggerFactory.getLogger(VeterinaryReceptionControllers.class);
    private final VeterinaryReceptionServise veterinaryReceptionServise;
    private final ExceptionMethods exceptionMethods;
    private final ModelMapper modelMapper;

    public VeterinaryReceptionControllers(VeterinaryReceptionServise veterinaryReceptionServise, ExceptionMethods exceptionMethods, ModelMapper modelMapper) {
        this.veterinaryReceptionServise = veterinaryReceptionServise;
        this.exceptionMethods = exceptionMethods;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity <VeterinaryReception> createVeterinaryReception(@RequestBody @Valid VeterinaryReceptionDTO veterinaryReceptionDTO, BindingResult bindingResult){
        log.info("The POST method was called for the method: createVeterinaryReception");
        exceptionMethods.validationModelField(bindingResult);
        return ResponseEntity.ok( veterinaryReceptionServise.
                createVeterinaryReception(convertToVeterinaryReception(veterinaryReceptionDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity <VeterinaryReceptionDTO> getVeterinaryReceptionForId(@PathVariable("id") int id){
        log.info("The GET method was called for the method:getVeterinaryReceptionForId");
         VeterinaryReceptionDTO receptionDTO= convertToVeterinaryReceptionDTO( veterinaryReceptionServise.getVeterinaryReceptionForId(id));
         exceptionMethods.validationId(receptionDTO, id);
        return ResponseEntity.ok(receptionDTO);
    }

    @GetMapping
    public List<VeterinaryReception> getAllVeterenaryReception(){
        log.info("The GET method was called for the method:getAllVeterenaryReception");
        return veterinaryReceptionServise.getAllVeterenaryReception();
    }

    @PutMapping("/{id}")
    public ResponseEntity <VeterinaryReception> updateVeterenaryReception(@RequestBody @Valid VeterinaryReceptionDTO veterinaryReceptionDTO
            ,BindingResult bindingResult , @PathVariable("id") int id){
        log.info("The PUT method was called for the method: updateVeterenaryReception");
        exceptionMethods.existByID(id);
        exceptionMethods.validationModelField(bindingResult);
       return ResponseEntity.ok( veterinaryReceptionServise.updateVeterenaryReception(convertToVeterinaryReception(veterinaryReceptionDTO), id));
    }

    @DeleteMapping("/{id}")
    public int deleteVeterenaryReception(@PathVariable("id") int id){
        log.info("The DELETE method was called for the method: deleteVeterenaryReception");
        exceptionMethods.existByID(id);
        veterinaryReceptionServise.deleteVeterenaryReception(id);
        return id;
    }

    private VeterinaryReception convertToVeterinaryReception(VeterinaryReceptionDTO veterinaryReceptionDTO){
        log.info("Return convertToVeterinaryReception");
        return modelMapper.map(veterinaryReceptionDTO, VeterinaryReception.class);
    }

    private  VeterinaryReceptionDTO convertToVeterinaryReceptionDTO(VeterinaryReception veterinaryReception){
        log.info("Return convertToVeterinaryReceptionDTO");
        return modelMapper.map(veterinaryReception,VeterinaryReceptionDTO.class);
    }


}
