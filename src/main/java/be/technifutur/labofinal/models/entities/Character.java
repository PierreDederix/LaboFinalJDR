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
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id", nullable = false)
    private Long id;

    @Column(name = "character_name", nullable = false)
    private String name;

    @Column(name = "character_level")
    private Integer level;

    @Column(name = "character_hp")
    private Integer hp;

    @Column(name = "character_strength")
    private Integer strength;

    @Column(name = "character_dexterity")
    private Integer dexterity;

    @Column(name = "character_constitution")
    private Integer constitution;

    @Column(name = "character_intelligence")
    private Integer intelligence;

    @Column(name = "character_wisdom")
    private Integer wisdom;

    @Column(name = "character_charisma")
    private Integer charisma;

    @ManyToOne
    @JoinColumn(name = "character_player", nullable = false)
    private User player;

    @ManyToOne
    @JoinColumn(name = "character_job")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "character_subclass")
    private Subclass subclass;

    @ManyToMany
    @JoinTable(
            name = "character_spells",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "spell_id")
    )
    private Set<Spell> spells = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "character_scenario")
    private Scenario scenario;
}
