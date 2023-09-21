package be.technifutur.labofinal.services;

import be.technifutur.labofinal.models.entities.Session;

import java.time.LocalDate;
import java.util.List;

public interface SessionService {
    Long add(Session session);
    Session getOne(Long id);
    List<Session> getAll();
    void update(Long id, Session session);
    void delete(Long id);
    void addUser(Session session, Long id);
    void removeUser(Session session, Long id);
    void changeDate(Session session, LocalDate start, LocalDate end);
}
