package be.technifutur.labofinal.services;

import be.technifutur.labofinal.models.entities.Scenario;

import java.util.List;

public interface ScenarioService {
    Long add(Scenario scenario);
    Scenario getOne(Long id);
    List<Scenario> getAll();
    void update(Long id, Scenario scenario);
    void delete(Long id);
}
