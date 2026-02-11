package ru.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.models.VeterinaryReception;
import ru.servises.VeterinaryReceptionServise;
import ru.util.ExceptionMethods;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/VeterinaryReception")
public class VeterinaryReceptionControllers {



    private VeterinaryReceptionServise veterinaryReceptionServise;
    private ExceptionMethods exceptionMethods;

    public VeterinaryReceptionControllers(VeterinaryReceptionServise veterinaryReceptionServise, ExceptionMethods exceptionMethods) {
        this.veterinaryReceptionServise = veterinaryReceptionServise;
        this.exceptionMethods = exceptionMethods;
    }

    @PostMapping
    public VeterinaryReception createVeterinaryReception(@RequestBody @Valid VeterinaryReception veterinaryReception, BindingResult bindingResult){

        exceptionMethods.validationModelField(bindingResult);
        return veterinaryReceptionServise.createVeterinaryReception(veterinaryReception);
    }

    @GetMapping("/{id}")
    public VeterinaryReception getVeterinaryReceptionForId(@PathVariable("id") int id){

         VeterinaryReception reception= veterinaryReceptionServise.getVeterinaryReceptionForId(id);
         exceptionMethods.validationId(reception, id);
        return reception;
    }

    @GetMapping
    public List<VeterinaryReception> getAllVeterenaryReception(){
        return veterinaryReceptionServise.getAllVeterenaryReception();
    }

    @PutMapping("/{id}")
    public void updateVeterenaryReception(@RequestBody @Valid VeterinaryReception veterinaryReception,BindingResult bindingResult , @PathVariable("id") int id){
        exceptionMethods.existByID(id);
        exceptionMethods.validationModelField(bindingResult);
        veterinaryReceptionServise.updateVeterenaryReception(veterinaryReception, id);
    }

    @DeleteMapping("/{id}")
    public void deleteVeterenaryReception(@PathVariable("id") int id){
        exceptionMethods.existByID(id);
        veterinaryReceptionServise.deleteVeterenaryReception(id);
    }


}
