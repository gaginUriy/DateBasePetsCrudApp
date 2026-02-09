package ru.servises;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.models.OwnerPets;
import ru.repositories.PetsOwnerRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PetsOwnerServise {

    private final PetsOwnerRepository petsOwnerRepository;

    public PetsOwnerServise(PetsOwnerRepository ownerRepository) {
        this.petsOwnerRepository = ownerRepository;
    }

    @Transactional
    public OwnerPets saveOwnerPets(OwnerPets ownerPets) {

         return petsOwnerRepository.save(ownerPets);
    }

    public OwnerPets getOwnerPets(int id) {
        Optional<OwnerPets>owner= petsOwnerRepository.findById(id);
        return owner.orElse(null);
    }

    public List<OwnerPets> getAllOwnerPets() {
       return petsOwnerRepository.findAll();
    }
    @Transactional
    public void deleteOwnerPet(int id) {
        petsOwnerRepository.deleteById(id);
    }

    @Transactional
    public OwnerPets updatePetsOwner(int id, OwnerPets ownerPets) {
        ownerPets.setPetsId(id);
        return petsOwnerRepository.save(ownerPets);
    }
}