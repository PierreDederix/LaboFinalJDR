package be.technifutur.labofinal.services.impl;

import be.technifutur.labofinal.exceptions.ResourceAlreadyAssignedException;
import be.technifutur.labofinal.exceptions.ResourceNotFoundException;
import be.technifutur.labofinal.models.entities.Session;
import be.technifutur.labofinal.models.entities.User;
import be.technifutur.labofinal.repositories.SessionRepository;
import be.technifutur.labofinal.repositories.UserRepository;
import be.technifutur.labofinal.services.SessionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final UserRepository userRepository;

    public SessionServiceImpl(SessionRepository sessionRepository, UserRepository userRepository) {
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
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
    public void addUser(Session session, Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id, User.class));
        if (session.getUsers().contains(user)) {
            throw new ResourceAlreadyAssignedException(id, User.class);
        }
        session.getUsers().add(user);
        sessionRepository.save(session);
    }

    @Override
    public void removeUser(Session session, Long id) {
        session.getUsers().removeIf(user -> Objects.equals(user.getId(), id));
        sessionRepository.save(session);
    }

    @Override
    public void changeDate(Session session, LocalDate start, LocalDate end) {
        session.setSessionStart(start);
        session.setSessionEnd(end);
        sessionRepository.save(session);
    }
}
