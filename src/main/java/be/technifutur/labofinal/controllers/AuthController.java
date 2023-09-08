package be.technifutur.labofinal.controllers;

import be.technifutur.labofinal.models.dtos.AuthDTO;
import be.technifutur.labofinal.models.entities.User;
import be.technifutur.labofinal.models.forms.LoginForm;
import be.technifutur.labofinal.models.forms.RegisterForm;
import be.technifutur.labofinal.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final UserDetailsService userDetailsService;

    public AuthController(UserService userService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterForm form) {
        User user = form.toEntity();
        userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginForm form) {
        String token = userService.login(form.getUsername(), form.getPassword());
        User user = (User)userDetailsService.loadUserByUsername(form.getUsername());
        return ResponseEntity.ok(AuthDTO.toDTO(token, user));
    }
}
