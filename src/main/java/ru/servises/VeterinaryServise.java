package ru.servises;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.models.Veterinary;
import ru.models.VeterinaryReception;
import ru.repositories.VeterinaryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class VeterinaryServise {

    private final VeterinaryRepository repository;

    public VeterinaryServise(VeterinaryRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Veterinary createVeterinary(Veterinary veterinary){
        repository.save(veterinary);
        return veterinary;
    }

    public List<Veterinary> findAllVeterinary(){
        return repository.findAll();
    }

    public Veterinary findoneVeterinary(int id){
        Optional<Veterinary> find = repository.findById(id);
        return find.orElse(null);
    }
    @Transactional
    public Veterinary updateVeterinary (Veterinary veterinary, int id){
       veterinary.setId(id);
      return repository.save(veterinary);
    }
    @Transactional
    public void deleteVeterinary(int id) {
        repository.deleteById(id);

    }
}
