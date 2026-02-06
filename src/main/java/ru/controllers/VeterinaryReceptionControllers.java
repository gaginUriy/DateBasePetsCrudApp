package ru.controllers;

import org.springframework.web.bind.annotation.*;
import ru.models.VeterinaryReception;
import ru.servises.VeterinaryReceptionServise;

import java.util.List;

@RestController
@RequestMapping("/VeterinaryReception")
public class VeterinaryReceptionControllers {



    private VeterinaryReceptionServise veterinaryReceptionServise;

    public VeterinaryReceptionControllers(VeterinaryReceptionServise veterinaryReceptionServise) {
        this.veterinaryReceptionServise = veterinaryReceptionServise;
    }

    @PostMapping
    public VeterinaryReception createVeterinaryReception(@RequestBody VeterinaryReception veterinaryReception ){
        return veterinaryReceptionServise.createVeterinaryReception(veterinaryReception);
    }

    @GetMapping("/{id}")
    public VeterinaryReception getVeterinaryReceptionForId(@PathVariable("id") int id){
        return veterinaryReceptionServise.getVeterinaryReceptionForId(id);
    }

    @GetMapping
    public List<VeterinaryReception> getAllVeterenaryReception(){
        return veterinaryReceptionServise.getAllVeterenaryReception();
    }

    @PutMapping("/{id}")
    public void updateVeterenaryReception(@RequestBody VeterinaryReception veterinaryReception, @PathVariable("id") int id){
        veterinaryReceptionServise.updateVeterenaryReception(veterinaryReception, id);
    }

    @DeleteMapping("/{id}")
    public void deleteVeterenaryReception(@PathVariable("id") int id){
        veterinaryReceptionServise.deleteVeterenaryReception(id);

    }


}
