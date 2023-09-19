package be.technifutur.labofinal.services;

import be.technifutur.labofinal.models.entities.Session;
import be.technifutur.labofinal.models.entities.User;

import java.time.LocalDate;
import java.util.List;

public interface SessionService {
    Long add(Session session);
    Session getOne(Long id);
    List<Session> getAll();
    void update(Long id, Session session);
    void delete(Long id);
    void addUser(Long id, User user);
    void removeUser(Long id, User user);
    void modifyDate(Long id, LocalDate start, LocalDate end);
}
