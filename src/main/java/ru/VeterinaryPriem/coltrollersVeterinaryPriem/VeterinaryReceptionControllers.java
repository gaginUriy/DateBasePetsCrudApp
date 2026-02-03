package ru.VeterinaryPriem.coltrollersVeterinaryPriem;

import org.springframework.web.bind.annotation.*;
import ru.Veterinary.modelsVeterinary.Veterinary;
import ru.Veterinary.veterinaryDAO.VeterinaryDAO;
import ru.VeterinaryPriem.modelsVeterinaryPriem.VeterinaryReception;
import ru.VeterinaryPriem.veterinaryPriemDAO.VeterenaryReceptionDAO;

import java.util.List;

@RestController
@RequestMapping("/VeterinaryReception")
public class VeterinaryReceptionControllers {
    private VeterenaryReceptionDAO veterenaryReceptionDAO;

    public VeterinaryReceptionControllers(VeterenaryReceptionDAO veterenaryReceptionDAO) {
        this.veterenaryReceptionDAO = veterenaryReceptionDAO;
    }

    @PostMapping
    public void createVeterinaryReception(@RequestBody VeterinaryReception veterinaryReception ){
        veterenaryReceptionDAO.createVeterinaryReception(veterinaryReception);
    }

    @GetMapping("/{id}")
    public VeterinaryReception getVeterinaryReceptionForId(@PathVariable("id") int id){
        return veterenaryReceptionDAO.getVeterinaryReceptionForId(id);
    }

    @GetMapping
    public List<VeterinaryReception> getAllVeterenaryReception(){
        return veterenaryReceptionDAO.getAllVeterenaryReception();
    }

    @PutMapping("/{id}")
    public void updateVeterenaryReception(@RequestBody VeterinaryReception veterinaryReception, @PathVariable("id") int id){
    veterenaryReceptionDAO.updateVeterenaryReception(veterinaryReception, id);
    }

    @DeleteMapping("/{id}")
    public void deleteVeterenaryReception(@PathVariable("id") int id){
        veterenaryReceptionDAO.deleteVeterenaryReception(id);

    }


}
