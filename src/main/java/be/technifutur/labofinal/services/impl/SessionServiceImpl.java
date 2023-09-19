package be.technifutur.labofinal.services.impl;

import be.technifutur.labofinal.exceptions.ResourceNotFoundException;
import be.technifutur.labofinal.models.entities.Session;
import be.technifutur.labofinal.models.entities.User;
import be.technifutur.labofinal.repositories.SessionRepository;
import be.technifutur.labofinal.services.SessionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public Long add(Session session) {
        return sessionRepository.save(session).getId();
    }

    @Override
    public Session getOne(Long id) {
        return sessionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id, Session.class));
    }

    @Override
    public List<Session> getAll() {
        return sessionRepository.findAll();
    }

    @Override
    public void update(Long id, Session session) {
        session.setId(id);
        sessionRepository.save(session);
    }

    @Override
    public void delete(Long id) {
        sessionRepository.deleteById(id);
    }

    @Override
    public void addUser(Long id, User user) {
        Session session = getOne(id);
        session.getUsers().add(user);
        sessionRepository.save(session);
    }

    @Override
    public void removeUser(Long id, User user) {
        Session session = getOne(id);
        session.getUsers().remove(user);
        sessionRepository.save(session);
    }

    @Override
    public void modifyDate(Long id, LocalDate start, LocalDate end) {
        Session session = getOne(id);
        session.setSessionStart(start);
        session.setSessionEnd(end);
        sessionRepository.save(session);
    }
}
