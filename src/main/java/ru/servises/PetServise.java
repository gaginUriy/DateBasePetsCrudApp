package ru.servises;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.models.Pets;
import ru.repositories.PetRepository;

import javax.persistence.EntityManagerFactory;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)


public class PetServise {


    public final PetRepository petRepository;

@Autowired
    public PetServise(PetRepository petRepository, EntityManagerFactory entityManagerFactory) {

        this.petRepository = petRepository;


}

    @Transactional
    public Pets postPets(Pets pet) {
        return petRepository.save(pet);
    }

    public Pets getPets(int id) {
       Optional<Pets> getPets= petRepository.findById(id);
       return getPets.orElse(null);
    }

    public List<Pets> getAllPets() {
        return petRepository.findAll();
    }
    @Transactional
    public Pets updatePetsId(Pets pet, int id) {
        pet.setId(id);
        return petRepository.save(pet);

    }
    @Transactional
    public void DeletePets(int id) {
        petRepository.deleteById(id);
    }


}
