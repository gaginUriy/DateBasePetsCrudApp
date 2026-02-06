package ru.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.models.Veterinary;
import ru.servises.VeterinaryServise;


import java.util.List;

@RestController
@RequestMapping("/veterinary")
public class VeterinaryControllers {



    private final VeterinaryServise veterinaryServise;

    public VeterinaryControllers(VeterinaryServise veterinaryServise) {
        this.veterinaryServise = veterinaryServise;
    }

    @PostMapping
    public void createVeterinary(@RequestBody Veterinary veterinary){
        System.out.println("Post Method createVeterinary");
        veterinaryServise.createVeterinary(veterinary);
    }

    @GetMapping("/{id}")
    public Veterinary getVeterinaryId(@PathVariable("id")int id){
        System.out.println("get Method getVeterinaryId");
        return veterinaryServise.findoneVeterinary(id);
    }

    @GetMapping
    public List<Veterinary> getAllVeterinary(){
        System.out.println("getALL Method getVeterinary");
        return veterinaryServise.findAllVeterinary();
    }

    @PutMapping("/{id}")
    public void updateVeterinary(@RequestBody Veterinary veterinary,@PathVariable("id")int id){
        System.out.println("put Method updateVeterinary");
        veterinaryServise.updateVeterinary( id, veterinary);

    }

    @DeleteMapping("/{id}")
    public void deleteVeterinary(@PathVariable("id")int id){
        veterinaryServise.deleteVeterinary(id);
        System.out.println("delete Method deleteVeterinary");


    }



}
