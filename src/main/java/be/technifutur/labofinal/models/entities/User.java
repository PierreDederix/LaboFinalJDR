package be.technifutur.labofinal.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_enabled", nullable = false)
    private boolean enabled = true;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Role> role;

    @OneToMany(mappedBy = "player")
    private Set<Character> characters = new HashSet<>();

    @ManyToMany(mappedBy = "users")
    private Set<Session> sessions = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Set.of(
                new SimpleGrantedAuthority("ROLE_PLAYER"),
                new SimpleGrantedAuthority("ROLE_GAME_MASTER")
        );
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
