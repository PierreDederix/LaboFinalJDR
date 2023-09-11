package be.technifutur.labofinal.services.impl;

import be.technifutur.labofinal.jwt.JWTUtils;
import be.technifutur.labofinal.models.entities.Role;
import be.technifutur.labofinal.models.entities.User;
import be.technifutur.labofinal.repositories.UserRepository;
import be.technifutur.labofinal.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void register(User user) {
        Assert.notNull(user, "User should not be null");

        if (userRepository.existsByName(user.getName())) {
            // TODO EXCEPTION
            throw new RuntimeException();
        }

        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(Set.of(Role.USER));
        userRepository.save(user);
    }

    @Override
    public String login(String username, String password) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        return JWTUtils.generateToken(auth);
    }
}
