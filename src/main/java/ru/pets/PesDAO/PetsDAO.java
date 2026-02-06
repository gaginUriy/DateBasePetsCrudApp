package ru.pets.PesDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.pets.models.Pets;
import ru.petsOwner.modelsOwnerPets.OwnerPets;

import java.util.List;

@Component
public class PetsDAO {

    private final SessionFactory sessionFactory ;

    @Autowired
    public PetsDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public Pets postPets(Pets pet) {

        Session session= sessionFactory.getCurrentSession();
        session.save(pet);
        return pet;
    }

    @Transactional(readOnly = true)
    public Pets getPets(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Pets.class, id);

    }

    @Transactional(readOnly = true)
    public List<Pets> getAllPets() {
        Session session = sessionFactory.getCurrentSession();
        List<Pets> pets= session.createQuery("SELECT p from Pets p", Pets.class).getResultList();
        return pets;
    }

    @Transactional
    public Pets updatePetsId(Pets pet, int id) {
        Session session = sessionFactory.getCurrentSession();
        Pets petUpdate = session.get(Pets.class, id);

        petUpdate.setType(pet.getType());
        petUpdate.setName(pet.getName());
        petUpdate.setVaccination(pet.getVaccination());
        petUpdate.setEndVaccination(pet.getEndVaccination());
        petUpdate.setColor(pet.getColor());
        return pet;
    }

    @Transactional
    public void DeletePets(int id) {
            Session session = sessionFactory.getCurrentSession();
            session.delete(session.get(Pets.class,id));
    }
}
