package be.technifutur.labofinal.services.impl;

import be.technifutur.labofinal.exceptions.ResourceNotFoundException;
import be.technifutur.labofinal.models.entities.Subclass;
import be.technifutur.labofinal.repositories.SubclassRepository;
import be.technifutur.labofinal.services.SubclassService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubclassServiceImpl implements SubclassService {

    private final SubclassRepository subclassRepository;

    public SubclassServiceImpl(SubclassRepository subclassRepository) {
        this.subclassRepository = subclassRepository;
    }

    @Override
    public Long add(Subclass subclass) {
        return subclassRepository.save(subclass).getId();
    }

    @Override
    public Subclass getOne(Long id) {
        return subclassRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id, Subclass.class));
    }

    @Override
    public List<Subclass> getAll() {
        return subclassRepository.findAll();
    }

    @Override
    public void update(Long id, Subclass subclass) {
        subclass.setId(id);
        subclassRepository.save(subclass);
    }

    @Override
    public void delete(Long id) {
        subclassRepository.deleteById(id);
    }
}
