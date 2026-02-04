package ru.petsOwner.controllersOwnerPets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.petsOwner.PetsOwnerExeption.GetOwnerPetsExeption;
import ru.petsOwner.PetsOwnerExeption.NoOwnerPetsExeption;
import ru.petsOwner.modelsOwnerPets.OwnerPets;
import ru.petsOwner.ownerPetsDAO.PetsOwnerDAO;

import javax.validation.Valid;
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
    public ResponseEntity<OwnerPets> postPetsOwner(@RequestBody OwnerPets ownerPets){
        System.out.println("Post Method / petsOwner");
        OwnerPets saveOwnerPets= petsOwnerDAO.createPetsOwner(ownerPets);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveOwnerPets);
    }

    @GetMapping("/{id}")
        public OwnerPets getPetsOwner (@PathVariable("id")int id){

        System.out.println("getid  Method / petsOwner");
     OwnerPets ownerPets = petsOwnerDAO.getPetsOwnerFofId(id);
     if (ownerPets == null){

         throw new NoOwnerPetsExeption("No for owner pets in id = "+id);
     }
     return ownerPets;
    }

    @GetMapping
    public List<OwnerPets> getAllPetsOwner(){
        System.out.println("getall Method / petsOwner");
       return petsOwnerDAO.getAllPetsOwner();
    }

    @PutMapping("/{id}")
    public void updatePetsOwner(@Valid @RequestBody OwnerPets ownerPets , @PathVariable("id")int id){
        OwnerPets petOwner = petsOwnerDAO.getPetsOwnerFofId(id);
        if (petOwner == null){

            throw new NoOwnerPetsExeption("No for owner pets in id = "+id);
        }
        else {
            petsOwnerDAO.updatePetsOwner(ownerPets, id);
        }

    }
    @DeleteMapping("/{id}")
    public OwnerPets deletePetsOwner(@PathVariable("id")int id){

        return petsOwnerDAO.deletePetsOwner(id);


    }
}
