package be.technifutur.labofinal.services.impl;

import be.technifutur.labofinal.exceptions.ElementUsedOnCharacterException;
import be.technifutur.labofinal.exceptions.ResourceNotFoundException;
import be.technifutur.labofinal.models.entities.Subclass;
import be.technifutur.labofinal.repositories.CharacterRepository;
import be.technifutur.labofinal.repositories.SubclassRepository;
import be.technifutur.labofinal.services.SubclassService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SubclassServiceImpl implements SubclassService {

    private final SubclassRepository subclassRepository;
    private final CharacterRepository characterRepository;

    public SubclassServiceImpl(SubclassRepository subclassRepository, CharacterRepository characterRepository) {
        this.subclassRepository = subclassRepository;
        this.characterRepository = characterRepository;
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
        List<Long> characterSubclassId = characterRepository.findAll().stream()
                .filter(character -> Objects.equals(character.getSubclass().getId(), id))
                .map(character -> character.getSubclass().getId())
                .toList();
        if (!characterSubclassId.isEmpty()) {
            throw new ElementUsedOnCharacterException(characterSubclassId);
        }
        subclassRepository.deleteById(id);
    }
}
