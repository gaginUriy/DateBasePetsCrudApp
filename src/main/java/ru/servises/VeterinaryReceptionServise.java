package ru.servises;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.models.VeterinaryReception;
import ru.repositories.VeterinaryReceptionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)


public class VeterinaryReceptionServise {

    private final VeterinaryReceptionRepository veterinaryReceptionRepository;

    public VeterinaryReceptionServise(VeterinaryReceptionRepository veterinaryReceptionRepository) {
        this.veterinaryReceptionRepository = veterinaryReceptionRepository;
    }
@Transactional
    public VeterinaryReception createVeterinaryReception(VeterinaryReception veterinaryReception) {
    return veterinaryReceptionRepository.save(veterinaryReception);

    }

    public VeterinaryReception getVeterinaryReceptionForId(int id) {
        Optional<VeterinaryReception> reception = veterinaryReceptionRepository.findById(id);
        return reception.orElse(null);
    }

    public List<VeterinaryReception> getAllVeterenaryReception() {
        return veterinaryReceptionRepository.findAll();
    }

    public VeterinaryReception updateVeterenaryReception(VeterinaryReception veterinaryReception, int id) {
        veterinaryReception.setId(id);
        return veterinaryReceptionRepository.save(veterinaryReception);
    }

    public void deleteVeterenaryReception(int id) {
        veterinaryReceptionRepository.deleteById(id);
    }
}
