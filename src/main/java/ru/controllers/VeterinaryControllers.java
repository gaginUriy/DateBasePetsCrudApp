package ru.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.models.Veterinary;
import ru.servises.VeterinaryServise;
import ru.util.ExceptionMethods;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/veterinary")
public class VeterinaryControllers {



    private final VeterinaryServise veterinaryServise;
    private final ExceptionMethods exceptionMethods;

    public VeterinaryControllers(VeterinaryServise veterinaryServise, ExceptionMethods exceptionMethods) {
        this.veterinaryServise = veterinaryServise;
        this.exceptionMethods = exceptionMethods;
    }

    @PostMapping
    public void createVeterinary(@RequestBody @Valid Veterinary veterinary, BindingResult bindingResult){
        System.out.println("Post Method createVeterinary");
        exceptionMethods.validationModelField(bindingResult);
        veterinaryServise.createVeterinary(veterinary);
    }

    @GetMapping("/{id}")
    public Veterinary getVeterinaryId(@PathVariable("id")int id){
        System.out.println("get Method getVeterinaryId");
        Veterinary veterinary = veterinaryServise.findoneVeterinary(id);
        exceptionMethods.validationId(veterinary,id);
        return veterinary;
    }

    @GetMapping
    public List<Veterinary> getAllVeterinary(){
        System.out.println("getALL Method getVeterinary");
        return veterinaryServise.findAllVeterinary();
    }

    @PutMapping("/{id}")
    public void updateVeterinary(@RequestBody @Valid Veterinary veterinary,BindingResult bindingResult ,@PathVariable("id")int id){
        System.out.println("put Method updateVeterinary");
        exceptionMethods.existByID(id);
        exceptionMethods.validationModelField(bindingResult);
        veterinaryServise.updateVeterinary( id, veterinary);

    }

    @DeleteMapping("/{id}")
    public void deleteVeterinary(@PathVariable("id")int id){
        exceptionMethods.existByID(id);
        veterinaryServise.deleteVeterinary(id);
        System.out.println("delete Method deleteVeterinary");


    }



}
