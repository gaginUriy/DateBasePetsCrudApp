package ru.Veterinary.controllersVeterinary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.Veterinary.modelsVeterinary.Veterinary;
import ru.Veterinary.veterinaryDAO.VeterinaryDAO;

import java.util.List;

@RestController
@RequestMapping("/veterinary")
public class VeterinaryControllers {

    VeterinaryDAO veterinaryDAO;
@Autowired
    public VeterinaryControllers(VeterinaryDAO veterinaryDAO) {
        this.veterinaryDAO = veterinaryDAO;
    }
    @PostMapping
    public void createVeterinary(@RequestBody Veterinary veterinary){
        System.out.println("Post Method createVeterinary");
        veterinaryDAO.createVeterinary(veterinary);
    }

    @GetMapping("/{id}")
    public Veterinary getVeterinaryId(@PathVariable("id")int id){
        System.out.println("get Method getVeterinaryId");
        return veterinaryDAO.getVeterinaryId(id);
    }

    @GetMapping
    public List<Veterinary> getAllVeterinary(){
        System.out.println("getALL Method getVeterinary");
        return veterinaryDAO.getAllVeterinary();
    }

    @PutMapping("/{id}")
    public void updateVeterinary(@RequestBody Veterinary veterinary,@PathVariable("id")int id){
        System.out.println("put Method updateVeterinary");
        veterinaryDAO.updateVeterinary(veterinary, id);

    }

    @DeleteMapping("/{id}")
    public void deleteVeterinary(@PathVariable("id")int id){
        veterinaryDAO.deleteVeterinary(id);
        System.out.println("delete Method deleteVeterinary");


    }



}
