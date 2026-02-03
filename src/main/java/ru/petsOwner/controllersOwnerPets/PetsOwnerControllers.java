package ru.petsOwner.controllersOwnerPets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.petsOwner.modelsOwnerPets.OwnerPets;
import ru.petsOwner.ownerPetsDAO.PetsOwnerDAO;

import java.util.List;

@RestController
@RequestMapping("/petsOwner")

public class PetsOwnerControllers {

   private final PetsOwnerDAO petsOwnerDAO ;

   @Autowired
    public PetsOwnerControllers(PetsOwnerDAO petsOwnerDAO) {
        this.petsOwnerDAO = petsOwnerDAO;
    }

    @PostMapping(consumes = "application/json")
    public int postPetsOwner(@RequestBody OwnerPets ownerPets){
        System.out.println("Post Method / petsOwner");
       return petsOwnerDAO.createPetsOwner(ownerPets);

    }

    @GetMapping("/{id}")
        public OwnerPets getPetsOwner (@PathVariable("id")int id){

        System.out.println("getid  Method / petsOwner");
     return petsOwnerDAO.getPetsOwnerFofId(id);
    }

    @GetMapping
    public List<OwnerPets> getAllPetsOwner(){
        System.out.println("getall Method / petsOwner");
       return petsOwnerDAO.getAllPetsOwner();
    }

    @PutMapping("/{id}")
    public void updatePetsOwner( @RequestBody OwnerPets ownerPets, @PathVariable("id")int id){
         petsOwnerDAO.updatePetsOwner(ownerPets, id);
    }
    @DeleteMapping("/{id}")
    public OwnerPets deletePetsOwner(@PathVariable("id")int id){

        return petsOwnerDAO.deletePetsOwner(id);
    }
}
