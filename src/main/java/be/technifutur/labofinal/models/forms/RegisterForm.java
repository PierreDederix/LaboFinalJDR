package be.technifutur.labofinal.models.forms;

import be.technifutur.labofinal.models.entities.Role;
import be.technifutur.labofinal.models.entities.Status;
import be.technifutur.labofinal.models.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Set;

@Data
public class RegisterForm {

    @NotBlank
    private String username;

    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+={}\\[\\]:;<>,.?~])(?!.*\\s).{6,}$")
    private String password;

    @NotNull
    private Set<Status> status;

    public User toEntity() {
        User entity = new User();
        entity.setName(username);
        entity.setPassword(password);
        entity.setStatus(status);
        return entity;
    }

}
