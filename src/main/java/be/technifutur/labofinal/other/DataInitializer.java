package be.technifutur.labofinal.other;

import be.technifutur.labofinal.models.entities.Role;
import be.technifutur.labofinal.models.entities.Status;
import be.technifutur.labofinal.models.entities.User;
import be.technifutur.labofinal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;

    @Autowired
    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setName("Pitou");
        user1.setPassword("Test1234=");
        user1.setStatus(Set.of(Status.GAME_MASTER));
        user1.setRoles(Set.of(Role.ADMIN));
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("Blabla");
        user2.setPassword("Test1234=");
        user2.setStatus(Set.of(Status.PLAYER));
        user2.setRoles(Set.of(Role.USER));
        userRepository.save(user2);
    }
}
