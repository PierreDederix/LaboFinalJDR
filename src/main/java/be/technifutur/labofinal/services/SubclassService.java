package be.technifutur.labofinal.services;

import be.technifutur.labofinal.models.entities.Subclass;

import java.util.List;

public interface SubclassService {
    Long add(Subclass subclass);
    Subclass getOne(Long id);
    List<Subclass> getAll();
    void update(Long id, Subclass subclass);
    void delete(Long id);
}
