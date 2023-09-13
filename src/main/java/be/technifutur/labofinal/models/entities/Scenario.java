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

    @Column(name = "scenario_name")
    private String name;

    @Column(name = "scenario_synopsis", length = 1000)
    private String synopsis;

    @OneToMany(mappedBy = "scenario")
    private Set<Character> characters = new HashSet<>();
}
