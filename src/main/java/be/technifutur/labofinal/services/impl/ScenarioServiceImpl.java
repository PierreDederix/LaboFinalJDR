package be.technifutur.labofinal.services.impl;

import be.technifutur.labofinal.exceptions.ResourceNotFoundException;
import be.technifutur.labofinal.models.entities.Scenario;
import be.technifutur.labofinal.repositories.ScenarioRepository;
import be.technifutur.labofinal.services.ScenarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenarioServiceImpl implements ScenarioService {
    private final ScenarioRepository scenarioRepository;

    public ScenarioServiceImpl(ScenarioRepository scenarioRepository) {
        this.scenarioRepository = scenarioRepository;
    }


    @Override
    public Long add(Scenario scenario) {
        return scenarioRepository.save(scenario).getId();
    }

    @Override
    public Scenario getOne(Long id) {
        return scenarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id, Scenario.class));
    }

    @Override
    public List<Scenario> getAll() {
        return scenarioRepository.findAll();
    }

    @Override
    public void update(Long id, Scenario scenario) {
        scenario.setId(id);
        scenarioRepository.save(scenario);
    }

    @Override
    public void delete(Long id) {
        scenarioRepository.deleteById(id);
    }
}
