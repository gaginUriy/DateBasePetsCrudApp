package ru.petsOwner.ownerPetsDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.petsOwner.modelsOwnerPets.OwnerPets;

import java.util.List;
import java.util.Map;

@Component

public class PetsOwnerDAO {


    private final SessionFactory sessionFactory;

    public PetsOwnerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public OwnerPets  createPetsOwner(OwnerPets ownerPets) {
        Session session = sessionFactory.getCurrentSession();
        session.save(ownerPets);
        return ownerPets;
    }

    @Transactional(readOnly = true)
    public OwnerPets getPetsOwnerFofId(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(OwnerPets.class, id);
    }

    @Transactional(readOnly = true)
    public List<OwnerPets> getAllPetsOwner() {

        Session session = sessionFactory.getCurrentSession();
        List<OwnerPets> ownerPets= session.createQuery("SELECT p from OwnerPets p", OwnerPets.class).getResultList();
        return ownerPets;
    }

    @Transactional
    public OwnerPets updatePetsOwner(OwnerPets ownerPets, int id) {
        Session session = sessionFactory.getCurrentSession();
        OwnerPets ownerPetsUpdate = session.get(OwnerPets.class, id);

        ownerPetsUpdate.setFirstName(ownerPets.getFirstName());
        ownerPetsUpdate.setLastName(ownerPets.getLastName());
        ownerPetsUpdate.setPhone(ownerPets.getPhone());
        ownerPetsUpdate.setPetsId(ownerPets.getPetsId());
        ownerPetsUpdate.setBirthDay(ownerPets.getBirthDay());
        ownerPetsUpdate.setTelegram(ownerPets.getTelegram());
        ownerPetsUpdate.setEmail(ownerPets.getEmail());

        return ownerPets;


    }

    @Transactional
    public void deletePetsOwner(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(OwnerPets.class,id));
    }
}
