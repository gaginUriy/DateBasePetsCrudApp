package ru.Veterinary.controllersVeterinary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.Veterinary.modelsVeterinary.Veterinary;
import ru.Veterinary.services.VeterinariService;
import ru.Veterinary.veterinaryDAO.VeterinaryDAO;

import java.util.List;

@RestController
@RequestMapping("/veterinary")
public class VeterinaryControllers {

    @Autowired
    private VeterinariService veterinariService; // убрал final!


    @PostMapping
    public void createVeterinary(@RequestBody Veterinary veterinary){
        System.out.println("Post Method createVeterinary");
        veterinariService.createVeterinary(veterinary);
    }

    @GetMapping("/{id}")
    public Veterinary getVeterinaryId(@PathVariable("id")int id){
        System.out.println("get Method getVeterinaryId");
        return veterinariService.findoneVeterinary(id);
    }

    @GetMapping
    public List<Veterinary> getAllVeterinary(){
        System.out.println("getALL Method getVeterinary");
        return veterinariService.findAllVeterinary();
    }

    @PutMapping("/{id}")
    public void updateVeterinary(@RequestBody Veterinary veterinary,@PathVariable("id")int id){
        System.out.println("put Method updateVeterinary");
        veterinariService.updateVeterinary( id, veterinary);

    }

    @DeleteMapping("/{id}")
    public void deleteVeterinary(@PathVariable("id")int id){
        veterinariService.deleteVeterinary(id);
        System.out.println("delete Method deleteVeterinary");


    }



}
