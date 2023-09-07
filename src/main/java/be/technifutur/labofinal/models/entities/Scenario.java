package be.technifutur.labofinal.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Scenario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scenario_id", nullable = false)
    private Long id;

    @Column(name = "scenario_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "scenario")
    @JoinColumn(name = "scenario_characters")
    private Set<Character> characters = new HashSet<>();

}
