package be.technifutur.labofinal.models.forms;

import be.technifutur.labofinal.models.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterForm {

    @NotBlank
    private String username;

    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+{}\\[\\]:;<>,.?~])(?!.*\\s).{6,}$")
    private String password;

    public User toEntity() {
        User entity = new User();
        entity.setName(username);
        entity.setPassword(password);
        return entity;
    }

}
