package be.technifutur.labofinal.services;

import be.technifutur.labofinal.models.entities.User;

public interface UserService {
    void register(User user);
    String login(String username, String password);
}
