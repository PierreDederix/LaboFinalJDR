package be.technifutur.labofinal.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spell_id", nullable = false)
    private Long id;

    @Column(name = "spell_name", nullable = false)
    private String name;

    @Column(name = "spell_description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "spell_jobs",
            joinColumns = @JoinColumn(name = "spell_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private Set<Job> availableClasses;
}
